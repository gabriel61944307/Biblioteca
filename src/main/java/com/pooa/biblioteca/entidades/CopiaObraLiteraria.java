package com.pooa.biblioteca.entidades;

class CopiaObraLiteraria {
    private Integer numeroSequencial;
    private ObraLiteraria obra;
    private EstadoCopia estado = new Disponivel();

    public CopiaObraLiteraria(Integer numeroSequencial, ObraLiteraria obra) {
        this.numeroSequencial = numeroSequencial;
        this.obra = obra;
    }

    public Integer getNumeroSequencial() {
        return numeroSequencial;
    }
    public void setNumeroSequencial(Integer numeroSequencial) {
        this.numeroSequencial = numeroSequencial;
    }

    public ObraLiteraria getObra() {
        return obra;
    }
    public void setObra(ObraLiteraria obra) {
        this.obra = obra;
    }

    public EstadoCopia getEstado() {
        return estado;
    }
    public void setEstado(EstadoCopia estado) {
        this.estado = estado;
    }




}

