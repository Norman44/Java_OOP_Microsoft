package com.company;

public class Main {

    public static void main(String[] args) {

        String[][] ocean = new String[10][10];
	    for (int row = 0; row < ocean.length; row++){
	        System.out.print(row + "|");
	        for (int col =0; col<ocean[row].length;col++){
	            if(ocean[row][col]==null){
	                System.out.print(" ");

                }else {
	                System.out.print(ocean[row][col]);
                }
            }
            System.out.println("|" + row);
        }

    }
}
