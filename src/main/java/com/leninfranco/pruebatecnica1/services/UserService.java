package com.leninfranco.pruebatecnica1.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.leninfranco.pruebatecnica1.classes.User;

@Service
public class UserService {

    private final RestTemplate restTemplate;

    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Cacheable("users")
    public List<User> getUsers(){
        String url = "https://jsonplaceholder.typicode.com/users";
        try{
            User[] users = restTemplate.getForObject(url, User[].class);
            return Arrays.asList(users);
        } catch(RestClientException ex){
            throw new RestClientException("No se pudo obtener la lista de usuarios", ex);
        }
    }
}
