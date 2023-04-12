package com.tuanln6.model;

import com.tuanln6.dto.details.ComputerDetailsDTO;
import com.tuanln6.dto.view.ComputerViewDetailsDTO;
import com.tuanln6.model.id.ComputerDetailsID;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "computer_detail")
public class ComputerDetails {
    @EmbeddedId
    ComputerDetailsID computerDetailsID;
    @Column(name = "time_use")
    Integer time_use;

    public ComputerDetails() {
    }

    public ComputerDetails(ComputerDetailsID computerDetailsID, Integer time_use) {
        this.computerDetailsID = computerDetailsID;
        this.time_use = time_use;
    }

    public ComputerDetails(ComputerDetailsDTO computerDetailsDTO) {
        this.time_use = computerDetailsDTO.getTimeUse();
        this.computerDetailsID = new ComputerDetailsID(computerDetailsDTO);
    }

    public ComputerDetails(ComputerViewDetailsDTO computerViewDetailsDTO) {
        this.time_use = computerViewDetailsDTO.getTimeUse();
        this.computerDetailsID = new ComputerDetailsID(computerViewDetailsDTO);
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

