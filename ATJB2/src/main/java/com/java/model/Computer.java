package com.java.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "computer")
public class Computer {
    @Id
    @GeneratedValue(generator = "auto-generator")
    @GenericGenerator(name = "auto-generator", parameters = @Parameter(name = "prefix", value = "MT"), strategy = "com.java.utils.AutoGeneration")
    String id;

     String position;

     String status;

    public Computer() {
        super();
    }

    public Computer(String id) {
        this.id = id;
    }

    public Computer(String id, String position, String status) {
        super();
        this.id = id;
        this.position = position;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "id='" + id + '\'' +
                ", position='" + position + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
