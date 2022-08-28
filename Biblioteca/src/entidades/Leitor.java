package entidades;

class Leitor extends Pessoa{
	private String numeroUfscar;
	private String email;
	private ICategoriaLeitor categoriaLeitor;
	private double multa = 0;
	
	public Leitor() {}
	public Leitor(String nome, String telefone, String dataNasc, Endereco endereco, String numeroUfscar, String email,
			ICategoriaLeitor categoriaLeitor) {
		super(nome, telefone, dataNasc, endereco);
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
	}
	@Override
	public Integer getCodigo() {
		// doNothing.
		return null;
	}
}
