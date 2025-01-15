package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.durandb.ItinerariosModel;
import com.appchoferes.nomina.models.durandb.dtos.ItinerariosDTO;
import com.appchoferes.nomina.repositories.durandb.ItinerariosDTORepository;
import com.appchoferes.nomina.repositories.durandb.ItinerariosRepository;
import com.appchoferes.nomina.services.durandb.ItinerariosService;

@RestController
@RequestMapping("/itinerarios")
public class ItinerariosController {

    @Autowired
    ItinerariosService itinerariosService;

    @Autowired
    ItinerariosRepository itinerariosRepository;

    @Autowired
    ItinerariosDTORepository itinerariosDTORepository;

    @GetMapping()
    public ArrayList<ItinerariosModel> obtenerItinerarios() {
        return itinerariosService.obtenerItinerarios();
    }

    @GetMapping("/tabla")
    public ArrayList<ItinerariosModel> findTop50ByOrderByItinerarioIDAsc() {
        return itinerariosService.obtenerItinerarios50();
    }

    @GetMapping("/status")
    public ArrayList<ItinerariosModel> obtenerItinerariosByStatus(
            @RequestParam(value = "status", defaultValue = "1") int Status) {
        //return itinerariosRepository.findByStatus(Status);
        return itinerariosRepository.findByStatusAux(Status);
    }

    @PostMapping()
    public ItinerariosDTO registrarItinerarios(@RequestBody ItinerariosDTO nuevaOrden) {
        return itinerariosService.registrarItinerario(nuevaOrden);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItinerariosDTO> actualizarItinerario(@PathVariable Integer id,
            @RequestBody ItinerariosDTO itinerario) {
        Optional<ItinerariosDTO> itinerarioExistenteOpt = itinerariosDTORepository.findById(id);

        if (itinerarioExistenteOpt.isPresent()) {
            ItinerariosDTO itinerarioExistente = itinerarioExistenteOpt.get();
            itinerarioExistente.setRutaID(itinerario.getRutaID());
            itinerarioExistente.setChoferID(itinerario.getChoferID());
            itinerarioExistente.setCamionID(itinerario.getCamionID());
            itinerarioExistente.setCajaID(itinerario.getCajaID());
            itinerarioExistente.setNota(itinerario.getNota());
            itinerarioExistente.setCaja(itinerario.getCaja());
            itinerarioExistente.setMercancia(itinerario.getMercancia());
            itinerarioExistente.setStatus(itinerario.getStatus());
            itinerarioExistente.setFecha(itinerario.getFecha());
            itinerarioExistente.setPagodelCliente(itinerario.getPagodelCliente());
            itinerarioExistente.setPagoSV(itinerario.getPagoSV());
            itinerarioExistente.setPagoSC(itinerario.getPagoSC());
            itinerarioExistente.setPagoRV(itinerario.getPagoRV());
            itinerarioExistente.setPagoRC(itinerario.getPagoRC());
            itinerarioExistente.setMonedaCliente(itinerario.getMonedaCliente());
            itinerarioExistente.setMonedaChofer(itinerario.getMonedaChofer());
            itinerarioExistente.setCarga(itinerario.getCarga());
            itinerarioExistente.setViaticos(itinerario.getViaticos());
            itinerarioExistente.setViaticosUSD(itinerario.getViaticosUSD());
            itinerarioExistente.setCantidadSellos(itinerario.getCantidadSellos());
            itinerarioExistente.setUsuarioID(itinerario.getUsuarioID());
            itinerarioExistente.setEstadoOrden(itinerario.getEstadoOrden());
            itinerarioExistente.setProgramacionID(itinerario.getProgramacionID());
            itinerarioExistente.setWcontFK(itinerario.getWcontFK());
            itinerarioExistente.setStatusMov(itinerario.getStatusMov());
            itinerarioExistente.setTipoContFK(itinerario.getTipoContFK());
            itinerarioExistente.setClienteSerID(itinerario.getClienteSerID());
            itinerarioExistente.setLocacionOrigenID(itinerario.getLocacionOrigenID());
            itinerarioExistente.setFuente(itinerario.getFuente());
            itinerarioExistente.setEstado(itinerario.getEstado());
            itinerarioExistente.setTipoOperacion(itinerario.getTipoOperacion());
            itinerarioExistente.setExternalid(itinerario.getExternalid());
            itinerarioExistente.setUsuarioDocs(itinerario.getUsuarioDocs());
            itinerarioExistente.setFechaDocs(itinerario.getFechaDocs());
            itinerarioExistente.setCusRef(itinerario.getCusRef());

            ItinerariosDTO itinerarioActualizado = itinerariosDTORepository.save(itinerarioExistente);
            return ResponseEntity.ok(itinerarioActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleting/{id}")
    public ResponseEntity<Map<String, String>> deleteItinerarios(@PathVariable Integer id) {
        Optional<ItinerariosModel> itinerarios = itinerariosRepository.findById(id);

        if (itinerarios.isPresent()) {
            itinerariosRepository.deleteById(id);
            return ResponseEntity.ok(Map.of("message", "Itinerario eliminado correctamente"));
        } else {
            return ResponseEntity.ok(Map.of("estado", "0"));
        }
    }


    @PostMapping("/status/{itinerarioID}/{status}")
    public ItinerariosModel updateStatus(@PathVariable Integer itinerarioID, @PathVariable Integer status){
        Optional<ItinerariosModel> itinerario = itinerariosRepository.findById(itinerarioID);

        if(!itinerario.isEmpty()){
            ItinerariosModel it = itinerario.get();
            it.setStatus(status);
            return itinerariosRepository.save(it);
        }else{
            return null;
        }  
        
    }
}
