package com.javarush.task.task34.task3413;

import java.util.Scanner;

public class Player {
        public static void main(String args[]) {
            Scanner in = new Scanner(System.in);

            // game loop
            int max = 0;
            int maxi = 0;
            while (true) {
                for (int i = 0; i < 8; i++) {
                    int mountainH = in.nextInt(); // represents the height of one mountain.
                    if(mountainH >= max){
                        max = mountainH;
                        maxi = i;
                    }
                }


                // Write an action using System.out.println()
                // To debug: System.err.println("Debug messages...");

                System.out.println(maxi); // The index of the mountain to fire on.
            }
        }

}
