
package Controllers;

import Beans.Cliente;
import Models.ControlException;
import Services.clienteService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class registroClienteController extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        int result=0;
        PrintWriter out = response.getWriter();
        try {
            response.setContentType("text/html;charset=UTF-8");            
            String nombre = request.getParameter("nombre");
            String paterno = request.getParameter("paterno");
            String materno = request.getParameter("materno");
            String estado = request.getParameter("estado");
            boolean sex=true;
            if (request.getParameter("sexo").equals("1")) {
                sex = true; 
            }else{
                sex = false;
            }
            Cliente cli = new Cliente(nombre,paterno,materno,sex,estado);
            clienteService service = new clienteService();
            result = service.insert(cli);
        } catch (ControlException ex) {
            Logger.getLogger(registroClienteController.class.getName()).log(Level.SEVERE, null, ex);
            out.println(ex);
        }
        if (result>0) {
            out.println("OK");
        }else{
            out.println("ERROR");
        }
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
