package com.example.examenfinallizarzaburu.domain.services;

import com.example.examenfinallizarzaburu.application.dto.respuestas.Respuesta;
import com.example.examenfinallizarzaburu.domain.entities.Parqueo;

import java.util.List;

public interface ParqueoService {
    Parqueo crearParqueo(Parqueo parqueo) throws InterruptedException;
    Parqueo modificarParqueo(Parqueo parqueo) throws InterruptedException;
    Respuesta eliminarParqueo(Integer idParqueo) throws InterruptedException;
    List<Parqueo> listarParqueos() throws InterruptedException;
    Parqueo obtenerParqueoPorId(Integer idParqueo) throws InterruptedException;

}
