package com.ejemplos.spring.errores;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.WebRequest;

import com.ejemplos.spring.controller.PagoController;

public class CustomErrorAttributes extends DefaultErrorAttributes {

    private static final Logger logger = LoggerFactory.getLogger(PagoController.class);

    // Formato de fecha
    private static final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    /**
     * {@inheritDoc}
     * <p>
     * Personaliza los atributos de error para incluir información adicional y formatear la fecha.
     */
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        logger.info("------ getErrorAttributes(): " + options);
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);
        logger.info("------ getErrorAttributes(): " + options);

        // Formatear y actualizar la marca de tiempo
        Object timestamp = errorAttributes.get("timestamp");
        if (timestamp == null) {
            errorAttributes.put("timestamp", dateFormat.format(new Date()));
        } else {
            errorAttributes.put("timestamp", dateFormat.format((Date) timestamp));
        }

        // Eliminar la traza para simplificar la salida
        errorAttributes.remove("trace");

        // Insertar nueva clave
        errorAttributes.put("jdk", System.getProperty("java.version"));
        // ¿Este mensaje aparece? ¿Sí? ¿No?
        errorAttributes.put("infoadicional", "eres muuuuuuuuuuuuuuuuuuuu tonto");

        return errorAttributes;
    }

}
