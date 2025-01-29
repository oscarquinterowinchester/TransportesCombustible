package com.appchoferes.nomina.models.lorasdb.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContenedorPatios {
    private int InventarioID;
    private int ItinerarioID;
    private int AnteriorID;
    private int WContenedorID;
    private String Contenedor;
    private String PlacasChasis;
    private String Sello;
    private String SelloDiesel;
    private int PaisID;
    private int EstadoID;
    private int ChoferID;
    private int ClienteID;
    private int UsuarioID;
    private Integer RutaID;
    private String NombreChofer;
    private String EmpresaChofer;
    private int UsuarioEventoID;
    private String Nota;
    private int EstadoCarga;
    private int TipoEvento;
    private String FechaEvento;
    private String Fecha;
    private int PatioID;
    private int Tamano;
    private int Status;
    private Integer UsuarioEliminaID;
    private String FechaElimina;
    private String Camion;
    private String EquipmentProvider;
    private String EquipmentProviderExt;
    private String Firmak9;
    private int Botando;
    private String Origen;
    private int CamionID;
    private String Destino;
    private String PlacasUnidad;
    private String NumeroChasis;
    private String Carrier;
    private String Grade;
    private String AssignedTo;
    private String FechaEdicion;
    private int IsCamion;
    private int PerfilCobroID;
    private int IsVirtual;
    private String PlacasChasisUSA;
    private Integer EstadoUSAID;
    private String PlacasUnidadUSA;
    private String EstadoPlacasMex;
    private String EstadoPlacasUsa;
    private String RemolqueEstado;
    private String RemolquePais;
    private int SoloChasis;
    private int CreacionUsuarioEventoID;
    private String Licencia;
    private Integer CajaID;
    private String Chasis;
    private int IsFull;
    private int FullItinerarioBase;
    private String SelloComplementario;
    private String FotoSello;
    private String FirmaGuardia;
    private String FirmaChofer;
    private int Facturado;
    private String TotalRenta;
    private String Estado;
    private String Pais;
    private String Carga;
    private String Cliente;
    private String OrigenData;
    private String EstadoData;
    private int Dias;
    private Integer Flag;
}
