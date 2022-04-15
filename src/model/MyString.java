package model;

public class MyString {

    final char[] VOCALES = {'a', 'e', 'i', 'o', 'u'};

    public int posMayorString(String[] array) {

        int largerSize = 0; //Tamaño del arreglo más largo. Va cambiando a lo largo del ciclo.
        int index = -1; //posición del elemento de mayor tamaño.

        for (int i = 0; i < array.length; i++) {

            int aux = array[i].length();

            if (aux > largerSize) {
                largerSize = aux;
                index = i;
            }
        }
        return index;
    }


    //----------------------------------PUNTO 10------------------------------------------------//

    public String[] ordenarAscendentemente(String[] strArray) {

        String[] sortedArray = strArray;

        int i, j;
        String temp = "";

        for (i = 0; i < strArray.length - 1; i++) {
            for (j = 0; j < strArray.length - 1 - i; j++) {
                if ((strArray[j].compareToIgnoreCase(strArray[j + 1])) > 0) {

                    temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = temp;
                }
            }
        }
        return sortedArray;
    }

    public String[] ordernarDescendentemente(String[] strArray) {

        String[] sortedArray = strArray;

        int i, j;
        String temp = "";

        for (i = 0; i < sortedArray.length - 1; i++) {
            for (j = 0; j < sortedArray.length - 1 - i; j++) {
                if ((strArray[j].compareToIgnoreCase(strArray[j + 1])) < 0) {

                    temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = temp;
                }
            }
        }
        return sortedArray;
    }

    /*----------------------------- PUNTO 11 ---------------------------------- */

    public char[] ordenarSegunVocales(String str) {

        String lowerCaseStr = str.toLowerCase();

        char[] charArray = lowerCaseStr.toCharArray(); // String hecho arreglo.
        char[] sortedArray = new char[charArray.length]; //Arreglo a llenar.

        for (int i = 0, j = sortedArray.length - 1, k=0; i < sortedArray.length; i++) {

            if (esVocal(charArray[i])) {
                sortedArray[k] = charArray[i];
                k++;
            } else {
                sortedArray[j] = charArray[i];
                j--;
            }
        }

        return sortedArray;
    }

    public boolean esVocal(char c) {

        for (int i = 0; i < VOCALES.length; i++) {
            if (c == VOCALES[i])
                return true;
        }
        return false;
    }


}


