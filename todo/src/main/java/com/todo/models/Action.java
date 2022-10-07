package com.todo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "action")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "time_begin",columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private Timestamp time_begin;

    @Column(name = "time_finish")
    private Timestamp time_finish;
}
