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

    @GetMapping(value = "/grupo-academico-membros")
    public List<Object> getGrupoAcademicoMembros(){
    //Lista pessoas no grupo academico

    String id = "ea68898c-ea06-43ab-85db-463dbb05fbb4"; //ID do grupo academico
    String url = "https://pooa-grupos-academicos.herokuapp.com/academicGroup/"+ id + "/member";
    RestTemplate restTemplate = new RestTemplate();
    String accessToken = "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI3NTNkNGYwYy1kYWZmLTQwNDgtOWJkOS1kMWRhNTEzMWVjYzUiLCJpYXQiOjE2NjM1MTg4MDksImV4cCI6MTY2MzUyMjQwOX0.Rjpb_XGbd2VaUeRZemu5xPCadVhOi8SjhtuRhhDQDwzROym09KDD0PsPl9ccQWTb-b7_njuUTUuYLxWDAsJJSTrJ5jkG581X6BR-emZjRicbPZ60PrXdgWY3gWJfxqKKjd6GpgoNMBgJBz0T0lESk_7Wxvx5l67o8oRbTKsaprk";

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", accessToken);

        RequestEntity<Object> request = new RequestEntity<>(
                headers, HttpMethod.GET, URI.create(url));


        ResponseEntity<Object[]> response = restTemplate.exchange(request, Object[].class);


        return Arrays.asList(response.getBody());
    }

    @GetMapping(value = "/leitor-grupo-academico")
    public List<Object> getLeitorGrupoAcademico(){
        String id1 = "03dec7a5-9b4e-4d73-a87f-c00ff03d71b7"; //ID do leitor
        String id2 = "3fa85f64-5717-4562-b3fc-2c963f66afa6"; //ID do leitor
        String id3 = "ec1c550c-96da-4703-8dd3-3724cbd6a687"; //ID do leitor sem grupo academico
        String url = "https://pooa-grupos-academicos.herokuapp.com/user/"+ id1 + "/academicGroup";
        RestTemplate restTemplate = new RestTemplate();
        String accessToken = "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI3NTNkNGYwYy1kYWZmLTQwNDgtOWJkOS1kMWRhNTEzMWVjYzUiLCJpYXQiOjE2NjM1MTg4MDksImV4cCI6MTY2MzUyMjQwOX0.Rjpb_XGbd2VaUeRZemu5xPCadVhOi8SjhtuRhhDQDwzROym09KDD0PsPl9ccQWTb-b7_njuUTUuYLxWDAsJJSTrJ5jkG581X6BR-emZjRicbPZ60PrXdgWY3gWJfxqKKjd6GpgoNMBgJBz0T0lESk_7Wxvx5l67o8oRbTKsaprk";

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", accessToken);

        RequestEntity<Object> request = new RequestEntity<>(
                headers, HttpMethod.GET, URI.create(url));

        ResponseEntity<Object[]> response = restTemplate.exchange(request, Object[].class);

        return Arrays.asList(response.getBody());
    }

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

}
