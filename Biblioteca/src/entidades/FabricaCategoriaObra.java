package entidades;

public class FabricaCategoriaObra {
	public CategoriaObraLiteraria criar(Integer codigo, String descricao, Integer maximoDiasEmprestimo, Double taxaDiariaMulta) {
		return new CategoriaObraLiteraria(codigo, descricao, maximoDiasEmprestimo, taxaDiariaMulta);
	}
}
