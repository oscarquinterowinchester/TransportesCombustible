package com.appchoferes.nomina.dtos;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import com.appchoferes.nomina.operaciones.UtilsCarga;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cargasDiesel_tbl")
public class CargasDieselEntityOld {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CargaID")
    private Integer cargaId;

    @Column(name = "Tipo")
    private Integer tipo;

    @Column(name = "UnidadID")
    private Integer unidadId;

    @Column(name = "ChoferID")
    private Integer choferId;

    @Column(name = "Litros")
    private Double litros;

    @Column(name = "LitrosECM")
    private Double litrosECM;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "Fecha")
    private LocalDate fecha;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "Hora")
    private Time hora;

    @Column(name = "FechayHora")
    private ZonedDateTime fechayHora;

    @Column(name = "Folio")
    private String folio;

    @Column(name = "Nota")
    private String nota;

    @Column(name = "FechaRegistro")
    private Date fechaRegistro;

    @Column(name = "Status")
    private Boolean status;

    @Column(name = "AjusteOdometro")
    private Boolean ajusteOdometro;

    @Column(name = "ProveedorID")
    private Integer proveedorId;

    @Column(name = "FacturaID")
    private Integer facturaId;

    @Column(name = "CantidadActual")
    private Double cantidadActual;

    @Column(name = "MetodoPago")
    private Integer metodoPago;

    @Column(name = "SerieBomba")
    private String serieBomba;

    @Column(name = "RendimientoCarga")
    private Double rendimientoCarga;

    @Column(name = "RendimientoECM")
    private Double rendimientoECM;

    @Column(name = "RendimientoRutas")
    private Double rendimientoRutas;

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

    @Column(name = "FotoSello")
    private String fotoSello;

    @Column(name = "Sellos2")
    private String sellos2;

    @Column(name = "FotoSello2")
    private String fotoSello2;

    @Column(name = "PrecioTotal")
    private Double precioTotal;

    @Column(name = "MonedaCarga")
    private Integer monedaCarga;

    @Column(name = "FotoOdometro")
    private String fotoOdometro;

    @Column(name = "Firma")
    private String firma;

    @Column(name = "FotoTanque1")
    private String fotoTanque1;

    @Column(name = "FotoTanque2")
    private String fotoTanque2;

    @Column(name = "UsuarioID")
    private Integer usuarioId;

    @Column(name = "FromWS")
    private Boolean fromWS;

    @Column(name = "RecorridoRutas")
    private Double recorridoRutas;

    @Column(name = "OdometroAjustado")
    private Double odometroAjustado;

    @Column(name = "UsuarioAjuste")
    private Integer usuarioAjuste;

    @Column(name = "FechaAjuste")
    private Date fechaAjuste;

    @Column(name = "MotivoAjuste")
    private String motivoAjuste;

    @Column(name = "EstadoID")
    private Integer estadoId;

    @Column(name = "segundoSello")
    private String segundoSello;

    @Column(name = "tipoCombustible")
    private Integer tipoCombustible;

    @Column(name = "esChofer")
    private Boolean esChofer;
   
    // public void calcularRecorridoyRendimiento(String ultimoOdometro){
    //     double recorrido = UtilsCarga.calcularRecorrido(this, ultimoOdometro);
    //     this.setRecorridoCarga(recorrido);

    //     double rendimiento = UtilsCarga.calcularRendimiento(recorrido, this.getLitros());
    //     this.setRendimientoCarga(rendimiento);

    // }

}
