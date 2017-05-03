package servlets;

import javax.servlet.*;
import java.io.*;
import java.util.*;
import java.lang.reflect.*;

/** This class uses the Reflection API to fetch data from an array or
 *  a vector and put it in a table. */

public class TableServlet extends GenericServlet
{
    public static final Class[] NO_PARAMS = new Class[0];

    public void service(ServletRequest request, ServletResponse response)
        throws IOException, ServletException
    {

// First, get the parameters for the TABLE, TR, TD, and TH options.
        String tableOptions = request.getParameter("tableOptions");
        if (tableOptions == null) tableOptions = "";

        String trOptions = request.getParameter("trOptions");
        if (trOptions == null) trOptions = "";

        String tdOptions = request.getParameter("tdOptions");
        if (tdOptions == null) tdOptions = "";

        String thOptions = request.getParameter("thOptions");
        if (thOptions == null) thOptions = "";

// Now, get the name of the object that contains the data to display.
        String data = request.getParameter("data");

        if (data == null)
        {
            getServletContext().log("No data available");
            throw new ServletException("No data parameter available");
        }

// Get the actual data object.
        Object dataOb = request.getAttribute(data);
        if (dataOb == null)
        {
            getServletContext().log("No data object found");
            throw new ServletException("Can't locate the data object named "+ data);
        }
        
// Get the list of method/field names to display in each column.
        String[] columns = request.getParameterValues("column");

// Get the types of each column field.
        String[] columnType = request.getParameterValues("columnType");

// Get the headers for each column
        String[] columnHeaders = request.getParameterValues("columnHeader");

        
        
// Create a table of column names and Fields/Methods for fetching data.
        Hashtable columnAccessors = getAccessors(dataOb, columns);

        
        
// First print the table header.
        PrintWriter out = response.getWriter();
        out.println("<table "+ tableOptions+">");

// If there are any headers, print them out.
        if (columnHeaders != null)
        {
            out.println("<tr "+trOptions+">");
            for (int i=0; i < columnHeaders.length; i++)
            {
                out.print("<th "+thOptions+">");
                out.println(columnHeaders[i]);
                out.println("</th>");
            }
            out.println("</tr>");
        }

// If the object is a vector, loop through the elements.
        if (dataOb instanceof Vector)
        {
            Vector v = (Vector) dataOb;

            Enumeration e = v.elements();

            while (e.hasMoreElements())
            {
// For each row, print out the <tr> tag plus any options.
                out.println("<tr "+trOptions+">");

// Print out the column values for the row.
                printRow(out, e.nextElement(),
                    columns, columnType,
                    columnAccessors, tdOptions);
                out.println("</tr>");
            }
        }
// If the object is an array, loop through the objects.
        else if (dataOb instanceof Object[])
        {
            Object[] obs = (Object[]) dataOb;

            for (int i=0; i < obs.length; i++)
            {
// For each row, print out the <tr> tag plus any options.
                out.println("<tr "+trOptions+">");

// Print out the column values for the row.
                printRow(out, obs[i],
                    columns, columnType,
                    columnAccessors, tdOptions);
                out.println("</tr>");
            }
        }
        out.println("</table>");
    }

    
    
    
    
    protected void printRow(PrintWriter out, Object ob, 
        String[] columns, String[] columnTypes,
        Hashtable columnAccessors, String tdOptions)
        throws ServletException
    {

// Loop through all the column names.
        for (int i=0; i < columns.length; i++)
        {
// Get the value for this column out of the object.
            Object value = getColumnValue(ob, columns[i],
                columnAccessors);

// Print the <td> tag.
            out.print("<td "+tdOptions+">");

// If the column type is data, just print the data.
            if (columnTypes[i].equalsIgnoreCase("data"))
            {
                out.print(value);
            }
// If the column type is "image", print out an <img> tag.
            else if (columnTypes[i].equalsIgnoreCase("image"))
            {
                out.print("<img src=\""+value+"\">");
            }
            out.print("</td>");
        }
    }

    
    
    
    
/**Use either a Field or a Method object to fetch a value from an object.*/
    protected Object getColumnValue(Object ob, String columnName,
        Hashtable columnAccessors)
        throws ServletException
    {
// Get the object used to fetch this column's value.
        Object accessor = columnAccessors.get(columnName);

// If the column is a field...
        if (accessor instanceof Field)
        {
// ... use the field's get method to fetch the value.
            try
            {
                Field f = (Field) accessor;

                return f.get(ob);
            }
// Log and then return the IllegalAccessException.
            catch (IllegalAccessException exc)
            {
                getServletContext().log(
                    "Error getting column "+
                    columnName, exc);
                throw new ServletException(
                    "Illegal access exception for column "+
                    columnName);
            }
        }
// If the column is a Method...
        else if (accessor instanceof Method)
        {
// ... invoke the method.
            try
            {
                Method m = (Method) accessor;

// The NO_PARAMS value is an empty array of Class defined at the top
// of this class.
                return m.invoke(ob, NO_PARAMS);
            }
// Log and then return any exceptions that come up while invoking the method.
            catch (IllegalAccessException exc)
            {
                getServletContext().log(
                    "Error getting column "+
                    columnName, exc);
                throw new ServletException(
                    "Illegal access exception for column "+
                    columnName);
            }
            catch (InvocationTargetException exc)
            {
                getServletContext().log(
                    "Error getting column "+
                    columnName, exc);
                throw new ServletException(
                    "Invocation target exception "+
                    "for column "+columnName);
            }
        }
// If the column is neither a Field nor a Method, return null. You should
// never get to this point.
        return null;
    }

    
    
    
    
    
    
/** Creates a table mapping column name to Field/Method */
    protected Hashtable getAccessors(Object ob, String[] columns)
        throws ServletException
    {
        Hashtable result = new Hashtable();

// First, get the Class for the kind of object being displayed.
        Class obClass = null;

        if (ob instanceof Object[])
        {
// If the objects are in an array, get the first object in the array.
            Object[] obs = (Object[]) ob;
// If there are no objects, don't bother filling the table
// because it won't be needed.
            if (obs.length == 0) return result;

            obClass = obs[0].getClass();
        }
        else if (ob instanceof Vector)
        {
// If the objects are in a vector, get the first element of the vector.
            Vector v = (Vector) ob;

// If there are no objects, don't bother filling the table
// because it won't be needed.
            if (v.size() == 0) return result;

            obClass = v.elementAt(0).getClass();
        }

// For each column, look for a field and then a method with the column name.
        for (int i=0; i < columns.length; i++)
        {
// First see whether there is a field that matches the column name.
            try
            {
                
                java.lang.reflect.Field f = obClass.getField(columns[i]);
// If so, put it in the table and go to the next column name.
                result.put(columns[i], f);
                continue;
            }
            catch (Exception ignore)
            {
            }

// Now see whether there is a method that matches this column name.
            try
            {
// The NO_PARAMS value is an empty array of Class defined at the top
// of this class.
                java.lang.reflect.Method m = obClass.getMethod(columns[i],
                    NO_PARAMS);
// If so, put it in the table.
                result.put(columns[i], m);
            }
            catch (Exception exc)
            {
                getServletContext().log(
                    "Exception location field "+
                    columns[i], exc);
                throw new ServletException(
                    "Can't locate field/method for "+
                    columns[i]);
            }
        }

        return result;
    }
}
