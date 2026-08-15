package org.fiap.repository;

import org.fiap.model.Mensagem;
import org.fiap.model.Usuario;
import org.junit.Test;
import org.mockito.Mock;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class MensagemRepositorytest {

    @Mock
    private MensagemRepository mensagemRepository;

    @Test
    public void devePermitirRegistrarMensagem(){
        var mensagem = gerarMensagem();

        //Arrange - Preparar
        //Quando o repository salvar qualquer objeto do tipo mensagem deve retornar o objeto Mensagem
        when(mensagemRepository.save(any(Mensagem.class))).thenReturn(mensagem);

        //Act - Atuar
        var mensagemArmazena = mensagemRepository.save(mensagem);
    }

    private Mensagem gerarMensagem(){
        Mensagem mensagem = new Mensagem();
        mensagem.setId(UUID.randomUUID());
        mensagem.setConteudo("Um Post Sobre Cabras");
        mensagem.setUsuario(gerarUsuario());

        return mensagem;
    }

    private Usuario gerarUsuario(){
        Usuario usuario = new Usuario();
        usuario.setNome("Ruth Camile");

        return usuario;
    }

}
