package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.durandb.CajasModel;
import com.appchoferes.nomina.repositories.durandb.CajasRepository;
import com.appchoferes.nomina.services.durandb.CajasService;

@RestController
@RequestMapping("/cajas")
public class CajasController {

    @Autowired
    CajasService cajasService;

    @Autowired
    CajasRepository cajasRepository;

    @GetMapping()
    public ArrayList<CajasModel> obtenerCajas() {
        return cajasService.obtenerCajas();
    }

    @PostMapping()
    public CajasModel registrarCaja(@RequestBody CajasModel nuevaCaja) {
        return cajasService.registrarCaja(nuevaCaja);
    }

    /*
     * @GetMapping("/activas")
     * public ResponseEntity<List<CajasModel>> obtenerCajasActivasOrdenadas() {
     * List<CajasModel> cajas =
     * cajasService.obtenerCajasActivasOrdenadasPorNoEconomico();
     * return new ResponseEntity<>(cajas, HttpStatus.OK);
     * }
     */
    @GetMapping("/activas")
    public ResponseEntity<List<CajasModel>> obtenerCajasActivasOrdenadas() {
        List<CajasModel> cajasActivasOrdenadas = cajasService.obtenerCajasActivasOrdenadas();
        return new ResponseEntity<>(cajasActivasOrdenadas, HttpStatus.OK);
    }

    @PutMapping("borrar/{id}")
    public ResponseEntity<CajasModel> actualizarCajaStatus(@PathVariable Integer id,
            @RequestBody CajasModel orden) {
        Optional<CajasModel> ordenExistenteOpt = cajasRepository.findById(id);

        if (ordenExistenteOpt.isPresent()) {
            CajasModel ordenExistente = ordenExistenteOpt.get();

            ordenExistente.setStatus(orden.getStatus());

            CajasModel cajaActualizada = cajasRepository.save(ordenExistente);

            return ResponseEntity.ok(cajaActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteCaja(@PathVariable Integer id) {
        Optional<CajasModel> caja = cajasRepository.findById(id);

        if (caja.isPresent()) {
            cajasRepository.deleteById(id);
            return ResponseEntity.ok(Map.of("message", "Caja, eliminado correctamente"));
        } else {
            return ResponseEntity.notFound().build(); // El caja no se encontró
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CajasModel> actualizarCaja(@PathVariable Integer id, @RequestBody CajasModel caja) {
        Optional<CajasModel> cajaExistenteOpt = cajasRepository.findById(id);

        if (cajaExistenteOpt.isPresent()) {
            CajasModel cajaExistente = cajaExistenteOpt.get();

            // Actualiza los campos del objeto existente con los valores proporcionados en
            // el cuerpo de la solicitud
            cajaExistente.setNoEconomico(caja.getNoEconomico());
            cajaExistente.setStatus(caja.getStatus());
            cajaExistente.setModelo(caja.getModelo());
            cajaExistente.setSerie(caja.getSerie());
            cajaExistente.setTamano(caja.getTamano());
            cajaExistente.setTipo(caja.getTipo());
            cajaExistente.setTanque(caja.getTanque());
            cajaExistente.setPlacas(caja.getPlacas());
            cajaExistente.setExpPlacas(caja.getExpPlacas());
            cajaExistente.setFecha(caja.getFecha());
            cajaExistente.setEstado(caja.getEstado());
            cajaExistente.setCategoria(caja.getCategoria());
            cajaExistente.setPlacasUSA(caja.getPlacasUSA());
            cajaExistente.setEstadoPlacas(caja.getEstadoPlacas());
            cajaExistente.setEstadoPlacasUSA(caja.getEstadoPlacasUSA());
            cajaExistente.setMarca(caja.getMarca());
            cajaExistente.setExpPlacasUSA(caja.getExpPlacasUSA());
            cajaExistente.setPertenece(caja.getPertenece());
            cajaExistente.setUNegocioID(caja.getUNegocioID());
            cajaExistente.setUsuarioMod(caja.getUsuarioMod());
            cajaExistente.setFechaMod(caja.getFechaMod());
            cajaExistente.setComentarios(caja.getComentarios());
            cajaExistente.setSubTipoRem(caja.getSubTipoRem());
            cajaExistente.setEmpresaID(caja.getEmpresaID());
            cajaExistente.setDescr(caja.getDescr());
            cajaExistente.setClasificacion(caja.getClasificacion());
            cajaExistente.setOperacion(caja.getOperacion());
            cajaExistente.setTarifamensual(caja.getTarifamensual());
            cajaExistente.setMoneda(caja.getMoneda());
            cajaExistente.setProveedorID(caja.getProveedorID());
            cajaExistente.setFecha_alquiler(caja.getFecha_alquiler());
            cajaExistente.setEstatus_caja(caja.getEstatus_caja());

            // Guarda los cambios en la base de datos
            CajasModel cajaActualizada = cajasRepository.save(cajaExistente);

            return ResponseEntity.ok(cajaActualizada);
        } else {
            // Si la caja no existe, devuelve una respuesta 404 Not Found
            return ResponseEntity.notFound().build();
        }
    }

}
