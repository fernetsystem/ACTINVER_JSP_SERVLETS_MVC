
package Controllers;

import Beans.Cuenta;
import Models.ControlException;
import Services.cuentaService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class registroCuentaController extends HttpServlet {
   
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
            
        PrintWriter out = response.getWriter();
        int result = 0;
        try {
            response.setContentType("text/html;charset=UTF-8");
            int idCliente = Integer.parseInt(request.getParameter("idCliente"));
            int idSucursal = Integer.parseInt(request.getParameter("idSucursal"));
            float saldo;
            saldo = Float.parseFloat(request.getParameter("saldo"));
            Cuenta cuenta = new Cuenta(0, idCliente, idSucursal, saldo);
            cuentaService service = new cuentaService();

            result = service.insert(cuenta);

        } catch (ControlException ex) {
            Logger.getLogger(registroCuentaController.class.getName()).log(Level.SEVERE, null, ex);

        }
        if (result > 0) {
            out.println("OK");
        } else {
            out.println("ERROR");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
