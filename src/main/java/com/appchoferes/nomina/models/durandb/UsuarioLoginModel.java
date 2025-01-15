package com.appchoferes.nomina.models.durandb;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios_tbl")
public class UsuarioLoginModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "nombreUsuario")
    private String nombreUsuario;

    @Column(name = "apellidoPaterno")
    private String apellidoPaterno;

    @Column(name = "apellidoMaterno")
    private String apellidoMaterno;

    @Column(name = "nombre_db")
    private String nombreDb;

    @Column(name = "usuario_db")
    private String usuarioDb;

    @Column(name = "password_db")
    private String passwordDb;

    @Column(name = "loginUsuario")
    private String loginUsuario;

    @Column(name = "passwordUsuario")
    private String passwordUsuario;

    @Column(name = "empresaID")
    private Integer empresaID;
    // Getters y Setters

    /**
     * @return String return the nombreUsuario
     */
    public Long getID() {
        return ID;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setID(Long ID) {
        this.ID = ID;
    }

    /**
     * @return String return the nombreUsuario
     */
    public String getnombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setnombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * @return String return the apellidoPaterno
     */
    public String getapellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * @param apellidoPaterno the apellidoPaterno to set
     */
    public void setapellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * @return String return the nombreUsuario
     */
    public String getapellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setapellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * @return String return the nombreDb
     */
    public String getnombreDb() {
        return nombreDb;
    }

    /**
     * @param nombreDb the nombreDb to set
     */
    public void setnombreDb(String nombreDb) {
        this.nombreDb = nombreDb;
    }

    /**
     * @return String return the usuarioDb
     */
    public String getusuarioDb() {
        return usuarioDb;
    }

    /**
     * @param usuarioDb the usuarioDb to set
     */
    public void setusuarioDb(String usuarioDb) {
        this.usuarioDb = usuarioDb;
    }

    /**
     * @return String return the passwordDb
     */
    public String getpasswordDb() {
        return passwordDb;
    }

    /**
     * @param passwordDb the passwordDb to set
     */
    public void setpasswordDb(String passwordDb) {
        this.passwordDb = passwordDb;
    }

    /**
     * @return String return the loginUsuario
     */
    public String getloginUsuario() {
        return loginUsuario;
    }

    /**
     * @param loginUsuario the loginUsuario to set
     */
    public void setloginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    /**
     * @return String return the passwordUsuario
     */
    public String getpasswordUsuario() {
        return passwordUsuario;
    }

    /**
     * @param passwordUsuario the passwordUsuario to set
     */
    public void setpasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    public Integer getempresaID() {
        return empresaID;
    }

    public void setempresaID(Integer empresaID) {
        this.empresaID = empresaID;
    }
}
