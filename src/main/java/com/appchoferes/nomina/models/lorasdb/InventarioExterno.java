package com.appchoferes.nomina.models.lorasdb;

//import java.util.List;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "inventarioexterno_tbl")
public class InventarioExterno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "InventarioID")
    private Integer InventarioID;

    @Column(name = "Contenedor")
    private String Contenedor;

    @Column(name = "ItinerarioID")
    private Integer ItinerarioID;

    @Column(name = "placasunidad")
    private String PlacasUnidad;

    @Column(name = "Sello")
    private String Sello;

    @Column(name = "PaisID")
    private Integer PaisID;

    @Column(name = "EstadoID")
    private Integer EstadoID;

    @Column(name = "ChoferID")
    private Integer ChoferID;

    @Column(name = "RutaID")
    private Integer RutaID;

    @Column(name = "UsuarioID")
    private Integer UsuarioID;

    @Column(name = "ClienteID")
    private Integer ClienteID;

    @Column(name = "EquipmentProvider")
    private Integer EquipmentProvider;

    @Column(name = "EquipmentProviderExt")
    private String EquipmentProviderExt;

    @Column(name = "NombreChofer")
    private String NombreChofer;

    @Column(name = "EmpresaChofer")
    private String EmpresaChofer;

    @Column(name = "UsuarioEventoID")
    private Integer UsuarioEventoID;

    @Column(name = "Nota")
    private String Nota;

    @Column(name = "EstadoCarga")
    private Integer EstadoCarga;

    @Column(name = "Botando")
    private Boolean Botando;

    @Column(name = "TipoEvento")
    private Integer TipoEvento;

    @Column(name = "FechaEvento")
    private String FechaEvento;

    @Column(name = "PatioID")
    private Integer PatioID;

    @Column(name = "Tamano")
    private Integer Tamano;

    @Column(name = "Firmak9")
    private String Firmak9;

    @Column(name = "FirmaChofer")
    private String FirmaChofer;

    @Column(name = "FirmaGuardia")
    private String FirmaGuardia;

    @Column(name = "camion")
    private String Camion;

    @Column(name = "Carrier")
    private String Carrier;

    private String FotoSello;
    
    //@OneToMany(mappedBy = "inventarioExterno", cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<InventarioExternoInspeccion> puntosInspeccion;

}
