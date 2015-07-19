package modelo;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import pojos.Regimen;
import pojos.Usuario;

public class RegimenDAO {
	private ConexionBD conn = ConexionBD.getInstance();
	
	public Regimen consultarUltimoRegimen(Usuario u){
		try{
			PreparedStatement ps;
			String query = "CALL ConsultarUltimoRegimen(?)";
			ps = conn.buildPreparedStatement(query);
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
	
	public Collection<Regimen> obtenerHistorialRegimen(Usuario u){
		try{
			PreparedStatement ps;
			String query = "CALL ConsultarHistorialRegimen(?)";
			ps = conn.buildPreparedStatement(query);
			ps.setInt(1, Integer.parseInt(u.getId()));
			ResultSet rs = ps.executeQuery();
			ArrayList<Regimen> ls = new ArrayList<Regimen>();
			Regimen r = null;
			int i = 0;
			while(rs.next()){
				switch (i) {
					case 0:
						r = new Regimen();
						r.setCarbohidratos(rs.getFloat(2));
						r.setFechaInicio(rs.getDate(3).toString());
						r.setFechaFin(rs.getDate(4).toString());
						break;
					case 1:
						r.setFibra(rs.getFloat(2));
						break;
					case 2:
						r.setLipidos(rs.getFloat(2));
						break;
					case 3:
						r.setProteinas(rs.getFloat(2));
						ls.add(r);
						i = -1;
						break;
				}
				i++;
			}
			return ls;
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
			ps = conn.buildPreparedStatement(query);
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
			ps = conn.buildPreparedStatement(query);
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
		ArrayList<Regimen> hist = (ArrayList<Regimen>) r.obtenerHistorialRegimen(u);
		System.out.println("Mostrando historial...");
		for (Regimen reg : hist) {
			System.out.println(reg.getCarbohidratos());
			System.out.println(reg.getFibra());
			System.out.println(reg.getLipidos());
			System.out.println(reg.getProteinas());
			System.out.println(reg.getFechaInicio());
			System.out.println(reg.getFechaFin());
		}
		
	}
}
