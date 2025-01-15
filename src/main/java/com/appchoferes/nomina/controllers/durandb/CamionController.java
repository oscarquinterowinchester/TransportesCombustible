package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.durandb.CamionModel;
import com.appchoferes.nomina.repositories.durandb.CamionRepository;
import com.appchoferes.nomina.services.durandb.CamionService;

@RestController
@RequestMapping("/camiones")
@CrossOrigin(origins = "*")
public class CamionController {
    @Autowired
    CamionService camionService;

    @Autowired
    CamionRepository camionRepository;

    @GetMapping()
    public ArrayList<CamionModel> obtenerCamiones() {
        return camionService.obtenerCamiones();
    }

    @GetMapping("activos")
    public ArrayList<CamionModel> obtenerCamionesActivos() {
        return camionService.obtenerCamionesActivos();
    }


    @GetMapping("/status")
    public ArrayList<CamionModel> obtenerCamionByStatus(
            @RequestParam(value = "status", defaultValue = "1") int Status) {
        return camionRepository.findByStatus(Status);
    }

    @GetMapping("/{id}")
    public CamionModel obtenerCamionid(@PathVariable int id) {
        Optional<CamionModel> entidad = camionService.findById(id);
        if (entidad.isPresent()) {
            return entidad.get();
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteCamion(@PathVariable Integer id) {
        Optional<CamionModel> camion = camionRepository.findById(id);

        if (camion.isPresent()) {
            camionRepository.deleteById(id);
            return ResponseEntity.ok(Map.of("message", "Camión eliminado correctamente"));
        } else {
            return ResponseEntity.notFound().build(); // El camión no se encontró
        }
    }

    @PutMapping("borrar/{id}")
    public ResponseEntity<CamionModel> actualizarCamiontatus(@PathVariable Integer id,
            @RequestBody CamionModel orden) {
        Optional<CamionModel> ordenExistenteOpt = camionRepository.findById(id);

        if (ordenExistenteOpt.isPresent()) {
            CamionModel ordenExistente = ordenExistenteOpt.get();

            ordenExistente.setStatus(orden.getStatus());

            CamionModel CamionActualizado = camionRepository.save(ordenExistente);

            return ResponseEntity.ok(CamionActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public CamionModel registrarCamion(@RequestBody CamionModel nuevoCamion) {
        return camionService.registrarCamion(nuevoCamion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CamionModel> actualizarCamion(@PathVariable Integer id, @RequestBody CamionModel camion) {
        Optional<CamionModel> camionExistenteOpt = camionRepository.findById(id);

        if (camionExistenteOpt.isPresent()) {
            CamionModel camionExistente = camionExistenteOpt.get();
            camionExistente.setNoEconomico(camion.getNoEconomico());
            camionExistente.setModelo(camion.getModelo());
            camionExistente.setMarca(camion.getMarca());
            camionExistente.setPlacas(camion.getPlacas());
            camionExistente.setPlacasUSA(camion.getPlacasUSA());
            camionExistente.setExpPlacas(camion.getExpPlacas());
            camionExistente.setExpPlacasUSA(camion.getExpPlacasUSA());
            camionExistente.setExpSeguro(camion.getExpSeguro());
            camionExistente.setNoPoliza(camion.getNoPoliza());
            camionExistente.setSerie(camion.getSerie());
            camionExistente.setMoto(camion.getMoto());
            camionExistente.setTransmision(camion.getTransmision());
            camionExistente.setDiferencial(camion.getDiferencial());
            camionExistente.setSuspension(camion.getSuspension());
            camionExistente.setTipoAutobus(camion.getTipoAutobus());
            camionExistente.setVerifiMotor(camion.getVerifiMotor());
            camionExistente.setVerifiHumo(camion.getVerifiHumo());
            camionExistente.setFecha(camion.getFecha());
            camionExistente.setKmMantenimiento(camion.getKmMantenimiento());
            camionExistente.setTanques(camion.getTanques());
            camionExistente.setCapacidad(camion.getCapacidad());
            camionExistente.setStatus(camion.getStatus());
            camionExistente.setCajaID(camion.getCajaID());
            camionExistente.setPolizaUSA(camion.getPolizaUSA());
            camionExistente.setTransponder(camion.getTransponder());
            camionExistente.setTipoOdometro(camion.getTipoOdometro());
            camionExistente.setEstadoPlacas(camion.getEstadoPlacas());
            camionExistente.setEstadoPlacasUSA(camion.getEstadoPlacasUSA());
            camionExistente.setTipoPermiso(camion.getTipoPermiso());
            camionExistente.setSinOdometro(camion.getSinOdometro());
            camionExistente.setRegistroID(camion.getRegistroID());
            camionExistente.setGPSID(camion.getGPSID());
            camionExistente.setLat(camion.getLat());
            camionExistente.setLon(camion.getLon());
            camionExistente.setDireccion(camion.getDireccion());
            camionExistente.setUltimoOdometro(camion.getUltimoOdometro());
            camionExistente.setPatioActualID(camion.getPatioActualID());
            camionExistente.setUNegocioID(camion.getUNegocioID());
            camionExistente.setFechaMantenimiento(camion.getFechaMantenimiento());
            camionExistente.setTanqueActual(camion.getTanqueActual());
            camionExistente.setRendimiento(camion.getRendimiento());
            camionExistente.setItinerarioFK(camion.getItinerarioFK());
            camionExistente.setNumIFTA(camion.getNumIFTA());
            camionExistente.setTarjetaCombustible(camion.getTarjetaCombustible());
            camionExistente.setUsuarioMod(camion.getUsuarioMod());
            camionExistente.setFechaMod(camion.getFechaMod());
            camionExistente.setUsuarioEli(camion.getUsuarioEli());
            camionExistente.setNotaEli(camion.getNotaEli());
            camionExistente.setFechaEli(camion.getFechaEli());
            camionExistente.setMetaDiaria(camion.getMetaDiaria());
            camionExistente.setComentarios(camion.getComentarios());
            camionExistente.setCIFTA(camion.getCIFTA());
            camionExistente.setNombreAseguradora(camion.getNombreAseguradora());
            camionExistente.setCostoporMillaMatto(camion.getCostoporMillaMatto());
            camionExistente.setConfigVehicular(camion.getConfigVehicular());
            camionExistente.setNumPermSCT(camion.getNumPermSCT());
            camionExistente.setPermSCT(camion.getPermSCT());
            camionExistente.setAnio(camion.getAnio());
            camionExistente.setNombreAseguradoraMA(camion.getNombreAseguradoraMA());
            camionExistente.setPolizaMA(camion.getPolizaMA());
            camionExistente.setEmpresaID(camion.getEmpresaID());
            camionExistente.setBoe(camion.getBoe());
            camionExistente.setCaat(camion.getCaat());
            camionExistente.setScac(camion.getScac());
            camionExistente.setCerthazmat(camion.getCerthazmat());
            camionExistente.setNlic(camion.getNlic());
            camionExistente.setFuelGID(camion.getFuelGID());
            camionExistente.setTipoCamionID(camion.getTipoCamionID());
            camionExistente.setPartetransporte(camion.getPartetransporte());
            camionExistente.setTipofigura(camion.getTipofigura());

            CamionModel camionActualizado = camionRepository.save(camionExistente);
            return ResponseEntity.ok(camionActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
