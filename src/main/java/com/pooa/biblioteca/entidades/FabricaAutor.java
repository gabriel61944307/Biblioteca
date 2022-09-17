package com.pooa.biblioteca.entidades;

public class FabricaAutor{

    public Pessoa criar(String nome, String telefone, String dataNasc, String cep, String logradouro, String numero, String complemento, String bairro, String nomeCidade,
                        String nomeEstado, String siglaEstado, String nomePais, Integer codigo) {
        return new Autor(nome, telefone, dataNasc, cep, logradouro, numero, complemento, bairro, nomeCidade, nomeEstado, siglaEstado, nomePais, codigo);
    }


}
