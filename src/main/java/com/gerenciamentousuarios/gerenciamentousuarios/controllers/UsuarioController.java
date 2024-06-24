package com.example.demo.controller;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;


    //CONSTRUCTOR - INJEÇÃO DE DEPENDENCIA
    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    //LISTAR TODOS OS USUÁRIOS
    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }


    //LISTAR USUÁRIO POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.buscarUsuarioPorId(id);
        return usuario.map(ResponseEntity::ok) //SE O USUÁRIO FOR ENCONTRADO, RETORNA 200
                .orElseGet(() -> ResponseEntity.notFound().build()); //SE NÃO FOR ENCONTRADO, RETORNA 404
    }

    @PostMapping("/inserir")
    public ResponseEntity<Usuario> inserirUsuario(@RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioService.inserirUsuario(usuario);
        if (novoUsuario != null) {
            return ResponseEntity.ok(novoUsuario);  // Se o usuário for criado com sucesso, retorna 200 OK com o novo usuário
        } else {
            return ResponseEntity.status(500).build(); // Se houver algum erro ao criar o usuário, retorna 500 Internal Server Error
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioService.atualizarUsuario(id, usuario)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }



}
