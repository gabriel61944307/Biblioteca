package view;

import controladores.ControladorCategoriaLeitor;
import controladores.ControladorCategoriaObraLiteraria;
import controladores.ControladorObra;
import controladores.ControladorPessoas;

public class API {
    public static void main(String[] args) {
        ControladorCategoriaLeitor.criarCategoria();

        ControladorPessoas.criarAutor();
        ControladorPessoas.criarFuncionario();
        ControladorPessoas.criarLeitor();
        
        ControladorCategoriaObraLiteraria.criarCategoria();
        
        ControladorObra.criarObra();

    }
}
