package entidades;

public class FabricaFuncionario{

	public Pessoa criar(String nome, String telefone, String dataNasc, String cep, String logradouro, String numero, String complemento, String bairro, String nomeCidade, 
	String nomeEstado, String siglaEstado, String nomePais, String numeroUfscar) {
		return new Funcionario(nome, telefone, dataNasc, cep, logradouro, numero, complemento, bairro, nomeCidade, nomeEstado, siglaEstado, nomePais, numeroUfscar);
	}

}
