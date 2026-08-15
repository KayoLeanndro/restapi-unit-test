package org.fiap.repository;

import org.fiap.model.Mensagem;
import org.fiap.model.Usuario;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class MensagemRepositorytest {

    @Mock
    private MensagemRepository mensagemRepository;
    AutoCloseable mock;

    @BeforeEach
    void setup(){
        mock = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }


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
