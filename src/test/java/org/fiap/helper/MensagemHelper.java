package org.fiap.helper;

import org.fiap.model.Mensagem;

import java.util.UUID;

public class MensagemHelper {

    UsuarioHelper usuarioHelper = new UsuarioHelper();

    public Mensagem gerarMensagem(){
        Mensagem mensagem = new Mensagem();
        mensagem.setConteudo("Um Post Sobre Cabras");
        mensagem.setUsuario(usuarioHelper.gerarUsuario());

        return mensagem;
    }

}
