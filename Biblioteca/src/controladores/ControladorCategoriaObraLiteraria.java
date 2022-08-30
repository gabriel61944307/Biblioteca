package controladores;

import entidades.BancoDeDados;
import entidades.FabricaCategoriaObra;
import entidades.ICategoriaObraLiteraria;

public class ControladorCategoriaObraLiteraria {
    public static void criarCategoria() {
        
		FabricaCategoriaObra fabricaCategoriaObra = new FabricaCategoriaObra();
		
		// TESTE DE CADASTRO ALTERACAO E REMOCAO DE CATEGORIA DE OBRA
		
		ICategoriaObraLiteraria categoriaObra1 = fabricaCategoriaObra.criar(1, "terror", 5, 5.5);
		ICategoriaObraLiteraria categoriaObra2 = fabricaCategoriaObra.criar(2, "comedia", 7, 2.2);
		
		categoriaObra1.cadastrar();
		categoriaObra2.cadastrar();
		
		BancoDeDados.imprimeCategoriasObra();
		
		categoriaObra1.remover();
	
		BancoDeDados.imprimeCategoriasObra();	
		
		categoriaObra2.alterar("japones", null, 1.5);
		
		BancoDeDados.imprimeCategoriasObra();
		
    }
}
