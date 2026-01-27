package br.com.aprendizado.modulo_02.service;


import br.com.aprendizado.modulo_02.data.dto.PersonDTO;
import br.com.aprendizado.modulo_02.exception.ResourceNotFoundException;

import br.com.aprendizado.modulo_02.mapper.ObjectMapper;
import br.com.aprendizado.modulo_02.model.Person;
import br.com.aprendizado.modulo_02.repository.PersonRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static br.com.aprendizado.modulo_02.mapper.ObjectMapper.parseListObject;
import static br.com.aprendizado.modulo_02.mapper.ObjectMapper.parseObject;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(PersonService.class.getName());

    public List<PersonDTO> findAll() {
        logger.info("Finding one people!");
        return parseListObject(repository.findAll(), PersonDTO.class);

    }


    public PersonDTO findById(Long id) {
        logger.info("Finding one person!");
        var entity = repository
                .findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Person not found with id "+id));
        return parseObject(entity, PersonDTO.class);
    }


    public PersonDTO create(PersonDTO person){
        logger.info("create one Person!");
        var entity = parseObject(person, Person.class);
        return parseObject(repository.save(entity), PersonDTO.class);
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

        return parseObject(repository.save(entity), PersonDTO.class);
    }



    public void delete(Long id){
        logger.info("deleting one Person!");
        Person entity =
                repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Person not found with id "+id));
        repository.delete(entity);
    }



}


