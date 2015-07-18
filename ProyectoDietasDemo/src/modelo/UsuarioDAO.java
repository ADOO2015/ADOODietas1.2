package modelo;

import java.sql.SQLException;
import java.util.Collection;

import pojos.Regimen;
import pojos.Usuario;

public interface UsuarioDAO {
	
	public Usuario create(String usuario, String nombre, String apellidos, String correo, String password) throws SQLException;
	
	public Collection<Usuario> findAll() throws SQLException;
	
	public Usuario findByUsuario(String usuario) throws SQLException;
	
	public Usuario findByCorreo(String correo) throws SQLException;
	
	public Collection<Usuario> getAllPregistered() throws SQLException;
	
	public Collection<Usuario> bySearchPregistered(String q) throws SQLException;
	
	public void update(Usuario usuario) throws SQLException;
	
	public void insertinUsuario(String nombre, String apellidos, String correo, String password,String sexo,String TipoUsuario) throws SQLException;
	
	public String isUserResgistered(String correo) throws SQLException;
	
	public String getIdUsuario(String correo) throws SQLException;
	
	public String getIdTipoUsuario(String correo) throws SQLException;
	
	public void insertinTipoUsuario(String correo,String descripcion) throws SQLException;
	
	public void insertinDireccion(String ciudad,String calle,String numeroExt) throws SQLException;
	
	public void insertPaciente(String idUsuarioPaciente, String idEstadoPaciente , String idDireccion) throws SQLException;
	
	public String selectLastID() throws SQLException;

	int estaRegistrado(String id) throws SQLException;
	
	int obtenerIdMP(int idPaciente) throws SQLException;
	
	public Collection<Regimen> obtenerHistorialRegimen(int idMP) throws SQLException;
public String getApellido(String correo) throws SQLException;
	
	public String getNombre(String correo) throws SQLException;
	
	public String getIdDireccion(String idUsuario) throws SQLException;
	
	public void updateUsuario(String idUsuario,String nombre,String correo,String apellido) throws SQLException;
	
	public void updateDireccion(String idPaciente,String calle,String numero,String ciudad) throws SQLException;
	
	public void updatePaciente(String idPaciente) throws SQLException;
	
	public void insertInProgreso(String idUsuarioPaciente,String altura,String peso,String perimetroCintura,String perimetroCadera) throws SQLException;

}


