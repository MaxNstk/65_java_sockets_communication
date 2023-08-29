package modelo;

public class Saqueador extends Pessoa{

	private double valorSaqueado;

	public Saqueador(String nome, String cpf, String endereco, double valorSaqueado) {
		super(nome, cpf, endereco);
		this.setValorSaqueado(valorSaqueado);
	}

	public double getValorSaqueado() {
		return valorSaqueado;
	}

	public void setValorSaqueado(double valorSaqueado) {
		this.valorSaqueado = valorSaqueado;
	}
	
	@Override
	public String toString() {
		return super.toString()+this.valorSaqueado;
	}
}
