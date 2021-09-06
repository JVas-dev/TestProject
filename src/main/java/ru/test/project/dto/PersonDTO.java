package ru.test.project.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

public class PersonDTO {
    @NotNull
    protected Long Id;
    @NotNull
    protected String name;
    @NotNull
    @Past
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "dd.MM.yyyy" )
    protected Date birthdate;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public PersonDTO(Long id, String name, Date birthdate) {
        this.Id = id;
        this.name = name;
        this.birthdate = birthdate;
    }

    public PersonDTO() {
    }
}
