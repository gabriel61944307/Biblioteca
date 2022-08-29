package entidades;

import java.time.LocalDate;
import java.util.ArrayList;

class Devolucao {
	private CopiaObraLiteraria copiaDevolvida;
	private LocalDate dataDevolucao;
	private Leitor leitor;
	private Double multa = 0.0;
	
	public Devolucao() {}
	public Devolucao(CopiaObraLiteraria copiaDevolvida, Leitor leitor) {
		this.copiaDevolvida = copiaDevolvida;
		this.dataDevolucao = LocalDate.now();
		this.leitor = leitor;
	}
	
	public CopiaObraLiteraria getCopiaDevolvida() {
		return copiaDevolvida;
	}
	public void setCopiaDevolvida(CopiaObraLiteraria copiaDevolvida) {
		this.copiaDevolvida = copiaDevolvida;
	}
	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public Leitor getLeitor() {
		return leitor;
	}
	public void setLeitor(Leitor leitor) {
		this.leitor = leitor;
	}
	
	public void realizar() {
		Emprestimo emprestimo;
		ArrayList<Emprestimo> emprestimosAtivos = this.leitor.getEmprestimosAtivos();
		
		for(int i = 0; i < emprestimosAtivos.size(); i++) {
			if(emprestimosAtivos.get(i).getCopiaEmprestada().getNumeroSequencial() == this.copiaDevolvida.getNumeroSequencial()) {
				emprestimo = emprestimosAtivos.get(i);
				
				this.copiaDevolvida.getEstado().disponibilizarObra(this.copiaDevolvida);
				this.leitor.getEmprestimosAtivos().remove(i);
				this.multa = calculaMulta(emprestimo.getDataPrevistaDevolucao(), emprestimo.getCopiaEmprestada().getObra());
				this.leitor.setMulta(this.leitor.getMulta() + this.multa);
			}
		}
		
		
	}
	
	private double calculaMulta(LocalDate dataPrevistaDevolucao, ObraLiteraria obra) {
		if(LocalDate.now().isAfter(dataPrevistaDevolucao)) {
			return  dataPrevistaDevolucao.until(LocalDate.now()).getDays() * obra.getCategoriaObraLiteraria().getTaxaDiariaMulta();
		}
		return 0.0;
	}
}
