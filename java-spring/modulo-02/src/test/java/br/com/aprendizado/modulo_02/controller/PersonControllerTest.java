// java
package br.com.aprendizado.modulo_02.controller;

import br.com.aprendizado.modulo_02.data.dto.PersonDTO;
import br.com.aprendizado.modulo_02.model.Person;
import br.com.aprendizado.modulo_02.service.PersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.jfr.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PersonController.class)
class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("find all persons")
    void findAll() throws Exception {
        PersonDTO p1 = new PersonDTO();
        p1.setId(1L);
        p1.setFirstName("John");
        p1.setLastName("Doe");

        PersonDTO p2 = new PersonDTO();
        p2.setId(2L);
        p2.setFirstName("Jane");
        p2.setLastName("Smith");

        List<PersonDTO> list = Arrays.asList(p1, p2);
        when(service.findAll()).thenReturn(list);

        mockMvc.perform(get("/person")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(1));
    }

    @Test
    @DisplayName("find person by id")
    void findById() throws Exception {
        PersonDTO p = new PersonDTO();
        p.setId(1L);
        p.setFirstName("John");
        p.setLastName("Doe");

        when(service.findById(1L)).thenReturn(p);

        mockMvc.perform(get("/person/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.firstName").value("John"));
    }

    @Test
    @DisplayName("create person")
    void create() throws Exception {
        PersonDTO toCreate = new PersonDTO();
        toCreate.setFirstName("New");
        toCreate.setLastName("Person");

        PersonDTO created = new PersonDTO();
        created.setId(10L);
        created.setFirstName("New");
        created.setLastName("Person");

        when(service.create(any(PersonDTO.class))).thenReturn(created);

        mockMvc.perform(post("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(toCreate)))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(10))
                .andExpect(jsonPath("$.firstName").value("New"));
    }

    @Test
    @DisplayName("update person")
    void update() throws Exception {
        PersonDTO toUpdate = new PersonDTO();
        toUpdate.setId(10L);
        toUpdate.setFirstName("Updated");
        toUpdate.setLastName("Name");

        when(service.updatePerson(any(PersonDTO.class))).thenReturn(toUpdate);

        mockMvc.perform(put("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(toUpdate)))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(10))
                .andExpect(jsonPath("$.firstName").value("Updated"));
    }

    @Test
    @DisplayName("delete person by id")
    void delete() throws Exception {
        doNothing().when(service).delete(1L);

        mockMvc.perform(MockMvcRequestBuilders.delete("/person/1"))
                .andExpect(status().isNoContent());

        verify(service, times(1)).delete(1L);
    }
}
