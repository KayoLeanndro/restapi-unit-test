package org.fiap.dto;

import jakarta.validation.constraints.NotEmpty;

import java.util.UUID;

public class MensagemRequestDTO {
    @NotEmpty(message = "Preencha dados do Usuario")
    UUID idUsuario;
    @NotEmpty(message = "Conteudo Vazio")
    String  conteudo;
}
