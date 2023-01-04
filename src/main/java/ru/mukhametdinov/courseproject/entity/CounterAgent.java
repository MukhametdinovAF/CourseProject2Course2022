package ru.mukhametdinov.courseproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "COUNTERAGENTS")
public class CounterAgent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "date")
    private String date;
    @Column(name = "client")
    private String client;
    @Column(name = "size")
    private String size;
    @Column(name = "resolution")
    private String resolution;
    @Column(name = "controller")
    private String controllerModel;
    @Column(name = "connection")
    private String connectionType;
    @Column(name = "warranty")
    private String warranty;
}
