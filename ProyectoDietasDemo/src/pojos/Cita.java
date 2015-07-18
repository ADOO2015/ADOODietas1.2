package pojos;

import java.sql.Date;
import java.sql.Time;

public class Cita {
	private int idMedicoPaciente;
	private int idCita;
	private Date fecha;
	private Time hora;
	public Time getHora() {
		return hora;
	}
	public void setHora(Time hora) {
		this.hora = hora;
	}
	private String observaciones;
	public int getIdMedicoPaciente() {
		return idMedicoPaciente;
	}
	public void setIdMedicoPaciente(int idMedicoPaciente) {
		this.idMedicoPaciente = idMedicoPaciente;
	}
	public int getIdCita() {
		return idCita;
	}
	public void setIdCita(int idCita) {
		this.idCita = idCita;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
}
