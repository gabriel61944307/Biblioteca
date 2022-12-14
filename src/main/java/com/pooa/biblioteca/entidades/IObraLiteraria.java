package com.pooa.biblioteca.entidades;

public interface IObraLiteraria {
    public void cadastrar();
    public void alterar(Integer ISBN, String titulo, ICategoriaObraLiteraria categoriaObraLiteraria,
                        String palavrasChave, String dataPublicacao, Editora editora, Integer numeroPaginas);
    public void remover();
    public void criarCopia(Integer numeroSequencial);
    public void addAutor(IPessoa autor);
    public void imprimirInfo();
    public void emprestar(String numeroUfscarFuncionario, Integer numeroSequencialCopia,
                          String numeroUfscarLeitor);
    public void devolver(Integer numeroSequencialCopia, String numeroUfscarLeitor);
    public void reservar(String dataRetirada, String numeroUfscarFuncionario, String numeroUfscarLeitor);
    public void adicionarInteressado(String numeroUfscar);
    public void removerInteressado(String numeroUfscar);
}