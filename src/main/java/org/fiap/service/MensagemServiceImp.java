package org.fiap.service;

import org.fiap.exception.MensagemNaoEncontradaException;
import org.fiap.model.Mensagem;
import org.fiap.repository.MensagemRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class MensagemServiceImp implements MensagemService{

    private final MensagemRepository mensagemRepository;

    public MensagemServiceImp(MensagemRepository mensagemRepository) {
        this.mensagemRepository = mensagemRepository;
    }

    @Override
    public Mensagem registrarMensagem(Mensagem mensagem) {

         return  mensagemRepository.save(mensagem);

    }

    @Override
    public Mensagem obterMensagemPorId(UUID mensagemID) {
        return mensagemRepository.findById(mensagemID)
                .orElseThrow(() -> new MensagemNaoEncontradaException("Mensagem não encontrada"));
    }

    @Override
    public List<Mensagem> obterMensagens() {
        return mensagemRepository.findAll();
    }

    @Override
    public Mensagem atualizarMensagem(UUID mensagemID, Mensagem mensagem) {

        Mensagem mensagemExistente = obterMensagemPorId(mensagemID);

        mensagemExistente.setConteudo(mensagem.getConteudo());
        mensagemExistente.setGostei(mensagem.getGostei());
        mensagemExistente.setUsuario(mensagem.getUsuario());
        mensagemExistente.setDataAlteracao(LocalDateTime.now());

        return mensagemRepository.save(mensagemExistente);
    }

    @Override
    public void removerMensagem(UUID mensagemID) {
        mensagemRepository.deleteById(mensagemID);
    }

}
