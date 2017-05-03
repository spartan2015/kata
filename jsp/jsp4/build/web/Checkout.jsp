<%@ page language="java" import="shoppingcart.*" %>
<html>
<body bgcolor="#ffffff">
<p>
<jsp:include page="DisplayShoppingCart.jsp" flush="true"/>
<p>
<h1>Please enter your shipping information</h1>
<p>
<form action="CheckoutServlet" method="post">

<table>
<tr><td>Name:</td><td><input type="text" name="name"></td></tr>
<tr><td>Address:</td><td><input type="text" name="address1"></td>
</tr>
<tr><td></td><td><input type="text" name="address2"></td></tr>
<tr><td>City:</td><td><input type="text" name="city"></td></tr>
    <td>State:</td>
    <td><input type="text" name="state" size=2 maxlength=2></td></tr>
<tr><td>Postal Code (Zip in U.S.):</td>
    <td><input type="text" name="postalCode"></td></tr>
<tr><td>Country:</td><td><input type="text" name="country"></td></tr>
<tr></tr>
<tr><td>Email Address:</td><td><input type="text" name="email">
</td></tr>
</table>
<p>
<h1>Please enter your billing information</h1>
<table>
<tr><td>Name (as it appears on credit card):</td>
    <td><input type="text" name="nameOnCard"></td></tr>
<tr><td>Credit Card:</td>
<td><select name="creditCardType">
    <option value="amex">American Express</option>
    <option value="visa">Visa</option>
    <option value="mc">Mastercard</option>
    <option value="discover">Discover</option>
    <option value="bbbt">Billy Bob's Bank &amp; Trust</option>
    </select></td></tr>
<tr><td>Credit Card Number:</td>
    <td><input type="text" name="creditCardNumber"></td></tr>
<tr><td>Expiration Date:</td>
    <td><input type="text" name="creditCardExpiration"></td></tr>
</table>
<p>
<input type="submit" value="Complete Order">
</form>
</body>
</html>

