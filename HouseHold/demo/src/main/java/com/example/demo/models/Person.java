package com.example.demo.models;

import com.example.demo.DAO.PersonDAO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "people")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String cmnd;

    String name;

    Date birthday;

    @ManyToMany(mappedBy = "personSet", fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    @JsonBackReference
    List<HouseHold> houseHoldList;

    public Person(PersonDAO personDAO) {
//        this(personDAO.getName(),personDAO.getName(),personDAO.getBirthday())
        this.cmnd = personDAO.getCmnd();
        this.name = personDAO.getName();
        this.birthday = personDAO.getBirthday();
    }
}
