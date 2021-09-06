package ru.test.project.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

@Entity
@Table(name = "person", schema = "public")
public class Person {
    @Id
    @Column(unique = true)
    @NotNull
    private Long Id;
    @NotNull
    private String name;
    @NotNull
    private Date birthdate;

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

    public Person(Long id, String name, Date birthdate) {
        this.Id = id;
        this.name = name;
        this.birthdate = birthdate;
    }

    public Person() {
    }
}
