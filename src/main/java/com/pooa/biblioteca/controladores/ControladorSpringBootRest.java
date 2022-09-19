package com.pooa.biblioteca.controladores;

import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.*;

@RestController
public class ControladorSpringBootRest {
/*
    @GetMapping(value = "/grupo-academico-membros")
    public List<Object> getGrupoAcademicoMembros(){
    //Lista pessoas no grupo academico

    String id = "ea68898c-ea06-43ab-85db-463dbb05fbb4"; //ID do grupo academico
    String url = "https://pooa-grupos-academicos.herokuapp.com/academicGroup/"+ id + "/member";
    RestTemplate restTemplate = new RestTemplate();
    String accessToken = "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI3NTNkNGYwYy1kYWZmLTQwNDgtOWJkOS1kMWRhNTEzMWVjYzUiLCJpYXQiOjE2NjM1NDA0NTAsImV4cCI6MTY2MzU0NDA1MH0.K7bBbnhCNDzBheJDt1lOcGjjORAn2lZu829YBy7GhEOzLNg_uAbnIE748iuUbPjcQhSmJQpAV5qVSthKPd22Uw0irtkPhk0VcwrKAAhVZu5l4hYRajimEEkrHlbUxSxDsf2C2t4o-Qx4kBg7CUnHNPDQ-dqhhXQFvkfZA-27uOA";

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", accessToken);

        RequestEntity<Object> request = new RequestEntity<>(
                headers, HttpMethod.GET, URI.create(url));


        ResponseEntity<Object[]> response = restTemplate.exchange(request, Object[].class);


        return Arrays.asList(response.getBody());
    }
*/
    @GetMapping(value = "/leitor-grupo-academico")
    public List<Object> getLeitorGrupoAcademico(){
        String id1 = "03dec7a5-9b4e-4d73-a87f-c00ff03d71b7"; //ID do leitor
        String id2 = "3fa85f64-5717-4562-b3fc-2c963f66afa6"; //ID do leitor
        String id3 = "ec1c550c-96da-4703-8dd3-3724cbd6a687"; //ID do leitor sem grupo academico
        String url = "https://pooa-grupos-academicos.herokuapp.com/user/"+ id2 + "/academicGroup";
        RestTemplate restTemplate = new RestTemplate();
        String accessToken = "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI3NTNkNGYwYy1kYWZmLTQwNDgtOWJkOS1kMWRhNTEzMWVjYzUiLCJpYXQiOjE2NjM1OTgyODIsImV4cCI6MTY2MzYwMTg4Mn0.lIQiKl61tPU_-lMt8fwckTWxm3sGbNxCK-5d_EHfsrllRpsOEt0vTY8zwFbUSOEOUc8OPrbA5BsKZK_Dgy6ZpA5E5Lm7-udNBMje86H6bf-5YL80HUe1rkdwpIbgIm5d_YkXHmQZ03HCs8RyK8psuQ1Is8k0lBw6jZKWL-F6uGs";

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", accessToken);

        RequestEntity<Object> request = new RequestEntity<>(
                headers, HttpMethod.GET, URI.create(url));

        ResponseEntity<Object[]> response = restTemplate.exchange(request, Object[].class);

        List<Object> res = Arrays.asList(response.getBody());

        System.out.println(res.toString());

        if (res.toString().contains("status=active"))
            System.out.println("Ativo");
        else
            System.out.println("Inativo");

        return Arrays.asList(response.getBody());
    }

    public static boolean verificarGrupoAcademico(String id){
        /*String id1 = "03dec7a5-9b4e-4d73-a87f-c00ff03d71b7"; //ID do leitor
        String id2 = "3fa85f64-5717-4562-b3fc-2c963f66afa6"; //ID do leitor
        String id3 = "ec1c550c-96da-4703-8dd3-3724cbd6a687"; //ID do leitor sem grupo academico*/
        String url = "https://pooa-grupos-academicos.herokuapp.com/user/"+ id + "/academicGroup";
        RestTemplate restTemplate = new RestTemplate();
        String accessToken = "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI3NTNkNGYwYy1kYWZmLTQwNDgtOWJkOS1kMWRhNTEzMWVjYzUiLCJpYXQiOjE2NjM1OTgyODIsImV4cCI6MTY2MzYwMTg4Mn0.lIQiKl61tPU_-lMt8fwckTWxm3sGbNxCK-5d_EHfsrllRpsOEt0vTY8zwFbUSOEOUc8OPrbA5BsKZK_Dgy6ZpA5E5Lm7-udNBMje86H6bf-5YL80HUe1rkdwpIbgIm5d_YkXHmQZ03HCs8RyK8psuQ1Is8k0lBw6jZKWL-F6uGs";

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

    public static boolean verificarGrupoAcademicoAtivo(String id){
        /*String id1 = "03dec7a5-9b4e-4d73-a87f-c00ff03d71b7"; //ID do leitor
        String id2 = "3fa85f64-5717-4562-b3fc-2c963f66afa6"; //ID do leitor
        String id3 = "ec1c550c-96da-4703-8dd3-3724cbd6a687"; //ID do leitor sem grupo academico*/
        String url = "https://pooa-grupos-academicos.herokuapp.com/user/"+ id + "/academicGroup";
        RestTemplate restTemplate = new RestTemplate();
        String accessToken = "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI3NTNkNGYwYy1kYWZmLTQwNDgtOWJkOS1kMWRhNTEzMWVjYzUiLCJpYXQiOjE2NjM1OTgyODIsImV4cCI6MTY2MzYwMTg4Mn0.lIQiKl61tPU_-lMt8fwckTWxm3sGbNxCK-5d_EHfsrllRpsOEt0vTY8zwFbUSOEOUc8OPrbA5BsKZK_Dgy6ZpA5E5Lm7-udNBMje86H6bf-5YL80HUe1rkdwpIbgIm5d_YkXHmQZ03HCs8RyK8psuQ1Is8k0lBw6jZKWL-F6uGs";

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
/*
    @RequestMapping(value = "/auth",
            method = RequestMethod.POST)
    public String token(@RequestBody Map<String, String> login){
        String url = "https://pooa-grupos-academicos.herokuapp.com/login";
        RestTemplate restTemplate = new RestTemplate();
        login.put("email", "ana@hotmail.com");
        login.put("password", "banana");

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);

        RequestEntity<Object> request = new RequestEntity<>(
                login, HttpMethod.POST, URI.create(url));

        ResponseEntity<Object[]> response = restTemplate.exchange(request, Object[].class);
        String bearer = response.getBody().toString();
        return bearer;
    }
*/
}
