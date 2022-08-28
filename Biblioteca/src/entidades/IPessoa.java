package entidades;

public interface IPessoa {
	public void cadastrar();
	public void remover();
	public void imprimirInfo();
	public void alterar(String nome, String telefone, String dataNasc, Endereco endereco);
	public void alterar(String nome, String telefone, String dataNasc, Endereco endereco, String email,
			CategoriaLeitor categoriaLeitor);
	public Integer getCodigo();
}
