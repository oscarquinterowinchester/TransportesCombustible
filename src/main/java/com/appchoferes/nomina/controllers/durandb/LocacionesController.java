package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.durandb.LocacionesModel;
import com.appchoferes.nomina.repositories.durandb.LocacionesRepository;
import com.appchoferes.nomina.services.durandb.LocacionesService;

@RestController
@RequestMapping("/locaciones")
public class LocacionesController {

    @Autowired
    LocacionesService locacionesService;

    @Autowired
    LocacionesRepository locacionesRepository;

    @GetMapping()
    public ArrayList<LocacionesModel> obtenerLocaciones() {
        return locacionesService.obtenerLocaciones();
    }

    @GetMapping("/status")
    public ArrayList<LocacionesModel> obtenerLocacionesByStatus(
            @RequestParam(value = "status", defaultValue = "1") int Status) {
        return locacionesRepository.findByStatus(Status);
    }

    @GetMapping("/{id}")
    public LocacionesModel obtenerEntidadPorId(@PathVariable int id) {
        Optional<LocacionesModel> entidad = locacionesService.findById(id);
        if (entidad.isPresent()) {
            return entidad.get();
        } else {
            return null;
        }
    }

    @PostMapping()
    public LocacionesModel registrarLocacion(@RequestBody LocacionesModel nuevaLocacion) {
        System.out.println("Llegue");
        return locacionesService.registrarLocaciones(nuevaLocacion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteLocaciones(@PathVariable Integer id) {
        Optional<LocacionesModel> locacion = locacionesRepository.findById(id);

        if (locacion.isPresent()) {
            locacionesRepository.deleteById(id);
            return ResponseEntity.ok(Map.of("message", "Locacion, eliminado correctamente"));
        } else {
            return ResponseEntity.notFound().build(); // La locacion no se encontró
        }
    }

    @PutMapping("borrar/{id}")
    public ResponseEntity<LocacionesModel> actualizarLocacionesStatus(@PathVariable Integer id,
            @RequestBody LocacionesModel orden) {
        Optional<LocacionesModel> ordenExistenteOpt = locacionesRepository.findById(id);

        if (ordenExistenteOpt.isPresent()) {
            LocacionesModel ordenExistente = ordenExistenteOpt.get();

            ordenExistente.setStatus(orden.getStatus());

            LocacionesModel locacionActualizada = locacionesRepository.save(ordenExistente);

            return ResponseEntity.ok(locacionActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocacionesModel> actualizarLocacion(@PathVariable Integer id,
            @RequestBody LocacionesModel locacion) {
        Optional<LocacionesModel> locacionExistenteOpt = locacionesRepository.findById(id);

        if (locacionExistenteOpt.isPresent()) {
            LocacionesModel locacionExistente = locacionExistenteOpt.get();

            locacionExistente.setNombre(locacion.getNombre());
            locacionExistente.setStatus(locacion.getStatus());
            locacionExistente.setDireccion(locacion.getDireccion());
            locacionExistente.setNoExterior(locacion.getNoExterior());
            locacionExistente.setEstado(locacion.getEstado());
            locacionExistente.setPais(locacion.getPais());
            locacionExistente.setCP(locacion.getCP());
            locacionExistente.setClienteID(locacion.getClienteID());
            locacionExistente.setMunicipio(locacion.getMunicipio());
            locacionExistente.setPuerto(locacion.getPuerto());
            locacionExistente.setTren(locacion.getTren());
            locacionExistente.setNombreCompleto(locacion.getNombreCompleto());
            locacionExistente.setNombreCorto(locacion.getNombreCorto());
            locacionExistente.setCodigoL(locacion.getCodigoL());
            locacionExistente.setPaisID(locacion.getPaisID());
            locacionExistente.setEstadoID(locacion.getEstadoID());
            locacionExistente.setCestado(locacion.getCestado());
            locacionExistente.setClocalidadid(locacion.getClocalidadid());
            locacionExistente.setCmunicipioid(locacion.getCmunicipioid());
            locacionExistente.setCcoloniaid(locacion.getCcoloniaid());
            locacionExistente.setRFCl(locacion.getRFCl());
            locacionExistente.setLongitud(locacion.getLongitud());
            locacionExistente.setLatitud(locacion.getLatitud());
            locacionExistente.setFiltraCP(locacion.getFiltraCP());
            locacionExistente.setContacto(locacion.getContacto());
            locacionExistente.setTelefono(locacion.getTelefono());
            locacionExistente.setGeoname(locacion.getGeoname());
            locacionExistente.setAgencia(locacion.getAgencia());
            locacionExistente.setHorarios(locacion.getHorarios());

            // Guarda los cambios en la base de datos
            LocacionesModel locacionActualizado = locacionesRepository.save(locacionExistente);

            return ResponseEntity.ok(locacionActualizado);

        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
