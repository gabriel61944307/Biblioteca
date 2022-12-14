package com.pooa.biblioteca.entidades;

public interface ICategoriaLeitor {
    public void cadastrar();
    public void alterar(Integer maximoDiasEmprestimo, String descricao);
    public void remover();
    public void imprimirInfo();
    public Integer getMaximoDiasEmprestimo();
}