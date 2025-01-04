package com.appchoferes.nomina.shared.context;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserContext {
    private String databaseName;
    private String username;
    private String password;
    private String empresa;
    private String nombreUsuario;
    private String appellidoPaterno;

}
