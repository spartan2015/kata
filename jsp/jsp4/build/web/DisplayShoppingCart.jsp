<%@ page import="java.text.*, java.util.*, java.lang.reflect.*, shoppingcart.*" %>

<h1>Shopping Cart Content</h1>
<a href='Checkout.jsp'>Checkout</a>
<%

// get the shopping cart from the session, if it was not created, create a new one.

ShoppingCart cart = (ShoppingCart)session.getAttribute("cart");

Item[] newitems = {
    new Item("1","Product 1", 100.2, 1 , 1),
    new Item("2","Product 2", 1200.45, 2 , 2 ),
    new Item("3","Product 3", 10300.12, 3, 3),
    new Item("4","Product 4", 1400.3, 4, 4),
    new Item("5","Product 5", 1500.5, 5, 5),
    new Item("6","Product 6", 1600.6, 6 ,6)
    };
    
if (cart == null || cart.getItems().size() == 0){
    cart = new ShoppingCart();
    
    if (cart.getItems().size() == 0)
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
        
    out.println("<p> <b>" + items.size() + "</b> Items in cart: </p>");
    
    out.println("<table border=1><tr>" +
    "<td>ProductCode</td> "  +       
    "<td>Description</td> "  +
    "<td>Price</td> "  +
    "<td>Quantity</td> "  +
    "<td>Total Quantity</td> "  +        
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
            else //if (type.equals("class java.lang.String"))
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
 
 
 
 // display product catalog
 application.getRequestDispatcher("/ShowProductCatalog.jsp").include(request,response);
%>