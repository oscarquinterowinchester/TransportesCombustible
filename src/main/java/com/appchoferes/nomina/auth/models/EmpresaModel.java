package com.appchoferes.nomina.auth.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "empresas_tbl")
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
}
