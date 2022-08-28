package entidades;

class Funcionario extends Pessoa{
	private String numeroUfscar;
	
	public Funcionario () {}
	public Funcionario (String nome, String telefone, String dataNasc, Endereco endereco, String numeroUfscar) {
		super(nome, telefone, dataNasc, endereco);
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
	
}
