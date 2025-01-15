package com.appchoferes.nomina.controllers.durandb;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.durandb.TipoCambioModel;
import com.appchoferes.nomina.repositories.durandb.TipoCambioDTORepository;
import com.appchoferes.nomina.repositories.durandb.TipoCambioRepository;
import com.appchoferes.nomina.services.durandb.TipoCambioService;

@RestController
@RequestMapping("/tipocambio")
public class TipoCambioController {

    @Autowired
    TipoCambioService tipocambioService;

    @Autowired
    TipoCambioRepository tipocambioRepository;

    @GetMapping()
    public ArrayList<TipoCambioModel> obtenerTipos() {
        return tipocambioService.obtenerTipos();
    }

    @GetMapping("/getall")
    public List<TipoCambioDTORepository> obtenerTodo() {
        return tipocambioService.obtenerTodo();
    }

    @PostMapping()
    public TipoCambioModel registrarCambio(@RequestBody TipoCambioModel nuevoTipo) {
        System.out.println("Datos recibidos: TipoCambio=" + nuevoTipo.getTipoCambio() +
                       ", UsuarioID=" + nuevoTipo.getUsuarioID() + 
                       ", Status=" + nuevoTipo.getStatus());
        TipoCambioModel fechaExiste = tipocambioRepository.findByFecha(nuevoTipo.getFecha());
        
        if(fechaExiste != null){
            return null;
        }else{
            return tipocambioService.registrarCambio(nuevoTipo);
        }
        
    }

    @GetMapping("/buscar/{fecha}")
    public ResponseEntity<TipoCambioModel> buscarTipoCambio(@PathVariable Date fecha){
        TipoCambioModel fechaExiste = tipocambioRepository.findByFecha(fecha);
        
        if(fechaExiste != null){
            return ResponseEntity.ok(fechaExiste);
        }else{
            return ResponseEntity.noContent().build();
        }
    }
    
    @DeleteMapping("/deleting/{id}")
    public ResponseEntity<Map<String, String>> deleteTipoCambio(@PathVariable Integer id) {
        Optional<TipoCambioModel> tipos = tipocambioRepository.findById(id);

        if (tipos.isPresent()) {
            tipocambioRepository.deleteById(id);
            return ResponseEntity.ok(Map.of("message", "Tipo Cambio eliminado correctamente"));
        } else {
            return ResponseEntity.ok(Map.of("estado", "0"));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoCambioModel> actualizarCamion(@PathVariable Integer id, @RequestBody TipoCambioModel tipocambio) {
        Optional<TipoCambioModel> tipoExistenteOpt = tipocambioRepository.findById(id);

        if (tipoExistenteOpt.isPresent()) {
            TipoCambioModel cambioExistente = tipoExistenteOpt.get();
            cambioExistente.setTipoCambio(tipocambio.getTipoCambio());
            cambioExistente.setFecha(tipocambio.getFecha());
            cambioExistente.setFechaRegistro(tipocambio.getFechaRegistro());
            cambioExistente.setUsuarioID(tipocambio.getUsuarioID());

            TipoCambioModel cambioActualizado = tipocambioRepository.save(cambioExistente);
            return ResponseEntity.ok(cambioActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
