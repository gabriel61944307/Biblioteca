package entidades;

public class Endereco {
	private String cep;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private Cidade cidade;
	
	public Endereco() {}
	public Endereco(String cep, String logradouro, String numero, String complemento, String bairro, String nomeCidade, 
			String nomeEstado, String siglaEstado, String nomePais) {
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = new Cidade(nomeCidade, nomeEstado, siglaEstado, nomePais);
		
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
}
