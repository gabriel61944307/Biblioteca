package controladores;

import entidades.BancoDeDados;
import entidades.Editora;
import entidades.FabricaObraLiteraria;
import entidades.IObraLiteraria;

public class ControladorObra {
    public static void criarObra() {
		FabricaObraLiteraria fabricaObraLiteraria = new FabricaObraLiteraria();
		Editora editora = new Editora("Editora1", "11935535", "cnpj", "editora@gmail.com");
		
		// TESTE DE CADASTRO ALTERACAO E REMOCAO DE OBRA LITERARIA, ADICAO DE COPIA E AUTOR, EMPRESTIMO E DEVOLU��O
		// E TESTE DE RESERVA
		
		
		IObraLiteraria obra1 = fabricaObraLiteraria.criar(123, 321, "a bela e a fera", BancoDeDados.getCategoriasObra().get(2), "conto de fadas",
				"11/09/1991", editora, 500);
		
		obra1.cadastrar();
		
		obra1.reservar("30/08/2022", "12345", "54321");
		
		BancoDeDados.imprimeObras();
		
		obra1.alterar(null, "branca de neve", null, null, null, null, null);
		
		
		
		obra1.criarCopia(32654);
		BancoDeDados.imprimeObras();
		obra1.emprestar("12345", 32654, "54321");
		obra1.criarCopia(324);
		obra1.reservar("30/08/2022", "12345", "54321");
		BancoDeDados.imprimeObras();
		
		
		
		obra1.criarCopia(15435);
		obra1.addAutor(BancoDeDados.getAutores().get(0));
		obra1.addAutor(BancoDeDados.getAutores().get(5));
		
		BancoDeDados.imprimeObras();
		
		obra1.emprestar("12345", 324, "54321");
		obra1.emprestar("12345", 15435, "54321");
		
		BancoDeDados.imprimeObras();
		
		obra1.devolver(324, "54321");
		obra1.devolver(15435, "54321");
		
		BancoDeDados.imprimeObras();
		
    }
  
}
