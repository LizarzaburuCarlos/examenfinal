package com.example.examenfinallizarzaburu.application.controllers;

import com.example.examenfinallizarzaburu.application.dto.parqueo.RespuestaParqueo;
import com.example.examenfinallizarzaburu.application.dto.parqueo.RespuestaParqueoEntity;
import com.example.examenfinallizarzaburu.application.dto.respuestas.Respuesta;
import com.example.examenfinallizarzaburu.domain.entities.Parqueo;
import com.example.examenfinallizarzaburu.domain.services.ParqueoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parqueos")
public class ParqueoController {

    @Autowired
    private ParqueoService parqueoService;
    @Value("Registro creado.")
    private String msgRegistroCreado;

    @Value("Registro modificado.")
    private String msgRegistroModificado;

    @Value("Registro eliminado.")
    private String msgRegistroEliminado;

    @Value("Registros listados.")
    private String msgRegistrosListados;

    @Value("Registro encontrado.")
    private String msgRegistroEncontrado;

    @Value("Error del proceso.")
    private String msgErrorRegistro;

    @PostMapping(value = "", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<RespuestaParqueoEntity> crearParqueo(@RequestBody Parqueo parqueo){
        RespuestaParqueoEntity res = new RespuestaParqueoEntity();
        try{
            res.setSatisfactorio(true);
            res.setCodigo("101");
            res.setMensaje(msgRegistroCreado);
            Parqueo parqueo1 = parqueoService.crearParqueo(parqueo);

            res.setData(parqueo1);

            if (res.isSatisfactorio()){
                return new ResponseEntity<RespuestaParqueoEntity>(res, HttpStatus.OK);
            } else {
                return new ResponseEntity<RespuestaParqueoEntity>(res, HttpStatus.BAD_REQUEST);
            }
        } catch (InterruptedException e){
            res.setSatisfactorio(false);
            res.setCodigo("109");
            res.setMensaje(msgErrorRegistro + e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e){
            res.setSatisfactorio(false);
            res.setCodigo("109");
            res.setMensaje(e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<RespuestaParqueoEntity> modificarParqueo(@RequestBody Parqueo parqueo) {
        RespuestaParqueoEntity res = new RespuestaParqueoEntity();

        try{
            res.setSatisfactorio(true);
            res.setCodigo("101");
            res.setMensaje(msgRegistroModificado);
            Parqueo parqueo1 = parqueoService.modificarParqueo(parqueo);

            res.setData(parqueo1);

            if (res.isSatisfactorio()){
                return new ResponseEntity<RespuestaParqueoEntity>(res, HttpStatus.OK);
            } else {
                return new ResponseEntity<RespuestaParqueoEntity>(res, HttpStatus.BAD_REQUEST);
            }
        } catch (InterruptedException e){
            res.setSatisfactorio(false);
            res.setCodigo("109");
            res.setMensaje(msgErrorRegistro + e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e){
            res.setSatisfactorio(false);
            res.setCodigo("109");
            res.setMensaje(e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(value = "{idParqueo}", produces = {"application/json"})
    public ResponseEntity<Respuesta> eliminarParqueo(@PathVariable("idParqueo") Integer idParqueo){
        Respuesta res = new Respuesta();
        try{
            res = parqueoService.eliminarParqueo(idParqueo);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (InterruptedException e){
            res.setSatisfactorio(false);
            res.setCodigo("109");
            res.setMensaje(msgErrorRegistro + e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e){
            res.setSatisfactorio(false);
            res.setCodigo("109");
            res.setMensaje(e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "", produces = {"application/json"})
    public ResponseEntity<RespuestaParqueo> listarParqueos(){
        RespuestaParqueo res = new RespuestaParqueo();
        try{
            res.setSatisfactorio(true);
            res.setCodigo("101");
            res.setMensaje(msgRegistrosListados);

            List<Parqueo> lista = parqueoService.listarParqueos();

            res.setData(lista);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e){
            res.setSatisfactorio(false);
            res.setCodigo("109");
            res.setMensaje(e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "{idParqueo}", produces = {"application/json"})
    public ResponseEntity<RespuestaParqueoEntity> obtenerParqueoPorId(@PathVariable("idParqueo")Integer idParqueo){
        RespuestaParqueoEntity res = new RespuestaParqueoEntity();
        try{
            res.setSatisfactorio(true);
            res.setCodigo("101");
            res.setMensaje(msgRegistrosListados);

            Parqueo parqueo = parqueoService.obtenerParqueoPorId(idParqueo);

            res.setData(parqueo);

            if(res.getData().getIdParqueo()==null){
                res.setMensaje("No se encontró el registro.");
            }
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (InterruptedException e){
            res.setSatisfactorio(false);
            res.setCodigo("109");
            res.setMensaje(msgErrorRegistro + e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e){
            res.setSatisfactorio(false);
            res.setCodigo("109");
            res.setMensaje(e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

