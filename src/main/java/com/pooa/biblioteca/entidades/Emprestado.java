package com.pooa.biblioteca.entidades;

class Emprestado extends EstadoCopia{
    private String nome = "Emprestado";

    @Override
    public void emprestarObra(CopiaObraLiteraria copiaObra) {
        System.out.println("Copia ja se encontra emprestada.");

    }

    @Override
    public void disponibilizarObra(CopiaObraLiteraria copiaObra) {
        copiaObra.setEstado(new Disponivel());
        copiaObra.getObra().notificarInteressados();
    }

    @Override
    public String getNome() {
        return nome;
    }

}
