package controladores;

import entidades.*;

public class ControladorPessoas {

	public static void cadastrarAutor() {

		FabricaAutor fabricaAutor = new FabricaAutor();

		IPessoa autor1 = fabricaAutor.criar("gabriel", "111", "10/10/2010", 
		"1", "casa", "45", "padaria", "monjolinho", 
		"Sao Carlos", "Sao Paulo", "SP", "Brasil", 0);

		IPessoa autor2 = fabricaAutor.criar("lucas", "222", "11/10/2010", 
		"1", "casa", "45", "padaria", "monjolinho", 
		"Sao Carlos", "Sao Paulo", "SP", "Brasil", 2);

		IPessoa autor3 = fabricaAutor.criar("tiago", "333", "12/10/2010", 
		"1", "casa", "45", "padaria", "monjolinho", 
		"Sao Carlos", "Sao Paulo", "SP", "Brasil", 5);
		
		autor1.cadastrar();
		autor2.cadastrar();
		autor3.cadastrar();
		
		imprimirInfoAutor();

	}

	public static void alterarAutor(int codigo) {

		IPessoa autor = BancoDeDados.getAutores().get(codigo);
		
		autor.alterar("joaquina", null, "13/07/2000", null);
		
		imprimirInfoAutor();

	}

	public static void removerAutor(int codigo) {

		IPessoa autor = BancoDeDados.getAutores().get(codigo);
		
		autor.remover();
		
		imprimirInfoAutor();

	}

    public static void imprimirInfoAutor() {
		
		//BancoDeDados.imprimeAutores();
		
    }

	public static void cadastrarFuncionario() {
		
		FabricaFuncionario fabricaFuncionario = new FabricaFuncionario();
		
		// TESTE DE CADASTRO, ALTERACAO E REMOCAO DE FUNCIONARIO
		
		IPessoa funcionario1 = fabricaFuncionario.criar("gabriel", "111", "10/10/2010", 
		"1", "casa", "45", "padaria", "monjolinho", 
		"Sao Carlos", "Sao Paulo", "SP", "Brasil", "12345");

		IPessoa funcionario2 = fabricaFuncionario.criar("lucas", "222", "11/11/2011", 
		"1", "casa", "45", "padaria", "monjolinho", 
		"Sao Carlos", "Sao Paulo", "SP", "Brasil", "54321");
		
		
		funcionario1.cadastrar();
		funcionario2.cadastrar();
		
		imprimirInfoFuncionario();
		
	}

	public static void alterarFuncionario(String numeroUfscar) {

		IPessoa funcionario = BancoDeDados.getFuncionarios().get(numeroUfscar);

		funcionario.alterar("gesonildo", "333", "01/01/2001", null);
		
		imprimirInfoFuncionario();
	}

	public static void removerFuncionario(String numeroUfscar) {

		IPessoa funcionario = BancoDeDados.getFuncionarios().get(numeroUfscar);
		
		funcionario.remover();
		
		imprimirInfoFuncionario();
	}

    public static void imprimirInfoFuncionario() {
		
		//BancoDeDados.imprimeAutores();
		
    }

	public static void cadastrarLeitor() {
		
		FabricaLeitor fabricaLeitor = new FabricaLeitor();
		 
		// TESTE CADASTRO ALTERACAO E REMOCAO DE LEITOR
		
		IPessoa leitor1 = fabricaLeitor.criar("gabriel", "111", "10/10/2010", "1", "casa", "45", "padaria", "monjolinho", "Sao Carlos", "Sao Paulo", "SP", "Brasil", "12345", "gabriel@gmail.com", BancoDeDados.getCategoriasLeitor().get(2));
		IPessoa leitor2 = fabricaLeitor.criar("lucas", "222", "11/11/2011", "1", "casa", "45", "padaria", "monjolinho", "Sao Carlos", "Sao Paulo", "SP", "Brasil", "54321", "lucas@gmail.com", BancoDeDados.getCategoriasLeitor().get(2));
		
		
		leitor1.cadastrar();
		leitor2.cadastrar();
		
		imprimirInfoLeitor();
		
	}

	public static void alterarLeitor(String numeroUfscar) {

		IPessoa leitor = BancoDeDados.getLeitores().get(numeroUfscar);
		
		leitor.alterar("joaquina", null, "20/03/1999", null, null, null);
		
		imprimirInfoLeitor();
	}

	public static void removerLeitor(String numeroUfscar) {

		IPessoa leitor = BancoDeDados.getLeitores().get(numeroUfscar);
		
		leitor.remover();
		
		imprimirInfoLeitor();
	}

    public static void imprimirInfoLeitor() {
		
		//BancoDeDados.imprimeLeitores();
		
    }
}
