package com.appchoferes.nomina.models.lorasdb.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContenedorPatios {
    private Integer InventarioID;
    private Integer ItinerarioID;
    private Integer AnteriorID;
    private String WContenedorID;
    private String Contenedor;
    private String PlacasChasis;
    private String Sello;
    private String SelloDiesel;
    private Integer PaisID;
    private Integer EstadoID;
    private Integer ChoferID;
    private Integer ClienteID;
    private Integer UsuarioID;
    private Integer RutaID;
    private String NombreChofer;
    private String EmpresaChofer;
    private Integer UsuarioEventoID;
    private String Nota;
    private Integer EstadoCarga;
    private Integer TipoEvento;
    private String FechaEvento;
    private String Fecha;
    private Integer PatioID;
    private Integer Tamano;
    private Integer Status;
    private Integer UsuarioEliminaID;
    private String FechaElimina;
    private String Camion;
    private String EquipmentProvider;
    private String EquipmentProviderExt;
    private String Firmak9;
    private Integer Botando;
    private String Origen;
    private Integer CamionID;
    private String Destino;
    private String PlacasUnidad;
    private String NumeroChasis;
    private String Carrier;
    private String Grade;
    private String AssignedTo;
    private String FechaEdicion;
    private Integer IsCamion;
    private Integer PerfilCobroID;
    private Integer IsVirtual;
    private String PlacasChasisUSA;
    private Integer EstadoUSAID;
    private String PlacasUnidadUSA;
    private String EstadoPlacasMex;
    private String EstadoPlacasUsa;
    private String RemolqueEstado;
    private String RemolquePais;
    private Integer SoloChasis;
    private Integer CreacionUsuarioEventoID;
    private String Licencia;
    private Integer CajaID;
    private String Chasis;
    private Integer IsFull;
    private Integer FullItinerarioBase;
    private String SelloComplementario;
    private String FotoSello;
    private String FirmaGuardia;
    private String FirmaChofer;
    private Integer Facturado;
    private String TotalRenta;
    private String Estado;
    private String Pais;
    private String Carga;
    private String Cliente;
    private String OrigenData;
    private String EstadoData;
    private Integer Dias;
    private Integer Flag;

    // Constructor solo con los campos para getContenedorPatio
    public ContenedorPatios(Integer inventarioID, Integer itinerarioID, String wContenedorID, String contenedor,
            String placasChasis, String sello, Integer paisID, Integer clienteID, Integer estadoCarga,
            Integer tipoEvento, String fechaEvento, String camion, String origen,
            String destino, String carrier) {
        this.InventarioID = inventarioID; // Mapea con inv.InventarioID
        this.ItinerarioID = itinerarioID; // Mapea con inv.ItinerarioID
        this.WContenedorID = wContenedorID; // Mapea con w.WContenedorID
        this.Contenedor = contenedor; // Mapea con inv.Contenedor
        this.PlacasChasis = placasChasis; // Mapea con inv.PlacasChasis
        this.Sello = sello; // Mapea con inv.Sello
        this.PaisID = paisID; // Mapea con inv.PaisID
        this.ClienteID = clienteID; // Mapea con inv.ClienteID
        this.EstadoCarga = estadoCarga; // Mapea con inv.EstadoCarga
        this.TipoEvento = tipoEvento; // Mapea con `1 AS TipoEvento`
        this.FechaEvento = fechaEvento; // Mapea con `NOW() AS FechaEvento`
        this.Camion = camion; // Mapea con cam.NoEconomico AS Camion
        this.Origen = origen; // Mapea con ru.Origen
        this.Destino = destino; // Mapea con ru.Destino
        this.Carrier = carrier; // Mapea con IF(inv.CamionID > 0, 'MX', '') AS Carrier
    }

}
