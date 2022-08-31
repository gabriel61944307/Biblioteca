package controladores;

import entidades.BancoDeDados;
import entidades.FabricaCategoriaLeitor;
import entidades.ICategoriaLeitor;

public class ControladorCategoriaLeitor {
    public static void cadastrarCategoria() {
        
		FabricaCategoriaLeitor fabricaCatLeitor = new FabricaCategoriaLeitor();

        //TESTE DE CATEGORIA LEITOR
		
		ICategoriaLeitor categoria1 = fabricaCatLeitor.criar(1, 10, "Leitor medio");
		ICategoriaLeitor categoria2 = fabricaCatLeitor.criar(2, 15, "Leitor assiduo");
		
		categoria1.cadastrar();
		categoria2.cadastrar();

		imprimirInfo();
		
    }

    public static void alterarCategoria(int codigo) {

		ICategoriaLeitor categoria = BancoDeDados.getCategoriasLeitor().get(codigo);

		categoria.alterar(20, null);

		imprimirInfo();
		
    }

    public static void removerCategoria(int codigo) {

		ICategoriaLeitor categoria = BancoDeDados.getCategoriasLeitor().get(codigo);

		categoria.remover();

		imprimirInfo();
		
    }

    public static void imprimirInfo() {

		//BancoDeDados.imprimeCategoriasLeitor();
		
    }
}
