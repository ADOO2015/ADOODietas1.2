package pojos;

import java.util.ArrayList;
import java.sql.Date;

import pojos.AlimentoDieta.Tiempo;

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
	
	public ArrayList<AlimentoDieta> getDesayuno(){
		ArrayList<AlimentoDieta> alimentos = new ArrayList<AlimentoDieta>();
		for(AlimentoDieta a:this.getAlimentos()){
			System.out.println(a.getTiempo().compareTo(Tiempo.DESAYUNO));
			if (a.getTiempo().compareTo(Tiempo.DESAYUNO)==0){
				alimentos.add(a);
			}
		}
		return alimentos;
	}
	
	public ArrayList<AlimentoDieta> getComida(){
		ArrayList<AlimentoDieta> alimentos = new ArrayList<AlimentoDieta>();
		for(AlimentoDieta a:this.getAlimentos()){
			if (a.getTiempo().compareTo(Tiempo.COMIDA) ==0){
				alimentos.add(a);
			}
		}
		return alimentos;
	} 
	
	public ArrayList<AlimentoDieta> getCena(){
		ArrayList<AlimentoDieta> alimentos = new ArrayList<AlimentoDieta>();
		for(AlimentoDieta a:this.getAlimentos()){
			System.out.println(a.getTiempo().compareTo(Tiempo.CENA));
			if (a.getTiempo().compareTo(Tiempo.CENA) ==0){
				alimentos.add(a);
			}
		}
		return alimentos;
	} 
	public ArrayList<AlimentoDieta> getColacionMatutina(){
		ArrayList<AlimentoDieta> alimentos = new ArrayList<AlimentoDieta>();
		for(AlimentoDieta a:this.getAlimentos()){
			if (a.getTiempo().compareTo(Tiempo.COLACION_MATUTINA)==0){
				alimentos.add(a);
			}
		}
		return alimentos;
	} 
	public ArrayList<AlimentoDieta> getColacionVespertina(){
		ArrayList<AlimentoDieta> alimentos = new ArrayList<AlimentoDieta>();
		for(AlimentoDieta a:this.getAlimentos()){
			if (a.getTiempo().compareTo(Tiempo.COLACION_VESPERTINA)==0){
				alimentos.add(a);
			}
		}
		return alimentos;
	} 
	
	
}
