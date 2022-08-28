package entidades;

class Cidade {
	private String nomeCidade;
	private Estado estado;
	
	public Cidade() {}
	public Cidade(String nomeCidade, String nomeEstado, String siglaEstado, String nomePais) {
		this.nomeCidade = nomeCidade;
		this.estado = new Estado(nomeEstado, siglaEstado, nomePais);
	}
	
	public String getNomeCidade() {
		return nomeCidade;
	}
	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}
	
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}
