package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.CitaNutriologoDAO;

/**
 * Servlet implementation class EliminarCita
 */
@WebServlet(name = "eliminarCita", urlPatterns = { "/eliminarCita" })
public class EliminarCita extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarCita() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CitaNutriologoDAO citaNutDAO = new CitaNutriologoDAO();

		int idCita = Integer.parseInt(request.getParameter("idCita"));
		try{
			citaNutDAO.deleteCita(idCita);
			response.sendRedirect("CitasNutriologo.jsp?idPac="+request.getParameter("idPac"));
		}catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}


}
