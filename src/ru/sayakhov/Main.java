package ru.sayakhov;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int a;
        int n = 0;

        try (FileReader fr = new FileReader(new File("F:\\JAVA\\git-eduard.sd\\HW19\\products.txt"))) {
            while ((a = fr.read()) != -1) {
                sb.append((char) a);
            }
            String newText = sb.toString();
            String[] arrayText = newText.split("\n");
            String[][] newarray = new String[(arrayText.length) / 3][3];

            for (int i = 0; i < arrayText.length / 3; i++) {
                for ( int j = 0; j < 3; j++ ) {
                    newarray[i][j] = arrayText[n++];
                }
            }
            double totalPrice = 0;
            System.out.printf("%-20s%-12s%-15s%-5s%n", "Наименование", "Цена", "Количество", "Стоимость");
            System.out.println("-------------------------------------------------------");
            for ( int i = 0; i < newarray.length; i++ ) {
                    //System.out.println(newarray[i][0]+newarray[i][1]+newarray[i][2]);
                    System.out.print(String.format("%-15.25s%10.2f%5s%10.2f%5s%10.2f%n", newarray[i][0], Double.parseDouble(newarray[i][1]), "X", Double.parseDouble(newarray[i][2]), "=", (Double.parseDouble(newarray[i][1]) * Double.parseDouble(newarray[i][2]))));
                    totalPrice += (Double.parseDouble(newarray[i][1]) * Double.parseDouble(newarray[i][2]));

            }
            System.out.println("-------------------------------------------------------");
            System.out.print(String.format("%5s%48.2f", "Total: ", totalPrice));
        }catch ( IOException ex){ex.printStackTrace();}
    }
}
