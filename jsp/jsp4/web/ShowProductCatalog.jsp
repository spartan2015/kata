<%@ page import="shoppingcart.*, java.net.*" %>
<%

Item[] newitems = {
    new Item("1","Product 1", 100.2, 1 , 1),
    new Item("2","Product 2", 1200.45, 2 , 2 ),
    new Item("3","Product 3", 10300.12, 3, 3),
    new Item("4","Product 4", 1400.3, 4, 4),
    new Item("5","Product 5", 1500.5, 5, 5),
    new Item("6","Product 6", 1600.6, 6 ,6)
    };
    
%>
<h1>Product Catalog:</h1>
<table>
    <tr>
        <td>ProductCoder</td>
        <td>Description</td>
        <td>Quantity</td>
        <td>Price</td>
        <td>Total Ordered</td>
        <td>Actions</td>
    </tr>
<%
for(int i = 0; i < newitems.length; i++)
{    
%>
    <tr>
        <td><%=newitems[i].productCode%></td>
        <td><%=newitems[i].description%></td>
        <td><%=newitems[i].quantity%></td>
        <td><%=newitems[i].price%></td>
        <td><%=newitems[i].orderQuantity%></td>
        <td><a href='AddToCart?productCode=<%=URLEncoder.encode(newitems[i].productCode)%>&description=<%=URLEncoder.encode(newitems[i].description)%>&quantity=<%=URLEncoder.encode(new Integer(newitems[i].quantity).toString())%>&price=<%=URLEncoder.encode(new Double(newitems[i].price).toString())%>'>Add To Cart</a></td>
    </tr>
<%
}
%>
</table>

