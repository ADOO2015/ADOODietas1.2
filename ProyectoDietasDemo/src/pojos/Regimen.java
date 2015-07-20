package pojos;

public class Regimen {
	private float proteinas;
	private float carbohidratos;
	private float lipidos;
	private float fibra;
	private float calorias;
	
	public Regimen(){
		proteinas = 0;
		carbohidratos = 0;
		lipidos = 0;
		fibra = 0 ;
		calorias =0;
	}
	public float getProteinas() {
		return proteinas;
	}
	public void setProteinas(float proteinas) {
		this.proteinas = proteinas;
	}
	public float getCarbohidratos() {
		return carbohidratos;
	}
	public void setCarbohidratos(float carbohidratos) {
		this.carbohidratos = carbohidratos;
	}
	public float getLipidos() {
		return lipidos;
	}
	public void setLipidos(float lipidos) {
		this.lipidos = lipidos;
	}
	public float getFibra() {
		return fibra;
	}
	public void setFibra(float fibra) {
		this.fibra = fibra;
	}
	public float getCalorias() {
		return calorias;
	}
	public void setCalorias(float calorias) {
		this.calorias = calorias;
	}
	
	
}
