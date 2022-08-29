package controladores;

import entidades.*;

public class ControladorPessoas {
	public static void main(String[] args) {
		FabricaAutor fabricaAutor = new FabricaAutor();
		FabricaFuncionario fabricaFuncionario = new FabricaFuncionario();
		FabricaLeitor fabricaLeitor = new FabricaLeitor();
		FabricaCategoriaObra fabricaCategoriaObra = new FabricaCategoriaObra();
		FabricaCategoriaLeitor fabricaCatLeitor = new FabricaCategoriaLeitor();
		FabricaObraLiteraria fabricaObraLiteraria = new FabricaObraLiteraria();
		Endereco endereco = new Endereco("1", "casa", "45", "padaria", "monjolinho", "Sao Carlos", "Sao Paulo", "SP", "Brasil");
		
		// TESTE DE CADASTRO ALTERACAO E REMOCAO DE OBRA LITERARIA, ADICAO DE COPIA E AUTOR, EMPRESTIMO E DEVOLU��O
		
		/*ICategoriaObraLiteraria categoriaObra1 = fabricaCategoriaObra.criar(1, "terror", 5, 5.5);
		Editora editora = new Editora("Editora1", "11935535", "cnpj", "editora@gmail.com");
		IPessoa autor1 = fabricaAutor.criar("gabriel", "111", "10/10/2010", endereco, 0);
		IPessoa autor2 = fabricaAutor.criar("lucas", "111", "10/10/2010", endereco, 1);
		IPessoa funcionario1 = fabricaFuncionario.criar("gabriel", "111", "10/10/2010", endereco, "12345");
		ICategoriaLeitor tipo1 = fabricaCatLeitor.criar(1, 10, "Leitor medio");
		
		autor1.cadastrar();
		autor2.cadastrar();
		funcionario1.cadastrar();
		tipo1.cadastrar();
		
		IPessoa leitor1 = fabricaLeitor.criar("lucas", "222", "11/11/2011", endereco, "54321", "lucas@gmail.com", tipo1);
		leitor1.cadastrar();
		
		IObraLiteraria obra1 = fabricaObraLiteraria.criar(123, 321, "a bela e a fera", categoriaObra1, "conto de fadas",
				"11/09/1991", editora, 500);
		
		obra1.cadastrar();
		
		BancoDeDados.imprimeObras();
		
		obra1.alterar(null, "branca de neve", null, null, null, null, null);
		
		BancoDeDados.imprimeObras();
		
		obra1.criarCopia(32654);
		obra1.criarCopia(324);
		obra1.criarCopia(15435);
		obra1.addAutor(autor1);
		obra1.addAutor(autor2);
		
		BancoDeDados.imprimeObras();
		
		obra1.emprestar("12345", 324, "54321");
		obra1.emprestar("12345", 15435, "54321");
		
		BancoDeDados.imprimeObras();
		
		obra1.devolver(324, "54321");
		obra1.devolver(15435, "54321");
		
		BancoDeDados.imprimeObras();
		
		leitor1.imprimirInfo();
		*/
		
		// TESTE DE CADASTRO ALTERACAO E REMOCAO DE CATEGORIA DE OBRA
		/*
		ICategoriaObraLiteraria categoriaObra1 = fabricaCategoriaObra.criar(1, "terror", 5, 5.5);
		ICategoriaObraLiteraria categoriaObra2 = fabricaCategoriaObra.criar(2, "comedia", 7, 2.2);
		
		categoriaObra1.cadastrar();
		categoriaObra2.cadastrar();
		
		BancoDeDados.imprimeCategoriasObra();
		
		categoriaObra1.remover();
	
		BancoDeDados.imprimeCategoriasObra();	
		
		categoriaObra2.alterar("japones", null, 1.5);
		
		BancoDeDados.imprimeCategoriasObra();
		*/
		
		//TESTE DE CATEGORIA LEITOR
		/*
		ICategoriaLeitor tipo1 = fabricaCatLeitor.criar(1, 10, "Leitor medio");
		ICategoriaLeitor tipo2 = fabricaCatLeitor.criar(2, 15, "Leitor assiduo");
		
		tipo1.cadastrar();
		tipo2.cadastrar();
		BancoDeDados.imprimeCategoriasLeitor();
		
		tipo1.remover();
		BancoDeDados.imprimeCategoriasLeitor();
		
		tipo2.alterar(20, null);
		BancoDeDados.imprimeCategoriasLeitor();
		*/
		
		 
		// TESTE CADASTRO ALTERACAO E REMOCAO DE LEITOR
		/*
		IPessoa leitor1 = fabricaLeitor.criar("gabriel", "111", "10/10/2010", endereco, "12345", "gabriel@gmail.com", tipo2);
		IPessoa leitor2 = fabricaLeitor.criar("lucas", "222", "11/11/2011", endereco, "54321", "lucas@gmail.com", tipo2);
		
		
		leitor1.cadastrar();
		leitor2.cadastrar();
		
		BancoDeDados.imprimeLeitores();
		
		leitor1.remover();
		
		BancoDeDados.imprimeLeitores();
		
		leitor2.alterar("joaquina", null, "20/03/1999", null, null, null);
		
		BancoDeDados.imprimeLeitores();
		*/
		
		
		// TESTE DE CADASTRO, ALTERA��O E REMO��O DE FUNCIONARIO
		/*
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
		*/
		
		// TESTE DE CADASTRO ALTERACAO E REMOCAO DE AUTOR
		/*
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
		*/
	}
	
}
