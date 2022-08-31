package entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

abstract class Pessoa implements IPessoa{
	private String nome;
	private String telefone;
	private LocalDate dataNasc;
	private Endereco endereco;
	
	public Pessoa() {}
	public Pessoa(String nome, String telefone, String dataNasc, String cep, String logradouro, String numero, String complemento, String bairro, String nomeCidade, 
	String nomeEstado, String siglaEstado, String nomePais) {
		Endereco endereco = new Endereco(cep, logradouro, numero, complemento, bairro, nomeCidade, nomeEstado, siglaEstado, nomePais);
		this.nome = nome;
		this.telefone = telefone;
		this.dataNasc = LocalDate.parse(dataNasc, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		this.endereco = endereco;
	}
	
	public void imprimirInfo() {
		System.out.println("NOME: " + this.nome);
		System.out.println("TELEFONE: " + this.telefone);
		System.out.println("DATA NASCIMENTO: " + this.dataNasc);
		System.out.println("CIDADE: " + this.endereco.getCidade().getNomeCidade());
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
	
	public LocalDate getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(String dataNasc) {
		this.dataNasc = LocalDate.parse(dataNasc, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
