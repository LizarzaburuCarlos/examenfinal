package com.example.examenfinallizarzaburu.application.dto.parqueo;

import com.example.examenfinallizarzaburu.application.dto.respuestas.Respuesta;
import com.example.examenfinallizarzaburu.domain.entities.Parqueo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RespuestaParqueo extends Respuesta {
    @JsonProperty("datos")
    List<Parqueo> data;
}
