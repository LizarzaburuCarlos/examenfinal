package com.example.examenfinallizarzaburu.domain.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "parqueo")
public class Parqueo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idParqueo;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "fecha_salida", nullable = false)
    private Date fechasalida;

    @NotNull
    @Column(name = "hora_salida", nullable = false)
    private String horasalida;

    @NotNull
    @Column(name = "placa_vehiculo", nullable = false)
    private String placavehiculo;

    @NotNull
    @Column(name = "chofer", nullable = false)
    private String chofer;
}
