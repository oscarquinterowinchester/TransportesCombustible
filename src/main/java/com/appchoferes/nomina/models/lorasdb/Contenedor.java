package com.appchoferes.nomina.models.lorasdb;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "inventarioexterno_tbl")
public class Contenedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "InventarioID")
    private Integer inventarioID;

    @Column(name = "WContenedorID")
    private String wContenedorID;

    @Column(name = "Contenedor")
    private String contenedor;

    @Column(name = "ItinerarioID")
    private Integer itinerarioID;

    @Column(name = "ClienteID")
    private Integer clienteID;

    @Column(name = "TipoEvento")
    private Integer tipoEvento;

    @Column(name = "FechaEvento")
    private LocalDateTime fechaEvento;

    @Column(name = "PlacasUnidad")
    private String placasUnidad;

    @Column(name = "Sello")
    private String sello;

    @Column(name = "PaisID")
    private Integer paisID;

    @Column(name = "EstadoID")
    private Integer estadoID;

    @Column(name = "ChoferID")
    private Integer choferID;

    @Column(name = "RutaID")
    private Integer rutaID;

    @Column(name = "UsuarioID")
    private Integer usuarioID;

    @Column(name = "EquipmentProvider")
    private String equipmentProvider;

    @Column(name = "EquipmentProviderExt")
    private String equipmentProviderExt;

    @Column(name = "NombreChofer")
    private String nombreChofer;

    @Column(name = "EmpresaChofer")
    private String empresaChofer;

    @Column(name = "UsuarioEventoID")
    private Integer usuarioEventoID;

    @Column(name = "Nota")
    private String nota;

    @Column(name = "EstadoCarga")
    private String estadoCarga;

    @Column(name = "Botando")
    private Boolean botando;

    @Column(name = "PatioID")
    private Integer patioID;

    @Column(name = "Tamano")
    private String tamano;

    @Column(name = "Firmak9")
    private String firmak9;

    @Column(name = "FirmaChofer")
    private String firmaChofer;

    @Column(name = "FirmaGuardia")
    private String firmaGuardia;

    @Column(name = "Camion")
    private String camion;

    @Column(name = "Carrier")
    private String carrier;

}
