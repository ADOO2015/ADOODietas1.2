package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.DAOFactoria;
import modelo.UsuarioDAO;
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
		Usuario usuario = (Usuario) session.getAttribute("Usuario");
		
		if (usuario != null) {
			System.out.println(usuario.getId());
			System.out.println(usuario.getNombre());
			DAOFactoria fact = DAOFactoria.getDAOFactoria(1);
			UsuarioDAO usuarioDAO = fact.getUsuarioDAO();
			try {
				int idMP = usuarioDAO.obtenerIdMP(Integer.parseInt(usuario.getId()));
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
