package com.arquiteturamvc.tarefas.controller;

import com.arquiteturamvc.tarefas.model.Tarefas;
import com.arquiteturamvc.tarefas.service.TarefasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/tarefas")
public class TarefasController {

    private final TarefasService service;

    @Autowired
    public TarefasController(TarefasService service) {
        this.service = service;
    }

    @GetMapping
    public String listarTarefas(Model model) {
        model.addAttribute("tarefas", service.listarTodas());
        return "/lista";
    }

    @GetMapping("/nova")
    public String novaTarefa(Model model) {
        Tarefas tarefas = new Tarefas();

        model.addAttribute("tarefas", tarefas);
        return "/form";
    }

    @PostMapping("/salvar")
    public String salvarTarefa(@ModelAttribute Tarefas tarefas) {
        if (tarefas.getData() == null) {
            tarefas.setData(LocalDate.now());
        }
        service.salvar(tarefas);
        return "redirect:/tarefas";
    }

    @GetMapping("/editar/{id}")
    public String editarTarefas(@PathVariable Long id,
                                Model model) {
        model.addAttribute("tarefas", service.listarPorId(id));
        return "/form";
    }

    @GetMapping("deletar/{id}")
    public String deletarTarefas(@PathVariable Long id) {
        service.excluir(id);
        return "redirect:/tarefas";
    }
}
