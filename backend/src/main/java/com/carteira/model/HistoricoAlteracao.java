package com.carteira.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "historico_alteracoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoricoAlteracao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estudante_id", nullable = false)
    private Estudante estudante;

    @Column(nullable = false)
    private String acao;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    private String usuarioEmail;

    private LocalDateTime dataHora = LocalDateTime.now();

    public HistoricoAlteracao(Estudante estudante, String acao, String descricao, String usuarioEmail) {
        this.estudante = estudante;
        this.acao = acao;
        this.descricao = descricao;
        this.usuarioEmail = usuarioEmail;
        this.dataHora = LocalDateTime.now();
    }
}