package com.example.examenfinallizarzaburu.application.dto.respuestas;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Respuesta {
    @JsonProperty("satisfactorio")
    boolean satisfactorio;
    @JsonProperty("codigo")
    String codigo;
    @JsonProperty("mensaje")
    String mensaje;
}
