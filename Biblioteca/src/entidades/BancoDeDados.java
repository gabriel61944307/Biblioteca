package entidades;

import java.util.HashMap;

public final class BancoDeDados {
	private static HashMap<Integer, Autor> autores = new HashMap<Integer, Autor>();
	private static HashMap<String, Funcionario> funcionarios = new HashMap<String, Funcionario>();
	private static HashMap<String, Leitor> leitores = new HashMap<String, Leitor>();
	private static HashMap<Integer, CategoriaLeitor> categoriasLeitor = new HashMap<Integer, CategoriaLeitor>();
	private static HashMap<Integer, CategoriaObraLiteraria> categoriasObra = new HashMap<Integer, CategoriaObraLiteraria>();
	private static HashMap<Integer, ObraLiteraria> obrasLiterarias = new HashMap<Integer, ObraLiteraria>();
	
	public static HashMap<Integer, Autor> getAutores() {
		return autores;
	}
	public static void addAutor(Autor autor) {
		BancoDeDados.autores.put(autor.getCodigo(), autor);
	}
	
	public static HashMap<String, Funcionario> getFuncionarios() {
		return funcionarios;
	}
	public static void addFuncionario(Funcionario funcionario) {
		BancoDeDados.funcionarios.put(funcionario.getNumeroUfscar(), funcionario);
	}
	
	public static HashMap<String, Leitor> getLeitores() {
		return leitores;
	}
	public static void addLeitor(Leitor leitor) {
		BancoDeDados.leitores.put(leitor.getNumeroUfscar(), leitor);
	}
	
	public static HashMap<Integer, CategoriaLeitor> getCategoriasLeitor() {
		return categoriasLeitor;
	}
	public static void addCategoriaLeitor(CategoriaLeitor categoriaLeitor) {
		BancoDeDados.categoriasLeitor.put(categoriaLeitor.getCodigo(), categoriaLeitor);
	}
	
	public static HashMap<Integer, CategoriaObraLiteraria> getCategoriasObra() {
		return categoriasObra;
	}
	public static void addCategoriaObra(CategoriaObraLiteraria categoriaObra) {
		BancoDeDados.categoriasObra.put(categoriaObra.getCodigo(), categoriaObra);
	}
	
	public static HashMap<Integer, ObraLiteraria> getObrasLiterarias() {
		return obrasLiterarias;
	}
	public static void addObraLiteraria(ObraLiteraria obraLiteraria) {
		BancoDeDados.obrasLiterarias.put(obraLiteraria.getCodigo(), obraLiteraria);
	}
}
