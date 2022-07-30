package com.example.examenfinallizarzaburu.application.dto.parqueo;

import com.example.examenfinallizarzaburu.application.dto.respuestas.Respuesta;
import com.example.examenfinallizarzaburu.domain.entities.Parqueo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespuestaParqueoEntity extends Respuesta {
    @JsonProperty("dato")
    Parqueo data;
}
