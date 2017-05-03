/*
 * CheckoutServlet.java
 *
 * Created on 02 octombrie 2007, 10:59
 */

package shoppingcart;


import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.net.*;

public class CheckoutServlet extends HttpServlet
{
    public void service(HttpServletRequest request,
        HttpServletResponse response)
        throws IOException, ServletException
    {

// First get the shipping values from the request.
        Shipping shipping = new Shipping();

        shipping.setName(request.getParameter("name"));
        shipping.setAddress1(request.getParameter("address1"));
        shipping.setAddress2(request.getParameter("address2"));
        shipping.setCity(request.getParameter("city"));
        shipping.setState(request.getParameter("state"));
        shipping.setPostalCode(request.getParameter("postalCode"));
        shipping.setCountry(request.getParameter("country"));
        shipping.setEmail(request.getParameter("email"));

// Next, get the billing values.
        Billing billing = new Billing();

        billing.setNameOnCard(request.getParameter("nameOnCard"));
        billing.setCreditCardType(request.getParameter("creditCardType"));
        billing.setCreditCardNumber(request.getParameter(
            "creditCardNumber"));
        billing.setCreditCardExpiration(request.getParameter(
            "creditCardExpiration"));

        HttpSession session = request.getSession();

// Get the cart.
        ShoppingCart cart =
            (ShoppingCart) session.getAttribute("cart");

// If there is no shopping cart, create one (this should really be an error).
        if (cart == null)
        {
            cart = new ShoppingCart();

            session.setAttribute("cart", cart);
        }

        try
        {
            String confirmation = cart.completeOrder(shipping, billing);

// Now display the cart and allow the user to check out or order more items.
            response.sendRedirect(response.encodeRedirectURL(
                "ShowConfirmation.jsp"+
                "?confirmationNumber="+URLEncoder.encode(confirmation)));
        }
        catch (ShoppingCartException exc)
        {
            PrintWriter out = response.getWriter();

            out.println("<html><body><h1>Error</h1>");
            out.println("The following error occurred while "+
                "processing your order:");
            out.println("<pre>");
            out.println(exc.getMessage());
            out.println("</pre>");
            out.println("</body></html>");
            return;
        }
    }
}
