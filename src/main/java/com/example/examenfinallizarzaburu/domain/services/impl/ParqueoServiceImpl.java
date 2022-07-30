package com.example.examenfinallizarzaburu.domain.services.impl;

import com.example.examenfinallizarzaburu.application.dto.respuestas.Respuesta;
import com.example.examenfinallizarzaburu.domain.entities.Parqueo;
import com.example.examenfinallizarzaburu.domain.repositories.ParqueoRepository;
import com.example.examenfinallizarzaburu.domain.services.ParqueoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParqueoServiceImpl implements ParqueoService {

    @Autowired
    private final ParqueoRepository parqueoRepository;

    public ParqueoServiceImpl(ParqueoRepository parqueoRepository) throws InterruptedException{
        this.parqueoRepository=parqueoRepository;
    }

    @Override
    public Parqueo crearParqueo(Parqueo parqueo) throws InterruptedException {
        return parqueoRepository.save(parqueo);
    }

    @Override
    public Parqueo modificarParqueo(Parqueo parqueo) throws InterruptedException {
        return parqueoRepository.save(parqueo);
    }

    @Override
    public Respuesta eliminarParqueo(Integer idParqueo) throws InterruptedException {
        Respuesta respuesta = new Respuesta();

        if (parqueoRepository.existsById(idParqueo)){
            parqueoRepository.deleteById(idParqueo);
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("101");
            respuesta.setMensaje("Registro Eliminado.");
            return respuesta;
        }else {
            throw new InterruptedException("Error en la respuesta del servicio.");
        }
    }

    @Override
    public List<Parqueo> listarParqueos() throws InterruptedException {
        return parqueoRepository.findAll();
    }

    @Override
    public Parqueo obtenerParqueoPorId(Integer idParqueo) throws InterruptedException {
        return parqueoRepository.findById(idParqueo).orElse(new Parqueo());
    }
}
