package com.appchoferes.nomina.utils;

import java.io.IOException;
import java.time.Duration;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;
import software.amazon.awssdk.services.s3.presigner.model.PresignedGetObjectRequest;


@Service
public class S3Service {

    @Value("${aws.s3.bucketName}")
    private String bucketName;

    private final S3Client s3Client;

    private final S3Presigner s3Presigner;

    @Autowired
    public S3Service(S3Client s3Client, S3Presigner s3Presigner) {
        this.s3Client = s3Client;
        this.s3Presigner = s3Presigner;
    }

    /**
     * Sube un archivo a S3 y devuelve la URL pública del archivo.
     *
     * @param folder      Carpeta en S3 donde se guardará el archivo.
     * @param fileName    Nombre base del archivo.
     * @param id          Identificador único para el archivo.
     * @param base64Image Imagen en formato Base64.
     * @return URL pública del archivo en S3.
     * @throws IOException Si ocurre un error al subir el archivo.
     */
    public String uploadFile(String folder, String fileName, String id, String base64Image) throws IOException {
        try {
            // Decodifica la imagen base64
            byte[] imageBytes = Base64.getDecoder().decode(base64Image.split(",")[1]);

            // Genera un nombre único para el archivo
            String uniqueFileName = fileName + "_" + id + ".png";

            // Ruta completa en S3 (incluyendo la carpeta recursosweb)
            String key = "recursosweb/" + folder + "/" + uniqueFileName;

            // Sube el archivo a S3
            s3Client.putObject(PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(key)
                    .build(), RequestBody.fromBytes(imageBytes));

            // Devuelve la URL del archivo en S3
            return "https://" + bucketName + ".s3.amazonaws.com/" + key;
        } catch (S3Exception e) {
            throw new IOException("Error al subir el archivo a S3: " + e.getMessage(), e);
        }
    }

    /**
     * Genera una URL firmada para acceder a un archivo en S3.
     *
     * @param folder   Carpeta en S3 donde se encuentra el archivo.
     * @param fileName Nombre base del archivo.
     * @param id       Identificador único del archivo.
     * @return URL firmada para acceder al archivo.
     */
    public String generarUrlFirmada(String folder, String fileName) {
        try {
            // Genera la ruta completa del archivo en S3
            String key = "recursosweb/" + folder + "/" + fileName + ".png";

            // Crea una solicitud para obtener el objeto
            GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                    .bucket(bucketName)
                    .key(key)
                    .build();

            // Crea una solicitud firmada
            GetObjectPresignRequest getObjectPresignRequest = GetObjectPresignRequest.builder()
                    .signatureDuration(Duration.ofMinutes(10)) // Duración de la URL firmada (10 minutos)
                    .getObjectRequest(getObjectRequest)
                    .build();

            // Genera la URL firmada
            PresignedGetObjectRequest presignedGetObjectRequest = s3Presigner.presignGetObject(getObjectPresignRequest);
            return presignedGetObjectRequest.url().toString();
        } catch (Exception e) {
            throw new RuntimeException("Error al generar la URL firmada", e);
        }
    }
}
