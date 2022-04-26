package model;

import java.util.Arrays;

public class Tarea {

    public static void main(String[] args) {

        int[][]matrix = new int [3][3];
        matrix[0]= new int[]{1, 1, 5};
        matrix[1]= new int[]{1, 2, 3};
        matrix[2]= new int[]{5, 3, 4};

        int [][] newMatrix = recorrerMatriz(matrix, '-', '+');

        for (int [] e : newMatrix) {
            System.out.println(Arrays.toString(e));
        }



    }

    public static int [][] recorrerMatriz (int [][] matriz, char instruccionFila, char instruccionColmuna){
        //Hay dos posibilidades, que instFila y instCol sean iguales "+" ó "-"

        int [][] newMatrix = new int[matriz.length][matriz[0].length];

        if (instruccionFila== '+' && instruccionColmuna== '+'){
            //Recorremos normalmente

            for (int i = 0, f=0; i < matriz.length; i++, f++) {
                for (int j = 0, c=0; j < matriz.length; j++, c++) {
                    newMatrix [f][c] = matriz[i][j];
                }
            }
        }


        if (instruccionFila== '+' && instruccionColmuna== '-'){
            //Recorremos aumentando filas y disminuyendo columnas
            for (int i = 0, f=0; i < matriz.length; i++, f++) {
                for (int j = matriz[i].length - 1, c=0; j >= 0; j--, c++) {
                    newMatrix [f][c] = matriz[i][j];
                }
            }

        }



        if (instruccionFila== '-' && instruccionColmuna== '+'){
            //Recorremos aumentando filas y disminuyendo columnas
            for (int i = matriz.length-1, f=0; i >= 0; i--, f++) {
                for (int j =0, c=0; j < matriz[i].length; j++, c++) {
                    newMatrix [f][c] = matriz[i][j];
                }
            }
        }



        if (instruccionFila== '-' && instruccionColmuna== '-'){
            //Recorremos disminuyendo filas y columnas.
            for (int i = matriz.length -1 , f=0; i >= 0; i--, f++) {
                for (int j = matriz[i].length-1, c=0; j >=0; j--, c++) {
                    newMatrix [f][c] = matriz[i][j];
                }
            }
        }

    return newMatrix;
    }

}
