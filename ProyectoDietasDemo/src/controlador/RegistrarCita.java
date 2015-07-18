package controlador;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import modelo.CitaNutriologoDAO;

/**
 * Servlet implementation class RegistrarCita
 */
@WebServlet(name = "registrarCita", urlPatterns = { "/registrarCita" })
public class RegistrarCita extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarCita() {
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		CitaNutriologoDAO citaNutDAO = new CitaNutriologoDAO();
		Date fecha = Date.valueOf(request.getParameter("ano")+"-"+request.getParameter("mes")+"-"+request.getParameter("dia"));
		Time hora = Time.valueOf(request.getParameter("hora"));
		String obs =request.getParameter("obs");
		int idMed = Integer.parseInt(request.getParameter("idMed"));
		int idPac = Integer.parseInt(request.getParameter("idpac"));
		try{
			citaNutDAO.insertCita(idPac, idMed, fecha, hora, obs);
			response.sendRedirect("CitasNutriologo.jsp");
		}catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

}
