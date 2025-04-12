package com.appchoferes.nomina.models.lorasdb;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "inventarioexterno_tbl")
public class P_InventarioExterno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer InventarioID;

    @Column(name = "ItinerarioID")
    private Integer ItinerarioID;

    @Column(name = "AnteriorID")
    private Integer AnteriorID;

    private Integer WContenedorID;

    @Column(name = "Contenedor")
    private String Contenedor;

    @Column(name = "PlacasChasis")
    @JsonProperty("PlacasChasis")
    private String PlacasChasis;

    private String Sello;
    private Boolean SelloDiesel;
    private Integer PaisID;
    private Integer EstadoID;

    @Column(name = "ChoferID")
    @JsonProperty("ChoferID")
    private Integer ChoferID;

    @Column(name = "ClienteID")
    @JsonProperty("ClienteID")
    private Integer ClienteID;

    private Integer UsuarioID;

    private Integer RutaID;

    @Column(name = "NombreChofer")
    @JsonProperty("NombreChofer")
    private String NombreChofer;
    private String EmpresaChofer;
    private Integer UsuarioEventoID;
    private String Nota;

    @Column(name = "EstadoCarga")
    @JsonProperty("carga")
    private Integer EstadoCarga;
    private Integer TipoEvento;

    @JsonProperty("FechaEvento")
    private LocalDateTime FechaEvento;

    @Column(name = "Fecha", nullable = true)
    private LocalDateTime Fecha;
    private Integer PatioID;
    private String Tamano;
    private Integer Status;
    private Integer UsuarioEliminaID;

    @Column(name = "FechaElimina", nullable = true)
    private LocalDateTime FechaElimina;

    @Column(name = "camion")
    @JsonProperty("camion")
    private String camion;
    private Integer EquipmentProvider;
    private String EquipmentProviderExt;
    private String Firmak9;

    @Column(name = "Botando")
    private Boolean botando;

    private String origen;
    private Integer camionID;
    private String destino;

    @Column(name = "placasunidad")
    @JsonProperty("PlacasUnidad")
    private String placasunidad;
    private String NumeroChasis;

    @Column(name = "Carrier")
    @JsonProperty("Carrier")
    private String Carrier;

    private String grade;
    private String assignedto;

    @Column(name = "fechaedicion", nullable = true)
    private LocalDateTime fechaedicion;
    private Boolean isCamion;
    private Integer perfilcobroID;
    private Boolean isVirtual;
    private String PlacasChasisUSA;
    private Integer EstadoUSAID;
    private String PlacasUnidadUSA;

    @Column(name = "EstadoPlacasMex")
    @JsonProperty("estadomex")
    private String EstadoPlacasMex;

    @Column(name = "EstadoPlacasUsa")
    @JsonProperty("estadousa")
    private String EstadoPlacasUsa;
    private Integer remolqueEstado;
    private String remolquePais;
    private Boolean solochasis;
    private Integer CreacionUsuarioEventoID;
    private String licencia;
    private Integer cajaID;
    private String chasis;
    private Boolean isFull;
    private Integer FullItinerarioBase;
    private String sellocomplementario;
    private String FotoSello;
    private String FirmaGuardia;
    private String FirmaChofer;
    private Boolean facturado;
    private String totalrenta;
    private Integer Estado;
}
