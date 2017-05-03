<%@ page language="java" import="java.net.*,java.text.*,shoppingcart.*" %>

<%!
// Declare a constant for the number of items to show on a page.
    public static final int ITEMS_PER_PAGE = 5;
%>

<html>
<body bgcolor="#ffffff">

<a href="DisplayShoppingCart.jsp">View Shopping Cart</a>
<p>
<h1>Available Products</h1>
<table border="1">
<tr><th>Description<th>Quantity<th>Price
<%

// Get the shared product catalog.
    shoppingcart.ProductCatalog catalog = (shoppingcart.ProductCatalog) application.getAttribute("ProductCatalog");

// If the shared product catalog hasn't been created yet, create it.
    if (catalog == null)
    {

// Not that it matters because it would be okay for two threads to initialize
// the product catalog, but synchronize this anyway to make sure only one
// thread stores the catalog. Any other JSP or servlet that needs to store
// the product catalog in the application object must also synchronize
// on application.

        synchronized (application)
        {
            catalog = new ProductCatalog();            
            application.setAttribute("ProductCatalog", catalog);
        }
    }

// Get the next starting position for displaying catalog items.
    String startingPositionStr = (String) request.
        getParameter("StartingPosition");

    int startingPosition = 0;

// If there is a starting position parameter, parse it as an integer.
    if (startingPositionStr != null)
    {
        try
        {
// If there's an error parsing the number, the starting position will
// just remain 0.
            startingPosition = Integer.parseInt(startingPositionStr);
        }
        catch (Exception ignore)
        {
        }
    }

// Get ITEMS_PER_PAGE items at a time.
    Item[] items = catalog.getItems(startingPosition, ITEMS_PER_PAGE);

// Get a currency formatter for showing the price.
    NumberFormat currency = NumberFormat.getCurrencyInstance();

    for (int i=0; i < items.length; i++)
    {
        Item item = items[i];

// Create the URL for adding the item to the shopping cart.
        String addItemURL =
            "/shoppingcart/AddToShoppingCartServlet?"+
            "productCode="+URLEncoder.encode(item.getProductCode())+
            "&description="+URLEncoder.encode(item.getDescription())+
            "&quantity="+URLEncoder.encode(""+item.getQuantity())+
            "&price="+URLEncoder.encode(""+item.getPrice());
%>
<tr><td><%=item.getDescription()%></td><td><%=item.getQuantity()%>
    </td><td><%=item.getPrice()%></td>
<td><a href="<%=addItemURL%>">Add to Shopping Cart</a></td></tr>
<%
    }
%>
</table>
<table border="0">
<tr>
<%
    if (startingPosition > 0)
    {
        int prevPosition = startingPosition-ITEMS_PER_PAGE;

// Don't let the starting position go negative.
        if (prevPosition < 0) prevPosition = 0;

// Write out a link to display the previous catalog page.
        out.println("<td><a href=\"ShowProductCatalog2.jsp?StartingPosition="+prevPosition+"\">&lt;&lt;Prev</a></td>");
    }
// Compute the next starting position in the catalog.
    int nextPosition = startingPosition+ITEMS_PER_PAGE;

// Make sure that there are still items to display at that starting
// position (that is, make sure nextPosition isn't greater than the total
// catalog size).
    if (catalog.itemsAvailable(nextPosition))
    {
// Write out a link to display the next catalog page.
        out.println("<td><a href=\"ShowProductCatalog2.jsp?StartingPosition="+nextPosition+"\">Next&gt;&gt;</a></td>");
    }
%>
</tr>
</table>
</body>
</html>
