package controlador;

import java.io.IOException;
import java.sql.SQLException;

import pojos.Usuario;




import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.AccessUsuarioDAO;
import pojos.Correo;
/**
 * Servlet implementation class RecuperaPass
 */
@WebServlet("/RecuperaPass")
public class RecuperaPass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AccessUsuarioDAO obj = new AccessUsuarioDAO();
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecuperaPass() {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		
		
		 
	}
		// TODO Auto-generated method stub
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Correo c = new Correo();
		c.setContrasena("nbscbjlbsbngklfp");
		c.setAsunto("RecuperarContrasena");
		c.setDestino(request.getParameter("Correo"));
		Usuario u = new Usuario();
		try {
			u=obj.findByUsuario(request.getParameter("txtEmail"));
			if(u !=null && obj.estaRegistrado(u.getId())==1){
				c.setMensaje("Hola "+ u.getCorreo()+ " tu contrasena es: "+ u.getPassword());
				c.setUsuarioCorreo("moica.17.16@gmail.com");
				c.setDestino(request.getParameter("txtEmail"));
				Controlador a = new Controlador();
				a.enviarCorreo(c);
				
			}else{
				HttpSession s = request.getSession();
				s.setAttribute("tipo", "UN");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("index.jsp");
	}

}
