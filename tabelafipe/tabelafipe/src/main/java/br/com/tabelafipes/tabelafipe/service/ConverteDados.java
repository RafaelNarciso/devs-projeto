package br.com.tabelafipes.tabelafipe.service;


import br.com.tabelafipes.tabelafipe.repository.IConverteDados;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

public class ConverteDados implements IConverteDados {

    private ObjectMapper mapper = new ObjectMapper();


    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        try {
            return mapper.readValue(json,classe);
        }catch (RuntimeException e){
            throw  new RuntimeException(e);
        }
    }

    public <T> List <T> obterLista(String json, Class<T> classe){
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(
                    json,
                    mapper.getTypeFactory().constructCollectionType(List.class, classe)
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
