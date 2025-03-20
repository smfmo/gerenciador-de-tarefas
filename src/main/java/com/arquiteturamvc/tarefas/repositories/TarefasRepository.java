package com.arquiteturamvc.tarefas.repositories;

import com.arquiteturamvc.tarefas.model.Tarefas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefasRepository extends JpaRepository<Tarefas, Long> {
}
