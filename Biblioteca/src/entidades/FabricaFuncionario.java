package entidades;

public class FabricaFuncionario{

	public Pessoa criar(String nome, String telefone, String dataNasc, Endereco endereco, String numeroUfscar) {
		return new Funcionario(nome, telefone, dataNasc, endereco, numeroUfscar);
	}

}
