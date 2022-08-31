package entidades;

public class FabricaLeitor{

	public Pessoa criar(String nome, String telefone, String dataNasc, String cep, String logradouro, String numero, String complemento, String bairro, String nomeCidade, 
	String nomeEstado, String siglaEstado, String nomePais, String numeroUfscar, 
			String email, ICategoriaLeitor categoriaLeitor) {
		return new Leitor(nome, telefone, dataNasc, cep, logradouro, numero, complemento, bairro, nomeCidade, 
		nomeEstado, siglaEstado, nomePais, numeroUfscar, email, categoriaLeitor);
	}

}
