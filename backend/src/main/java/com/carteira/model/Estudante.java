package com.carteira.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "estudantes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estudante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String codigo = UUID.randomUUID().toString();

    @Column(nullable = false)
    private String nomeCompleto;

    @Column(nullable = false)
    private String instituicao;

    @Column(nullable = false)
    private String curso;

    @Column(nullable = false)
    private String nivelEnsino;

    @Column(nullable = false)
    private String matricula;

    @Column(nullable = false, length = 11)
    private String cpf;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false)
    private LocalDate validade;

    private String fotoUrl;

    private String qrCodeUrl;

    @Enumerated(EnumType.STRING)
    private StatusCarteira status = StatusCarteira.ATIVA;

    private LocalDateTime dataEmissao;

    private LocalDateTime criadoEm = LocalDateTime.now();

    private LocalDateTime atualizadoEm = LocalDateTime.now();

    @OneToMany(mappedBy = "estudante", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HistoricoAlteracao> historico = new ArrayList<>();

    public enum StatusCarteira {
        ATIVA, VENCIDA, CANCELADA
    }

    @PreUpdate
    public void preUpdate() {
        this.atualizadoEm = LocalDateTime.now();
        if (this.validade != null && this.validade.isBefore(LocalDate.now()) && this.status == StatusCarteira.ATIVA) {
            this.status = StatusCarteira.VENCIDA;
        }
    }
}