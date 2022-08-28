package entidades;

class CategoriaLeitor implements ICategoriaLeitor{
	private Integer codigo;
	private Integer maximoDiasEmprestimo;
	private String descricao;
	
	public CategoriaLeitor() {}
	public CategoriaLeitor(Integer codigo, Integer maximoDiasEmprestimo, String descricao) {
		this.codigo = codigo;
		this.maximoDiasEmprestimo = maximoDiasEmprestimo;
		this.descricao = descricao;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public Integer getMaximoDiasEmprestimo() {
		return maximoDiasEmprestimo;
	}
	public void setMaximoDiasEmprestimo(Integer maximoDiasEmprestimo) {
		this.maximoDiasEmprestimo = maximoDiasEmprestimo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public void cadastrar() {
		System.out.println("CADASTRANDO TIPOLEITOR");
		BancoDeDados.addCategoriaLeitor(this);
	}
	@Override
	public void alterar(Integer maximoDiasEmprestimo, String descricao) {
		System.out.println("ALTERANDO TIPOLEITOR");
		CategoriaLeitor i = BancoDeDados.getCategoriasLeitor().get(this.codigo);
		if(i != null) {
			if(maximoDiasEmprestimo != null) {
				i.setMaximoDiasEmprestimo(maximoDiasEmprestimo);
			}
			if(descricao != null) {
				i.setDescricao(descricao);
			}
		}
	}
	@Override
	public void remover() {
		System.out.println("REMOVENDO TIPOLEITOR");
		BancoDeDados.getCategoriasLeitor().remove(this.codigo);
	}
	
	public void imprimirInfo() {
		System.out.println("CODIGO: " + this.codigo);
		System.out.println("MAXIMO DIAS EMPRESTIMO: " + this.maximoDiasEmprestimo);
		System.out.println("DESCRICAO: " + this.descricao);
	}
	
}
