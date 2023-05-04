package org.bedu.postwork.javase2project.negocio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LeerArchivo {

    public static void main(String[] args) {

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        Map<String, Integer> estudianteConCalificacion = new HashMap<>();
        int contardorLinea;
        String ciclo="";
        String nombreMateria="";


        String linea = null;

        try {
            archivo = new File("C:\\Users\\jacor\\Documents\\personas.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String[] datos = null;
            contardorLinea =0;

            while ((linea = br.readLine()) != null) {
                datos = linea.split(";");
                if(contardorLinea<=0){
                    ciclo = datos[0];
                    nombreMateria = datos[1];
                }else{
                    estudianteConCalificacion.put(datos[0],Integer.valueOf(datos[1]));
                }
                contardorLinea++;
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
        System.out.println(ciclo + nombreMateria);
        System.out.println(estudianteConCalificacion);

    }

}
