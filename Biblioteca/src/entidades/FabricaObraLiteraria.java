package entidades;

public class FabricaObraLiteraria {
	public ObraLiteraria criar(Integer codigo, Integer ISBN, String titulo, ICategoriaObraLiteraria categoriaObraLiteraria,
			String palavrasChave, String dataPublicacao, String nome, String telefone, String cnpj, String email, Integer numeroPaginas) {
		return new ObraLiteraria(codigo, ISBN, titulo, categoriaObraLiteraria, palavrasChave, dataPublicacao, nome, telefone, cnpj, email, numeroPaginas);
	}
}
