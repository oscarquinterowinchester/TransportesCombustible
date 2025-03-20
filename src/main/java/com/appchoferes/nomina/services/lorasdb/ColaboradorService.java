package com.appchoferes.nomina.services.lorasdb;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.RegistroEntradaSalida;
import com.appchoferes.nomina.models.lorasdb.dtos.ColaboradorDTO;
import com.appchoferes.nomina.repositories.lorasdb.ColaboradorRepository;
import com.appchoferes.nomina.repositories.lorasdb.RegistroEntradaSalidaRepository;

@Service
public class ColaboradorService {

   @Autowired
   private ColaboradorRepository colaboradorRepository;

   @Autowired
   private RegistroEntradaSalidaRepository registroRepository;

   public void actualizarSalida(int idRegistro, String fechaSalida) {
      // Buscar el registro por ID y actualizar la fecha de salida
      RegistroEntradaSalida registro = registroRepository.findById(idRegistro)
            .orElseThrow(() -> new RuntimeException("Registro no encontrado"));
      registro.setFechaSalida(fechaSalida);
      registroRepository.save(registro);
   }

   public void registrarEntrada(Map<String, Object> entrada) {
      // Crear un nuevo registro de entrada
      RegistroEntradaSalida nuevoRegistro = new RegistroEntradaSalida();
      nuevoRegistro.setChoferID((int) entrada.get("ChoferID"));
      nuevoRegistro.setFirma((String) entrada.get("Firma"));
      nuevoRegistro.setFechaEntrada((String) entrada.get("FechaEntrada"));
      nuevoRegistro.setFecha((String) entrada.get("Fecha"));

      registroRepository.save(nuevoRegistro);
   }

   public Optional<ColaboradorDTO> getColaborador(String palabra) {
      String date = LocalDate.now().toString(); // Obtener la fecha actual en formato YYYY-MM-DD
      List<Object[]> resultados = colaboradorRepository.findColaborador(palabra, date);

      if (resultados.isEmpty()) {
         return Optional.empty();
      }

      // Mapear el primer resultado al DTO
      Object[] resultado = resultados.get(0);
      ColaboradorDTO colaboradorDTO = new ColaboradorDTO();
      colaboradorDTO.setId(((Number) resultado[0]).longValue());
      colaboradorDTO.setNombre((String) resultado[1]);
      colaboradorDTO.setNoEmpleado((String) resultado[2]);

      // Convertir java.sql.Timestamp a java.time.LocalDateTime
      Timestamp timestamp = (Timestamp) resultado[3];
      colaboradorDTO.setAhorita(timestamp.toLocalDateTime());

      colaboradorDTO.setTelefono((String) resultado[4]);
      colaboradorDTO.setEntrada((Long) resultado[5]);
      colaboradorDTO.setArea((String) resultado[6]);
      colaboradorDTO.setPuesto((String) resultado[7]);

      return Optional.of(colaboradorDTO);
   }
}