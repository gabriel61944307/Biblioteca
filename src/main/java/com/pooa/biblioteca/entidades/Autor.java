package com.pooa.biblioteca.entidades;

class Autor extends Pessoa{
    private Integer codigo;

    public Autor() {}
    public Autor(String nome, String telefone, String dataNasc, String cep, String logradouro, String numero, String complemento, String bairro, String nomeCidade,
                 String nomeEstado, String siglaEstado, String nomePais, Integer codigo) {
        super(nome, telefone, dataNasc, cep, logradouro, numero, complemento, bairro, nomeCidade, nomeEstado, siglaEstado, nomePais);
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    @Override
    public double getMulta() {
        return 0;
    }

    public void setMulta(double multa) {

    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public void cadastrar() {
        System.out.println("Cadastrando autor");
        BancoDeDados.addAutor(this);
    }

    public void alterar(String nome, String telefone, String dataNasc, Endereco endereco) {
        System.out.println("Alterando autor");
        Autor i = BancoDeDados.getAutores().get(this.getCodigo());
        if(i != null) {
            if(nome != null) {
                i.setNome(nome);
            }
            if(telefone != null) {
                i.setTelefone(telefone);
            }
            if(dataNasc != null) {
                i.setDataNasc(dataNasc);
            }
            if(endereco != null) {
                i.setEndereco(endereco);
            }
        }
    }
    @Override
    public void alterar(String nome, String telefone, String dataNasc, Endereco endereco, String email,
                        CategoriaLeitor categoriaLeitor) { /*doNothing*/ }

    @Override
    public void remover() {
        System.out.println("Removendo autor");
        BancoDeDados.getAutores().remove(this.codigo);
    }

    @Override
    public void imprimirInfo() {
        System.out.println("CODIGO AUTOR: " + this.codigo);
        super.imprimirInfo();
    }

}

