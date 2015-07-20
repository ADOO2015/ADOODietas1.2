package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pojos.Regimen;
import pojos.Usuario;
import modelo.RegimenDAO;

/**
 * Servlet implementation class RegistraRegimen
 */
@WebServlet("/RegistraRegimen")
public class RegistraRegimen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistraRegimen() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession();
		String cal, prot, lip, carb, fib;
		cal = request.getParameter("cal");
		prot = request.getParameter("prot");
		lip = request.getParameter("lip");
		carb = request.getParameter("carb");
		fib = request.getParameter("fib");
		
		Regimen nreg = new Regimen();
		nreg.setCalorias(Float.parseFloat(cal));
		nreg.setProteinas(Float.parseFloat(prot));
		nreg.setLipidos(Float.parseFloat(lip));
		nreg.setCarbohidratos(Float.parseFloat(carb));
		nreg.setFibra(Float.parseFloat(fib));
		RegimenDAO rdao = new RegimenDAO();
		rdao.registrarRegimen(nreg,(Usuario)(ses.getAttribute("paciente")));
		
		response.sendRedirect("pacientesDoctor.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
