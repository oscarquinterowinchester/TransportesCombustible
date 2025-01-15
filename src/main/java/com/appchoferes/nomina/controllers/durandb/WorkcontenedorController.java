package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.durandb.WorkContenedorDTO;
import com.appchoferes.nomina.models.durandb.WorkcontenedorModel;
import com.appchoferes.nomina.repositories.durandb.WorkcontenedorRepository;
import com.appchoferes.nomina.services.durandb.WorkcontenedorService;

@RestController
@RequestMapping("/workcontenedor")
public class WorkcontenedorController {

    @Autowired
    WorkcontenedorService workcontenedorService;

    @Autowired
    WorkcontenedorRepository workcontenedorRepository;

    @GetMapping()
    public ArrayList<WorkcontenedorModel> obtenerWork() {
        return workcontenedorService.getWorkContenedores();
    }

    @GetMapping("/workcontenedores")
    public WorkContenedorDTO obtenerInformacionExtra(@RequestParam Integer wcont1, @RequestParam Integer wcont2,
    @RequestParam Double cobroCliente, @RequestParam Double tipoCambio, @RequestParam Integer monedaCliente){
        Double tipoCambio2 = tipoCambio;
        if(tipoCambio2 == 0.00){
            tipoCambio2 = 1.00;
        }
        Double CobroCliente = cobroCliente * tipoCambio2;
        Double CobroCliente2 = cobroCliente / tipoCambio2;
        Double importe = workcontenedorRepository.obtenerImporte(CobroCliente, CobroCliente2, tipoCambio, wcont2, monedaCliente);
        String description = workcontenedorRepository.obtenerDescription(wcont1, wcont2);
        String objImp = workcontenedorRepository.obtenerObjImp(wcont1);
        Double iva = workcontenedorRepository.obtenerIVA(wcont1);
        Double ivaRet = workcontenedorRepository.obtenerIVARET(wcont1);

        WorkContenedorDTO workContenedorDTO = new WorkContenedorDTO();

        workContenedorDTO.setDescripcion(description);
        workContenedorDTO.setObjimp(objImp);
        workContenedorDTO.setIva(iva);
        workContenedorDTO.setIvaret(ivaRet);
        workContenedorDTO.setImporte(importe);

        return workContenedorDTO;
    }

    @GetMapping("/{id}")
    public WorkcontenedorModel obtenerWorkid(@PathVariable int id) {
        Optional<WorkcontenedorModel> entidad = workcontenedorService.findById(id);
        if (entidad.isPresent()) {
            return entidad.get();
        } else {
            return null;
        }
    }

    @PostMapping()
    public WorkcontenedorModel registrarOrden(@RequestBody WorkcontenedorModel nuevaOrden) {
        return workcontenedorService.registrarOrden(nuevaOrden);
    }

    // @PostMapping()
    // public String registrarOrden(@RequestBody WorkcontenedorModel nuevaOrden) {
    //     return "SI LLEGO";
    // }

