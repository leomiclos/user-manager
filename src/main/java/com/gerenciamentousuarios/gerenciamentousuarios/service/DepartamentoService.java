package com.example.demo.service;

import com.example.demo.model.Departamento;
import com.example.demo.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    private final DepartamentoRepository departamentoRepository;

    @Autowired
    public DepartamentoService(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    public List<Departamento> listarDepartamentos() {
        return departamentoRepository.findAll();
    }

    public Optional<Departamento> buscarDepartamentoPorId(Long id) {
        return departamentoRepository.findById(id);
    }

    public Departamento inserirDepartamento(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    public Optional<Departamento> atualizarDepartamento(Long id, Departamento departamentoAtualizado) {
        return departamentoRepository.findById(id)
                .map(departamentoExistente -> {
                    departamentoExistente.setNome(departamentoAtualizado.getNome());
                    // Adicione outros campos para atualização conforme necessário
                    return departamentoRepository.save(departamentoExistente);
                });
    }

    public boolean deletarDepartamento(Long id) {
        if (departamentoRepository.existsById(id)) {
            departamentoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
