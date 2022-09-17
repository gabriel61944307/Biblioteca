package com.pooa.biblioteca.controladores;

import com.pooa.biblioteca.entidades.BancoDeDados;
import com.pooa.biblioteca.entidades.FabricaObraLiteraria;
import com.pooa.biblioteca.entidades.IObraLiteraria;

public class ControladorObra {
    public static void cadastrarObra() {
        FabricaObraLiteraria fabricaObraLiteraria = new FabricaObraLiteraria();

        IObraLiteraria obra1 = fabricaObraLiteraria.criar(123, 321, "a bela e a fera", BancoDeDados.getCategoriasObra().get(2), "conto de fadas",
                "11/09/1991", "Editora1", "11935535", "cnpj", "editora@gmail.com", 500);

        IObraLiteraria obra2 = fabricaObraLiteraria.criar(0, 456, "alice no pais das maravilhas", BancoDeDados.getCategoriasObra().get(2), "conto de fadas",
                "11/09/1990", "Editora1", "11935535", "cnpj", "editora@gmail.com", 200);

        obra1.cadastrar();
        obra2.cadastrar();

    }

    public static void alterarObra(int codigo) {

        IObraLiteraria obra = BancoDeDados.getObrasLiterarias().get(codigo);

        obra.alterar(null, "branca de neve", null, null, null, null, null);

    }

    public static void removerObra(int codigo) {

        IObraLiteraria obra = BancoDeDados.getObrasLiterarias().get(codigo);

        obra.remover();

    }

    public static void criarCopia(int codigoObra, int codigoCopia) {

        IObraLiteraria obra = BancoDeDados.getObrasLiterarias().get(codigoObra);

        obra.criarCopia(codigoCopia);

    }

    public static void addAutor(int codigoObra, int codigoAutor) {

        IObraLiteraria obra = BancoDeDados.getObrasLiterarias().get(codigoObra);

        obra.addAutor(BancoDeDados.getAutores().get(codigoAutor));

    }

    public static void imprimirInfo() {

        BancoDeDados.imprimeObras();

    }

    public static void emprestar(int codigo, String numeroUfscarFuncionario, Integer numeroSequencialCopia, String numeroUfscarLeitor) {

        IObraLiteraria obra = BancoDeDados.getObrasLiterarias().get(codigo);

        obra.emprestar(numeroUfscarFuncionario, numeroSequencialCopia, numeroUfscarLeitor);

    }

    public static void devolver(int codigo, Integer numeroSequencialCopia, String numeroUfscarLeitor) {

        IObraLiteraria obra = BancoDeDados.getObrasLiterarias().get(codigo);

        obra.devolver(numeroSequencialCopia, numeroUfscarLeitor);

    }

    public static void reservar(int codigo, String dataRetirada, String numeroUfscarFuncionario, String numeroUfscarLeitor) {

        IObraLiteraria obra = BancoDeDados.getObrasLiterarias().get(codigo);

        obra.reservar(dataRetirada, numeroUfscarFuncionario, numeroUfscarLeitor);

    }

    public static void cadastrarInteressado(Integer codigoObra, String codigoLeitor) {
        IObraLiteraria obra = BancoDeDados.getObrasLiterarias().get(codigoObra);
        obra.adicionarInteressado(codigoLeitor);
    }
    public static void removerInteressado(Integer codigoObra, String codigoLeitor) {
        IObraLiteraria obra = BancoDeDados.getObrasLiterarias().get(codigoObra);
        obra.removerInteressado(codigoLeitor);
    }

}
