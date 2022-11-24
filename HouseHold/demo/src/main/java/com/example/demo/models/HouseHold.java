package com.example.demo.models;

import com.example.demo.DAO.HouseHoldDAO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "household")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@EntityListeners(AuditingEntityListener.class)
@Getter
@Builder
public class HouseHold {
    @Id
    @GeneratedValue(generator = "my-generated")
    @GenericGenerator(name = "my-generated",
            strategy = "com.example.demo.utils.MyGenerator")
    String id;

    String name;

    @Column(name = "date_create")
    Date dateCreate;

    String address;

    @ManyToMany(fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    @JoinTable(name = "people_live_house", joinColumns = @JoinColumn(name = "house_id"),
            inverseJoinColumns = @JoinColumn(name = "people_id"))
    @JsonManagedReference
    Set<Person> personSet;

    public HouseHold(HouseHoldDAO dao) {
        this.name = dao.getName();
        this.address = dao.getAddress();
        this.dateCreate = dao.getDateCreate();
    }
}
