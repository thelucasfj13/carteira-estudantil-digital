package com.carteira.dto;

import com.carteira.model.Estudante;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class EstudanteResponse {
    private Long id;
    private String codigo;
    private String nomeCompleto;
    private String instituicao;
    private String curso;
    private String nivelEnsino;
    private String matricula;
    private String cpf;
    private LocalDate dataNascimento;
    private LocalDate validade;
    private String fotoUrl;
    private String qrCodeUrl;
    private String status;
    private LocalDateTime dataEmissao;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

    public static EstudanteResponse fromEntity(Estudante e) {
        EstudanteResponse r = new EstudanteResponse();
        r.setId(e.getId());
        r.setCodigo(e.getCodigo());
        r.setNomeCompleto(e.getNomeCompleto());
        r.setInstituicao(e.getInstituicao());
        r.setCurso(e.getCurso());
        r.setNivelEnsino(e.getNivelEnsino());
        r.setMatricula(e.getMatricula());
        r.setCpf(maskCpf(e.getCpf()));
        r.setDataNascimento(e.getDataNascimento());
        r.setValidade(e.getValidade());
        r.setFotoUrl(e.getFotoUrl());
        r.setQrCodeUrl(e.getQrCodeUrl());
        r.setStatus(e.getStatus().name());
        r.setDataEmissao(e.getDataEmissao());
        r.setCriadoEm(e.getCriadoEm());
        r.setAtualizadoEm(e.getAtualizadoEm());
        return r;
    }

    private static String maskCpf(String cpf) {
        if (cpf == null || cpf.length() != 11) return cpf;
        return cpf.substring(0, 3) + ".***.***-" + cpf.substring(9);
    }
}