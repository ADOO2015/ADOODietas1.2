package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.AccessUsuarioDAO;
import pojos.Usuario;

/**
 * Servlet implementation class ControladorRegistro
 */
@WebServlet("/ControladorRegistro")
public class ControladorRegistro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorRegistro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// para la tabla usuario
		String correo="";
		String nombre="";
		String apellido="";
		String idPaciente="";
	
		
		//para tabla direccion
		String calle="";
		String numero="";
		String ciudad="";
		
		//para la tabla progreso
		String cintura="";
		String altura="";
		String peso="";
		String cadera="";


		
		//Jala todos los datos del formulario y se inicializan
		correo=request.getParameter("correo");
		nombre=request.getParameter("nombre");
		apellido=request.getParameter("apellido");
		
		calle=request.getParameter("calle");
		numero=request.getParameter("numero");
		ciudad=request.getParameter("ciudad");
		
		cintura=request.getParameter("cintura");
		cadera=request.getParameter("cadera");
		peso=request.getParameter("peso");
		altura=request.getParameter("altura");
		AccessUsuarioDAO gestor=new AccessUsuarioDAO();
		
		//registramos en tabla Usuario
		try {
			idPaciente=gestor.getIdUsuario(correo);
			System.out.println("idPaciente:"+idPaciente);
			gestor.updateUsuario(idPaciente,correo,nombre,apellido);
		} catch (SQLException e) {
			System.out.println("Error al alctualizar usuario");
			e.printStackTrace();
		}
		
		//registramos en tabla direccion
		try {
			String aux2=gestor.getIdDireccion(idPaciente);
			System.out.println("idDireccin:"+aux2);
			gestor.updateDireccion(aux2,calle,numero,ciudad);
		} catch (SQLException e) {
			System.out.println("Error al insertar en direccion");
			e.printStackTrace();
		}
		//registramos en tabla paciente
		try {
			gestor.updatePaciente(idPaciente);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error al actualizar paciente");
		}
		
		//tlatisnere 19/07/2015: Se agrega insercion a medicoPaciente
		
		try {			
			HttpSession sesion = request.getSession();
	    	Usuario user = new Usuario();
	    	user = (Usuario)sesion.getAttribute("Usuario");
			gestor.insertInMedicoPaciente(idPaciente, user.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error al insertar en medicopaciente");
		}
		
		//registramos en Progreso
		try {
			gestor.insertInProgreso(idPaciente, altura, peso, cintura, cadera);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al insertar en Progreso");
			e.printStackTrace();
		}

		response.sendRedirect("pacientesDoctor.jsp");


		/*
		 * String us="";
		
		try {
			us=gestor.isUserResgistered(correo);
		} catch (SQLException e1) {
			System.out.println("Error buscando usuario por correo");
			e1.printStackTrace();
		}
		
		

			//registramos en tabla Usuario
			gestor.insertinUsuario(nombre, apellidos, correo, contrasena,sexo,TipoUsuario);
			//registramos en tabla direccion
			gestor.insertinDireccion(delMun, calle, numeroExt);
			String idDireccion=gestor.selectLastID();
			System.out.println(idDireccion);
			gestor.insertPaciente(gestor.getIdUsuario(correo), "0", idDireccion);
		} catch (SQLException e) {
						e.printStackTrace();
						System.out.println("Error al insertar usuario");
		}
		response.sendRedirect("index.jsp");
*/
		
	}

}
