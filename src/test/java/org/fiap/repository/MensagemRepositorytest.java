package org.fiap.repository;

import org.fiap.helper.MensagemHelper;
import org.fiap.model.Mensagem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MensagemRepositorytest {

    @Mock
    private MensagemRepository mensagemRepository;

    MensagemHelper mensagemHelper = new MensagemHelper();

    @Test
    public void devePermitirRegistrarMensagem(){
        var mensagem = mensagemHelper.gerarMensagem();

        //Arrange - Preparar
        //Quando o repository salvar qualquer objeto do tipo mensagem deve retornar o objeto Mensagem
        when(mensagemRepository.save(any(Mensagem.class))).thenReturn(mensagem);
        //Act - Atuar
        var mensagemArmazenada = mensagemRepository.save(mensagem);

        //Assert - Validar
        verify(mensagemRepository, times(1)).save(mensagem);
    }

    @Test
    public void devePermitirConsultarMensagem(){

        //Arrange - Preparar
        var mensagem = mensagemHelper.gerarMensagem();
        when(mensagemRepository.findById(any(UUID.class))).thenReturn(Optional.of(mensagem));

        //Act - Atuar
        var mensagemEncontrada = mensagemRepository.findById(mensagem.getId());

        //Assert - Validar
        assertThat(mensagemEncontrada)
                .isNotNull()
                .contains(mensagem);
    }

    @Test
    public void devePermitirApagarMensagem(){

        //Arrange - Preparar
        var mensagem = mensagemHelper.gerarMensagem();
        doNothing().when(mensagemRepository).deleteById(any(UUID.class));

        //Act - Atuar
        mensagemRepository.deleteById(mensagem.getId());

        //Assert - Validar
       verify(mensagemRepository, times(1)).deleteById(mensagem.getId());
    }
}
