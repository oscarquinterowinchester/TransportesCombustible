package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.durandb.ChoferesModel;
import com.appchoferes.nomina.repositories.durandb.ChoferesRepository;
import com.appchoferes.nomina.services.durandb.ChoferesService;

@RestController
@RequestMapping("/choferes")
public class ChoferesController {
    @Autowired
    ChoferesService choferesService;

    @Autowired
    ChoferesRepository choferesRepository;

    @GetMapping()
    public ArrayList<ChoferesModel> obtenerChoferes() {
        return choferesService.obtenerChoferes();
    }

    @GetMapping("/status")
    public ArrayList<ChoferesModel> obtenerChoferByStatus(
            @RequestParam(value = "status", defaultValue = "1") int Status) {
        return choferesRepository.findByStatus(Status);
    }

    @PostMapping()
    public ChoferesModel registrarChofer(@RequestBody ChoferesModel nuevoChofer) {
        return choferesService.registrarChofer(nuevoChofer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteChofer(@PathVariable Integer id) {
        Optional<ChoferesModel> chofer = choferesRepository.findById(id);

        if (chofer.isPresent()) {
            choferesRepository.deleteById(id);
            return ResponseEntity.ok(Map.of("message", "Chofer, eliminado correctamente"));
        } else {
            return ResponseEntity.notFound().build(); // El chofer no se encontró
        }
    }

    @PutMapping("borrar/{id}")
    public ResponseEntity<ChoferesModel> actualizarChoferesStatus(@PathVariable Integer id,
            @RequestBody ChoferesModel orden) {
        Optional<ChoferesModel> ordenExistenteOpt = choferesRepository.findById(id);

        if (ordenExistenteOpt.isPresent()) {
            ChoferesModel ordenExistente = ordenExistenteOpt.get();

            ordenExistente.setStatus(orden.getStatus());

            ChoferesModel choferActualizado = choferesRepository.save(ordenExistente);

            return ResponseEntity.ok(choferActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChoferesModel> actualizarChofer(@PathVariable Integer id, @RequestBody ChoferesModel chofer) {
        Optional<ChoferesModel> choferExistenteOpt = choferesRepository.findById(id);

        if (choferExistenteOpt.isPresent()) {
            ChoferesModel choferExistente = choferExistenteOpt.get();

            choferExistente.setNombre(chofer.getNombre());
            choferExistente.setDireccion(chofer.getDireccion());
            choferExistente.setTelefono(chofer.getTelefono());
            choferExistente.setCelular(chofer.getCelular());
            choferExistente.setNextel(chofer.getNextel());
            choferExistente.setNacimiento(chofer.getNacimiento());
            choferExistente.setIngreso(chofer.getIngreso());
            choferExistente.setCURP(chofer.getCURP());
            choferExistente.setLicencia(chofer.getLicencia());
            choferExistente.setTipoLicencia(chofer.getTipoLicencia());
            choferExistente.setExpLicencia(chofer.getExpLicencia());
            choferExistente.setEscolaridad(chofer.getEscolaridad());
            choferExistente.setSS(chofer.getSS());
            choferExistente.setContrato(chofer.getContrato());
            choferExistente.setFoto(chofer.getFoto());
            choferExistente.setPuesto(chofer.getPuesto());
            choferExistente.setInfonavit(chofer.getInfonavit());
            choferExistente.setRFC(chofer.getRFC());
            choferExistente.setVisa(chofer.getVisa());
            choferExistente.setFast(chofer.getFast());
            choferExistente.setCamionID(chofer.getCamionID());
            choferExistente.setEstadoLicencia(chofer.getEstadoLicencia());
            choferExistente.setTipoChofer(chofer.getTipoChofer());
            choferExistente.setGafete(chofer.getGafete());
            choferExistente.setCorreo(chofer.getCorreo());
            choferExistente.setTipoPermiso(chofer.getTipoPermiso());
            choferExistente.setVencimientoVisa(chofer.getVencimientoVisa());
            choferExistente.setVencimientoFast(chofer.getVencimientoFast());
            choferExistente.setUsuario(chofer.getUsuario());
            choferExistente.setContra(chofer.getContra());
            choferExistente.setNoEmpleado(chofer.getNoEmpleado());
            choferExistente.setNotres(chofer.getNotres());
            choferExistente.setTurnoID(chofer.getTurnoID());
            choferExistente.setCuenta(chofer.getCuenta());
            choferExistente.setNoTarjeta(chofer.getNoTarjeta());
            choferExistente.setTipoOperador(chofer.getTipoOperador());
            choferExistente.setDetener(chofer.getDetener());
            choferExistente.setNoContrato(chofer.getNoContrato());
            choferExistente.setLentes(chofer.getLentes());
            choferExistente.setTipoSangre(chofer.getTipoSangre());
            choferExistente.setNotaMedica(chofer.getNotaMedica());
            choferExistente.setAntidoping(chofer.getAntidoping());
            choferExistente.setNoPenales(chofer.getNoPenales());
            choferExistente.setDollyID(chofer.getDollyID());
            choferExistente.setClaveHisense(chofer.getClaveHisense());
            choferExistente.setExterno(chofer.getExterno());
            choferExistente.setNoTractor(chofer.getNoTractor());
            choferExistente.setPlacasTractor(chofer.getPlacasTractor());
            choferExistente.setChoferUSA(chofer.getChoferUSA());
            choferExistente.setCuadrarNomina(chofer.getCuadrarNomina());
            choferExistente.setVGIdentificacion(chofer.getVGIdentificacion());
            choferExistente.setVGNoInfraccion(chofer.getVGNoInfraccion());
            choferExistente.setVGConsultaLicencia(chofer.getVGConsultaLicencia());
            choferExistente.setVGComprobanteDom(chofer.getVGComprobanteDom());
            choferExistente.setVGGafeteEmpresa(chofer.getVGGafeteEmpresa());
            choferExistente.setVGGafeteMexicano(chofer.getVGGafeteMexicano());
            choferExistente.setVGGafeteAmericano(chofer.getVGGafeteAmericano());
            choferExistente.setVGTarjetaTWIC(chofer.getVGTarjetaTWIC());
            choferExistente.setVGRecordDMV(chofer.getVGRecordDMV());
            choferExistente.setVGPullNotice(chofer.getVGPullNotice());
            choferExistente.setVGExamenMedico(chofer.getVGExamenMedico());
            choferExistente.setVGContrato(chofer.getVGContrato());
            choferExistente.setVGApoyoCTPAT(chofer.getVGApoyoCTPAT());
            choferExistente.setVGAnnualReviewDriving(chofer.getVGAnnualReviewDriving());
            choferExistente.setVGDriversCertificationViolations(chofer.getVGDriversCertificationViolations());
            choferExistente.setVGVisitaDomiciliaria(chofer.getVGVisitaDomiciliaria());
            choferExistente.setVGConstancia(chofer.getVGConstancia());
            choferExistente.setUsuarioID(chofer.getUsuarioID());
            choferExistente.setBaseDM(chofer.getBaseDM());
            choferExistente.setGafeteAm(chofer.getGafeteAm());
            choferExistente.setUNegocioID(chofer.getUNegocioID());
            choferExistente.setPuestos(chofer.getPuestos());
            choferExistente.setUsuarioMod(chofer.getUsuarioMod());
            choferExistente.setFechaMod(chofer.getFechaMod());
            choferExistente.setNoExterior(chofer.getNoExterior());
            choferExistente.setEstado(chofer.getEstado());
            choferExistente.setEstadoID(chofer.getEstadoID());
            choferExistente.setPais(chofer.getPais());
            choferExistente.setPaisID(chofer.getPaisID());
            choferExistente.setCP(chofer.getCP());
            choferExistente.setMunicipio(chofer.getMunicipio());
            choferExistente.setCestado(chofer.getCestado());
            choferExistente.setClocalidad(chofer.getClocalidad());
            choferExistente.setClocalidadid(chofer.getClocalidadid());
            choferExistente.setCmunicipio(chofer.getCmunicipio());
            choferExistente.setCmunicipioid(chofer.getCmunicipioid());
            choferExistente.setCcolonia(chofer.getCcolonia());
            choferExistente.setCcoloniaid(chofer.getCcoloniaid());
            choferExistente.setDepartamentoID(chofer.getDepartamentoID());
            choferExistente.setEmpresaID(chofer.getEmpresaID());
            choferExistente.setPerfilrfk(chofer.getPerfilrfk());
            choferExistente.setDriverType(chofer.getDriverType());

            // Guarda los cambios en la base de datos
            ChoferesModel choferActualizado = choferesRepository.save(choferExistente);

            return ResponseEntity.ok(choferActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
