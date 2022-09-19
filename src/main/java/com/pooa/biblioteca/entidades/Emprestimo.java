package com.pooa.biblioteca.entidades;

import com.pooa.biblioteca.controladores.ControladorSpringBootRest;

import java.time.LocalDate;

class Emprestimo {
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolucao;
    private Funcionario funcionario;
    private CopiaObraLiteraria copiaEmprestada;
    private Leitor leitor;

    public Emprestimo() {}
    public Emprestimo(Funcionario funcionario, CopiaObraLiteraria copiaEmprestada, Leitor leitor) {
        this.dataEmprestimo = LocalDate.now();
        this.dataPrevistaDevolucao = calcularDataDevolucao(copiaEmprestada.getObra(), leitor);
        this.funcionario = funcionario;
        this.copiaEmprestada = copiaEmprestada;
        this.leitor = leitor;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }
    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }
    public LocalDate getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }
    public void setDataPrevistaDevolucao(LocalDate dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }
    public Funcionario getFuncionario() {
        return funcionario;
    }
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    public CopiaObraLiteraria getCopiaEmprestada() {
        return copiaEmprestada;
    }
    public void setCopiaEmprestada(CopiaObraLiteraria copiaEmprestada) {
        this.copiaEmprestada = copiaEmprestada;
    }
    public Leitor getLeitor() {
        return leitor;
    }
    public void setLeitor(Leitor leitor) {
        this.leitor = leitor;
    }

    public void realizar() {
        //O empr�stimo s� pode ser feito se o requisitante estiver inscrito em pelo menos uma disciplina
        //e tiver participado pelo menos de um grupo acad�mico no passado, mesmo que o grupo j� esteja desativado.
        if (ControladorSpringBootRest.verificarGrupoAcademico(this.leitor.getNumeroUfscar())) {
            this.copiaEmprestada.getEstado().emprestarObra(this.copiaEmprestada);
            this.leitor.getEmprestimos().add(this);
            this.leitor.getEmprestimosAtivos().add(this);
        } else {
            System.out.println("Leitor: " + this.leitor.getNumeroUfscar() + " nunca foi inscrito em um Grupo Acadêmico");
        }
    }

    static LocalDate calcularDataDevolucao(ObraLiteraria obraEmprestada, Leitor leitor) {
        //Data da devolucao
        LocalDate data = LocalDate.now();

        //Recuperando o maximo de dias que a obra pode ser emprestada
        int diasEmprestimoObra = obraEmprestada.getCategoriaObraLiteraria().getMaximoDiasEmprestimo();

        //Recuperando o maximo de dias que o leitor pode ficar com uma obra
        int diasEmprestimoLeitor = leitor.getCategoriaLeitor().getMaximoDiasEmprestimo();

        if(diasEmprestimoObra < diasEmprestimoLeitor)
            return data.plusDays(diasEmprestimoObra);
        return data.plusDays(diasEmprestimoLeitor);

    }
}
