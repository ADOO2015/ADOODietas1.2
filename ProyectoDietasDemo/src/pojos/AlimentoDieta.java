package pojos;

public class AlimentoDieta {
	public enum Tiempo{
		DESAYUNO,COLACION_MATUTINA,COMIDA,COLACION_VESPERTINA,CENA
	}
	private int idAlimento;
	private String nombre;
	private Tiempo tiempo;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Tiempo getTiempo() {
		return tiempo;
	}
	public void setTiempo(Tiempo tiempo) {
		this.tiempo = tiempo;
	}
	
	public void asignarTiempo(int idTiempo){
		switch (idTiempo) {
		case 1:
			this.setTiempo(AlimentoDieta.Tiempo.DESAYUNO);
			break;		
		case 2:
			this.setTiempo(AlimentoDieta.Tiempo.COMIDA);
			break;
		case 3:
			this.setTiempo(AlimentoDieta.Tiempo.COLACION_MATUTINA);
			break;
		case 4:
			this.setTiempo(AlimentoDieta.Tiempo.CENA);
			break;
		case 5:
			this.setTiempo(AlimentoDieta.Tiempo.COLACION_VESPERTINA);
			break;
		}
	}
	public int getIdAlimento() {
		return idAlimento;
	}
	public void setIdAlimento(int idAlimento) {
		this.idAlimento = idAlimento;
	}
	
}
