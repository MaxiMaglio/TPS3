package Grupo10EjCaballo;

import utils.IsEmptyException;
import utils.Scanner;
import utils.UI;

public class Main {
    public static void main(String[] args) throws IsEmptyException {
        UI.clear();

        boolean correctInput = false;
        while(!correctInput){
            UI.title("♞ ♘ Grupo 10 ~ Movimiento de caballo ♘ ♞");
            int columna = Scanner.getInt("\n\n->Ingrese la posicion inicial del caballo en el tablero \n > columna nro: ");
            int fila = Scanner.getInt(" >    fila nro: ");
            UI.clear();
            if(columna < 1 || fila < 1 || columna > 8 || fila > 8) {
                UI.message(" Ingrese un nro entre 1 y 8 como posicion");
            }else{
                Knight k = new Knight();
                UI.clear();
                k.knightMenu(new int[]{columna,fila});
                correctInput = true;
            }
        }
    }
}
