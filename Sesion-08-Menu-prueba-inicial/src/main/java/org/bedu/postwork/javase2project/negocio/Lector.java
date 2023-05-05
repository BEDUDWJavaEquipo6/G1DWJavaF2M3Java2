package org.bedu.postwork.javase2project.negocio;

import java.util.Scanner;

public class Lector {
    private Scanner scanner = new Scanner(System.in);

    public byte leeOpcion(){
        return scanner.nextByte();
    }

    public String leeDato(){
        //System.out.print("Cadena: ");
        return scanner.nextLine();
    }

    public int leeNum(){
        return scanner.nextInt();
    }

    public Long leeId(){
        return scanner.nextLong();
    }


}