    @PutMapping("placas/{id}")
    public ResponseEntity<WorkcontenedorModel> actualizarContenedorPlacas(@PathVariable Integer id,
            @RequestBody WorkcontenedorModel orden) {
        Optional<WorkcontenedorModel> ordenExistenteOpt = workcontenedorRepository.findById(id);

        if (ordenExistenteOpt.isPresent()) {
            WorkcontenedorModel ordenExistente = ordenExistenteOpt.get();

            ordenExistente.setPlacasChasis(orden.getPlacasChasis());
            ordenExistente.setCSubtipoRem(orden.getCSubtipoRem());

            WorkcontenedorModel ordenActualizado = workcontenedorRepository.save(ordenExistente);
            return ResponseEntity.ok(ordenActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkcontenedorModel> actualizarContenedor(@PathVariable Integer id,
            @RequestBody WorkcontenedorModel orden) {
        Optional<WorkcontenedorModel> ordenExistenteOpt = workcontenedorRepository.findById(id);

        if (ordenExistenteOpt.isPresent()) {
            WorkcontenedorModel ordenExistente = ordenExistenteOpt.get();

            // ordenExistente.setWContenedorID(orden.getWContenedorID());
            ordenExistente.setClientefk(orden.getClientefk());
            ordenExistente.setTipoMov(orden.getTipoMov());
            ordenExistente.setNcontenedor(orden.getNcontenedor());
            ordenExistente.setCopiable(orden.getCopiable());
            ordenExistente.setNavierafk(orden.getNavierafk());
            ordenExistente.setNavierawc(orden.getNavierawc());
            ordenExistente.setBuquewc(orden.getBuquewc());
            ordenExistente.setPrioridad(orden.getPrioridad());
            ordenExistente.setInbond(orden.getInbond());
            ordenExistente.setReferenciaccp(orden.getReferenciaccp());
            ordenExistente.setEquipprovid(orden.getEquipprovid());
            ordenExistente.setCamionfk(orden.getCamionfk());
            ordenExistente.setChoferfk(orden.getChoferfk());
            ordenExistente.setConceptoSAT(orden.getConceptoSAT());
            ordenExistente.setUnidadSAT(orden.getUnidadSAT());
            ordenExistente.setCantidad(orden.getCantidad());
            ordenExistente.setEstadoCarga(orden.getEstadoCarga());
            ordenExistente.setNumeroReservacion(orden.getNumeroReservacion());
            ordenExistente.setStatus(orden.getStatus());
            ordenExistente.setNotaInterna(orden.getNotaInterna());
            ordenExistente.setPONumber(orden.getPONumber());
            ordenExistente.setBLwc(orden.getBLwc());
            ordenExistente.setPesoC(orden.getPesoC());
            ordenExistente.setStatusf(orden.getStatusf());
            ordenExistente.setEdiID(orden.getEdiID());
            ordenExistente.setFolioTE(orden.getFolioTE());
            ordenExistente.setAppoimentDate(orden.getAppoimentDate());
            ordenExistente.setDeliveryDateReq(orden.getDeliveryDateReq());
            ordenExistente.setContenedor(orden.getContenedor());
            ordenExistente.setNotaProgramacion(orden.getNotaProgramacion());
            ordenExistente.setEstadoPlacas(orden.getEstadoPlacas());
            ordenExistente.setFecha(orden.getFecha());
            ordenExistente.setTamano(orden.getTamano());
            ordenExistente.setCajaID(orden.getCajaID());
            ordenExistente.setNumeroSello(orden.getNumeroSello());
            ordenExistente.setRFD(orden.getRFD());
            ordenExistente.setCScale(orden.getCScale());
            ordenExistente.setAppNumber(orden.getAppNumber());
            ordenExistente.setLastFreeDay(orden.getLastFreeDay());
            ordenExistente.setOutPort(orden.getOutPort());
            ordenExistente.setPUCliente(orden.getPUCliente());
            ordenExistente.setAvDate(orden.getAvDate());
            ordenExistente.setCobroCliente(orden.getCobroCliente());
            ordenExistente.setWorkOrderID(orden.getWorkOrderID());
            ordenExistente.setUSArrDate(orden.getUSArrDate());
            ordenExistente.setCSubtipoRem(orden.getCSubtipoRem());
            ordenExistente.setPlacasChasis(orden.getPlacasChasis());
            ordenExistente.setTipoUID(orden.getTipoUID());
            ordenExistente.setFechaPosicion(orden.getFechaPosicion());
            ordenExistente.setUsuarioID(orden.getUsuarioID());
            ordenExistente.setRutaID(orden.getRutaID());
            ordenExistente.setMonedaCliente(orden.getMonedaCliente());
            ordenExistente.setTipoOperacion(orden.getTipoOperacion());
            ordenExistente.setCusRef(orden.getCusRef());

            WorkcontenedorModel ordenActualizado = workcontenedorRepository.save(ordenExistente);
            return ResponseEntity.ok(ordenActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
