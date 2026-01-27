package br.com.aprendizado.modulo_03.controller;

import br.com.aprendizado.modulo_03.data.dto.PersonDTO;
import br.com.aprendizado.modulo_03.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/person/v1")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public List<PersonDTO> findAll() {
        return service.findAll();
    }




    @GetMapping(value = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public PersonDTO findById(@PathVariable("id") Long id) {
        var person = service.findById(id);
        person.setBirthDate(new Date());
        return person;
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public PersonDTO create(@RequestBody PersonDTO person) {

        return service.create(person);
    }


    @PutMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public PersonDTO update(@PathVariable Long id, @RequestBody PersonDTO person) {
        person.setId(id); 
        return service.updatePerson(person);
    }



    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }



}
