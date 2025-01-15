package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.durandb.CartasPorteModel;
import com.appchoferes.nomina.repositories.durandb.CartasPorteRepository;
import com.appchoferes.nomina.services.durandb.CartasPorteService;

@RestController
@RequestMapping("/cartasporte")
public class CartasPorteController {

    @Autowired
    CartasPorteService cartasPorteService;

    @Autowired
    CartasPorteRepository cartasPorteRepository;

    @GetMapping()
    public ArrayList<CartasPorteModel> obtenerCartas() {
        return cartasPorteRepository.getCartasPorte();
    }

    @GetMapping("/status")
    public ArrayList<CartasPorteModel> getCartasPorteByStatus(
            @RequestParam(value = "status", defaultValue = "1") int Status) {
        return cartasPorteRepository.findByStatus(Status);
    }

    @GetMapping("/status/cancelados")
    public ArrayList<CartasPorteModel> getCartasPorteByStatusCancelados(
            @RequestParam(value = "status", defaultValue = "0") int Status) {
        return cartasPorteRepository.findByStatus(Status);
    }

    @GetMapping("/ultimo-registro")
    public CartasPorteModel obtenerUltimoRegistro() {
        return cartasPorteService.obtenerUltimoRegistro();
    }

    @GetMapping("/ultimo-registroid")
    public CartasPorteModel obtenerUltimoRegistroId() {
        return cartasPorteService.obtenerUltimoRegistroId();
    }

    @GetMapping("/registrotimbrado")
    public CartasPorteModel findFirstByGeneracionCartaPorteOrderByFechaRegistroDesc() {
        return cartasPorteService.findFirstByGeneracionCartaPorteOrderByFechaRegistroDesc();
    }

    @GetMapping("/{id}")
    public CartasPorteModel obtenerCartas(@PathVariable int id) {
        Optional<CartasPorteModel> entidad = cartasPorteService.findById(id);
        if (entidad.isPresent()) {
            return entidad.get();
        } else {
            return null;
        }
    }

    @GetMapping("/NoCartaPorte/{NoCartaPorte}")
    public CartasPorteModel obtenerCartaPorte(@PathVariable String NoCartaPorte){
        return cartasPorteRepository.findByNoCartasPorteModel(NoCartaPorte);
    }

    @GetMapping("/status/{itinerarioID}/{status}")
    public CartasPorteModel obtenerCartaPorteByItinerarioAndStatus(@PathVariable Integer itinerarioID, @PathVariable Integer status){
        Optional<CartasPorteModel> entidad = cartasPorteRepository.obtenerCartaPorteByItinerarioAndStatus(itinerarioID, status);

        if(entidad.isPresent()){
            return entidad.get();
        }else{
            return null;
        }
    }
    //TRANSACCION INICIO
    @PostMapping()
    public CartasPorteModel registrarCartas(@RequestBody CartasPorteModel nuevaCarta) {
        System.out.println("Fecha enviada1: " + nuevaCarta.getFechaRegistro());
        return cartasPorteService.registrarCartas(nuevaCarta);
    }

    @PostMapping("/{UUID}/{status}")
    public CartasPorteModel cancelarCartaPorte(@PathVariable String UUID, @PathVariable Integer status){
        Optional<CartasPorteModel> entidad = Optional.ofNullable(cartasPorteService.findByUUID(UUID));
        if (entidad.isPresent()) {
            CartasPorteModel cartaPorte = entidad.get();
            cartaPorte.setCancelar(status);
            return cartasPorteRepository.save(cartaPorte);
        } else {
            return null;
        }
    }


    // @PutMapping("foliocp/{id}")
    // public ResponseEntity<CartasPorteModel> actualizarCartaPorte2(@PathVariable
    // Integer id,
    // @RequestBody CartasPorteModel cartaPorteActualizada) {
    // // Buscar la carta porte por ID en la base de datos
    // CartasPorteModel cartaPorteExistente = cartasPorteRepository.findById(id)
    // .orElseThrow();

    // // Actualizar los atributos deseados
    // cartaPorteExistente.setFoliocp(cartaPorteActualizada.getFoliocp());
    // cartaPorteExistente.setNoCartaPorte(cartaPorteActualizada.getNoCartaPorte());
    // cartaPorteExistente.setGeneracionCartaPorte(cartaPorteActualizada.getGeneracionCartaPorte());

    // // Guardar la carta porte actualizada en la base de datos
    // CartasPorteModel cartaPorteActualizadaGuardada =
    // cartasPorteRepository.save(cartaPorteExistente);

    // // Devolver la respuesta con la carta porte actualizada
    // return ResponseEntity.ok(cartaPorteActualizadaGuardada);
    // }

    @PutMapping("placas/{id}")
    public ResponseEntity<CartasPorteModel> actualizarCartaPorte(@PathVariable Integer id,
            @RequestBody CartasPorteModel orden) {
        Optional<CartasPorteModel> ordenExistenteOpt = cartasPorteRepository.findById(id);

        if (ordenExistenteOpt.isPresent()) {
            CartasPorteModel ordenExistente = ordenExistenteOpt.get();

            ordenExistente.setFoliocp(orden.getFoliocp());
            ordenExistente.setNoCartaPorte(orden.getNoCartaPorte());
            ordenExistente.setSeriecp(orden.getSeriecp());
            ordenExistente.setGeneracionCartaPorte(orden.getGeneracionCartaPorte());
            ordenExistente.setFolioFiscalcp(orden.getFolioFiscalcp());

            CartasPorteModel ordenActualizado = cartasPorteRepository.save(ordenExistente);
            return ResponseEntity.ok(ordenActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updatestatusfalse/{id}")
    public ResponseEntity<CartasPorteModel> actualizarCartasPorteFalse(@PathVariable Integer id){
        CartasPorteModel cpExistente = cartasPorteRepository.findByCartaPorteID(id);
        if(cpExistente != null){
            cpExistente.setStatus( 0);
            CartasPorteModel ordenActualizado = cartasPorteRepository.save(cpExistente);
            return ResponseEntity.ok(ordenActualizado);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
