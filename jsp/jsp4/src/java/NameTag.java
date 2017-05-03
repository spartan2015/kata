package servlets; 

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.ArrayList;

public class NameTag extends TagSupport implements DynamicAttributes
{
    protected String firstName = "First";
    protected String lastName = "Last";

    private ArrayList names = new ArrayList();
    private ArrayList values = new ArrayList();


    public void setDynamicAttribute(String uri, String localName,Object Value ) throws JspException
    {
            names.add(localName);
            values.add(Value);
    }

            
    public int doStartTag() throws JspException
    {
        try
        {
            JspWriter out = pageContext.getOut();
            out.println("This tag prints this name: <b>"+firstName + " " + lastName + "</b>!");
            
            out.println("Aditional parameters: <br>");
            for(int i=0; i<names.size(); i++){
                out.println("Dynamic Attribute Name: <b>"+names.get(i)+"</b> = " + values.get(i) + "<br>");
            }
                           
        }
        catch (IOException ioExc)
        {
            throw new JspException(ioExc.toString());
        }

        return SKIP_BODY;
    }

    public int doEndTag()
    {
        return EVAL_PAGE;
    }

// Get/set methods, just like in a bean

    public String getFirstName() { return firstName; }
    public void setFirstName(String aName) { firstName = aName; }

    public String getLastName() { return lastName; }
    public void setLastName(String aName) { lastName = aName; }

}
