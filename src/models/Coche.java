package models;

public class Coche {
	
	protected String Matricula;
	protected float horaEntrada;
	protected float horaSalida;
	protected float importeEntregado;
	
	
	public Coche(String matricula, float horaEntrada, float horaSalida, float importeEntregado) {
		Matricula = matricula;
		this.horaEntrada = horaEntrada;
		this.horaSalida = horaSalida;
		this.importeEntregado = importeEntregado;
	}


	public String getMatricula() {
		return Matricula;
	}


	public void setMatricula(String matricula) {
		Matricula = matricula;
	}


	public float getHoraEntrada() {
		return horaEntrada;
	}


	public void setHoraEntrada(float horaEntrada) {
		this.horaEntrada = horaEntrada;
	}


	public float getHoraSalida() {
		return horaSalida;
	}


	public void setHoraSalida(float horaSalida) {
		this.horaSalida = horaSalida;
	}


	public float getImporteEntregado() {
		return importeEntregado;
	}


	public void setImporteEntregado(float importeEntregado) {
		this.importeEntregado = importeEntregado;
	}


	@Override
	public String toString() {
		return "Coche [Matricula=" + Matricula + ", horaEntrada=" + horaEntrada + ", horaSalida=" + horaSalida
				+ ", importeEntregado=" + importeEntregado + "]";
	}
	
	
	
	

}
