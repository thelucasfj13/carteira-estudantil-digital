package com.carteira.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class ValidacaoResponse {
    private boolean valida;
    private String status;
    private String mensagem;
    private String nomeCompleto;
    private String instituicao;
    private String curso;
    private String nivelEnsino;
    private String matricula;
    private LocalDate validade;
    private String fotoUrl;
}