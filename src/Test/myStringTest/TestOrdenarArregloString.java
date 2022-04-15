package Test.myStringTest;

import model.MyString;

import java.util.Arrays;

public class TestOrdenarArregloString {


    public static void main(String[] args) {

       MyString myString = new MyString();

       String [] strArray = {"wmb","zab","cba", "cab", "cab", "acb", "abc"};

       System.out.println("Arreglo sin ordernar:\n "+ Arrays.toString(strArray) +"\n");

       strArray = myString.ordenarAscendentemente(strArray);
       System.out.println("Arreglo ordenado"+ Arrays.toString(strArray) +"\n");

       strArray = myString.ordernarDescendentemente(strArray);
       System.out.println("Arreglo ordenado a la inversa" + Arrays.toString(strArray) );



    }
}
