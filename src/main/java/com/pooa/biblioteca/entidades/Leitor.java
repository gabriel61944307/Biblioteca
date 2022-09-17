package com.pooa.biblioteca.entidades;

import java.util.ArrayList;

class Leitor extends Pessoa{
    private String numeroUfscar;
    private String email;
    private ICategoriaLeitor categoriaLeitor;
    private double multa = 0;
    private ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
    private ArrayList<Emprestimo> emprestimosAtivos = new ArrayList<Emprestimo>();

    public Leitor() {}
    public Leitor(String nome, String telefone, String dataNasc, String cep, String logradouro, String numero, String complemento, String bairro, String nomeCidade,
                  String nomeEstado, String siglaEstado, String nomePais, String numeroUfscar, String email,
                  ICategoriaLeitor categoriaLeitor) {
        super(nome, telefone, dataNasc, cep, logradouro, numero, complemento, bairro, nomeCidade, nomeEstado, siglaEstado, nomePais);
        this.numeroUfscar = numeroUfscar;
        this.email = email;
        this.categoriaLeitor = categoriaLeitor;
    }

    public String getNumeroUfscar() {
        return numeroUfscar;
    }
    public void setNumeroUfscar(String numeroUfscar) {
        this.numeroUfscar = numeroUfscar;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public ICategoriaLeitor getCategoriaLeitor() {
        return categoriaLeitor;
    }
    public void setCategoriaLeitor(CategoriaLeitor categoriaLeitor) {
        this.categoriaLeitor = categoriaLeitor;
    }

    public double getMulta() {
        return multa;
    }
    public void setMulta(double multa) {
        this.multa = multa;
    }

    @Override
    public void cadastrar() {
        System.out.println("Cadastrando leitor");
        BancoDeDados.addLeitor(this);
    }

    @Override
    public void alterar(String nome, String telefone, String dataNasc, Endereco endereco, String email,
                        CategoriaLeitor categoriaLeitor) {
        System.out.println("Alterando leitor");
        Leitor i = BancoDeDados.getLeitores().get(this.getNumeroUfscar());
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
            if(email != null) {
                i.setEmail(email);
            }
            if(categoriaLeitor != null) {
                i.setCategoriaLeitor(categoriaLeitor);
            }
        }
    }
    @Override
    public void alterar(String nome, String telefone, String dataNasc, Endereco endereco) {/* doNothing. */}

    @Override
    public void remover() {
        System.out.println("Removendo leitor");
        BancoDeDados.getLeitores().remove(this.numeroUfscar);
    }

    @Override
    public void imprimirInfo() {
        System.out.println("NUMEROUFSCAR: " + this.numeroUfscar);
        super.imprimirInfo();
        System.out.println("EMAIL: " + this.email);
        System.out.println("CATEGORIA LEITOR: ");
        this.categoriaLeitor.imprimirInfo();
        System.out.println("MULTA: " + this.multa);
        System.out.println("EMPRESTIMOS DESSE LEITOR: ");
        for(int i = 0; i < this.emprestimos.size(); i++) {
            System.out.println(this.emprestimos.get(i).getCopiaEmprestada().getNumeroSequencial());
        }
        System.out.println("EMPRESTIMOS ATIVOS DESSE LEITOR: ");
        for(int i = 0; i < this.emprestimosAtivos.size(); i++) {
            System.out.println(this.emprestimosAtivos.get(i).getCopiaEmprestada().getNumeroSequencial());
        }
    }
    @Override
    public Integer getCodigo() {
        // doNothing.
        return null;
    }
    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
    public void setEmprestimos(ArrayList<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }
    public ArrayList<Emprestimo> getEmprestimosAtivos() {
        return emprestimosAtivos;
    }
    public void setEmprestimosAtivos(ArrayList<Emprestimo> emprestimosAtivos) {
        this.emprestimosAtivos = emprestimosAtivos;
    }
    public void notificar(ObraLiteraria obraLiteraria) {
        System.out.println("---------------------------");
        System.out.println("Email para: " + this.email);
        System.out.println("O livro " + obraLiteraria.getTitulo() + " se encontra dispon�vel para emprestimo.");
        System.out.println("Cordialmente, sistema biblioteca UFSCar.");
        System.out.println("---------------------------");
    }
}
