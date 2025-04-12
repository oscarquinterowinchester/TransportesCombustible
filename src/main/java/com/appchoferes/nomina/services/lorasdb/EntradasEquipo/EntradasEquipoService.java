package com.appchoferes.nomina.services.lorasdb.EntradasEquipo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.models.lorasdb.dtos.EntradasEquipo.EquipoEntradaResponse;
import com.appchoferes.nomina.models.lorasdb.dtos.EntradasEquipo.EquipoInfoDto;
import com.appchoferes.nomina.models.lorasdb.dtos.EntradasEquipo.InspeccionEntradaDto;
import com.appchoferes.nomina.repositories.lorasdb.EntradasEquipo.EquipoEntradaRepository;

@Service
public class EntradasEquipoService {

   @Autowired
   private EquipoEntradaRepository equipoEntradaRepository;

   public EquipoEntradaResponse getContenedorEntrada(Long itinerarioId, Integer patioId) {
      LocalDate fecha = LocalDate.of(2020, 1, 1);
      EquipoEntradaResponse response = new EquipoEntradaResponse();
      response.setMensaje("");
      response.setEstatus(20);

      // Obtener la informacion del equipo que se busca la entrada
      List<Object[]> equipoRaw = equipoEntradaRepository.getInfoEntradaEquipo(itinerarioId, patioId, fecha);

      if (equipoRaw != null && !equipoRaw.isEmpty()) {
         // Mapear el primer resultado al DTO
         EquipoInfoDto equipoInfo = mapToEquipoInfoDto(equipoRaw.get(0));

         // Si el estado del equipo es 2, marcar como "Botando"
         if (equipoInfo.getEstado() == 2) {
            equipoInfo.setEl("Botando");
            equipoInfo.setBotando(true);
            equipoInfo.setContenedor("BOTANDO - " + equipoInfo.getUnidad());
         } else {
            equipoInfo.setEl(equipoInfo.getEstado() == 1 ? "Cargado" : "Vacio");
         }

         // Si el destino del equipo es el patio donde se encuentra
         if (equipoInfo.getDestino().equals(patioId)) {
            // Obtener la informacion de check entrada
            List<Object[]> checkEntradaRaw = equipoEntradaRepository.getCheckEntrada(equipoInfo.getCamionId(), patioId);
            List<EquipoInfoDto> checkEntrada = convertToEquipoInfoDto(checkEntradaRaw); // Mapeamos la respuesta

            if (!checkEntrada.isEmpty()) {
               EquipoInfoDto check = checkEntrada.get(0);
               if (check.getAnterior() > 0) {
                  response.setEstatus(20);
                  response.setMensaje("Driver move encontrado");
                  response.setInfo(equipoInfo);

                    // Obtener las inspecciones y mapearlas
                    List<Object[]> inspeccionesRaw = equipoEntradaRepository.getInspeccionEntrada(itinerarioId);
                    List<InspeccionEntradaDto> inspecciones = convertToInspeccionEntradaDto(inspeccionesRaw);

                  response.setInspeccion(inspecciones);
               } else {
                  response.setEstatus(15);
                  response.setMensaje("Este camion se encuentra en este patio actualmente");
               }
            } else {
               response.setEstatus(20);
               response.setMensaje("Driver move encontrado");
               response.setInfo(equipoInfo);

                    // Obtener las inspecciones y mapearlas
                    List<Object[]> inspeccionesRaw = equipoEntradaRepository.getInspeccionEntrada(itinerarioId);
                    List<InspeccionEntradaDto> inspecciones = convertToInspeccionEntradaDto(inspeccionesRaw);

               response.setInspeccion(inspecciones);
            }
         } else {
            response.setEstatus(10);
            response.setMensaje("El destino del viaje no es al patio donde se encuentra");
         }
      } else {
         response.setEstatus(5);
         response.setMensaje("No se encontró el driver move buscado");
      }

      return response;
   }

