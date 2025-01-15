package com.appchoferes.nomina.controllers.durandb;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appchoferes.nomina.models.durandb.CuentasPorCobrarModel;
import com.appchoferes.nomina.repositories.durandb.CuentasPorCobrarRepository;
import com.appchoferes.nomina.services.durandb.CuentasPorCobrarService;

@RestController
@RequestMapping("/cuentasporcobrar")
public class CuentasPorCobrarController {

    private static final String FILE_DIRECTORY = "C:/SERVER/TransportesNOE/dist/rsctFacturas";
    @Autowired
    CuentasPorCobrarService cuentasPorCobrarService;

    @Autowired
    CuentasPorCobrarRepository cuentasPorCobrarRepository;

    @GetMapping("/byCliente")
    public ArrayList<CuentasPorCobrarModel> obtenerCuentasPorCobrarByCliente(@RequestParam Integer clienteID){
        return cuentasPorCobrarService.obtenCuentasPorCobrarByCliente(clienteID);
    }

    @GetMapping("/file/{filename}")
    public static byte[] downloadFile(@PathVariable String filename) throws IOException {
        String fileUrl = FILE_DIRECTORY + "/" + filename + ".pdf";
        URL url = new URL(fileUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            try (InputStream inputStream = connection.getInputStream()) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            }
            return outputStream.toByteArray();
        } else {
            throw new IOException("Failed to download file. Server returned HTTP response code: " + connection.getResponseCode());
        }
    }
}
