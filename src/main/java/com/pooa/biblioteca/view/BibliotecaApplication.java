package com.pooa.biblioteca.view;

import com.pooa.biblioteca.controladores.ControladorCategoriaLeitor;
import com.pooa.biblioteca.controladores.ControladorCategoriaObraLiteraria;
import com.pooa.biblioteca.controladores.ControladorObra;
import com.pooa.biblioteca.controladores.ControladorPessoas;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = ControladorPessoas.class)
public class BibliotecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
		api();
	}

	static void api(){
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

		System.out.println("TESTE OBSERVER AQUIIIIIIIIIIIIIIIII");
		ControladorPessoas.cadastrarLeitor();
		//cadastrando leitor 54321 como interessado na obra 123
		ControladorObra.cadastrarInteressado(123, "54321");
		//cadastrando leitor 12345 como interessado na obra 123
		ControladorObra.cadastrarInteressado(123, "12345");

		ControladorObra.emprestar(123, "12345", 324, "54321");
		ControladorObra.devolver(123, 324, "54321");

		ControladorObra.removerInteressado(123, "54321");
		System.out.println("removeu lucas");
		ControladorObra.emprestar(123, "12345", 324, "54321");
		ControladorObra.devolver(123, 324, "54321");

		ControladorObra.removerInteressado(123, "12345");
		System.out.println("removeu gabriel");
		ControladorObra.emprestar(123, "12345", 324, "54321");
		ControladorObra.devolver(123, 324, "54321");

		System.out.println("TESTE OBSERVER AQUIIIIIIIIIIIIIIIII");

	}

}
