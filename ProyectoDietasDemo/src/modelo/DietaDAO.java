package modelo;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import pojos.AlimentoDieta;
import pojos.Dieta;
import pojos.Usuario;

public class DietaDAO {
	private ConexionBD conn = ConexionBD.getInstance();
	public Dieta generarDieta(Usuario u){
		try{
			PreparedStatement ps;
			String query = "CALL GenerarDieta(?)";
			ps = conn.builldPreparedStatement(query);
			ps.setInt(1, Integer.parseInt(u.getId()));
			Dieta d = new Dieta();
			d.setFecha(new Date(System.currentTimeMillis()));
			ResultSet rs = ps.executeQuery();
			rs.beforeFirst();
			ArrayList<AlimentoDieta> alimentos = new ArrayList<AlimentoDieta>();
			//CONSULTA EL ID DEL REGIMEN
				rs.beforeFirst();
				rs.next();
				d.setIdDieta(rs.getInt(3));	
			rs.beforeFirst();
			while(rs.next()){
				AlimentoDieta a = new AlimentoDieta();
				a.setIdAlimento(rs.getInt(1));
				a.setNombre(rs.getString(2));
				a.asignarTiempo(rs.getInt(4));
				alimentos.add(a);
			}
			d.setAlimentos(alimentos);
			return d;
		}	
		catch(SQLException sex){
			sex.printStackTrace();
			return null;
		}
	}
	public boolean aprobarDieta(Dieta d){
		try{
			PreparedStatement ps;
			String query = "CALL AprobarDieta(?,?)";
			ps = conn.builldPreparedStatement(query);
			ps.setInt(1, d.getIdDieta());
			ps.setDate(2, d.getFecha());
			ps.execute();
			return true;
		}
		catch(SQLException sex){
			sex.printStackTrace();
			return false;
		}
	}

	public static void main(String args[]) throws IOException{
		Usuario u = new Usuario();
		u.setId("2");
		DietaDAO dao = new DietaDAO();
		System.out.println("Generando dieta...");
		Dieta d = dao.generarDieta(u);
		System.out.println("Verifique que la dieta ha sido registrada");
		System.out.println(d.getAlimentos().size());
		System.in.read();
		dao.aprobarDieta(d);
		System.out.println("Dieta registrada,verificar");
		
	}
}


