package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.durandb.CamionModel;
import com.appchoferes.nomina.models.durandb.ItiCartasPorteModel;
import com.appchoferes.nomina.models.durandb.dtos.ItiCartasPorteDTO;
import com.appchoferes.nomina.repositories.durandb.ItiCartasPorteRepository;
import com.appchoferes.nomina.services.durandb.ItiCartasPorteService;

@RestController
@RequestMapping("/iticartasporte")
public class ItiCartasPorteController {

    @Autowired
    ItiCartasPorteService itiCartasPorteService;

    @Autowired
    ItiCartasPorteRepository itiCartasPorteRepository;

    @GetMapping()
    public ArrayList<ItiCartasPorteModel> obtenerItiCarta() {
        return itiCartasPorteService.obtenerItiCarta();
    }

    @GetMapping("/dto")
    public ArrayList<ItiCartasPorteDTO> obtenerItiCartaDTO() {
        return itiCartasPorteService.obtenerItiCartaDTO();
    }

    @GetMapping("/status")
    public ArrayList<ItiCartasPorteModel> obtenerItiCartaByStatus(
            @RequestParam(value = "Status", defaultValue = "1") int Status) {
        return itiCartasPorteRepository.findByStatus(Status);
    }

    @GetMapping("/byItinerarioID/{itinerarioID}")
    public ItiCartasPorteModel obtenerItiCartasPorteModelByItinerarioID(@PathVariable int itinerarioID){
        Optional<ItiCartasPorteModel> entidad = itiCartasPorteRepository.findByItinerarioID(itinerarioID);
        if(entidad.isPresent()){
            return entidad.get();
        }else{
            return null;
        }
    }

    

    @GetMapping("/{id}")
    public ItiCartasPorteModel obtenerItiCartaID(@PathVariable int id) {
        Optional<ItiCartasPorteModel> entidad = itiCartasPorteService.findById(id);
        if (entidad.isPresent()) {
            return entidad.get();
        } else {
            return null;
        }
    }

    @GetMapping("/bycartaporteid/{id}")
    public ResponseEntity<ItiCartasPorteModel> findByCartaPorteID(@PathVariable Integer id) {
        ItiCartasPorteModel icont = itiCartasPorteRepository.findByCartaPorteID(id);

        if (!icont.isEmpty()) {
            return ResponseEntity.ok(icont);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/anio/{ItinerarioID}")
    public ResponseEntity<String> getAnioByItinerarioId(@PathVariable Integer ItinerarioID) {
        String anio = itiCartasPorteRepository.findAnioByItinerarioID(ItinerarioID);
        return ResponseEntity.ok(anio);
    }

    @GetMapping("/camion/{ItinerarioID}")
    public ResponseEntity<CamionModel> getCamionByItinerarioId(@PathVariable Integer ItinerarioID) {
        CamionModel camion = itiCartasPorteRepository.findCamionByItinerarioID(ItinerarioID);

        if (camion != null) {
            return ResponseEntity.ok(camion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/dto")
    public ItiCartasPorteDTO registrarItiCartas(@RequestBody ItiCartasPorteDTO nuevaCarta) {
        return itiCartasPorteService.registrarItiCartas(nuevaCarta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItiCartasPorteModel> actualizarItiCartasPorte(@PathVariable Integer id, @RequestBody ItiCartasPorteModel iti){
        ItiCartasPorteModel itiExistente = itiCartasPorteRepository.findByCartaPorteID(id);
        if(itiExistente != null){
            itiExistente.setNoCartaPorte(iti.getNoCartaPorte());
            ItiCartasPorteModel ordenActualizado = itiCartasPorteRepository.save(itiExistente);
            return ResponseEntity.ok(ordenActualizado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/cancel/{ItinerarioID}/{NoCartaPorte}")
    public ItiCartasPorteModel getItinerarioToCancel(@PathVariable Integer ItinerarioID, @PathVariable String NoCartaPorte) {
        Optional<ItiCartasPorteModel> entidad = itiCartasPorteRepository.findItiCartaPorteToCancel(ItinerarioID, NoCartaPorte);

        if (entidad.isPresent()) {
            return entidad.get();
        } else {
            return null;
        }
    }

    @PutMapping("/updatestatusfalse/{id}")
    public ResponseEntity<ItiCartasPorteModel> actualizarItiCartasPorteFalse(@PathVariable Integer id){
        ItiCartasPorteModel itiExistente = itiCartasPorteRepository.findByCartaPorteID(id);
        if(itiExistente != null){
            itiExistente.setStatus( (byte) 0);
            ItiCartasPorteModel ordenActualizado = itiCartasPorteRepository.save(itiExistente);
            return ResponseEntity.ok(ordenActualizado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
