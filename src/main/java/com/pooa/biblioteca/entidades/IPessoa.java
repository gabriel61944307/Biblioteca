package com.pooa.biblioteca.entidades;

public interface IPessoa {
    public void cadastrar();
    public void remover();
    public void imprimirInfo();
    public void alterar(String nome, String telefone, String dataNasc, Endereco endereco);
    public void alterar(String nome, String telefone, String dataNasc, Endereco endereco, String email,
                        CategoriaLeitor categoriaLeitor);
    public Integer getCodigo();
    public double getMulta();
    public void setMulta(double multa);
}

