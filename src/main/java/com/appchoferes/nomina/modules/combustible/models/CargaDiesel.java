package com.appchoferes.nomina.modules.combustible.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cargasdiesel_tbl")
public class CargaDiesel{

    @Id
    @Column(name = "CargaID")
    private long cargaId;

    @Column(name = "Tipo")
    private Integer tipo;

    @Column(name = "UnidadID")
    private long unidadId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ChoferID", referencedColumnName = "ChoferID")
    private Chofer chofer;

    @Column(name = "LitrosECM")
    private double litrosECM;

    @Column(name = "Litros")
    private double litros;

    @Column(name = "Fecha")
    private String fecha;

    @Column(name = "Hora")
    private String hora;

    @Column(name = "FechayHora")
    private String fechayHora;

    @Column(name = "Folio")
    private String folio;

    @Column(name = "Nota")
    private String nota;

    @Column(name = "FechaRegistro")
    private String fechaRegistro;
    
    @Column(name = "Status")
    private Integer status;

    @Column(name = "AjusteOdometro")
    private Integer ajusteOdometro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProveedorID", referencedColumnName = "ProveedorID")
    private Proveedor proveedor;

    //Revisar si no se relaciona con otra tabla
    private String facturaId;

    @Column(name = "CantidadActual")
    private Double cantidadActual;

    //revisar si no se relaciona con otra tabla
    private Integer metodoPago;

    @Column(name = "SerieBomba")
    private String serieBomba;

    @Column(name = "RendimientoCarga")
    private double rendimientoCarga;

    @Column(name = "RendimientoECM")
    private double rendimientoECM;

    @Column(name = "RendimientoRutas")
    private double rendimientoRuta;

    @Column(name = "OdometroCarga")
    private Double odometroCarga;

    @Column(name = "OdometroECM")
    private Double odometroECM;

    @Column(name = "RecorridoCarga")
    private Double recorridoCarga;

    @Column(name = "RecorridoECM")
    private Double recorridoECM;

    @Column(name = "Sellos")
    private String sellos;

    @Column(name = "PrecioTotal")
    private Double precioTotal;

    @Column(name = "MonedaCarga")
    private Integer monedaCarga;

    @Column(name = "FotoSello")
    private String fotoSello;

    @Column(name = "FotoOdometro")
    private String fotoOdometro;

    @Column(name = "Firma")
    private String firma;

    @Column(name = "FotoTanque1")
    private String fotoTanque1;

    @Column(name = "FotoTanque2")
    private String fotoTanque2;

    //revisar la relacion con la tabla usuarios_tbl
    private Integer usuarioId;

    @Column(name = "FromWS")
    private Integer fromWS;

    @Column(name = "RecorridoRutas")
    private Double recorridoRutas;

    @Column(name = "OdometroAjustado")
    private Double odometroAjustado;

    @Column(name = "UsuarioAjuste")
    private Integer usuarioAjuste;

    @Column(name = "FechaAjuste")
    private String fechaAjuste;

    @Column(name = "MotivoAjuste")
    private String motivoAjuste;

    // revisar si no hace referencia a otra tabla
    private Integer estadoId;

    private Integer esChofer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unidadID", referencedColumnName = "CamionID")
    private Camion camion;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unidadID", referencedColumnName = "CajaID", insertable = false, updatable = false)
    private Caja caja;
}
