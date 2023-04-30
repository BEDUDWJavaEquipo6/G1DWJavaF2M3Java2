package org.bedu.postwork.javase2project.async;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class ReceptorSolicitudes implements Runnable{

//a) Procesa y espera solicitudes dentro de run
//Tomando como ejemplo el EventLoopSimple desarrollado en la s4
    private boolean enEjecucion = false;
    private Queue<SolicitudEstudiante> listaSolicitudes = new LinkedList<>();
    private final NotificadorInscripcion worker;

    public ReceptorSolicitudes(NotificadorInscripcion worker) {
        this.worker = worker;
    }

    @Override
    public void run() {
        try{
            while(enEjecucion || !listaSolicitudes.isEmpty()){
                SolicitudEstudiante solicitud = listaSolicitudes.poll();

                if(solicitud == null){
                    System.out.println("No hay solicitudes pendientes, el sistema sigue en espera");
                    TimeUnit.SECONDS.sleep(1);
                    continue;
                }
                worker.notificarAMaestro(solicitud);
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //b) Iniciar y detener la ejecucion con metodos separados
    public void iniciar(){
        this.enEjecucion = true;
        new Thread(this).start();
    }

    public void detener(){
        this.enEjecucion = false;
    }

//c) Agregar nuevas solicitudes a la lista de pendientes
    public void registrarEvento(SolicitudEstudiante evento){
        listaSolicitudes.add(evento);
    }

    //d) Metodo para validar si está en ejecucion
    public boolean isEnEjecucion(){
        return enEjecucion;
    }


}
