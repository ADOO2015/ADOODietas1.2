package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.DAOFactoria;
import modelo.RegimenDAO;
import modelo.UsuarioDAO;
import pojos.Regimen;
import pojos.Usuario;

/**
 * Servlet implementation class ControladorHistorialRegistro
 */
@WebServlet("/historialRegimen")
public class ControladorHistorialRegimen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorHistorialRegimen() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String correoPaciente = request.getParameter("e");
		Usuario usuario = (Usuario) session.getAttribute("Usuario");
		
		if (usuario != null) {
			
			if (correoPaciente != null) {
				RegimenDAO regDAO = new RegimenDAO();
				DAOFactoria fact = DAOFactoria.getDAOFactoria(1);
				UsuarioDAO usuarioDAO = fact.getUsuarioDAO();
				RequestDispatcher view = request.getRequestDispatcher("historialRegimen.jsp");
				
				try {
					Usuario paciente = usuarioDAO.findByCorreo(correoPaciente);
					ArrayList<Regimen> historial = (ArrayList<Regimen>) regDAO.obtenerHistorialRegimen(paciente);
					request.setAttribute("historial", historial);
					view.forward(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				} 
				
			}
			else {
				response.sendRedirect("pacientesDoctor.jsp");
			}
		}
		else {
			response.sendRedirect("index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
