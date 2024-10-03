package com.leninfranco.pruebatecnica1;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import com.leninfranco.pruebatecnica1.classes.Company;
import com.leninfranco.pruebatecnica1.classes.Geo;
import com.leninfranco.pruebatecnica1.classes.User;
import com.leninfranco.pruebatecnica1.classes.AddressClass;
import com.leninfranco.pruebatecnica1.services.UserService;

public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }


    //Este test verifica que el primer elemento de la lista de usuarios de la API Externa, sea igual a la lista obtenida del servicio.
    @Test
    public void testGetUsers(){
        
        User[] mockUsers = {
            User.builder()
                .id(1)
                .name("Leanne Graham")
                .username("Bret")
                .email("Sincere@april.biz")
                .address(new AddressClass("Kulas Light", "Apt. 556", "Gwenborough", "92998-3874", new Geo("-37.3159", "81.1496")))
                .phone("1-770-736-8031 x56442")
                .website("hildegard.org")
                .company(new Company("Romaguera-Crona", "Multi-layered client-server neural-net", "harness real-time e-markets"))
                .build()
        };
        
        when(restTemplate.getForObject("https://jsonplaceholder.typicode.com/users", User[].class))
                .thenReturn(mockUsers);

        List<User> serviceUsers = userService.getUsers();


        User expectedUser = mockUsers[0];
        User actualUser = serviceUsers.get(0);

        assertEquals(expectedUser.getId(), actualUser.getId());
        assertEquals(expectedUser.getName(), actualUser.getName());
        assertEquals(expectedUser.getUsername(), actualUser.getUsername());
        assertEquals(expectedUser.getEmail(), actualUser.getEmail());
        assertEquals(expectedUser.getPhone(), actualUser.getPhone());
        assertEquals(expectedUser.getWebsite(), actualUser.getWebsite());
        assertEquals(expectedUser.getAddress().getStreet(), actualUser.getAddress().getStreet());
        assertEquals(expectedUser.getAddress().getSuite(), actualUser.getAddress().getSuite());
        assertEquals(expectedUser.getAddress().getCity(), actualUser.getAddress().getCity());
        assertEquals(expectedUser.getAddress().getZipcode(), actualUser.getAddress().getZipcode());
        assertEquals(expectedUser.getAddress().getGeo().getLat(), actualUser.getAddress().getGeo().getLat());
        assertEquals(expectedUser.getAddress().getGeo().getLng(), actualUser.getAddress().getGeo().getLng());
        assertEquals(expectedUser.getCompany().getName(), actualUser.getCompany().getName());
        assertEquals(expectedUser.getCompany().getCatchPhrase(), actualUser.getCompany().getCatchPhrase());
        assertEquals(expectedUser.getCompany().getBs(), actualUser.getCompany().getBs());
    }

}
