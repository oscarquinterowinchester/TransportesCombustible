package com.appchoferes.nomina.controllers.durandb;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.appchoferes.nomina.models.durandb.ClientesModel;
import com.appchoferes.nomina.repositories.durandb.ClientesRepository;
import com.appchoferes.nomina.services.durandb.ClientesService;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    ClientesService clientesService;

    @Autowired
    ClientesRepository clientesRepository;

    @GetMapping()
    public ArrayList<ClientesModel> obtenerClientes() {
        return clientesService.obtenerClientes();
    }

    @GetMapping("/status")
    public ArrayList<ClientesModel> obtenerClientesByStatus(
            @RequestParam(value = "status", defaultValue = "1") int Status) {
        return clientesRepository.findByStatus(Status);
    }

    @GetMapping("/{id}")
    public ClientesModel obtenerClientes(@PathVariable int id) {
        Optional<ClientesModel> entidad = clientesService.findById(id);
        if (entidad.isPresent()) {
            return entidad.get();
        } else {
            return null;
        }
    }

    @PostMapping()
    public ClientesModel registrarCliente(@RequestBody ClientesModel nuevoCliente) {
        return clientesService.registrarCliente(nuevoCliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteCliente(@PathVariable Integer id) {
        Optional<ClientesModel> cliente = clientesRepository.findById(id);

        if (cliente.isPresent()) {
            clientesRepository.deleteById(id);
            return ResponseEntity.ok(Map.of("message", "Cliente, eliminado correctamente"));
        } else {
            return ResponseEntity.notFound().build(); // El cliente no se encontró
        }
    }

    @PutMapping("borrar/{id}")
    public ResponseEntity<ClientesModel> actualizarClientesStatus(@PathVariable Integer id,
            @RequestBody ClientesModel orden) {
        Optional<ClientesModel> ordenExistenteOpt = clientesRepository.findById(id);

        if (ordenExistenteOpt.isPresent()) {
            ClientesModel ordenExistente = ordenExistenteOpt.get();

            ordenExistente.setStatus(orden.getStatus());

            ClientesModel clientesActualizado = clientesRepository.save(ordenExistente);

            return ResponseEntity.ok(clientesActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientesModel> actualizarCliente(@PathVariable Integer id,
            @RequestBody ClientesModel cliente) {
        Optional<ClientesModel> clienteExistenteOpt = clientesRepository.findById(id);

        if (clienteExistenteOpt.isPresent()) {
            ClientesModel clienteExistente = clienteExistenteOpt.get();

            clienteExistente.setUsuarioID(cliente.getUsuarioID());
            clienteExistente.setCodigoC(cliente.getCodigoC());
            clienteExistente.setNComercial(cliente.getNComercial());
            clienteExistente.setNombreComercial(cliente.getNombreComercial());
            clienteExistente.setRFC(cliente.getRFC());
            clienteExistente.setCP(cliente.getCP());
            clienteExistente.setMesesCTPAT(cliente.getMesesCTPAT());
            clienteExistente.setTelefono(cliente.getTelefono());
            clienteExistente.setEstado(cliente.getEstado());
            clienteExistente.setPais(cliente.getPais());
            clienteExistente.setCorreo(cliente.getCorreo());
            clienteExistente.setDiasCredito(cliente.getDiasCredito());
            clienteExistente.setLimiteCredito(cliente.getLimiteCredito());
            clienteExistente.setMoneda(cliente.getMoneda());
            clienteExistente.setFecha(cliente.getFecha());
            clienteExistente.setContacto(cliente.getContacto());
            clienteExistente.setFolioContpaq(cliente.getFolioContpaq());
            clienteExistente.setNombreComun(cliente.getNombreComun());
            clienteExistente.setTipoCliente(cliente.getTipoCliente());
            clienteExistente.setCTPAT(cliente.getCTPAT());
            clienteExistente.setBanco(cliente.getBanco());
            clienteExistente.setNoCuenta(cliente.getNoCuenta());
            clienteExistente.setCuentaID(cliente.getCuentaID());
            clienteExistente.setCPF(cliente.getCPF());
            clienteExistente.setEstadoF(cliente.getEstadoF());
            clienteExistente.setPaisF(cliente.getPaisF());
            clienteExistente.setContactoF(cliente.getContactoF());
            clienteExistente.setContactoF1(cliente.getContactoF1());
            clienteExistente.setTelefonoF(cliente.getTelefonoF());
            clienteExistente.setTelefonoF1(cliente.getTelefonoF1());
            clienteExistente.setCorreoF(cliente.getCorreoF());
            clienteExistente.setCorreoF1(cliente.getCorreoF1());
            clienteExistente.setContactoT(cliente.getContactoT());
            clienteExistente.setContactoT1(cliente.getContactoT1());
            clienteExistente.setContactoT2(cliente.getContactoT2());
            clienteExistente.setTelefonoT(cliente.getTelefonoT());
            clienteExistente.setTelefonoT1(cliente.getTelefonoT1());
            clienteExistente.setTelefonoT2(cliente.getTelefonoT2());
            clienteExistente.setCorreoT(cliente.getCorreoT());
            clienteExistente.setCorreoT1(cliente.getCorreoT1());
            clienteExistente.setCorreoT2(cliente.getCorreoT2());
            clienteExistente.setBeneficiario(cliente.getBeneficiario());
            clienteExistente.setClaveInter(cliente.getClaveInter());
            clienteExistente.setSwift(cliente.getSwift());
            clienteExistente.setDiasRFD(cliente.getDiasRFD());
            clienteExistente.setTipoDiasRFD(cliente.getTipoDiasRFD());
            clienteExistente.setDiasCFD(cliente.getDiasCFD());
            clienteExistente.setTipoDiasCFD(cliente.getTipoDiasCFD());
            clienteExistente.setRFCBanco(cliente.getRFCBanco());
            clienteExistente.setDireccion(cliente.getDireccion());
            clienteExistente.setDireccionF(cliente.getDireccionF());
            clienteExistente.setDiasSinFactura(cliente.getDiasSinFactura());
            clienteExistente.setTotalContenedoresVencidos(cliente.getTotalContenedoresVencidos());
            clienteExistente.setContenedoresPorDia(cliente.getContenedoresPorDia());
            clienteExistente.setContenedoresFacturadosDiarios(cliente.getContenedoresFacturadosDiarios());
            clienteExistente.setContenedoresNoFacturadosDiarios(cliente.getContenedoresNoFacturadosDiarios());
            clienteExistente.setTipoFac(cliente.getTipoFac());
            clienteExistente.setUNegocioID(cliente.getUNegocioID());
            clienteExistente.setCorreoHoras(cliente.getCorreoHoras());
            clienteExistente.setCorreoEnviar(cliente.getCorreoEnviar());
            clienteExistente.setCorreoInventario(cliente.getCorreoInventario());
            clienteExistente.setCiudadF(cliente.getCiudadF());
            clienteExistente.setCiudad(cliente.getCiudad());
            clienteExistente.setCTPATID(cliente.getCTPATID());
            clienteExistente.setInfoPendiente(cliente.getInfoPendiente());
            clienteExistente.setStatus(cliente.getStatus());
            clienteExistente.setImportacion(cliente.getImportacion());
            clienteExistente.setExportacion(cliente.getExportacion());
            clienteExistente.setOEA(cliente.getOEA());
            clienteExistente.setAutoBill(cliente.getAutoBill());
            clienteExistente.setInactivo(cliente.getInactivo());
            clienteExistente.setComentarioInactivo(cliente.getComentarioInactivo());
            clienteExistente.setNombreQB(cliente.getNombreQB());
            clienteExistente.setCorreoClient(cliente.getCorreoClient());
            clienteExistente.setCorreoEProvider(cliente.getCorreoEProvider());
            clienteExistente.setUsuarioMod(cliente.getUsuarioMod());
            clienteExistente.setFechaMod(cliente.getFechaMod());
            clienteExistente.setMostrarExternos(cliente.getMostrarExternos());
            clienteExistente.setEquipmentprovider(cliente.getEquipmentprovider());
            clienteExistente.setEmptyx(cliente.getEmptyx());
            clienteExistente.setLoadx(cliente.getLoadx());
            clienteExistente.setUsuario(cliente.getUsuario());
            clienteExistente.setClave(cliente.getClave());
            clienteExistente.setNombrewsMerca(cliente.getNombrewsMerca());
            clienteExistente.setRegimenFiscal(cliente.getRegimenFiscal());
            clienteExistente.setRegimenCapital(cliente.getRegimenCapital());
            clienteExistente.setVersiontimbre(cliente.getVersiontimbre());
            clienteExistente.setComentario(cliente.getComentario());
            clienteExistente.setRazonSocial(cliente.getRazonSocial());
            clienteExistente.setVersionCCP(cliente.getVersionCCP());
            clienteExistente.setUsoCFDIc(cliente.getUsoCFDIc());
            clienteExistente.setFormaPagoc(cliente.getFormaPagoc());
            clienteExistente.setNotaFacturac(cliente.getNotaFacturac());
            clienteExistente.setMetodoPagoc(cliente.getMetodoPagoc());
            // Guarda los cambios en la base de datos
            ClientesModel clienteActualizado = clientesRepository.save(clienteExistente);

            return ResponseEntity.ok(clienteActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
