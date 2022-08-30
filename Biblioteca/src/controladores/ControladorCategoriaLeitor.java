package controladores;

import entidades.BancoDeDados;
import entidades.FabricaCategoriaLeitor;
import entidades.ICategoriaLeitor;

public class ControladorCategoriaLeitor {
    public static void criarCategoria() {
        
		FabricaCategoriaLeitor fabricaCatLeitor = new FabricaCategoriaLeitor();

        //TESTE DE CATEGORIA LEITOR
		
		ICategoriaLeitor tipo1 = fabricaCatLeitor.criar(1, 10, "Leitor medio");
		ICategoriaLeitor tipo2 = fabricaCatLeitor.criar(2, 15, "Leitor assiduo");
		
		tipo1.cadastrar();
		tipo2.cadastrar();
		BancoDeDados.imprimeCategoriasLeitor();
		
		tipo1.remover();
		BancoDeDados.imprimeCategoriasLeitor();
		
		tipo2.alterar(20, null);
		BancoDeDados.imprimeCategoriasLeitor();
		
    }
}
