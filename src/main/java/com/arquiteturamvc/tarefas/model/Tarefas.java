package com.arquiteturamvc.tarefas.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "tarefas",
        schema = "public")
public class Tarefas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "concluico")
    private boolean concluido;

    public Tarefas() {
        this.data = LocalDate.now(); // utilizar a data atual
    }

}
