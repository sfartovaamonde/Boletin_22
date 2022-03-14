package com.samu.lecturaFicheiros;
import java.util.Arrays;
import javax.swing.JOptionPane;
 import LibreriaSamuel.LerDatos;

public class Tabla {
    public static int[][] crearTaboaGoles(int[][] goles){
    for (int filas=0;filas<goles.length;filas++){
        for(int columnas=0;columnas<goles[filas].length;columnas++){
            goles[filas][columnas]=LerDatos.lerInteger("Introduza os goles do equipo: ");

        }
    }
        return goles;
}
    public static void amosarTaboa(int[][]goles,String[]xornadas,String[]equipos){
        for(int columnas=0;columnas<xornadas.length;columnas++){
            System.out.print("    "+xornadas[columnas]);
        }
        for(int filas=0;filas<goles.length;filas++){
            System.out.print("\n"+equipos[filas]+"                     ");
            for(int columnas=0;columnas<goles[filas].length;columnas++){
                System.out.print(goles[filas][columnas]+"    ");
            }
        }
    }

    public static int[] sumarGoles(int[][]goles,String[]equipos){
        int suma=0;
        int tam=LerDatos.lerInteger("De cantos equipos vai a sumar os goles: ");
        int[]sumas= new int[tam];
        for(int filas =0; filas<goles.length;filas++){
            suma=0;
            for(int columnas=0;columnas<goles[filas].length;columnas++){
                suma=suma+goles[filas][columnas];
                sumas[filas]=suma;

            }
            System.out.println("\n"+sumas[filas]);
        }
        return sumas;
    }

    public static void ordenarGoles (int [][]goles,String[]equipos){
        int[]sumado=TaboaXornadas.sumarGoles(goles,equipos);
        int golaux;
        String eqaux;
        for (int i=0;i<goles.length;i++){
            for(int j=i+1;j<goles.length;j++){
                if (sumado[i]>sumado[j]){
                    golaux=sumado[i];
                    sumado[i]=sumado[j];
                    sumado[j]=golaux;
                    eqaux=equipos[i];
                    equipos[i]=equipos[j];
                    equipos[j]=eqaux;

                }
            }
        }
        System.out.println("\n"+"\n"+Arrays.toString(equipos)+"   ");

    }

    public static void mayorXornada (int[][]goles,String[]equipos){
        int numXornada=LerDatos.lerInteger("Numero da xornada da que  quere saber o máximo goleador:  ");
        numXornada=numXornada-1;
        int mayor;
        int aux;
        String eqaux;
        for (int i=0;i<goles.length;i++){
            for(int j=i+1;j<goles.length;j++){
                if (goles[i][numXornada]<goles[j][numXornada]){
                    aux=goles[i][numXornada];
                    goles[i][numXornada]=goles[j][numXornada];
                    goles[j][numXornada]=aux;
                    eqaux=equipos[i];
                    equipos[i]=equipos[j];
                    equipos[j]=eqaux;
                }
            }
        }
        mayor=goles[0][numXornada];
        System.out.println("\n O máximo goleador da x"+(numXornada+1)+" foi "+equipos[0]+" con "+mayor+" goles.");
    }


    public static void mayordaLiga (int[][]goles, String[]equipos){
        //he de subir los mayores de cada columna a la primera fila y después en esta mover el mayor a la izq, recogiendo antes su columna para saber su jornada e inicialmente su fila para conocer el equipo al que pertenece.
    }

    public static void equipoXornada (int[][]goles,String[]equipos){
        int xornada=Integer.parseInt(JOptionPane.showInputDialog("Indique a xornada da que quere un resultado: "));
        xornada=xornada-1;
        String equipo=JOptionPane.showInputDialog("Escribe o equipo do que queras saber a puntuación da xornada: ");
        int existe=0;
        if(xornada<=goles.length){
            for (int i=0;i<equipos.length;i++){
                if(equipo.equalsIgnoreCase(equipos[i])){
                    int numgol=goles[i][xornada];
                    System.out.println(equipo+" marcou "+numgol+" goles na x"+(xornada+1));
                    existe=1;
                    break;
                }
            }
            if (existe==0){
                System.out.println("O equipo non xogou na liga.");
            }
        }
        else
            System.out.println("Esta xornada non existe.");
    }



}
