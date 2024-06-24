package com.example.demo.controller;

import com.example.demo.model.Departamento;
import com.example.demo.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {

    private final DepartamentoService departamentoService;

    @Autowired
    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @GetMapping
    public List<Departamento> listarDepartamentos() {
        return departamentoService.listarDepartamentos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> buscarDepartamentoPorId(@PathVariable Long id) {
        Optional<Departamento> departamento = departamentoService.buscarDepartamentoPorId(id);
        return departamento.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/inserir")
    public ResponseEntity<Departamento> inserirDepartamento(@RequestBody Departamento departamento) {
        Departamento novoDepartamento = departamentoService.inserirDepartamento(departamento);
        return ResponseEntity.ok(novoDepartamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Departamento> atualizarDepartamento(@PathVariable Long id, @RequestBody Departamento departamento) {
        Optional<Departamento> departamentoAtualizado = departamentoService.atualizarDepartamento(id, departamento);
        return departamentoAtualizado.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDepartamento(@PathVariable Long id) {
        if (departamentoService.deletarDepartamento(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
