package com.pooa.biblioteca.controladores;

import com.pooa.biblioteca.entidades.BancoDeDados;
import com.pooa.biblioteca.entidades.FabricaCategoriaObra;
import com.pooa.biblioteca.entidades.ICategoriaObraLiteraria;

public class ControladorCategoriaObraLiteraria {
    public static void cadastrarCategoria() {

        FabricaCategoriaObra fabricaCategoriaObra = new FabricaCategoriaObra();

        // TESTE DE CADASTRO ALTERACAO E REMOCAO DE CATEGORIA DE OBRA

        ICategoriaObraLiteraria categoriaObra1 = fabricaCategoriaObra.criar(1, "terror", 5, 5.5);
        ICategoriaObraLiteraria categoriaObra2 = fabricaCategoriaObra.criar(2, "comedia", 7, 2.2);

        categoriaObra1.cadastrar();
        categoriaObra2.cadastrar();

        imprimirInfo();

    }

    public static void alterarCategoria(int codigo) {

        ICategoriaObraLiteraria categoria = BancoDeDados.getCategoriasObra().get(codigo);

        categoria.alterar("japones", null, 1.5);

        imprimirInfo();

    }

    public static void removerCategoria(int codigo) {

        ICategoriaObraLiteraria categoria = BancoDeDados.getCategoriasObra().get(codigo);

        categoria.remover();

        imprimirInfo();

    }

    public static void imprimirInfo() {

        //BancoDeDados.imprimeCategoriasObra();

    }
}
