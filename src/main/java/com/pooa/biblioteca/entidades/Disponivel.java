package com.pooa.biblioteca.entidades;

class Disponivel extends EstadoCopia{
    private String nome = "Disponivel";

    @Override
    public void emprestarObra(CopiaObraLiteraria copiaObra) {
        copiaObra.setEstado(new Emprestado());
    }

    @Override
    public void disponibilizarObra(CopiaObraLiteraria copiaObra) {
        System.out.println("Copia ja se encontra disponivel.");
    }

    @Override
    public String getNome() {
        return nome;
    }

}
