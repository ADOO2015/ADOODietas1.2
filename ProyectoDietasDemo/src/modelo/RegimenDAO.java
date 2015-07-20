package modelo;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojos.Regimen;
import pojos.Usuario;

public class RegimenDAO {
	private ConexionBD conn = ConexionBD.getInstance();
	
	public Regimen consultarUltimoRegimen(Usuario u){
		try{
			PreparedStatement ps;
			String query = "CALL ConsultarUltimoRegimen(?)";
			ps = conn.builldPreparedStatement(query);
			ps.setInt(1, Integer.parseInt(u.getId()));
			ResultSet rs = ps.executeQuery();
			rs.beforeFirst();
			Regimen r = new Regimen();
			int i = 0;
			while(rs.next()){
				switch (i) {
					case 0:
						r.setCalorias(rs.getFloat(2));
						break;
					case 1:
						r.setProteinas(rs.getFloat(2));
						break;
					case 2:
						r.setCarbohidratos(rs.getFloat(2));
						break;
					case 3:
						r.setLipidos(rs.getFloat(2));
						break;
					case 4:
						r.setFibra(rs.getFloat(2));
						break;
				}
				i++;
			}
			return r;
		}
		catch(SQLException ex){
			ex.printStackTrace();
			return null;
		}
	}

	public Regimen generarNuevoRegimen(Usuario u){
		try{
			PreparedStatement ps;
			String query = "CALL GenerarRegimen(?)";
			ps = conn.builldPreparedStatement(query);
			ps.setInt(1, Integer.parseInt(u.getId()));
			ResultSet rs = ps.executeQuery();
			rs.beforeFirst();
			Regimen r = new Regimen();
			while(rs.next()){
				switch (rs.getInt(1)) {
					case 0:
						r.setCalorias(rs.getFloat(2));
						break;
					case 1:
						r.setProteinas(rs.getFloat(2));
						break;
					case 2:
						r.setCarbohidratos(rs.getFloat(2));
						break;
					case 3:
						r.setLipidos(rs.getFloat(2));
						break;
					case 5:
						r.setFibra(rs.getFloat(2));
						break;
				}
			}
			return r;
		}
		catch(SQLException ex){
			ex.printStackTrace();
			return null;
		}
	}

	public boolean registrarRegimen(Regimen r,Usuario u){
		try{
			PreparedStatement ps;
			String query = "CALL RegistrarRegimen(?,?,?,?,?,?)";
			ps = conn.builldPreparedStatement(query);
			ps.setInt(1, Integer.parseInt(u.getId()));
			ps.setFloat(2, r.getCalorias());
			ps.setFloat(3, r.getProteinas());
			ps.setFloat(4, r.getCarbohidratos());
			ps.setFloat(5, r.getLipidos());
			ps.setFloat(6, r.getFibra());
			ps.execute();
			return true;
			
		}
		catch(SQLException sex){
			sex.printStackTrace();
			return false;
		}
	}

	public static void main(String args[]) throws IOException{
		RegimenDAO r = new RegimenDAO();
		Usuario u = new Usuario();
		u.setId("2");
		Regimen nr = r.generarNuevoRegimen(u);
		System.out.println("El regimen se ha generado");
		System.out.println(nr.getCalorias());
		System.in.read();
		r.registrarRegimen(nr, u);
		System.out.println("Regimen guardado");
		
	}
}
