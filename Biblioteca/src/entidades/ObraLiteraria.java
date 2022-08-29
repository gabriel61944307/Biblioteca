package entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class ObraLiteraria implements IObraLiteraria{
	private Integer codigo;
	private Integer ISBN;
	private String titulo;
	private ICategoriaObraLiteraria categoriaObraLiteraria;
	private HashMap<Integer, IPessoa> autores = new HashMap<Integer, IPessoa>();
	private String palavrasChave;
	private LocalDate dataPublicacao;
	private Editora editora;
	private Integer numeroPaginas;
	private HashMap<Integer, CopiaObraLiteraria> copias = new HashMap<Integer, CopiaObraLiteraria>();
	private ArrayList<Reserva> reservas = new ArrayList<>();
	
	public ObraLiteraria(Integer codigo, Integer ISBN, String titulo, ICategoriaObraLiteraria categoriaObraLiteraria,
			String palavrasChave, String dataPublicacao, Editora editora, Integer numeroPaginas) {
		this.codigo = codigo;
		this.ISBN = ISBN;
		this.titulo = titulo;
		this.categoriaObraLiteraria = categoriaObraLiteraria;
		this.palavrasChave = palavrasChave;
		this.dataPublicacao = LocalDate.parse(dataPublicacao, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		this.editora = editora;
		this.numeroPaginas = numeroPaginas;
	}
	
	@Override
	public void cadastrar() {
		System.out.println("Cadastrando obra");
		BancoDeDados.addObraLiteraria(this);
	}
	@Override
	public void alterar(Integer ISBN, String titulo, ICategoriaObraLiteraria categoriaObraLiteraria,
			String palavrasChave, String dataPublicacao, Editora editora, Integer numeroPaginas) {
		System.out.println("Alterando obra");
		ObraLiteraria i = BancoDeDados.getObrasLiterarias().get(this.codigo);
		if(i != null) {
			if(ISBN != null) {
				i.setISBN(ISBN);
			}
			if(titulo != null) {
				i.setTitulo(titulo);
			}
			if(categoriaObraLiteraria != null) {
				i.setCategoriaObraLiteraria(categoriaObraLiteraria);
			}
			if(palavrasChave != null) {
				i.setPalavrasChave(palavrasChave);
			}
			if(dataPublicacao != null) {
				i.setDataPublicacao(dataPublicacao);
			}
			if(editora != null) {
				i.setEditora(editora);
			}
			if(numeroPaginas != null) {
				i.setNumeroPaginas(numeroPaginas);
			}
		}
	}
	@Override
	public void remover() {
		System.out.println("Removendo obra");
		BancoDeDados.getObrasLiterarias().remove(this.codigo);
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public ICategoriaObraLiteraria getCategoriaObraLiteraria() {
		return categoriaObraLiteraria;
	}
	public void setCategoriaObraLiteraria(ICategoriaObraLiteraria categoriaObraLiteraria) {
		this.categoriaObraLiteraria = categoriaObraLiteraria;
	}
	public HashMap<Integer, IPessoa> getAutores() {
		return autores;
	}
	public void addAutor(IPessoa autor) {
		this.autores.put(autor.getCodigo(), autor);
	}
	public String getPalavrasChave() {
		return palavrasChave;
	}
	public void setPalavrasChave(String palavrasChave) {
		this.palavrasChave = palavrasChave;
	}
	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}
	public void setDataPublicacao(String dataPublicacao) {
		this.dataPublicacao = LocalDate.parse(dataPublicacao, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	public Editora getEditora() {
		return editora;
	}
	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	public int getNumeroPaginas() {
		return numeroPaginas;
	}
	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}
	public HashMap<Integer, CopiaObraLiteraria> getCopias() {
		return copias;
	}
	public void addCopia(CopiaObraLiteraria copia) {
		this.copias.put(copia.getNumeroSequencial(), copia);
	}
	@Override
	public void criarCopia(Integer numeroSequencial) {
		addCopia(new CopiaObraLiteraria(numeroSequencial, this));
	}
	public ArrayList<Reserva> getReservas() {
		return reservas;
	}
	public void addReserva(Reserva reserva) {
		this.reservas.add(reserva);
	}

	@Override
	public void imprimirInfo() {
		System.out.println("CODIGO: " + this.codigo);
		System.out.println("ISBN: " + this.ISBN);
		System.out.println("TITULO: " + this.titulo);
		System.out.println("CATEGORIA: ");
		this.categoriaObraLiteraria.imprimirInfo();
		//LISTA AUTORES
		System.out.println("AUTORES: ");
		System.out.println("****************************");
		for(IPessoa i : this.autores.values()) {
			i.imprimirInfo();
		}
		System.out.println("****************************");
		//
		System.out.println("PALAVRAS CHAVE: " + this.palavrasChave);
		System.out.println("DATA PUBLICACAO: " + this.dataPublicacao);
		System.out.println("EDITORA: " + this.editora.getNome());
		System.out.println("NUMERO DE PAGINAS: " + this.numeroPaginas);
		//LISTA COPIAS
		System.out.println("COPIAS: ");
		System.out.println("****************************");
		for(CopiaObraLiteraria i : this.copias.values()) {
			System.out.println(i.getNumeroSequencial() + " " + i.getEstado().getNome());
		}
		System.out.println("****************************");
		//LISTA RESERVAS
	}

	@Override
	public void emprestar(String numeroUfscarFuncionario, Integer numeroSequencialCopia,
			String numeroUfscarLeitor) {
		Funcionario funcionario = BancoDeDados.getFuncionarios().get(numeroUfscarFuncionario);
		CopiaObraLiteraria copia = BancoDeDados.getObrasLiterarias().get(this.codigo).getCopias().get(numeroSequencialCopia);
		Leitor leitor = BancoDeDados.getLeitores().get(numeroUfscarLeitor);
		
		Emprestimo emprestimo = new Emprestimo(funcionario, copia, leitor);
		emprestimo.realizar();
	}

	@Override
	public void devolver(Integer numeroSequencialCopia, String numeroUfscarLeitor) {
		CopiaObraLiteraria copia = BancoDeDados.getObrasLiterarias().get(this.codigo).getCopias().get(numeroSequencialCopia);
		Leitor leitor = BancoDeDados.getLeitores().get(numeroUfscarLeitor);
		
		Devolucao devolucao = new Devolucao(copia, leitor);
		devolucao.realizar();
	}

	@Override
	public void reservar(String dataRetirada, String numeroUfscarFuncionario, String numeroUfscarLeitor) {
		Funcionario funcionario = BancoDeDados.getFuncionarios().get(numeroUfscarFuncionario);
		Leitor leitor = BancoDeDados.getLeitores().get(numeroUfscarLeitor);
		
		Reserva reserva = new Reserva(dataRetirada, funcionario, leitor, this);
		reserva.realizar();
	}
	
}
