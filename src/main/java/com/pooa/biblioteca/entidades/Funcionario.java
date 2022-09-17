package com.pooa.biblioteca.entidades;

class Funcionario extends Pessoa{
    private String numeroUfscar;

    public Funcionario () {}
    public Funcionario (String nome, String telefone, String dataNasc, String cep, String logradouro, String numero, String complemento, String bairro, String nomeCidade,
                        String nomeEstado, String siglaEstado, String nomePais, String numeroUfscar) {
        super(nome, telefone, dataNasc, cep, logradouro, numero, complemento, bairro, nomeCidade, nomeEstado, siglaEstado, nomePais);
        this.numeroUfscar = numeroUfscar;
    }

    public String getNumeroUfscar() {
        return numeroUfscar;
    }
    public void setNumeroUfscar(String numeroUfscar) {
        this.numeroUfscar = numeroUfscar;
    }

    @Override
    public void cadastrar() {
        System.out.println("Cadastrando funcionario");
        BancoDeDados.addFuncionario(this);
    }
    @Override
    public void alterar(String nome, String telefone, String dataNasc, Endereco endereco) {
        System.out.println("Alterando funcionario");
        Funcionario i = BancoDeDados.getFuncionarios().get(this.getNumeroUfscar());
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
        System.out.println("Removendo funcionario");
        BancoDeDados.getFuncionarios().remove(this.numeroUfscar);
    }

    @Override
    public void imprimirInfo() {
        System.out.println("NUMERO UFSCAR DO FUNCIONARIO: " + this.numeroUfscar);
        super.imprimirInfo();
    }
    @Override
    public Integer getCodigo() {
        // doNothing.
        return null;
    }

    @Override
    public double getMulta() {
        return 0;
    }

}
