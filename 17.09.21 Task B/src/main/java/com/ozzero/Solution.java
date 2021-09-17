package com.ozzero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    
    static class Seat{
        int x;
        String side;
        String position;

        Seat(int x, String s, String p) {
            this.x = x;
            side = s;
            position = p;
        }
    } 

    static List<char[]> plane = new ArrayList<>();
    static List<Seat> lst = new ArrayList<>();
    public static void main( String[] args )
    {


        Scanner s = new Scanner(System.in);

        int n = Integer.parseInt(s.nextLine());
        for(int i = 0; i < n; i++) {
            plane.add(s.nextLine().toCharArray());
        }

        int t = s.nextInt();
        for(int i = 0; i < t; i++) {
            int count = s.nextInt();
            String side = s.next();
            String prefer = s.next();

            calcPlace(count, side, prefer);
        }


    }

    public static void calcPlace(int count, String side, String prefer) {
        
        int seat = -1;
        boolean step = false; // true - вправо, false - влево

        if (side.equals("left") && prefer.equals("window")) {
            seat = 0;
            step = true;
        }

        if (side.equals("right") && prefer.equals("window")) {
            seat = 6;
            step = false;
        }
        if (side.equals("left") && prefer.equals("aisle")) {
            seat = 2;
            step = false;
        }
        if (side.equals("right") && prefer.equals("aisle")) {
            seat = 4;
            step = true;
        }
        

        for(int i = 0; i < plane.size(); i++) {
            if(plane.get(i)[seat] == '.') {
                boolean flag = false;
                for (int j = 0; j < count; j++){
                    if(plane.get(i)[step ? (seat + j) : (seat - j)] == '#') {
                        flag = true;
                        break;
                    }
                }
                if (flag == true)
                    continue;
                
                System.out.print("Passengers can take seats:");
                String number = Integer.toString(i + 1);    
                String[] seats = new String[count];
                for(int j = 0; j < count; j++){
                    char letter = 'A';
                    int t = step ? (seat + j) : (seat - j);
                    switch(t) {
                        case 0: 
                            letter = 'A';
                            break;
                        case 1:
                            letter = 'B';
                            break;
                        case 2:
                            letter = 'C';
                            break;
                        case 4:
                            letter = 'D';
                            break;
                        case 5:
                            letter = 'E';
                            break;
                        case 6:
                            letter = 'F';
                            break;
                    }

                    seats[j] = number + letter;

                    plane.get(i)[t] = 'X';
                }

                Arrays.sort(seats);

                for(String now : seats) {
                    System.out.print(" " + now);
                }
                System.out.println();
                printPlane();
                removeX(i);
                return;

            }
        }
        System.out.println("Cannot fulfill passengers requirements");
    } 


    public static void printPlane(){
        for(char[] now : plane){
            System.out.println(new String(now));
        }
    }

    public static void removeX(int n){
        char[] now = plane.get(n);
        for(int i = 0; i < now.length; i++){
            if (now[i] == 'X')
                now[i] = '#';
        }
    }
}
