package entidades;

public interface ICategoriaObraLiteraria {
	public void cadastrar();
	public void alterar(String descricao, Integer maximoDiasEmprestimo, Double taxaDiariaMulta);
	public void remover();
	public void imprimirInfo();
}
