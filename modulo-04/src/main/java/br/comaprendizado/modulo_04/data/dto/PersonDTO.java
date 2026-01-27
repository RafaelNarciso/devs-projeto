package br.comaprendizado.modulo_04.data.dto;


import br.comaprendizado.modulo_04.serializer.GenerSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonDTO extends RepresentationModel<PersonDTO> implements Serializable {


    private static final long serialVersionUID = 1L;

    private Long id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @XmlSchemaType(name = "date")
    private Date birthDate;

    private String address;

    // ⚠️ Serializer customizado NÃO FUNCIONA em XML
    @JsonSerialize(using = GenerSerializer.class)
    private String gender;



    public PersonDTO() {}


    //region Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //endregion



// region Override equals and hashcode

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PersonDTO personDTO)) return false;
        return Objects.equals(id, personDTO.id) && Objects.equals(firstName, personDTO.firstName) && Objects.equals(lastName, personDTO.lastName) && Objects.equals(phoneNumber, personDTO.phoneNumber) && Objects.equals(birthDate, personDTO.birthDate) && Objects.equals(address, personDTO.address) && Objects.equals(gender, personDTO.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, phoneNumber, birthDate, address, gender);
    }


// endregion
}
