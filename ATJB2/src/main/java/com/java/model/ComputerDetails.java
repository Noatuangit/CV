package com.java.model;

import com.java.dto.ComDetailsDTO;
import com.java.model.compositeID.ComputerDetailsID;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "computer_detail")
public class ComputerDetails {
    @EmbeddedId
    ComputerDetailsID computerDetailsID;

    Integer time_use;

    public ComputerDetails() {
    }

    public ComputerDetails(ComputerDetailsID computerDetailsID, Integer time_use) {
        this.computerDetailsID = computerDetailsID;
        this.time_use = time_use;
    }

    public ComputerDetails(ComDetailsDTO comDetailsDTO) {
        this.time_use = (comDetailsDTO.getTimeUse());
        this.computerDetailsID = new ComputerDetailsID(comDetailsDTO);

    }

    public ComputerDetailsID getComputerDetailsID() {
        return computerDetailsID;
    }

    public void setComputerDetailsID(ComputerDetailsID computerDetailsID) {
        this.computerDetailsID = computerDetailsID;
    }

    public Integer getTime_use() {
        return time_use;
    }

    public void setTime_use(Integer time_use) {
        this.time_use = time_use;
    }
}

