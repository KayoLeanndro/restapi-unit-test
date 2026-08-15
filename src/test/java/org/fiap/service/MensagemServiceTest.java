package org.fiap.service;

import org.fiap.helper.MensagemHelper;
import org.fiap.model.Mensagem;
import org.fiap.repository.MensagemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MensagemServiceTest {

    @Mock
    private MensagemRepository mensagemRepository;

    @InjectMocks
    private MensagemServiceImp mensagemService;

    MensagemHelper mensagemHelper = new MensagemHelper();

    @Test
    public void devePermitirRegistrarMensagem(){
       var mensagem = mensagemHelper.gerarMensagem();

        //Arrange - Preparar
        when(mensagemService.registrarMensagem(any(Mensagem.class))).thenAnswer(i -> i.getArgument(0));

        //Act - Atuar
        var mensagemRegistrada = mensagemService.registrarMensagem(mensagem);

        //Assert
        assertThat(mensagemRegistrada)
                .isNotNull()
                .isInstanceOf(Mensagem.class);

        assertThat(mensagemRegistrada.getId()).isNotNull();

        assertThat(mensagemRegistrada.getUsuario()).isEqualTo(mensagem.getUsuario());

        assertThat(mensagemRegistrada.getConteudo()).isEqualTo(mensagem.getConteudo());
    }

    @Test
    public void devePermitirObterMensagemPorId(){
        //Arrange - Preparar
        var mensagem = mensagemHelper.gerarMensagem();
        when(mensagemRepository.findById(any(UUID.class))).thenReturn(Optional.of(mensagem));

        //Act - Atuar
        var mensagemEncontrada = mensagemService.obterMensagemPorId(mensagem.getId());

        //Assert - Validar
       verify(mensagemRepository, times(1)).findById(mensagem.getId());

       assertThat(mensagemEncontrada).isEqualTo(mensagem);

    }

    @Test
    public void devePermitirObterMensagens(){
        fail("Logica nao implementada");
    }

    @Test
    public void devePermitirModificarMensagem(){
        fail("Logica nao implementada");
    }

    @Test
    public void devePermitirRemoverMensagem(){
        fail("Logica nao implementada");
    }

}
