package com.appchoferes.nomina.shared.context;

public class UserContext {
    private String databaseName;
    private String username;
    private String password;
    private String empresa;
    private String nombreUsuario;
    private String apellidoPaterno;

    public UserContext(String databaseName, String username, String password, String empresa, String nombreUsuario, String apellidoPaterno) {
        this.databaseName = databaseName;
        this.username = username;
        this.password = password;
        this.empresa = empresa;
        this.nombreUsuario = nombreUsuario;
        this.apellidoPaterno = apellidoPaterno; 
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }   

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }   
}
