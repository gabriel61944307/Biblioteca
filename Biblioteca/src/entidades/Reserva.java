package entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Reserva {
	private LocalDate dataReserva;
	private LocalDate dataRetirada;
	private LocalDate dataPrevistaDevolucao;
	private Funcionario funcionarioResponsavel;
	private Leitor leitor;
	private ObraLiteraria obra;
	
	public Reserva() {}
	public Reserva(String dataRetirada, Funcionario funcionarioResponsavel, Leitor leitor, ObraLiteraria obra) {
		this.dataReserva = LocalDate.now();
		this.dataRetirada = LocalDate.parse(dataRetirada, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		this.dataPrevistaDevolucao = Emprestimo.calcularDataDevolucao(obra, leitor);
		this.funcionarioResponsavel = funcionarioResponsavel;
		this.leitor = leitor;
		this.obra = obra;
	}
	
	public LocalDate getDataReserva() {
		return dataReserva;
	}
	public void setDataReserva(LocalDate dataReserva) {
		this.dataReserva = dataReserva;
	}
	public LocalDate getDataRetirada() {
		return dataRetirada;
	}
	public void setDataRetirada(LocalDate dataRetirada) {
		this.dataRetirada = dataRetirada;
	}
	public LocalDate getDataPrevistaDevolucao() {
		return dataPrevistaDevolucao;
	}
	public void setDataPrevistaDevolucao(LocalDate dataPrevistaDevolucao) {
		this.dataPrevistaDevolucao = dataPrevistaDevolucao;
	}
	public Funcionario getFuncionarioResponsavel() {
		return funcionarioResponsavel;
	}
	public void setFuncionarioResponsavel(Funcionario funcionarioResponsavel) {
		this.funcionarioResponsavel = funcionarioResponsavel;
	}
	public Leitor getLeitor() {
		return leitor;
	}
	public void setLeitor(Leitor leitor) {
		this.leitor = leitor;
	}
	public ObraLiteraria getObra() {
		return obra;
	}
	public void setObra(ObraLiteraria obra) {
		this.obra = obra;
	}
	
	
	
	public void realizar() {
		//Uma reserva de obra s� pode ser feita se o requisitante estiver inscrito em pelo menos uma disciplina 
		//e participar de um grupo acad�mico da universidade
		int reservaMesmoPeriodo = 0;
		for(Reserva i : obra.getReservas()) {
			if(!(this.dataPrevistaDevolucao.isBefore(i.getDataRetirada()) 
					|| this.dataRetirada.isAfter(i.getDataPrevistaDevolucao())) ) {
				reservaMesmoPeriodo++;
			}
		}
		for(Leitor i : BancoDeDados.getLeitores().values()) {
			for(Emprestimo j : i.getEmprestimosAtivos()) {
				if( !(this.dataRetirada.isAfter(j.getDataPrevistaDevolucao())) && 
						j.getCopiaEmprestada().getObra().getCodigo() == this.obra.getCodigo()) {
					reservaMesmoPeriodo++;
				}
			}
		}
		
		
		if(reservaMesmoPeriodo < this.obra.getCopias().size()) {
			obra.addReserva(this);
			System.out.println("Reserva concluida.");
		}
		else {
			System.out.println("Nao ha obras suficientes para reservar neste periodo.");
		}
	}
}
