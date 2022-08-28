package entidades;

public class FabricaLeitor{

	public Pessoa criar(String nome, String telefone, String dataNasc, Endereco endereco, String numeroUfscar, 
			String email, ICategoriaLeitor categoriaLeitor) {
		return new Leitor(nome, telefone, dataNasc, endereco, numeroUfscar, email, categoriaLeitor);
	}

}
