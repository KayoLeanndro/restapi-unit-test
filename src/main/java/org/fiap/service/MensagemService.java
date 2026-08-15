package org.fiap.service;

import org.fiap.dto.MensagemResponseDTO;
import org.fiap.model.Mensagem;
import org.fiap.repository.MensagemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


public interface MensagemService {
    Mensagem registrarMensagem(Mensagem mensagem);
    Mensagem obterMensagemPorId(UUID mensagemID);
    List<Mensagem> obterMensagens();
    Mensagem atualizarMensagem(UUID mensagemID, Mensagem mensagem);
    void removerMensagem(UUID mensagemID);
}
