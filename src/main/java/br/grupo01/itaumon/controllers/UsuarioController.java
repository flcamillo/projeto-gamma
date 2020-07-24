package br.grupo01.itaumon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.grupo01.itaumon.models.Usuario;
import br.grupo01.itaumon.services.IUsuarioService;

@RestController
@CrossOrigin("*")
public class UsuarioController {
    
    @Autowired
    private IUsuarioService servico;

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable int id) {
        Usuario usuario = servico.buscarUsuarioPorId(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        usuario.setSenha("*****");
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> buscarPorNomeESenha(@RequestBody Usuario usuario) {
        Usuario login = servico.buscarUsuarioPorEmailOuRACF(usuario);
        if (login == null) {
            return ResponseEntity.notFound().build();
        }
        login.setSenha("*****");
        return ResponseEntity.ok(login);
    }

}