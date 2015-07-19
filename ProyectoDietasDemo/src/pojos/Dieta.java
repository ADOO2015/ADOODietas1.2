package pojos;

import java.util.ArrayList;
import java.sql.Date;

public class Dieta {
	private int idDieta;
	private ArrayList<AlimentoDieta> alimentos;
	private Date fecha;
	
	public ArrayList<AlimentoDieta> getAlimentos() {
		return alimentos;
	}
	public void setAlimentos(ArrayList<AlimentoDieta> alimentos) {
		this.alimentos = alimentos;
	}

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getIdDieta() {
		return idDieta;
	}
	public void setIdDieta(int idDieta) {
		this.idDieta = idDieta;
	}
	
}
