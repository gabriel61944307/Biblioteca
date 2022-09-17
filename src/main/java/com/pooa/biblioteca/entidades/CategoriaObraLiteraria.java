package com.pooa.biblioteca.entidades;

class CategoriaObraLiteraria implements ICategoriaObraLiteraria{
    private Integer codigo;
    private String descricao;
    private Integer maximoDiasEmprestimo;
    private Double taxaDiariaMulta;

    public CategoriaObraLiteraria(Integer codigo, String descricao, Integer maximoDiasEmprestimo,
                                  Double taxaDiariaMulta) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.maximoDiasEmprestimo = maximoDiasEmprestimo;
        this.taxaDiariaMulta = taxaDiariaMulta;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getMaximoDiasEmprestimo() {
        return maximoDiasEmprestimo;
    }
    public void setMaximoDiasEmprestimo(int maximoDiasEmprestimo) {
        this.maximoDiasEmprestimo = maximoDiasEmprestimo;
    }

    public Double getTaxaDiariaMulta() {
        return taxaDiariaMulta;
    }
    public void setTaxaDiariaMulta(double taxaDiariaMulta) {
        this.taxaDiariaMulta = taxaDiariaMulta;
    }

    @Override
    public void cadastrar() {
        System.out.println("Cadastrando categoria obra literaria");
        BancoDeDados.addCategoriaObra(this);

    }
    @Override
    public void alterar(String descricao, Integer maximoDiasEmprestimo, Double taxaDiariaMulta) {
        System.out.println("Alterando categoria obra literaria");
        CategoriaObraLiteraria i = BancoDeDados.getCategoriasObra().get(this.codigo);
        if(i != null) {
            if(descricao != null) {
                i.setDescricao(descricao);;
            }
            if(maximoDiasEmprestimo != null) {
                i.setMaximoDiasEmprestimo(maximoDiasEmprestimo);
            }
            if(taxaDiariaMulta != null) {
                i.setTaxaDiariaMulta(taxaDiariaMulta);
            }
        }
    }
    @Override
    public void remover() {
        System.out.println("Removendo categoria obra literaria");
        BancoDeDados.getCategoriasObra().remove(this.codigo);
    }
    @Override
    public void imprimirInfo() {
        System.out.println("CODIGO: " + this.codigo);
        System.out.println("DESCRICAO: " + this.descricao);
        System.out.println("MAXIMO DIAS EMPRESTIMO: " + this.maximoDiasEmprestimo);
        System.out.println("TAXA DIARIA MULTA: " + this.taxaDiariaMulta);
    }

}
