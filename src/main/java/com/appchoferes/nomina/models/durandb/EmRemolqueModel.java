package com.appchoferes.nomina.models.durandb;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "emremolque")
public class EmRemolqueModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "status")
    private int status;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "remolquefk")
    private Long remolquefk;
    
    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getRemolquefk() {
        return remolquefk;
    }

    public void setRemolquefk(Long remolquefk) {
        this.remolquefk = remolquefk;
    }
}
