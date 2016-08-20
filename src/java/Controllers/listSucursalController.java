
package Controllers;

import Beans.Sucursal;
import Models.ControlException;
import Services.sucursalService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class listSucursalController extends HttpServlet {
    
    sucursalService service = new sucursalService();        
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ArrayList<Sucursal> lista = new ArrayList();

        try {
            lista = service.getAllSucursal();    
            request.setAttribute("sucursales", lista);        
            request.getRequestDispatcher("listSucursalView.jsp").forward(request, response);
        } catch (ControlException e) {
            System.out.println(e);
        }                
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
            int id = Integer.parseInt(request.getParameter("idSucursal"));        
            request.setAttribute("sucursal", service.searchById(id));
            request.getRequestDispatcher("listSucursalView.jsp").forward(request, response);
        } catch (ControlException ex) {
            Logger.getLogger(listSucursalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
