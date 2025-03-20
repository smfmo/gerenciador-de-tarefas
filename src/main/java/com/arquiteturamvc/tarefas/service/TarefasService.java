package com.arquiteturamvc.tarefas.service;

import com.arquiteturamvc.tarefas.model.Tarefas;
import com.arquiteturamvc.tarefas.repositories.TarefasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefasService {

    private final TarefasRepository repository;

    @Autowired
    public TarefasService(TarefasRepository repository) {
        this.repository = repository;
    }

    public Tarefas salvar(Tarefas tarefas) {
        return repository.save(tarefas);
    }

    public Tarefas atualizar(Tarefas tarefas) {
        return repository.save(tarefas);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public List<Tarefas> listarTodas() {
        return repository.findAll();
    }

    public Tarefas listarPorId(Long id) {
        return repository.findById(id)
                .orElse(null);
    }
}
