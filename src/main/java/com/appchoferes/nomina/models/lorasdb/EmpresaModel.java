package com.appchoferes.nomina.models.lorasdb;

import jakarta.persistence.*;

@Entity
@Table(name="empresas_tbl")
public class EmpresaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmpresaID")
    private Integer EmpresaID;

    @Column(name = "RazonSocial")
    private String RazonSocial;

    @Column(name = "NComercial")
    private String NComercial;

    @Column(name = "RFC")
    private String RFC;

    @Column(name = "CP")
    private String CP;

    @Column(name = "RegimenFiscal")
    private String RegimenFiscal;

    @Column(name = "UsuarioSicofi")
    private String UsuarioSicofi;

    @Column(name = "ContraSicofi")
    private String ContraSicofi;

    // -- getters and setters

    public Integer getEmpresaID() {
        return EmpresaID;
    }

    public void setEmpresaID(Integer EmpresaID) {
        this.EmpresaID = EmpresaID;
    }

    public String getRazonSocial() {
        return RazonSocial;
    }

    public void setRazonSocial(String RazonSocial) {
        this.RazonSocial = RazonSocial;
    }

    public String getNComercial() {
        return NComercial;
    }

    public void setNComercial(String NComercial) {
        this.NComercial = NComercial;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getCP() {
        return CP;
    }

    public void setCP(String CP) {
        this.CP = CP;
    }

    public String getRegimenFiscal() {
        return RegimenFiscal;
    }

    public void setRegimenFiscal(String RegimenFiscal) {
        this.RegimenFiscal = RegimenFiscal;
    }

    public String getUsuarioSicofi() {
        return UsuarioSicofi;
    }

    public void setUsuarioSicofi(String UsuarioSicofi) {
        this.UsuarioSicofi = UsuarioSicofi;
    }

    public String getContraSicofi() {
        return ContraSicofi;
    }

    public void setContraSicofi(String ContraSicofi) {
        this.ContraSicofi = ContraSicofi;
    }

}
