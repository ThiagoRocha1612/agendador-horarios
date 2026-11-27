package com.rocha.agendador_horarios.infrastructure.repository;

import com.rocha.agendador_horarios.infrastructure.entity.AgendamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

public interface AgendamentoRepository extends JpaRepository<AgendamentoEntity, Long> {
    AgendamentoEntity findByServicoAndDataHoraAgendamentoBetween(String servico, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim);


    @Transactional
    void deleteByDataHoraAgendamentoAndCliente(LocalDateTime dataHoraAgendamento, String cliente);

    AgendamentoEntity findByDataHoraAgendamentoBetween(LocalDateTime dataHoraInical, LocalDateTime dataHoraFinal);

}
