package entidades;

public class FabricaCategoriaLeitor {
	public CategoriaLeitor criar(Integer codigo, Integer maximoDiasEmprestimo, String descricao) {
		return new CategoriaLeitor(codigo, maximoDiasEmprestimo, descricao);
	}
}
