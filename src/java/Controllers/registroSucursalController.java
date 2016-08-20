
package Controllers;

import Beans.Sucursal;
import Models.ControlException;
import Services.sucursalService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class registroSucursalController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int result = 0;
        String rfc = request.getParameter("rfc");
        String ubicacion = request.getParameter("ubicacion");
        String gerente = request.getParameter("gerente");
        String telefono = request.getParameter("telefono");
        
        Sucursal suc = new Sucursal(0,rfc,ubicacion,gerente,telefono);
        sucursalService service = new sucursalService();        
        try {
            result = service.insert(suc);    
        } catch (ControlException e) {
            System.err.println(e);
        }
        
        if (result == 0) {
            out.println("Error");
        } else {
            request.setAttribute("sucursal", suc);
            request.getRequestDispatcher("sucessSucursalView.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
