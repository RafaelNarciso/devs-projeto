package br.comaprendizado.modulo_04.service;


import br.comaprendizado.modulo_04.controller.PersonController;
import br.comaprendizado.modulo_04.data.dto.PersonDTO;
import br.comaprendizado.modulo_04.exception.ResourceNotFoundException;
import br.comaprendizado.modulo_04.model.Person;
import br.comaprendizado.modulo_04.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import java.util.List;


import static br.comaprendizado.modulo_04.mapper.ObjectMapper.parseListObject;
import static br.comaprendizado.modulo_04.mapper.ObjectMapper.parseObject;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;


    private Logger logger = LoggerFactory.getLogger(PersonService.class.getName());

    public List<PersonDTO> findAll() {
        logger.info("Finding one people!");
        var persons = parseListObject(repository.findAll(), PersonDTO.class);
        persons.forEach(this::addHateoasLinks);

        return persons;

    }


    public PersonDTO findById(Long id) {
        logger.info("Finding one person!");
        var entity = repository
                .findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Person not found with id "));
        var dto = parseObject(entity, PersonDTO.class);
        addHateoasLinks(dto);
        return dto;
    }


    public PersonDTO create(PersonDTO person){
        logger.info("create one Person!");
        var entity = parseObject(person, Person.class);
        var dto = parseObject(repository.save(entity), PersonDTO.class);
        addHateoasLinks(dto);
        return dto;

    }



    public PersonDTO updatePerson(PersonDTO person){
        logger.info("update one Person!");
                Person entity =
                        repository.findById(person.getId())
                                .orElseThrow(()-> new ResourceNotFoundException("Person not found with id "+person.getId()));
                entity.setFirstName(person.getFirstName());
                entity.setLastName(person.getLastName());
                entity.setAddress(person.getAddress());
                entity.setGender(person.getGender());

        var dto = parseObject(repository.save(entity), PersonDTO.class);
        addHateoasLinks(dto);
        return dto;
    }



    public void delete(Long id){
        logger.info("deleting one Person!");
        Person entity =
                repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Person not found with id "+id));
        repository.delete(entity);
    }

    private  void addHateoasLinks(PersonDTO dto) {
        dto.add(linkTo(methodOn(PersonController.class).findById(dto.getId())).withSelfRel().withType("GET"));
        dto.add(linkTo(methodOn(PersonController.class).findAll()).withRel("findAll").withType("GET"));
        dto.add(linkTo(methodOn(PersonController.class).create(dto)).withRel("create").withType("POST"));
        dto.add(linkTo(methodOn(PersonController.class).update(dto)).withRel("update").withType("PUT"));
        dto.add(linkTo(methodOn(PersonController.class).delete(dto.getId())).withRel("delete").withType("DELETE"));


    }



}


