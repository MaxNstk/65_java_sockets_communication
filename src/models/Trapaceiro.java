package models;

public class Trapaceiro extends Pessoa{

	private String habilidade;

	public Trapaceiro(String nome, String cpf, String endereco, String habilidade) {
		super(nome, cpf, endereco);
		this.setHabilidade(habilidade);
	}

	public String getHabilidade() {
		return habilidade;
	}

	public void setHabilidade(String habilidade) {
		this.habilidade = habilidade;
	}
	
	@Override
	public String toString() {
		return super.toString()+this.habilidade;
	}
}
