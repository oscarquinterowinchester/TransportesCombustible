package com.appchoferes.nomina.controllers.durandb;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/file")
public class FileController {

    //private static final String XML_DIRECTORY = "/ruta/dentro/contenedor/xml";
    //private static final String PDF_DIRECTORY = "/ruta/dentro/contenedor/pdf";


    @GetMapping("/download/xml/{filename}")
    public ResponseEntity<InputStreamResource> downloadXMLFile(@PathVariable String filename) {
        return downloadFile(filename, "/xml");
    }

    @GetMapping("/download/pdf/{filename}")
    public ResponseEntity<InputStreamResource> downloadPDFFile(@PathVariable String filename) {
        return downloadFile(filename, "/pdf");
    }

    private ResponseEntity<InputStreamResource> downloadFile(String filename, String directory) {
        File file = new File(directory + "/" + filename);

        try {
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename);

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(resource);
        } catch (FileNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/upload/xml")
    public ResponseEntity<Map<String, String>> uploadFile(@RequestParam("file") MultipartFile file) {
        Map<String, String> response = new HashMap<>();

        if (file.isEmpty()) {
            response.put("message", "El archivo está vacío");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        try {
            // Define la ruta donde se guardará el archivo en el servidor
            String uploadDir = "/xml";
            // String uploadDir = "C:/Users/carlo/Documents/files";
            //String uploadDir = "C:/carpetaevidencias";
            File destFile = new File(uploadDir + "/" + file.getOriginalFilename());

            // Guarda el archivo en el directorio de destino
            file.transferTo(destFile);

            response.put("message", "Archivo subido exitosamente");
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            e.printStackTrace();
            response.put("message", "Error al subir el archivo");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping("/upload/pdf")
    public ResponseEntity<Map<String, String>> uploadFilePDF(@RequestParam("file") MultipartFile file) {
        Map<String, String> response = new HashMap<>();

        if (file.isEmpty()) {
            response.put("message", "El archivo está vacío");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        try {
            // Define la ruta donde se guardará el archivo en el servidor
            String uploadDir = "/pdf";
            // String uploadDir = "C:/Users/carlo/Documents/files";
            //String uploadDir = "C:/carpetaevidencias";
            File destFile = new File(uploadDir + "/" + file.getOriginalFilename());

            // Guarda el archivo en el directorio de destino
            file.transferTo(destFile);

            response.put("message", "Archivo subido exitosamente");
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            e.printStackTrace();
            response.put("message", "Error al subir el archivo");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
