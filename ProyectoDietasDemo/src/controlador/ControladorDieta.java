package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.DietaDAO;
import modelo.RegimenDAO;
import pojos.AlimentoDieta;
import pojos.Dieta;
import pojos.Regimen;
import pojos.Usuario;

/**
 * Servlet implementation class ControladorDieta
 */
@WebServlet("/ControladorDieta")
public class ControladorDieta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorDieta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//selecciona el tipo de accion a realizar en el controlador
				if(request.getParameter("operacion")!= null){
					int op = Integer.parseInt(request.getParameter("operacion"));
					switch (op){
					case 1:
						//Solicitar una nueva dieta
						HttpSession sesion = request.getSession();
						Usuario u =(Usuario)sesion.getAttribute("Usuario");
						if (u != null){
							RegimenDAO rdao  = new RegimenDAO();
							Regimen r = rdao.consultarUltimoRegimen(u);
							sesion.setAttribute("regimen", r);
						}
						 solicitarDieta(request, response);
						break;
					case 2:
						//Solicitar un cambio de alimento
						cambiarAlimento(request, response);
						break;
					case 3:
						//aprobar una dieta
						aprobarDieta(request, response);
						break;
					}
				}
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//selecciona el tipo de accion a realizar en el controlador
		if(request.getParameter("operacion")!= null){
			int op = Integer.parseInt(request.getParameter("operacion"));
			switch (op){
			case 1:
				//Solicitar una nueva dieta
				HttpSession sesion = request.getSession();
				Usuario u =(Usuario)sesion.getAttribute("Usuario");
				if (u != null){
					RegimenDAO rdao  = new RegimenDAO();
					Regimen r = rdao.consultarUltimoRegimen(u);
					sesion.setAttribute("regimen", r);
				}
				 solicitarDieta(request, response);
				 
				break;
			case 2:
				//Solicitar un cambio de alimento
				cambiarAlimento(request, response);
				break;
			case 3:
				//aprobar una dieta
				aprobarDieta(request, response);
				break;
			}
		}
		
		
	}
	

	
	private void solicitarDieta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		System.out.println(sesion.getId());	
		Usuario u = (Usuario)sesion.getAttribute("Usuario");
		DietaDAO ddao = new DietaDAO();
		Dieta d  = ddao.generarDieta(u);
		for(AlimentoDieta a: d.getAlimentos()){
			System.out.println(a.getTiempo());
		}
		if(d != null){
			request.getSession().setAttribute("dieta", d);
			response.sendRedirect("GeneraDieta.jsp");
		}
		else
			response.sendRedirect("index.jsp");
	}

	private void aprobarDieta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DietaDAO ddao = new DietaDAO();
		Dieta d;
		if ((d = (Dieta)request.getSession().getAttribute("dieta"))!= null)
			ddao.aprobarDieta(d);
		response.sendRedirect("GeneraDieta.jsp?aprobada=1");
	}
	
	private void cambiarAlimento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("idAlimento")!= null && request.getSession().getAttribute("dieta")!= null){
			int idAlimento = Integer.parseInt(request.getParameter("idAlimento"));
			Dieta d = (Dieta)request.getSession().getAttribute("dieta");
			AlimentoDieta a = null;
			for (AlimentoDieta ad: d.getAlimentos()){
				if(ad.getIdAlimento() == idAlimento){
					a = ad;
					break;
				}
			}
			if(a != null){
				DietaDAO ddao = new DietaDAO();
				Dieta nd = ddao.cambiarAlimento(d, a);
				request.getSession().setAttribute("dieta",nd);
				response.sendRedirect("GeneraDieta.jsp");
			
			}
			else{
				response.sendRedirect("index.jsp");
			}
		}
		else{
			response.sendRedirect("index.jsp");
		}
	}
}
