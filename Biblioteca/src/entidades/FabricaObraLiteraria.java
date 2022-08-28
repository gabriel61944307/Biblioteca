package entidades;

public class FabricaObraLiteraria {
	public ObraLiteraria criar(Integer codigo, Integer ISBN, String titulo, ICategoriaObraLiteraria categoriaObraLiteraria,
			String palavrasChave, String dataPublicacao, Editora editora, Integer numeroP�ginas) {
		return new ObraLiteraria(codigo, ISBN, titulo, categoriaObraLiteraria, palavrasChave, dataPublicacao, editora, numeroP�ginas);
	}
}
