package com.appchoferes.nomina.controllers.lorasdb;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.lorasdb.dtos.ColaboradorDTO;
import com.appchoferes.nomina.services.lorasdb.ColaboradorService;

@RestController
@RequestMapping("/visitantes")
public class ColaboradorController {

   @Autowired
   private ColaboradorService colaboradorService;

   @PostMapping("/registarEntradaSalida")
    public ResponseEntity<?> registrarEntradaSalida(@RequestBody Map<String, Object> request) {
        // Extraer los datos del empleado del request
        Map<String, Object> params = (Map<String, Object>) request.get("params");

        int id = (int) params.get("id");
        String nombre = (String) params.get("nombre");
        String noEmpleado = (String) params.get("noEmpleado");
        String ahorita = (String) params.get("ahorita");
        String area = (String) params.get("area");
        int entrada = (int) params.get("entrada");
        String firma = (String) params.get("firma");

        // Lógica para registrar entrada o salida
        if (entrada > 0) {
            // Actualizar la salida
            colaboradorService.actualizarSalida(entrada, ahorita);
        } else {
            // Registrar una nueva entrada
            Map<String, Object> nuevaEntrada = new HashMap<>();
            nuevaEntrada.put("ChoferID", id);
            nuevaEntrada.put("Firma", firma);
            nuevaEntrada.put("FechaEntrada", ahorita);
            nuevaEntrada.put("Fecha", ahorita);

            colaboradorService.registrarEntrada(nuevaEntrada);
        }

        // Respuesta exitosa
        return ResponseEntity.ok().body(Map.of("success", true));
    }

   @GetMapping("/getColaborador")
   public ResponseEntity<ColaboradorDTO> getColaborador(@RequestParam String palabra) {
      Optional<ColaboradorDTO> colaborador = colaboradorService.getColaborador(palabra);

      // Retornar el DTO si existe, de lo contrario, retornar 404 Not Found
      return colaborador.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
   }
}