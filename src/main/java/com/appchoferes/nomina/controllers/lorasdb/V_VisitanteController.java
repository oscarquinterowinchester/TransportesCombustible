package com.appchoferes.nomina.controllers.lorasdb;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.VisitorGafete;
import com.appchoferes.nomina.models.lorasdb.dtos.BusquedaVisitanteDTO;
import com.appchoferes.nomina.models.lorasdb.dtos.EmpresaDTO;
import com.appchoferes.nomina.models.lorasdb.dtos.RegistroVisitaDTO;
import com.appchoferes.nomina.models.lorasdb.dtos.TipoVisitante2DTO;
import com.appchoferes.nomina.models.lorasdb.dtos.VisitanteVehiculoRequest;
import com.appchoferes.nomina.models.lorasdb.dtos.VisitorRequest;
import com.appchoferes.nomina.services.lorasdb.PV_RawQueryService;
import com.appchoferes.nomina.services.lorasdb.VisitorRegistroService;

@RestController
@RequestMapping("/visitantes")
public class V_VisitanteController {

    @Autowired
    private PV_RawQueryService rawQueryService;

    @Autowired
    private VisitorRegistroService visitorService;

    @GetMapping("/getBusquedaVisitantes")
    public ResponseEntity<List<BusquedaVisitanteDTO>> buscarVisitantes(
            @RequestParam(required = false) String word) {
        return ResponseEntity.ok(rawQueryService.buscarVisitantes(word));
    }

    @GetMapping("/getTipoVisitantes2")
    public ResponseEntity<List<TipoVisitante2DTO>> getTipoVisitantes2(
            @RequestParam(required = false) List<Integer> ids) {
        return ResponseEntity.ok(rawQueryService.getTipoVisitantes2(ids));
    }

    @GetMapping("/getGafetesDisponibles")
    public ResponseEntity<List<VisitorGafete>> getGafetesDisponibles(@RequestParam(required = false) Integer tipo) {
        return ResponseEntity.ok(rawQueryService.getGafetesDisponibles(tipo));
    }

    @PostMapping("/saveVisita")
    public ResponseEntity<Void> saveVisit(@RequestBody VisitorRequest request) {
        visitorService.saveVisit(request.getEmpleado(), request.getVisitantes(), request.getVehiculo());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getEmpresas")
    public ResponseEntity<List<EmpresaDTO>> getEmpresas() {
        return ResponseEntity.ok(rawQueryService.getEmpresas());
    }

    // guardar el visitante y el vehiculo
    @PostMapping("/saveVisitante")
    public ResponseEntity<Long> saveVisitanteAndVehiculo(@RequestBody VisitanteVehiculoRequest request) {
        try {
            Long idVisitante = visitorService.saveVisitanteAndVehiculo(request);
            return ResponseEntity.ok(idVisitante);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    // obtener la imagen asociada al visitante
    @GetMapping("/getImg/{id}")
    public ResponseEntity<byte[]> getImg(@PathVariable Long id) {
        try {
            byte[] image = visitorService.getImage(id, "foto"); // Cambia "foto" por el tipo necesario
            return ResponseEntity.ok().body(image);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // guardar registro de salida del visitante
    @GetMapping("/completeRegistro")
    public ResponseEntity<Boolean> completeRegistro(@RequestParam Map<String, String> params) {
        RegistroVisitaDTO registroDTO = new RegistroVisitaDTO();
        registroDTO.setId(Long.parseLong(params.get("id")));
        registroDTO.setSalida(params.get("salida"));
        registroDTO.setDuracion(params.get("duracion"));
        registroDTO.setVisitor(Long.parseLong(params.get("visitor")));
        registroDTO.setGafete(Long.parseLong(params.get("gafete")));

        rawQueryService.completeRegistro(registroDTO);
        return ResponseEntity.ok(true);
    }

}