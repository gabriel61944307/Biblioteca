package com.pooa.biblioteca.controladores;

import com.pooa.biblioteca.entidades.BancoDeDados;
import com.pooa.biblioteca.entidades.FabricaObraLiteraria;
import com.pooa.biblioteca.entidades.IObraLiteraria;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
public class ControladorObra {
    public static void cadastrarObra() {
        FabricaObraLiteraria fabricaObraLiteraria = new FabricaObraLiteraria();

        IObraLiteraria obra1 = fabricaObraLiteraria.criar(123, 321, "a bela e a fera", BancoDeDados.getCategoriasObra().get(2), "conto de fadas",
                "11/09/1991", "Editora1", "11935535", "cnpj", "editora@gmail.com", 500);

        IObraLiteraria obra2 = fabricaObraLiteraria.criar(0, 456, "alice no pais das maravilhas", BancoDeDados.getCategoriasObra().get(2), "conto de fadas",
                "11/09/1990", "Editora1", "11935535", "cnpj", "editora@gmail.com", 200);

        obra1.cadastrar();
        obra2.cadastrar();

    }

    public static void alterarObra(int codigo) {

        IObraLiteraria obra = BancoDeDados.getObrasLiterarias().get(codigo);

        obra.alterar(null, "branca de neve", null, null, null, null, null);

    }

    public static void removerObra(int codigo) {

        IObraLiteraria obra = BancoDeDados.getObrasLiterarias().get(codigo);

        obra.remover();

    }

    public static void criarCopia(int codigoObra, int codigoCopia) {

        IObraLiteraria obra = BancoDeDados.getObrasLiterarias().get(codigoObra);

        obra.criarCopia(codigoCopia);

    }

    public static void addAutor(int codigoObra, int codigoAutor) {

        IObraLiteraria obra = BancoDeDados.getObrasLiterarias().get(codigoObra);

        obra.addAutor(BancoDeDados.getAutores().get(codigoAutor));

    }

    public static void imprimirInfo() {

        BancoDeDados.imprimeObras();

    }

    public static void emprestar(int codigo, String numeroUfscarFuncionario, Integer numeroSequencialCopia, String numeroUfscarLeitor) {
        if (verificarGrupoAcademico(numeroUfscarLeitor) && verificarDisciplinas(numeroUfscarLeitor)) {
            IObraLiteraria obra = BancoDeDados.getObrasLiterarias().get(codigo);

            obra.emprestar(numeroUfscarFuncionario, numeroSequencialCopia, numeroUfscarLeitor);
            System.out.println("Empréstimo realizado com sucesso");
        } else {
            System.out.println("Leitor não possui os requisitos para fazer um empréstimo");
        }

    }

    public static void devolver(int codigo, Integer numeroSequencialCopia, String numeroUfscarLeitor) {

        IObraLiteraria obra = BancoDeDados.getObrasLiterarias().get(codigo);

        obra.devolver(numeroSequencialCopia, numeroUfscarLeitor);

    }

    public static void reservar(int codigo, String dataRetirada, String numeroUfscarFuncionario, String numeroUfscarLeitor) {

        if (verificarGrupoAcademicoAtivo(numeroUfscarLeitor) && verificarDisciplinas(numeroUfscarLeitor)) {
            IObraLiteraria obra = BancoDeDados.getObrasLiterarias().get(codigo);

            obra.reservar(dataRetirada, numeroUfscarFuncionario, numeroUfscarLeitor);
            System.out.println("Reserva realizada com sucesso");
        } else {
            System.out.println("Leitor não possui os requisitos para fazer uma reserva");
        }

    }

    public static void cadastrarInteressado(Integer codigoObra, String codigoLeitor) {
        IObraLiteraria obra = BancoDeDados.getObrasLiterarias().get(codigoObra);
        obra.adicionarInteressado(codigoLeitor);
    }
    public static void removerInteressado(Integer codigoObra, String codigoLeitor) {
        IObraLiteraria obra = BancoDeDados.getObrasLiterarias().get(codigoObra);
        obra.removerInteressado(codigoLeitor);
    }

    public static boolean verificarGrupoAcademico(String numeroUfscarLeitor){
        /*String id1 = "03dec7a5-9b4e-4d73-a87f-c00ff03d71b7"; //ID do leitor
        String id2 = "3fa85f64-5717-4562-b3fc-2c963f66afa6"; //ID do leitor
        String id3 = "ec1c550c-96da-4703-8dd3-3724cbd6a687"; //ID do leitor sem grupo academico*/
        String url = "https://pooa-grupos-academicos.herokuapp.com/user/"+ numeroUfscarLeitor + "/academicGroup";
        RestTemplate restTemplate = new RestTemplate();
        String accessToken = "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiIzZmE4NWY2NC01NzE3LTQ1NjItYjNmYy0yYzk2M2Y2NmFmYTYiLCJpYXQiOjE2NjM2ODE3MDYsImV4cCI6MTY2MzY4NTMwNn0.S-7_rQsJYFBB81IB-0OmQHLgSe5uT4iQIAY22GrFq-XE71ho4frKaU9pc0IRuF4VumfYhngtTApvJbBm2l97xTJaXDAefmmxE26WTb2bQS8fv6cA1YtL2fTSdbY99AkkytnCWft74ujrIknvj0OJIElQLvKTT0HQE6u5eBiVj0w";

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", accessToken);

        RequestEntity<Object> request = new RequestEntity<>(
                headers, HttpMethod.GET, URI.create(url));

        ResponseEntity<Object[]> response = restTemplate.exchange(request, Object[].class);

        if (response.toString().contains("Content-Length:\"2\"")) {
            return false;
        }

        return true;
    }

    public static boolean verificarGrupoAcademicoAtivo(String numeroUfscarLeitor){
        String url = "https://pooa-grupos-academicos.herokuapp.com/user/"+ numeroUfscarLeitor + "/academicGroup";
        RestTemplate restTemplate = new RestTemplate();
        String accessToken = "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiIzZmE4NWY2NC01NzE3LTQ1NjItYjNmYy0yYzk2M2Y2NmFmYTYiLCJpYXQiOjE2NjM2ODE3MDYsImV4cCI6MTY2MzY4NTMwNn0.S-7_rQsJYFBB81IB-0OmQHLgSe5uT4iQIAY22GrFq-XE71ho4frKaU9pc0IRuF4VumfYhngtTApvJbBm2l97xTJaXDAefmmxE26WTb2bQS8fv6cA1YtL2fTSdbY99AkkytnCWft74ujrIknvj0OJIElQLvKTT0HQE6u5eBiVj0w";

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", accessToken);

        RequestEntity<Object> request = new RequestEntity<>(
                headers, HttpMethod.GET, URI.create(url));

        ResponseEntity<Object[]> response = restTemplate.exchange(request, Object[].class);

        List<Object> res = Arrays.asList(response.getBody());

        if (res.toString().contains("status=active"))
            return true;

        return false;
    }

    public static boolean verificarDisciplinas(String numeroUfscarLeitor){
        String url = "https://inscricaodisciplinas.herokuapp.com/aluno/"+ numeroUfscarLeitor + "/disciplinas";
        RestTemplate restTemplate = new RestTemplate();

        RequestEntity<Integer> request = new RequestEntity<>(
                HttpMethod.GET, URI.create(url));

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        if (response.getBody().contains("0")) {
            return false;
        } else {
            return true;
        }
    }

}
