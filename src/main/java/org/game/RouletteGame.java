package org.game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class RouletteGame {
    public static void main(String[] args) throws IOException {
        readFile();
    }

    public static void readFile() throws IOException {
        String fileName = "C:\\filepath\\test.txt"; //need to specify your local correct path
        File file = new File(fileName);
        FileReader inputFile = new FileReader(file);
        BufferedReader bufferReader = new BufferedReader(inputFile);
        String line = "";
        //String number;
        int index = 0, rouletteNum, number = 0, result;
        float amount = 0.0f;
        int  win = 0, lose = 0, spin = 0;
        double total = 0.0d;
        int resultArr[] = new int[36];
        Random generator = new Random();
        String[] column1 = new String[100];
        String[] column2 = new String[100];
        String[] column3 = new String[100];
        String[] outcome = new String[100];
        String[] winings = new String[100];
        rouletteNum = generator.nextInt(37);
        spin++;
        while ((line = bufferReader.readLine()) != null) {
            String temp = "";
            int count = 1;
            StringTokenizer st = new StringTokenizer(line, " ");
            //String tokenizer gets the token from each space
            while (st.hasMoreTokens()) {
                temp = st.nextToken();
                if (count == 1) {
                    column1[index] = temp;
                }
                if (count == 2) {
                    column2[index] = temp;
                }
                if (count == 3) {
                    amount = Float.parseFloat(temp);
                    column3[index] = String.valueOf(amount);
                    total=amount;
                }
                if (count < 3)
                    count++;
            }
            index++;
        }

        for (int i = 0; i < index; i++) {
            int choice=-1;

            if (column2[i].equalsIgnoreCase("EVEN")) {
                choice = 0;
            }
            if (column2[i].equalsIgnoreCase("ODD")) {
                choice = 1;
            }
            if (!(column2[i].equalsIgnoreCase("EVEN")) && !(column2[i].equalsIgnoreCase("ODD"))) {
               number=Integer.parseInt( column2[i]);
               if(number < 1 || number > 36)
               {
                   choice=3;
               }
               else
                choice = 2;
            }
            System.out.println("Roulette number: " + rouletteNum );
            if (choice == 2) {
                if (rouletteNum == Integer.parseInt(column2[i]))
                    result = 35;
                else
                    result = 0;
            } else {
                if (rouletteNum == 0 || rouletteNum==1 || (rouletteNum % 2 )== choice)
                    result = 1;
                else
                    result=0;
            }
            if (result > 0) {
                if (choice == 2) {
                    total = (result + 1) * Float.parseFloat(column3[i]) ;
                    win++;
                    resultArr[rouletteNum]++;
                    winings[i]= String.valueOf(total);
                }
                else{
                    if(choice==0 ||choice ==1)
                    {
                        total = (result + 1) * Float.parseFloat(column3[i]) + total;
                        win++;
                        resultArr[rouletteNum]++;
                        winings[i]= String.valueOf(total);
                    }
                    outcome[i]="Win";
                }
            } else {
                total = total - (result + 1) * (amount);
                lose++;
                resultArr[rouletteNum]++;
                outcome[i]="Lose";
                winings[i]= String.valueOf(total);
            }
        }
        System.out.format("%s\t\t%s\t\t%s\t\t%s\n", "PlayerName","Bet","OutCome","Winings");
        System.out.format("---------\n");
        for(int j=0;j<index;j++)
        {
            System.out.format("%s\t\t\t%s\t\t\t  %s\t\t\t%s\n", column1[j],column2[j],outcome[j],winings[j]);
        }
    }
}