   public List<EquipoInfoDto> convertToEquipoInfoDto(List<Object[]> rows) {
      List<EquipoInfoDto> result = new ArrayList<>();

      for (Object[] row : rows) {
         EquipoInfoDto dto = new EquipoInfoDto();

         // Asignar los tres campos que vienen de la consulta
         dto.setInventarioID(castToInt(row[0])); // InventarioID
         dto.setAnterior(castToInt(row[1])); // Anterior
         dto.setCamion((String) row[2]); // Camion

         // Asignar valores por defecto o nulos para los otros campos
         dto.setItinerarioID(null);
         dto.setWContenedorId(null);
         dto.setPatioId(null);
         dto.setChoferID(null);
         dto.setBotando(null);
         dto.setClienteID(null);
         dto.setCarga(null);
         dto.setUnidad(null);
         dto.setPlacasChasis(null);
         dto.setContenedor(null);
         dto.setNombreChofer(null);
         dto.setOrigen(null);
         dto.setSelloDiesel(null);
         dto.setSello(null);
         dto.setFirmaChofer(null);
         dto.setFirmaGuardia(null);
         dto.setEstado(null);
         dto.setEl(null);
         dto.setDestino(null);

         result.add(dto);
      }
      return result;
   }

   public EquipoInfoDto mapToEquipoInfoDto(Object[] row) {
      EquipoInfoDto dto = new EquipoInfoDto();

      dto.setItinerarioID(castToInt(row[0]));
      dto.setWContenedorId(castToInt(row[1]));
      dto.setCamionId(castToInt(row[2]));
      dto.setPatioId(castToInt(row[3]));
      dto.setChoferID(castToInt(row[4]));
      dto.setBotando(castToBoolean(row[5]));
      dto.setClienteID(castToInt(row[6]));
      dto.setCarga(row[7] != null ? row[7].toString() : null);
      dto.setUnidad(row[8] != null ? row[8].toString() : null);
      dto.setPlacasChasis(row[9] != null ? row[9].toString() : null);
      dto.setContenedor(row[10] != null ? row[10].toString() : null);
      dto.setNombreChofer(row[11] != null ? row[11].toString() : null);
      dto.setOrigen(row[12] != null ? row[12].toString() : null);
      dto.setSelloDiesel(castToBoolean(row[13]));
      dto.setSello(row[14] != null ? row[14].toString() : null);
      dto.setFirmaChofer(row[15] != null ? row[15].toString() : null);
      dto.setFirmaGuardia(row[16] != null ? row[16].toString() : null);
      dto.setEstado(castToInt(row[17]));
      dto.setEl(row[18] != null ? row[18].toString() : null);
      dto.setDestino(castToInt(row[19]));
      dto.setAnterior(null); // El campo "anterior" no viene del SP, puedes omitir o setear después
      dto.setInventarioID(null); // El campo "inventarioId" no viene del SP, puedes omitir o setear después
      dto.setCamion(null); // El campo "camion" no viene del SP, puedes omitir o setear después

      return dto;
   }

   // Funciones auxiliares para castear evitando errores
   private Integer castToInt(Object obj) {
      return obj != null ? Integer.valueOf(obj.toString()) : null;
   }

   private Boolean castToBoolean(Object obj) {
      if (obj == null)
         return null;
      if (obj instanceof Boolean)
         return (Boolean) obj;
      if (obj instanceof Number)
         return ((Number) obj).intValue() != 0;
      return Boolean.valueOf(obj.toString());
   }

   public List<InspeccionEntradaDto> convertToInspeccionEntradaDto(List<Object[]> rows) {
      List<InspeccionEntradaDto> result = new ArrayList<>();

      for (Object[] row : rows) {
         InspeccionEntradaDto dto = new InspeccionEntradaDto();

         // Mapear las columnas de la consulta a los campos del DTO
         dto.setId(castToInt(row[0])); // InspeccionID
         dto.setListadoId(castToInt(row[1])); // ListadoID
         dto.setItinerarioId(castToInt(row[2])); // ItinerarioID
         dto.setConcepto((String) row[3]); // Concepto
         dto.setBien2(row[4] != null && Boolean.TRUE.equals(row[4]) ? 1 : 0); // Bien2

         result.add(dto);
      }
      return result;
   }

}
