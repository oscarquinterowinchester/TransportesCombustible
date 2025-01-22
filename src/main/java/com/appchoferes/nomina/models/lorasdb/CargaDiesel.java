package com.appchoferes.nomina.models.lorasdb;

import java.time.LocalDate;
import java.time.LocalTime;

import org.hibernate.annotations.JavaType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cargasdiesel_tbl")
public class CargaDiesel {

    @Id
    @Column(name = "CargaID")
    // se usa GenerationType.IDENTITY para indicar que es autoincrementable
    // en la base de datos
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cargaId;

    @Column(name = "Tipo")
    @JsonProperty("Tipo")
    private Integer Tipo;

    @Column(name = "UnidadID")
    // JsonProperty indica como se llamar el valor en el Json generado
    // evitando que la libreria Jackson convierta el valor a camelCase
    @JsonProperty("UnidadID")
    private Integer UnidadID;

    /*
     * @ManyToOne(fetch = FetchType.LAZY)
     * 
     * @JoinColumn(name = "ProveedorID", referencedColumnName = "ProveedorID")
     * private Proveedor proveedor;
     */
    @Column(name = "ProveedorID")
    @JsonProperty("ProveedorID")
    private Integer ProveedorID;

    @Column(name = "PrecioTotal")
    @JsonProperty("PrecioTotal")
    private Double PrecioTotal;

    @Column(name = "MonedaCarga")
    @JsonProperty("MonedaCarga")
    private Integer MonedaCarga;

    @Column(name = "Litros")
    @JsonProperty("Litros")
    private double Litros;

    @Column(name = "FotoTanque1")
    @JsonProperty("FotoTanque1")
    private String fotoTanque1;

    @Column(name = "FotoTanque2")
    @JsonProperty("FotoTanque2")
    private String fotoTanque2;

    @Column(name = "Folio")
    @JsonProperty("Folio")
    private String Folio;

    @Column(name = "Nota")
    @JsonProperty("Nota")
    private String Nota;

    @Column(name = "SerieBomba")
    @JsonProperty("SerieBomba")
    private String SerieBomba;

    @Column(name = "OdometroCarga")
    @JsonProperty("OdometroCarga")
    private Double OdometroCarga;

    @Column(name = "FotoOdometro")
    @JsonProperty("FotoOdometro")
    private String FotoOdometro;

    @Column(name = "RendimientoECM")
    @JsonProperty("RendimientoECM")
    private double RendimientoECM;

    @Column(name = "RecorridoECM")
    @JsonProperty("RecorridoECM")
    private Double RecorridoECM;

    @Column(name = "LitrosECM")
    @JsonProperty("LitrosECM")
    private double LitrosECM;

    @Column(name = "Sellos")
    @JsonProperty("Sellos")
    private String Sellos;

    @Column(name = "FotoSello")
    @JsonProperty("FotoSello")
    private String FotoSello;

    @Column(name = "Firma")
    @JsonProperty("Firma")
    private String Firma;

    @Column(name = "ChoferID")
    @JsonProperty("ChoferID")
    private Integer ChoferID;

    @Column(name = "UsuarioID")
    // @JsonProperty("UsuarioID")
    private Integer usuarioID;

    @Column(name = "esChofer")
    @JsonProperty("esChofer")
    private Integer esChofer;

    /*
     * @ManyToOne(fetch = FetchType.LAZY)
     * 
     * @JoinColumn(name = "UnidadID", referencedColumnName = "CamionID")
     * private Camion camion;
     */

    /*
     * @ManyToOne(fetch = FetchType.LAZY)
     * 
     * @JoinColumn(name = "UnidadID", referencedColumnName = "CajaID", insertable =
     * false, updatable = false)
     * private Caja caja;
     */

    /*
     * @ManyToOne(fetch = FetchType.LAZY)
     * 
     * @JoinColumn(name = "ChoferID", referencedColumnName = "ChoferID")
     * private Chofer chofer;
     */

    // revisar la relacion con la tabla usuarios_tbl
    /*
     * @ManyToOne(fetch = FetchType.LAZY)
     * 
     * @JoinColumn(name = "UsuarioID", referencedColumnName = "UsuarioID")
     * private Usuario usuario;
     */

    @Transient
    private String fechaString;

    @Transient
    private String horaString;

    @Column(name = "Fecha")
    // Especificamos el formato en que jackson recibira la fecha
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonProperty("Fecha")
    private LocalDate Fecha;

    @Column(name = "Hora")
    @JsonFormat(pattern = "HH:mm:ss")
    @JsonProperty("Hora")
    private LocalTime Hora;

    @Column(name = "Status")
    @JsonProperty("Status")
    private Integer status;

    @Column(name = "AjusteOdometro")
    @JsonProperty("AjusteOdometro")
    private Integer ajusteOdometro;

    @Column(name = "FacturaID")
    @JsonProperty("FacturaID")
    private Integer FacturaID;
    // Revisar si no se relaciona con otra tabla
    /*
     * @OneToOne(fetch = FetchType.LAZY)
     * 
     * @JoinColumn(name = "FacturaID", referencedColumnName = "FacturaID")
     * private Factura factura;
     */

    @Column(name = "CantidadActual")
    private Double cantidadActual;

    @Column(name = "MetodoPago")
    @JsonProperty("MetodoPago")
    private Integer MetodoPago;
    // revisar si no se relaciona con otra tabla
    /*
     * @ManyToOne(fetch = FetchType.LAZY)
     * 
     * @JoinColumn(name = "MetodoPago", referencedColumnName = "MetodoID")
     * 
     * @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
     * private MetodoPago metodoPago;
     */

    @Column(name = "RendimientoCarga")
    @JsonProperty("RendimientoCarga")
    private Double rendimientoCarga;

    @Column(name = "RendimientoRutas")
    private Double rendimientoRuta;

    @Column(name = "OdometroECM")
    @JsonProperty("OdometroECM")
    private Double odometroECM;

    @Column(name = "RecorridoCarga")
    private Double recorridoCarga;

    @Column(name = "FromWS")
    @JsonProperty("FromWS")
    private Integer fromWS;

    @Column(name = "RecorridoRutas")
    private Double recorridoRutas;

    @Column(name = "OdometroAjustado")
    @JsonProperty("OdometroAjustado")
    private Double odometroAjustado;

    @Column(name = "UsuarioAjuste")
    private String usuarioAjuste;

    @Column(name = "FechaAjuste")
    private String fechaAjuste;

    @Column(name = "MotivoAjuste")
    private String motivoAjuste;

    // revisar si no hace referencia a otra tabla
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EstadoID", referencedColumnName = "EstadoID")
    private Estado estado;

}
