package Test.myStringTest;

import model.MyString;

public class TestTamanioString {

    public static void main(String[] args) {

        MyString myString = new MyString();

        String [] stringArray = {"Que", "taller", "tan", "largo", "GraciasProfe", ":D"};


        int pos = myString.posMayorString(stringArray);
        System.out.println(" La posición del elemento más largo es: " + pos
         +"\n Y el elemento que contiene es el siguiente: " + stringArray[pos]);


    }

}
