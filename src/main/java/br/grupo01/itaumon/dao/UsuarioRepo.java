package br.grupo01.itaumon.dao;

import org.springframework.data.repository.CrudRepository;

import br.grupo01.itaumon.models.Usuario;

public interface UsuarioRepo extends CrudRepository<Usuario, Integer> {
    
    Usuario findByEmailAndSenha(String email, String senha);
    Usuario findByRacfAndSenha(String racf, String senha);

}