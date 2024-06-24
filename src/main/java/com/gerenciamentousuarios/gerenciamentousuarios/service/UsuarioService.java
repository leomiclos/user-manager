package com.example.demo.service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario inserirUsuario(Usuario usuario) {
        try {
            System.out.println("Operação realizada com sucesso!");
            return usuarioRepository.save(usuario);
        } catch (Exception e) {
            System.err.println("Erro ao inserir usuário: " + e.getMessage());
            return null;
        }
    }

    // Método para atualizar um usuário existente
    public Optional<Usuario> atualizarUsuario(Long id, Usuario usuarioAtualizado) {
        return usuarioRepository.findById(id)
                .map(usuarioExistente -> {
                    // Atualiza os campos
                    usuarioExistente.setNome(usuarioAtualizado.getNome());
                    usuarioExistente.setEmail(usuarioAtualizado.getEmail());

                    // Salva o usuário atualizado no repositório
                    return usuarioRepository.save(usuarioExistente);
                });
    }
}