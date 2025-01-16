package com.appchoferes.nomina.models.lorasdb;

import jakarta.persistence.*;

@Entity
@Table(name = "empresas_tbl")
public class EmpresasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmpresaID")
    private Integer EmpresaID;

    @Column(name = "RazonSocial")
    private String RazonSocial;

    @Column(name = "CP")
    private String CP;

    @Column(name = "SerieCCP40")
    private String SerieCCP40;

    @Column(name = "SerieCCP")
    private String SerieCCP;

    @Column(name = "SerieCPT40")
    private String SerieCPT40;

    @Column(name = "RFC")
    private String RFC;

    @Column(name = "RegimenFiscal")
    private String RegimenFiscal;

    @Column(name = "Pais")
    private String Pais;

    @Column(name = "SCAC")
    private String scac;
    
    
    // getters and setters

    /**
     * @return Integer return the EmpresaID
     */
    public Integer getEmpresaID() {
        return EmpresaID;
    }

    /**
     * @param EmpresaID the EmpresaID to set
     */
    public void setEmpresaID(Integer EmpresaID) {
        this.EmpresaID = EmpresaID;
    }

    /**
     * @return String return the RazonSocial
     */
    public String getRazonSocial() {
        return RazonSocial;
    }

    /**
     * @param RazonSocial the RazonSocial to set
     */
    public void setRazonSocial(String RazonSocial) {
        this.RazonSocial = RazonSocial;
    }

    /**
     * @return String return the CP
     */
    public String getCP() {
        return CP;
    }

    /**
     * @param CP the CP to set
     */
    public void setCP(String CP) {
        this.CP = CP;
    }

    /**
     * @return String return the SerieCCP40
     */
    public String getSerieCCP40() {
        return SerieCCP40;
    }

    /**
     * @param SerieCCP40 the SerieCCP40 to set
     */
    public void setSerieCCP40(String SerieCCP40) {
        this.SerieCCP40 = SerieCCP40;
    }

    /**
     * @return String return the SerieCCP
     */
    public String getSerieCCP() {
        return SerieCCP;
    }

    /**
     * @param SerieCCP the SerieCCP to set
     */
    public void setSerieCCP(String SerieCCP) {
        this.SerieCCP = SerieCCP;
    }

    /**
     * @return String return the SerieCPT40
     */
    public String getSerieCPT40() {
        return SerieCPT40;
    }

    /**
     * @param SerieCPT40 the SerieCPT40 to set
     */
    public void setSerieCPT40(String SerieCPT40) {
        this.SerieCPT40 = SerieCPT40;
    }

    /**
     * @return String return the RFC
     */
    public String getRFC() {
        return RFC;
    }

    /**
     * @param RFC the RFC to set
     */
    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    /**
     * @return String return the RegimenFiscal
     */
    public String getRegimenFiscal() {
        return RegimenFiscal;
    }

    /**
     * @param RegimenFiscal the RegimenFiscal to set
     */
    public void setRegimenFiscal(String RegimenFiscal) {
        this.RegimenFiscal = RegimenFiscal;
    }

    /**
     * @return String return the Pais
     */
    public String getPais() {
        return Pais;
    }

    /**
     * @param Pais the Pais to set
     */
    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    public String getScac() {
        return scac;
    }

    public void setScac(String scac) {
        this.scac = scac;
    }

}
