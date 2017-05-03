package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.*;
import java.util.*;
import java.lang.reflect.*;
import shoppingcart.*;

public final class DisplayShoppingCart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
      out.write('\n');
      out.write('\n');


// get the shopping cart from the session, if it was not created, create a new one.

ShoppingCart cart = (ShoppingCart)session.getAttribute("cart");
Item[] newitems = {
    new Item("1","Product 1", 100.2, 1),
    new Item("2","Product 2", 1200.45, 2),
    new Item("3","Product 3", 10300.12, 3),
    new Item("4","Product 4", 1400.3, 4),
    new Item("5","Product 5", 1500.5, 5),
    new Item("6","Product 6", 1600.6, 6)
    };;
if (cart == null){
    cart = new ShoppingCart();
    
    for(int y=0; y<newitems.length; y++)
        cart.addItem(newitems[y]);
    
}





// display the items in it
Vector items = cart.getItems();

if (items.size() == 0){
    out.println("You have 0 items in your cart.");
}
else
{
        
    out.println("<p>Items in cart: </p>");
    
    out.println("<table><tr>" +
    "<td>ProductCode</td> "  +       
    "<td>Description</td> "  +
    "<td>Price</td> "  +
    "<td>Quantity</td> "  +
    "<td>Actions</td> "  +        
    "</tr>");
    
    
    for(int u = 0; u < items.size(); u++)
    {
        
        out.println("<tr>");
        
        Object obj = items.elementAt(u);
        Class className = obj.getClass();
        java.lang.reflect.Field[] f = className.getFields();
        for(int o = 0 ; o<f.length ; o++)
        {
                        
            String type = ((Field)f[o]).getType().toString();             
            
           
            
            //if (type.equals("class java.lang.String"))
            
            if (type.equals("double"))
            {
                     out.println("<td align='right'>");    
                     out.println(new java.text.DecimalFormat().format( ((Field)f[o]).getDouble(obj) ) );
                     out.println("</td>");
            }         
            else if (type.equals("int"))
            {
                     out.println("<td align='right'>");    
                     out.println(new java.text.DecimalFormat().format( ((Field)f[o]).getInt(obj) ) );
                     out.println("</td>");
            }
            else
            {
                out.println("<td>");    
                out.println((String)((Field)f[o]).get(obj));
                out.println("</td>");
            }
                
                
          }
            
            
        
        
        out.println("<td><a href='RemoveItemServlet?item="+u+"'>Remove</a></td>");
        
        out.println("</tr>");
    }
     
    
    out.println("</table>");
 }       

 
 
 session.setAttribute("cart",cart);

    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
