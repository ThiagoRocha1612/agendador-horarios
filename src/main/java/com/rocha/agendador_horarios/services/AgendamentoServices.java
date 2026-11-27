package com.rocha.agendador_horarios.services;

import com.rocha.agendador_horarios.infrastructure.entity.AgendamentoEntity;
import com.rocha.agendador_horarios.infrastructure.repository.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor

public class AgendamentoServices {
    
    private final AgendamentoRepository agendamentoRepository;
    
    public AgendamentoEntity salvarAgendamento(AgendamentoEntity agendamentoEntity) {
        LocalDateTime horaAgendamento = LocalDateTime.from(agendamentoEntity.getDataHora());
        LocalDateTime horaFim = agendamentoEntity.getDataHoraAgendamento().plusHours(1);
        AgendamentoEntity agendados = agendamentoRepository.findByServicoAndDataHoraAgendamentoBetween(agendamentoEntity.getServico(), horaAgendamento, horaFim);
    
        if(Object.nonNull(agendados)) {
            throw new RuntimeException("Já existe um agendamento para este serviço neste horário.");
        } else {
            return agendamentoRepository.save(agendamentoEntity);
        }
    }

    public void deletarAgendamento(LocalDateTime dataHoraAgendamento, String cliente) {
        agendamentoRepository.deleteByDataHoraAgendamentoAndCliente(dataHoraAgendamento, cliente);

    }

    public AgendamentoEntity buscarAgendamentoDoDia(LocalDateTime dataHoraInical, LocalDateTime dataHoraFinal) {
        LocalDateTime primeiraHoraDoDia = data.atStartOfDay();
        LocalDateTime ultimaHoraDoDia = data.atTime(23, 59, 59).plusDays(1).minusSeconds(1);
        return agendamentoRepository.findByDataHoraAgendamentoBetween(primeiraHoraDoDia, ultimaHoraDoDia);
    }
}
