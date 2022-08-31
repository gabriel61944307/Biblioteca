package view;

import controladores.*;

public class API {
    public static void main(String[] args) {

        // Operações de Categoria Leitor
        ControladorCategoriaLeitor.cadastrarCategoria();
        ControladorCategoriaLeitor.alterarCategoria(2);
        ControladorCategoriaLeitor.removerCategoria(1);

        // Operações de Pessoas (Autor, Funcionario e Leitor)
        ControladorPessoas.cadastrarAutor();
        ControladorPessoas.alterarAutor(5);
        ControladorPessoas.removerAutor(0);

        ControladorPessoas.cadastrarFuncionario();
        ControladorPessoas.alterarFuncionario("12345");
        ControladorPessoas.removerFuncionario("54321");

        ControladorPessoas.cadastrarLeitor();
        ControladorPessoas.alterarLeitor("54321");
        ControladorPessoas.removerLeitor("12345");
        
        // Operações de Categoria Obra
        ControladorCategoriaObraLiteraria.cadastrarCategoria();
        ControladorCategoriaObraLiteraria.alterarCategoria(2);
        ControladorCategoriaObraLiteraria.removerCategoria(1);
        
        // Operações de Obra
        ControladorObra.cadastrarObra();
        ControladorObra.reservar(123, "29/08/2022", "12345", "54321");
        ControladorObra.imprimirInfo();

        ControladorObra.alterarObra(123);
        ControladorObra.removerObra(0);
        ControladorObra.criarCopia(123, 32654);
        ControladorObra.imprimirInfo();

        // Operações de Serviços de Obra
        ControladorObra.emprestar(123, "12345", 32654, "54321");
        ControladorObra.criarCopia(123, 324);
        ControladorObra.reservar(123, "30/08/2022", "12345", "54321");
        ControladorObra.imprimirInfo();

        ControladorObra.criarCopia(123, 15435);
		ControladorObra.addAutor(123, 2);
		ControladorObra.addAutor(123, 5);
        ControladorObra.imprimirInfo();

        ControladorObra.emprestar(123, "12345", 324, "54321");
        ControladorObra.emprestar(123, "12345", 15435, "54321");
        ControladorObra.imprimirInfo();
		
        ControladorObra.devolver(123, 324, "54321");
        ControladorObra.devolver(123, 15435, "54321");
        ControladorObra.imprimirInfo();

    }
}
