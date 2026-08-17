package org.fiap.helper;

import org.fiap.model.Usuario;

import java.util.UUID;

public class UsuarioHelper {

    public Usuario gerarUsuario(){
        Usuario usuario = new Usuario();
        usuario.setId(UUID.randomUUID());
        usuario.setNome("Ruth Camile");

        return usuario;
    }
}
