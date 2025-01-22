package com.appchoferes.nomina.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;
import java.util.UUID;

public class ImageUtil {

    public static String saveImage(String base64Image, String prefix, String directory) throws Exception {
        byte[] decodedBytes = Base64.getDecoder().decode(base64Image.split(",")[1]);

        // Creamos un directorio si no existe
        File dir = new File(directory);
        if (!dir.exists()) {
            if (!dir.mkdirs()) {
                throw new Exception("No se pudo crear el directorio: " + directory);
            }
        }

        // Crear archivo de imagen
        String fileName = prefix + "_" + UUID.randomUUID() + ".jpg";
        String filePath = directory + File.separator + fileName;

        // Guarda la imagen en el disco
        try (FileOutputStream fos = new FileOutputStream(new File(filePath))) {
            fos.write(decodedBytes);
        }

        return filePath;
    }

}
