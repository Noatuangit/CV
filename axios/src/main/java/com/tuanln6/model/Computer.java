package com.tuanln6.model;

import com.tuanln6.dto.computer.ComputerDTO;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "computer")
@Entity
public class Computer {
    @Id
    @GeneratedValue(generator = "auto-generator")
    @GenericGenerator(name = "auto-generator", parameters = @Parameter(name = "prefix", value = "MT"), strategy = "com.tuanln6.utils.AutoGeneration")
    String id;

    String position;

    String status;

    public Computer() {
    }

    public Computer(String id) {
        this.id = id;
    }
    public Computer(String id, String position, String status) {
        this.id = id;
        this.position = position;
        this.status = status;
    }

    public Computer(ComputerDTO computerDTO) {
        this.id = computerDTO.getId();
        this.status = computerDTO.getStatus();
        this.position = computerDTO.getPosition();
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
}
