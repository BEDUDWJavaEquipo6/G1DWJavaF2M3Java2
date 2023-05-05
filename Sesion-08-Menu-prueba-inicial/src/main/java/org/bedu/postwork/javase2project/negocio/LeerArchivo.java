package org.bedu.postwork.javase2project.negocio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LeerArchivo {
    private File archivo = null;
    private FileReader fr = null;
    private BufferedReader br = null;
    private Map<String, Integer> estudianteConCalificacion = new LinkedHashMap<>();
    private String ciclo="";
    private String nombreMateria="";
    private String linea = null;

    public Map<String, Integer> datosArchivo(String ruta) {

        try {
            archivo = new File(ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String[] datos = null;
            while ((linea = br.readLine()) != null) {
                datos = linea.split(";");
                estudianteConCalificacion.put(datos[0],Integer.valueOf(datos[1]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return estudianteConCalificacion;

    }

}
