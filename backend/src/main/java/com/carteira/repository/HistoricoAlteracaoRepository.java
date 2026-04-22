package com.carteira.repository;

import com.carteira.model.HistoricoAlteracao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HistoricoAlteracaoRepository extends JpaRepository<HistoricoAlteracao, Long> {
    List<HistoricoAlteracao> findByEstudanteIdOrderByDataHoraDesc(Long estudanteId);
}