package entidades;

abstract class EstadoCopia  {
	private String nome = "";
	
	public abstract void emprestarObra(CopiaObraLiteraria copiaObra);
	public abstract void disponibilizarObra(CopiaObraLiteraria copiaObra);
	public abstract String getNome();
}
