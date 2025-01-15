package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.durandb.RutasModel;
import com.appchoferes.nomina.repositories.durandb.RutasRepository;
import com.appchoferes.nomina.services.durandb.RutasService;

@RestController
@RequestMapping("/rutas")
public class RutasController {

    @Autowired
    RutasService rutasService;

    @Autowired
    RutasRepository rutasRepository;

    @GetMapping()
    public ArrayList<RutasModel> obtenerRutas() {
        return rutasService.obtenerRutas();
    }

    @GetMapping("/ractivas")
    public ArrayList<RutasModel> obtenerRutasActivas() {
        return rutasService.obtenerRutasActivas();
    }

    @GetMapping("/{id}")
    public RutasModel obtenerRutaid(@PathVariable int id) {
        Optional<RutasModel> entidad = rutasService.findById(id);
        if (entidad.isPresent()) {
            return entidad.get();
        } else {
            return null;
        }
    }

    @PostMapping()
    public RutasModel registrarRutas(@RequestBody RutasModel nuevaRuta) {
        return rutasService.registrarRutas(nuevaRuta);
    }

    @PutMapping("borrar/{id}")
    public ResponseEntity<RutasModel> actualizarRutasStatus(@PathVariable Integer id,
            @RequestBody RutasModel orden) {
        Optional<RutasModel> ordenExistenteOpt = rutasRepository.findById(id);

        if (ordenExistenteOpt.isPresent()) {
            RutasModel ordenExistente = ordenExistenteOpt.get();

            ordenExistente.setStatus(orden.getStatus());

            RutasModel rutaActualizada = rutasRepository.save(ordenExistente);

            return ResponseEntity.ok(rutaActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<RutasModel> actualizarRutas(@PathVariable Integer id,
            @RequestBody RutasModel orden) {
        Optional<RutasModel> ordenExistenteOpt = rutasRepository.findById(id);

        if (ordenExistenteOpt.isPresent()) {
            RutasModel ordenExistente = ordenExistenteOpt.get();

            ordenExistente.setStatus(orden.getStatus());
            ordenExistente.setNombre(orden.getNombre());
            ordenExistente.setOrigen(orden.getOrigen());
            ordenExistente.setDestino(orden.getDestino());
            ordenExistente.setKm(orden.getKm());
            ordenExistente.setViaticos(orden.getViaticos());
            ordenExistente.setCasetas(orden.getCasetas());
            ordenExistente.setLtDiesel(orden.getLtDiesel());
            ordenExistente.setLtGenerador(orden.getLtGenerador());
            ordenExistente.setFecha(orden.getFecha());
            ordenExistente.setMoneda(orden.getMoneda());
            ordenExistente.setMonedaChofer(orden.getMonedaChofer());
            ordenExistente.setViaticosUSD(orden.getViaticosUSD());
            ordenExistente.setNota(orden.getNota());
            ordenExistente.setDuracion(orden.getDuracion());
            ordenExistente.setTipoRuta(orden.getTipoRuta());
            ordenExistente.setCuentaID(orden.getCuentaID());
            ordenExistente.setContacto(orden.getContacto());
            ordenExistente.setCodigo(orden.getCodigo());
            ordenExistente.setTipoImpo(orden.getTipoImpo());
            ordenExistente.setConceptoSATID(orden.getConceptoSATID());
            ordenExistente.setDescripcionSAT(orden.getDescripcionSAT());
            ordenExistente.setTipoTarifa(orden.getTipoTarifa());
            ordenExistente.setLocacionPUID(orden.getLocacionPUID());
            ordenExistente.setLocacionTOID(orden.getLocacionTOID());
            ordenExistente.setCostoServicio(orden.getCostoServicio());
            ordenExistente.setMillasMX(orden.getMillasMX());
            ordenExistente.setClienteID(orden.getClienteID());
            ordenExistente.setRoundTrip(orden.getRoundTrip());
            ordenExistente.setHazmat(orden.getHazmat());
            ordenExistente.setUsuarioMod(orden.getUsuarioMod());
            ordenExistente.setControlhoras(orden.getControlhoras());
            ordenExistente.setFechaMod(orden.getFechaMod());
            ordenExistente.setTipoCruce(orden.getTipoCruce());
            ordenExistente.setEmpresaCobroID(orden.getEmpresaCobroID());
            ordenExistente.setObjimprt(orden.getObjimprt());
            ordenExistente.setIvart(orden.getIvart());
            ordenExistente.setIvaretrt(orden.getIvaretrt());
            ordenExistente.setVigencia(orden.getVigencia());
            ordenExistente.setEmpresaCCP(orden.getEmpresaCCP());
            ordenExistente.setExtrasJunto(orden.getExtrasJunto());
            ordenExistente.setAplicafsc(orden.getAplicafsc());
            ordenExistente.setFscid(orden.getFscid());
            ordenExistente.setEditable(orden.getEditable());
            ordenExistente.setComentario(orden.getComentario());

            RutasModel rutaActualizada = rutasRepository.save(ordenExistente);

            return ResponseEntity.ok(rutaActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
