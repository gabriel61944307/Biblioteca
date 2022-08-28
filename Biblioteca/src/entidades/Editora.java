package entidades;

public class Editora {
	private String nome;
	private String telefone;
	private String cnpj;
	private String email;
	
	public Editora() {}
	public Editora(String nome, String telefone, String cnpj, String email) {
		this.nome = nome;
		this.telefone = telefone;
		this.cnpj = cnpj;
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
