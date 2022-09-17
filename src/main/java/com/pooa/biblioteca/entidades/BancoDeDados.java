package com.pooa.biblioteca.entidades;


import java.util.HashMap;

public final class BancoDeDados {
    private static HashMap<Integer, Autor> autores = new HashMap<Integer, Autor>();
    private static HashMap<String, Funcionario> funcionarios = new HashMap<String, Funcionario>();
    private static HashMap<String, Leitor> leitores = new HashMap<String, Leitor>();
    private static HashMap<Integer, CategoriaLeitor> categoriasLeitor = new HashMap<Integer, CategoriaLeitor>();
    private static HashMap<Integer, CategoriaObraLiteraria> categoriasObra = new HashMap<Integer, CategoriaObraLiteraria>();
    private static HashMap<Integer, ObraLiteraria> obrasLiterarias = new HashMap<Integer, ObraLiteraria>();


    public static HashMap<Integer, Autor> getAutores() {
        return autores;
    }
    public static void addAutor(Autor autor) {
        BancoDeDados.autores.put(autor.getCodigo(), autor);
    }
    public static void imprimeAutores() {
        for(Autor i : autores.values()) {
            i.imprimirInfo();
        }
    }

    public static HashMap<String, Funcionario> getFuncionarios() {
        return funcionarios;
    }
    public static void addFuncionario(Funcionario funcionario) {
        BancoDeDados.funcionarios.put(funcionario.getNumeroUfscar(), funcionario);
    }
    public static void imprimeFuncionarios() {
        for(Funcionario i : funcionarios.values()) {
            i.imprimirInfo();
        }
    }

    public static HashMap<String, Leitor> getLeitores() {
        return leitores;
    }
    public static void addLeitor(Leitor leitor) {
        BancoDeDados.leitores.put(leitor.getNumeroUfscar(), leitor);
    }
    public static void imprimeLeitores() {
        for(Leitor i : leitores.values()) {
            i.imprimirInfo();
        }
    }

    public static HashMap<Integer, CategoriaLeitor> getCategoriasLeitor() {
        return categoriasLeitor;
    }
    public static void addCategoriaLeitor(CategoriaLeitor categoriaLeitor) {
        BancoDeDados.categoriasLeitor.put(categoriaLeitor.getCodigo(), categoriaLeitor);
    }
    public static void imprimeCategoriasLeitor() {
        for(CategoriaLeitor i : categoriasLeitor.values()) {
            i.imprimirInfo();
        }
    }

    public static HashMap<Integer, CategoriaObraLiteraria> getCategoriasObra() {
        return categoriasObra;
    }
    public static void addCategoriaObra(CategoriaObraLiteraria categoriaObra) {
        BancoDeDados.categoriasObra.put(categoriaObra.getCodigo(), categoriaObra);
    }
    public static void imprimeCategoriasObra() {
        for(CategoriaObraLiteraria i : categoriasObra.values()) {
            i.imprimirInfo();
        }
    }

    public static HashMap<Integer, ObraLiteraria> getObrasLiterarias() {
        return obrasLiterarias;
    }
    public static void addObraLiteraria(ObraLiteraria obraLiteraria) {
        BancoDeDados.obrasLiterarias.put(obraLiteraria.getCodigo(), obraLiteraria);
    }
    public static void imprimeObras() {
        for(ObraLiteraria i : obrasLiterarias.values()) {
            i.imprimirInfo();
        }
    }
}
