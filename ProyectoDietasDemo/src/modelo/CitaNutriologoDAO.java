package modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import pojos.Cita;

public class CitaNutriologoDAO {
	private ConexionBD con = ConexionBD.getInstance();
	public ArrayList<Cita> obtenerCitas(int idMed, int idPac,boolean todas) throws SQLException{
		ArrayList<Cita> citas=new ArrayList<Cita>();
		String query;
		if (todas){
			query="SELECT idCita,idMedicoPaciente,fecha,hora,observaciones FROM citas c NATURAL JOIN medicopaciente mc WHERE mc.Paciente_idUsuarioPaciente=? AND mc.Medico_idUsuarioMedico=? AND fecha>=current_date() ORDER BY fecha DESC";
		}else{
			query="SELECT idCita,idMedicoPaciente,fecha,hora,observaciones FROM citas c NATURAL JOIN medicopaciente mc WHERE mc.Paciente_idUsuarioPaciente=? AND mc.Medico_idUsuarioMedico=? ORDER BY fecha DESC";
		}
		PreparedStatement prepStmt;
			prepStmt = con.builldPreparedStatement(query);
			prepStmt.setString(1, String.valueOf(idPac));
			prepStmt.setString(2, String.valueOf(idMed));
			ResultSet rs = prepStmt.executeQuery();

			while(rs.next()){
				Cita c= new Cita();
				c.setIdCita(Integer.parseInt(rs.getString("idCita")));
				c.setIdMedicoPaciente(Integer.parseInt(rs.getString("idMedicoPaciente")));
				c.setFecha(Date.valueOf(rs.getString("fecha")));
				c.setHora(Time.valueOf(rs.getString("hora")));
				c.setObservaciones(rs.getString("observaciones"));
				citas.add(c);
			}
		return citas;
	}
	
	public void insertCita(int idPac,int idMed,Date fecha,Time hora, String obs) throws SQLException {
		int idMedPac=0;
		String query="SELECT idMedicoPaciente, fechaInicio FROM medicopaciente WHERE Paciente_idUsuarioPaciente=? AND Medico_idUsuarioMedico=? order by fechaInicio desc";
		PreparedStatement prepStmt;
		prepStmt = con.builldPreparedStatement(query);
		prepStmt.setString(1, String.valueOf(idPac));
		prepStmt.setString(2, String.valueOf(idMed));
		ResultSet rs = prepStmt.executeQuery();
		while(rs.next()){
			idMedPac=Integer.parseInt(rs.getString("idMedicoPaciente"));
		}
		
		String insertCitaSQL = "INSERT INTO citas"
				+ "(idMedicoPaciente,fecha,hora,observaciones) VALUES (?,?,?,?)";
		
		PreparedStatement prepStmt2 = con.builldPreparedStatement(insertCitaSQL);
		prepStmt2.setString(1, String.valueOf(idMedPac));
		prepStmt2.setString(2, String.valueOf(fecha));
		prepStmt2.setString(3, String.valueOf(hora));
		prepStmt2.setString(4, String.valueOf(obs));
		prepStmt2.executeUpdate();
	}
	
	public void deleteCita(int idCita) throws SQLException {
		String deleteCitaSQL = "DELETE FROM citas WHERE idCita = ?";
		PreparedStatement prepStmt = con.builldPreparedStatement(deleteCitaSQL);
		prepStmt.setString(1, String.valueOf(idCita));
		prepStmt.executeUpdate();
	}
	
	
}
