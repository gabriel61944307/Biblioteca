package entidades;

class Autor extends Pessoa{
	private Integer codigo;

	public Autor() {}
	public Autor(String nome, String telefone, String dataNasc, Endereco endereco, Integer codigo) {
		super(nome, telefone, dataNasc, endereco);
		this.codigo = codigo;
	}
	
	public Integer getCodigo() {
		return codigo;
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
