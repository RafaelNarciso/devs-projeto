package br.com.aprendizado.modulo_03.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class GenerSerializer extends JsonSerializer<String> {

    @Override
    public void serialize(String s, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String formatedGender = "Male".equalsIgnoreCase(s) ? "M" : "F";
        jsonGenerator.writeString(formatedGender);
    }
}
