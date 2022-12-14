package com.pooa.biblioteca.view;

import com.pooa.biblioteca.controladores.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = ControladorPessoas.class)
public class BibliotecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
		gerenciarCadastros();
		testePositivoServicos();
		testeNegativoServicos();
		testeObserver();
		System.out.println("\n\n\n\n***********************");
		System.out.println("FIM DOS TESTES :)");
	}

	static void gerenciarCadastros() {

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
		ControladorPessoas.alterarLeitor("03dec7a5-9b4e-4d73-a87f-c00ff03d71b7");
		ControladorPessoas.removerLeitor("ec1c550c-96da-4703-8dd3-3724cbd6a687");

		// Operações de Categoria Obra
		ControladorCategoriaObraLiteraria.cadastrarCategoria();
		ControladorCategoriaObraLiteraria.alterarCategoria(2);
		ControladorCategoriaObraLiteraria.removerCategoria(1);

		// Operações de Obra
		ControladorObra.cadastrarObra();
		ControladorObra.reservar(123, "29/08/2022", "12345", "03dec7a5-9b4e-4d73-a87f-c00ff03d71b7");
		ControladorObra.imprimirInfo();

		ControladorObra.alterarObra(123);
		ControladorObra.removerObra(0);
		ControladorObra.criarCopia(123, 32654);
		ControladorObra.imprimirInfo();

		ControladorObra.criarCopia(123, 15435);
		ControladorObra.criarCopia(123, 324);
		ControladorObra.criarCopia(123, 3244);

		ControladorObra.addAutor(123, 2);
		ControladorObra.addAutor(123, 5);
		ControladorObra.imprimirInfo();
	}

	static void testePositivoServicos() {

		// Operações de Serviços de Obra
		System.out.println("\n\n***********************");
		System.out.println("TESTE POSITIVO SERVICOS");
		System.out.println("***********************\n");
		ControladorObra.emprestar(123, "12345", 32654, "03dec7a5-9b4e-4d73-a87f-c00ff03d71b7");
		ControladorObra.reservar(123, "30/08/2022", "12345", "03dec7a5-9b4e-4d73-a87f-c00ff03d71b7");
		ControladorObra.imprimirInfo();

		ControladorObra.emprestar(123, "12345", 324, "03dec7a5-9b4e-4d73-a87f-c00ff03d71b7");
		ControladorObra.emprestar(123, "12345", 15435, "03dec7a5-9b4e-4d73-a87f-c00ff03d71b7");
		ControladorObra.imprimirInfo();

		ControladorObra.devolver(123, 324, "03dec7a5-9b4e-4d73-a87f-c00ff03d71b7");
		ControladorObra.devolver(123, 15435, "03dec7a5-9b4e-4d73-a87f-c00ff03d71b7");
		ControladorObra.imprimirInfo();

	}

	static void testeNegativoServicos() {

		System.out.println("\n\n***********************");
		System.out.println("TESTE NEGATIVO SERVICOS");
		System.out.println("***********************\n");
		ControladorObra.emprestar(123, "12345", 32654, "ec1c550c-96da-4703-8dd3-3724cbd6a687");
		ControladorObra.reservar(123, "30/08/2022", "12345", "ec1c550c-96da-4703-8dd3-3724cbd6a687");

	}

	static void testeObserver(){

		System.out.println("\n\n***********************");
		System.out.println("TESTE OBSERVER");
		System.out.println("***********************\n");
		
		ControladorPessoas.cadastrarLeitor();
		//cadastrando leitor 1 como interessado na obra 123
		ControladorObra.cadastrarInteressado(123, "03dec7a5-9b4e-4d73-a87f-c00ff03d71b7");
		//cadastrando leitor 2 como interessado na obra 123
		ControladorObra.cadastrarInteressado(123, "ec1c550c-96da-4703-8dd3-3724cbd6a687");

		ControladorObra.emprestar(123, "12345", 324, "03dec7a5-9b4e-4d73-a87f-c00ff03d71b7");
		ControladorObra.devolver(123, 324, "03dec7a5-9b4e-4d73-a87f-c00ff03d71b7");

		ControladorObra.removerInteressado(123, "03dec7a5-9b4e-4d73-a87f-c00ff03d71b7");
		System.out.println("removeu lucas");
		ControladorObra.emprestar(123, "12345", 324, "03dec7a5-9b4e-4d73-a87f-c00ff03d71b7");
		ControladorObra.devolver(123, 324, "03dec7a5-9b4e-4d73-a87f-c00ff03d71b7");

		ControladorObra.removerInteressado(123, "ec1c550c-96da-4703-8dd3-3724cbd6a687");
		System.out.println("removeu gabriel");
		ControladorObra.emprestar(123, "12345", 324, "03dec7a5-9b4e-4d73-a87f-c00ff03d71b7");
		ControladorObra.devolver(123, 324, "03dec7a5-9b4e-4d73-a87f-c00ff03d71b7");

	}

}
