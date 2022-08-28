package entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Emprestimo{
	private LocalDate dataEmprestimo;
	private LocalDate dataPrevistaDevolucao;
	private Funcionario funcionario;
	private CopiaObraLiteraria copiaEmprestada;
	private Leitor leitor;
	
	public Emprestimo() {}
	public Emprestimo(String dataEmprestimo, String dataPrevistaDevolucao, Funcionario funcionario, CopiaObraLiteraria copiaEmprestada,
			Leitor leitor) {
		this.dataEmprestimo = LocalDate.parse(dataEmprestimo, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		this.dataPrevistaDevolucao = LocalDate.parse(dataPrevistaDevolucao, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		this.funcionario = funcionario;
		this.copiaEmprestada = copiaEmprestada;
		this.leitor = leitor;
	}
	
	public void realizarEmprestimo(String dataEmprestimo, String dataPrevistaDevolucao, Funcionario funcionario, CopiaObraLiteraria copiaEmprestada,
			Leitor leitor) {
		 
	}
	
}
