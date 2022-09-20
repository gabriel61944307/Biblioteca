package com.pooa.biblioteca.controladores;


import com.pooa.biblioteca.entidades.BancoDeDados;
import com.pooa.biblioteca.entidades.FabricaAutor;
import com.pooa.biblioteca.entidades.FabricaFuncionario;
import com.pooa.biblioteca.entidades.FabricaLeitor;
import com.pooa.biblioteca.entidades.IPessoa;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/pessoa")
@ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 400, message = "This is a bad request, please follow the API documentation for the proper request format"),
        @io.swagger.annotations.ApiResponse(code = 401, message = "Due to security constraints, your access request cannot be authorized"),
        @io.swagger.annotations.ApiResponse(code = 500, message = "The server is down. Please bear with us."),
}
)
public class ControladorPessoas {

    public static void cadastrarAutor() {

        FabricaAutor fabricaAutor = new FabricaAutor();

        IPessoa autor1 = fabricaAutor.criar("gabriel", "111", "10/10/2010",
                "1", "casa", "45", "padaria", "monjolinho",
                "Sao Carlos", "Sao Paulo", "SP", "Brasil", 0);

        IPessoa autor2 = fabricaAutor.criar("lucas", "222", "11/10/2010",
                "1", "casa", "45", "padaria", "monjolinho",
                "Sao Carlos", "Sao Paulo", "SP", "Brasil", 2);

        IPessoa autor3 = fabricaAutor.criar("tiago", "333", "12/10/2010",
                "1", "casa", "45", "padaria", "monjolinho",
                "Sao Carlos", "Sao Paulo", "SP", "Brasil", 5);

        autor1.cadastrar();
        autor2.cadastrar();
        autor3.cadastrar();

        imprimirInfoAutor();

    }

    public static void alterarAutor(int codigo) {

        IPessoa autor = BancoDeDados.getAutores().get(codigo);

        autor.alterar("joaquina", null, "13/07/2000", null);

        imprimirInfoAutor();

    }

    public static void removerAutor(int codigo) {

        IPessoa autor = BancoDeDados.getAutores().get(codigo);

        autor.remover();

        imprimirInfoAutor();

    }

    public static void imprimirInfoAutor() {

        //BancoDeDados.imprimeAutores();

    }

    public static void cadastrarFuncionario() {

        FabricaFuncionario fabricaFuncionario = new FabricaFuncionario();

        // TESTE DE CADASTRO, ALTERACAO E REMOCAO DE FUNCIONARIO

        IPessoa funcionario1 = fabricaFuncionario.criar("gabriel", "111", "10/10/2010",
                "1", "casa", "45", "padaria", "monjolinho",
                "Sao Carlos", "Sao Paulo", "SP", "Brasil", "12345");

        IPessoa funcionario2 = fabricaFuncionario.criar("lucas", "222", "11/11/2011",
                "1", "casa", "45", "padaria", "monjolinho",
                "Sao Carlos", "Sao Paulo", "SP", "Brasil", "54321");


        funcionario1.cadastrar();
        funcionario2.cadastrar();

        imprimirInfoFuncionario();

    }

    public static void alterarFuncionario(String numeroUfscar) {

        IPessoa funcionario = BancoDeDados.getFuncionarios().get(numeroUfscar);

        funcionario.alterar("gesonildo", "333", "01/01/2001", null);

        imprimirInfoFuncionario();
    }

    public static void removerFuncionario(String numeroUfscar) {

        IPessoa funcionario = BancoDeDados.getFuncionarios().get(numeroUfscar);

        funcionario.remover();

        imprimirInfoFuncionario();
    }

    public static void imprimirInfoFuncionario() {

        //BancoDeDados.imprimeAutores();

    }

    public static void cadastrarLeitor() {

        FabricaLeitor fabricaLeitor = new FabricaLeitor();

        // TESTE CADASTRO ALTERACAO E REMOCAO DE LEITOR

        IPessoa leitor1 = fabricaLeitor.criar("gabriel", "111", "10/10/2010", "1", "casa", "45", "padaria", "monjolinho", "Sao Carlos", "Sao Paulo", "SP", "Brasil", "ec1c550c-96da-4703-8dd3-3724cbd6a687", "gabriel@gmail.com", BancoDeDados.getCategoriasLeitor().get(2));
        IPessoa leitor2 = fabricaLeitor.criar("lucas", "222", "11/11/2011", "1", "casa", "45", "padaria", "monjolinho", "Sao Carlos", "Sao Paulo", "SP", "Brasil", "03dec7a5-9b4e-4d73-a87f-c00ff03d71b7", "lucas@gmail.com", BancoDeDados.getCategoriasLeitor().get(2));
        IPessoa leitor3 = fabricaLeitor.criar("leonardo", "222", "11/11/2011", "1", "casa", "45", "padaria", "monjolinho", "Sao Carlos", "Sao Paulo", "SP", "Brasil", "3fa85f64-5717-4562-b3fc-2c963f66afa6", "lucas@gmail.com", BancoDeDados.getCategoriasLeitor().get(2));


        leitor1.cadastrar();
        leitor2.cadastrar();
        leitor3.cadastrar();

        imprimirInfoLeitor();

    }

    public static void alterarLeitor(String numeroUfscar) {

        IPessoa leitor = BancoDeDados.getLeitores().get(numeroUfscar);

        leitor.alterar("joaquina", null, "20/03/1999", null, null, null);

        imprimirInfoLeitor();
    }

    public static void removerLeitor(String numeroUfscar) {

        IPessoa leitor = BancoDeDados.getLeitores().get(numeroUfscar);

        leitor.remover();

        imprimirInfoLeitor();
    }

    public static void imprimirInfoLeitor() {

        //BancoDeDados.imprimeLeitores();

    }

    public static boolean verificarPendencia(String numeroUfscar) {
        IPessoa leitor = BancoDeDados.getLeitores().get(numeroUfscar);

        System.out.println(leitor.getMulta());

        if (leitor.getMulta() > 0) {
            //leitor possui pendencia
            return true;
        }
        //leitor nao possui pendencia
        return false;
    }

    @GetMapping("/pendencias/{id}")
    public static ResponseEntity<Boolean> verificarPendenciaResponse(@PathVariable("id") String numeroUfscar) {
        boolean pendencia = verificarPendencia(numeroUfscar);
        System.out.printf(String.valueOf(pendencia));
        return new ResponseEntity<>(pendencia, HttpStatus.OK);
    }
}
