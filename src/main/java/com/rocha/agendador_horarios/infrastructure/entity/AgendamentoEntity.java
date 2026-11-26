package com.rocha.agendador_horarios.infrastructure.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "agendamento")

public class AgendamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String servico;
    private LocalDate dataHora;
    private LocalDateTime dataHoraAgendamento;
    private String cliente;
    private LocalTime dataInsercao = LocalTime.now();
    private String nomeDaProfissional;
    private String telefoneDoCliente;

}
