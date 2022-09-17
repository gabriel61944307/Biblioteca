package com.pooa.biblioteca.entidades;

abstract class EstadoCopia  {
    public abstract void emprestarObra(CopiaObraLiteraria copiaObra);
    public abstract void disponibilizarObra(CopiaObraLiteraria copiaObra);
    public abstract String getNome();
}

