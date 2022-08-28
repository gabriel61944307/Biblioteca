package entidades;

public class FabricaAutor{

	public Pessoa criar(String nome, String telefone, String dataNasc, Endereco endereco, Integer codigo) {
		return new Autor(nome, telefone, dataNasc, endereco, codigo);
	}


}
