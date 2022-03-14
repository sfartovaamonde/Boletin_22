package com.samu.lecturaFicheiros;

import LibreriaSamuel.LerDatos;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {


        int filas=LerDatos.lerInteger("Número de filas: ");
        int columnas=LerDatos.lerInteger("Número de columnas: ");
        int opcion;

        int goles[][]=new int[filas][columnas];
        String[]xornadas={"equipos/xornadas","x1","x2","x3"};
        String[]equipos={LerDatos.lerString("Equipo1: "),LerDatos.lerString("Equipo2: "),LerDatos.lerString("Equipo3: ")};

        do{
            opcion=Integer.parseInt(JOptionPane.showInputDialog("MENÚ \n 1.Introducir o goles. \n 2.Equipos de menor a mayor marcador. \n 3.Máximo goleador dunha xornada. \n 4.Máximo goleador da liga. \n 5.Buscar os goles dun equipo e xornada concretos. \n 0.Salir."));
            switch (opcion){
                case 1:

                    TaboaXornadas.crearTaboaGoles(goles);
                    TaboaXornadas.amosarTaboa(goles, xornadas, equipos);
                    break;
                case 2:
                    TaboaXornadas.ordenarGoles(goles, equipos);
                    break;
                case 3:
                    TaboaXornadas.mayorXornada(goles, equipos);
                    break;
                case 4:

                    break;
                case 5:
                    TaboaXornadas.equipoXornada(goles, equipos);
                    break;

                case 0:
                    break;
                default:
                    System.out.println("A opción non se atopa no menú.");

            }
        }while (opcion!=0);
        System.out.println("Ata a próxima.");
    }

    }

