package com.appchoferes.nomina.models.durandb.dtos;

public class AutotransporteDTO {
    private String permsct;
    private String numpermisosct;
    private IdentificacionVehicular IdentificacionVehicular;
    private Seguros Seguros;
    private Remolques Remolques;

    // Getters y Setters

    /**
     * @return String return the permsct
     */
    public String getPermsct() {
        return permsct;
    }

    /**
     * @param permsct the permsct to set
     */
    public void setPermsct(String permsct) {
        this.permsct = permsct;
    }

    /**
     * @return String return the numpermisosct
     */
    public String getNumpermisosct() {
        return numpermisosct;
    }

    /**
     * @param numpermisosct the numpermisosct to set
     */
    public void setNumpermisosct(String numpermisosct) {
        this.numpermisosct = numpermisosct;
    }

    /**
     * @return IdentificacionVehicular return the IdentificacionVehicular
     */
    public IdentificacionVehicular getIdentificacionVehicular() {
        return IdentificacionVehicular;
    }

    /**
     * @param IdentificacionVehicular the IdentificacionVehicular to set
     */
    public void setIdentificacionVehicular(IdentificacionVehicular IdentificacionVehicular) {
        this.IdentificacionVehicular = IdentificacionVehicular;
    }

    /**
     * @return Seguros return the Seguros
     */
    public Seguros getSeguros() {
        return Seguros;
    }

    /**
     * @param Seguros the Seguros to set
     */
    public void setSeguros(Seguros Seguros) {
        this.Seguros = Seguros;
    }

    /**
     * @return Remolques return the Remolques
     */
    public Remolques getRemolques() {
        return Remolques;
    }

    /**
     * @param Remolques the Remolques to set
     */
    public void setRemolques(Remolques Remolques) {
        this.Remolques = Remolques;
    }

}
