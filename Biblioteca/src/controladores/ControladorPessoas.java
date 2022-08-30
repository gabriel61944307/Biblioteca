package controladores;

import entidades.*;

public class ControladorPessoas {

	public static void criarAutor() {

		FabricaAutor fabricaAutor = new FabricaAutor();
		Endereco endereco = new Endereco("1", "casa", "45", "padaria", "monjolinho", "Sao Carlos", "Sao Paulo", "SP", "Brasil");

		IPessoa autor1 = fabricaAutor.criar("gabriel", "111", "10/10/2010", endereco, 0);
		IPessoa autor2 = fabricaAutor.criar("lucas", "222", "11/10/2010", endereco, 2);
		IPessoa autor3 = fabricaAutor.criar("tiago", "333", "12/10/2010", endereco, 5);
		
		autor1.cadastrar();
		autor2.cadastrar();
		autor3.cadastrar();
		
		BancoDeDados.imprimeAutores();
		
		autor2.remover();
		
		BancoDeDados.imprimeAutores();
		
		autor1.alterar("joaquina", null, "13/07/2000", null);
		
		BancoDeDados.imprimeAutores();

	}

	public static void criarFuncionario() {
		
		FabricaFuncionario fabricaFuncionario = new FabricaFuncionario();
		Endereco endereco = new Endereco("1", "casa", "45", "padaria", "monjolinho", "Sao Carlos", "Sao Paulo", "SP", "Brasil");
		
		// TESTE DE CADASTRO, ALTERACAO E REMOCAO DE FUNCIONARIO
		
		IPessoa funcionario1 = fabricaFuncionario.criar("gabriel", "111", "10/10/2010", endereco, "12345");
		IPessoa funcionario2 = fabricaFuncionario.criar("lucas", "222", "11/11/2011", endereco, "54321");
		
		
		funcionario1.cadastrar();
		funcionario2.cadastrar();
		
		BancoDeDados.imprimeFuncionarios();
		
		funcionario1.remover();
		
		BancoDeDados.imprimeFuncionarios();
		
		funcionario2.alterar("gesonildo", "333", "01/01/2001", null);
		
		BancoDeDados.imprimeFuncionarios();
		
		funcionario2.alterar(null, null, "13/07/2000", null);
		
		BancoDeDados.imprimeFuncionarios();
		
	}

	public static void criarLeitor() {
		
		FabricaLeitor fabricaLeitor = new FabricaLeitor();
		Endereco endereco = new Endereco("1", "casa", "45", "padaria", "monjolinho", "Sao Carlos", "Sao Paulo", "SP", "Brasil");
		 
		// TESTE CADASTRO ALTERACAO E REMOCAO DE LEITOR
		
		IPessoa leitor1 = fabricaLeitor.criar("gabriel", "111", "10/10/2010", endereco, "12345", "gabriel@gmail.com", BancoDeDados.getCategoriasLeitor().get(2));
		IPessoa leitor2 = fabricaLeitor.criar("lucas", "222", "11/11/2011", endereco, "54321", "lucas@gmail.com", BancoDeDados.getCategoriasLeitor().get(2));
		
		
		leitor1.cadastrar();
		leitor2.cadastrar();
		
		BancoDeDados.imprimeLeitores();
		
		leitor1.remover();
		
		BancoDeDados.imprimeLeitores();
		
		leitor2.alterar("joaquina", null, "20/03/1999", null, null, null);
		
		BancoDeDados.imprimeLeitores();
		
	}
}
