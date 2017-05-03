/*
 * RemoveItemServlet.java
 *
 * Created on 28 septembrie 2007, 20:17
 */

package shoppingcart;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author neo_qs7
 * @version
 */
public class RemoveItemServlet extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        
        ShoppingCart cart = (ShoppingCart)request.getSession(false).getAttribute("cart");
        if (cart == null)
            cart = new ShoppingCart();
        
        request.getSession().setAttribute("cart",cart);
        
        String get = request.getParameter("item");
        if (get != null)
        {    
            int i = new java.lang.Integer(get);                    
            if (cart.getItems().get(i) != null)
                cart.removeItem(i);
            //else
            //    out.println("Item not present in the shopping cart.");
        }
        
        //getServletContext().getRequestDispatcher("/DisplayShoppingCart.jsp").forward(request,response);
        response.sendRedirect("DisplayShoppingCart.jsp");
        out.close();
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
