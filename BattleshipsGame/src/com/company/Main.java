package com.company;

import java.util.Scanner;
import java.util.Random;


public class Main {
    private static String special = "@";
    private static String specialcom = "#";
    private static Scanner input = new Scanner(System.in); //This line creates a Scanner for you to use
    private static Random rand = new Random();
    private static String[][] grid = new String[10][10];
    private static int nrOfShips = 2;
    private static int playerShips = nrOfShips;
    private static int computerShips = nrOfShips;
    private static Thread sleep = new Thread();


    public static void main(String[] args) throws InterruptedException {
        //hello window
        System.out.println("**** Welcome to battleships game! ****\n");
        System.out.println("Right now the sea is empty!\n");
        draw(grid);
        System.out.println();
        System.out.println();

        playerChoose();
        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println();
        draw(grid);
        System.out.println();
        System.out.println("--------------------------------------");
        Thread.sleep(1000);
        computerChoose();
        Thread.sleep(1000);
        System.out.println();
        System.out.println("--------------------------------------");
        playGame();


    }

    public static void draw(String[][] ocean) {
        System.out.print("  ");
        for (int i = 0; i < ocean[0].length; i++) {
            System.out.print(i);
        }
        System.out.println();
        for (int row = 0; row < ocean.length; row++) {
            System.out.print(row + "|");
            for (int col = 0; col < ocean[row].length; col++) {
                if (ocean[row][col] == null) {
                    System.out.print(" ");
                } else if (ocean[row][col] == specialcom){
                    System.out.print(" ");
                } else {
                    System.out.print(ocean[row][col]);
                }
            }
            System.out.println("|" + row);
        }
        System.out.print("  ");
        for (int i = 0; i < ocean[0].length; i++) {
            System.out.print(i);
        }
    }

    public static void playerTurn() {
        boolean status = true;
        while (status) {
            status = false;
            System.out.println("YOUR TURN");
            System.out.println("Enter X coordinate: ");
            int x = input.nextInt();
            System.out.println("Enter Y coordinate: ");
            int y = input.nextInt();
            if ((x < 0 || x > 9) || (y < 0 || y > 9)) {
                System.out.println("Out of bunds! Enter again!");
                status = true;
            } else if (grid[y][x] == null) {
                System.out.println("Sorry, you missed!");
                //System.out.println();
                grid[y][x] = "-";
                //draw(grid);
                status = false;
            } else if (grid[y][x] == special) {
                System.out.println("Oh no, you sunk your own ship :(");
                playerShips--;
                grid[y][x] = "x";
                //draw(grid);
                status = false;
            } else if (grid[y][x] == specialcom) {
                System.out.println("Boom! You sunk the ship!");
                computerShips--;
                grid[y][x] = "!";
                status = false;
            }
        }
    }

    public static void computerTurn() {
        boolean status = true;
        while (status) {
            status = false;
            //System.out.println();
            System.out.println("COMPUTER TURN");
            int x = rand.nextInt(10);
            int y = rand.nextInt(10);
            if (grid[y][x] == null) {
                System.out.println("Computer missed!");
                System.out.println();
                grid[y][x] = "-";
                //draw(grid);
                status = false;
            } else if (grid[y][x] == specialcom) {
                System.out.println("Computer sunk his own ship");
                computerShips--;
                System.out.println();
                grid[y][x] = "x";
                //draw(grid);
                status = false;
            } else if (grid[y][x] == special) {
                System.out.println("Boom! Computer sunk your ship!");
                playerShips--;
                System.out.println();
                grid[y][x] = "!";
                status = false;
            }
        }
    }

    public static void computerChoose() {
        int shipscmp = 1;
        System.out.println("Computer is deploying ships!");
        boolean statusCMP = true;
        while (statusCMP) {
            int x = rand.nextInt(10);
            int y = rand.nextInt(10);
            if (grid[y][x] == special) {
                statusCMP = true;
            } else {
                statusCMP = true;
                grid[y][x] = specialcom;
                System.out.println(shipscmp + ". ship DEPLOYED");
                shipscmp++;
                if (shipscmp > nrOfShips) {
                    statusCMP = false;
                    //System.out.println();
                    //System.out.println();
                    //draw(grid);
                }
            }
        }
    }

    public static void playerChoose() {
        int ships = 1;
        boolean status = true;
        while (status) {
            status = false;
            System.out.println("Enter X coordinate for your " + ships + " ship: ");
            int x = input.nextInt();
            System.out.println("Enter Y coordinate for your " + ships + " ship: ");
            int y = input.nextInt();
            if ((x < 0 || x > 9) || (y < 0 || y > 9)) {
                System.out.println("Wrong! Enter again!");
                status = true;
            } else if (grid[y][x] == special) {
                System.out.println("Wrong! Enter again!");
                status = true;
            } else {
                status = true;
                if (ships < nrOfShips) {
                    System.out.println("Good, next ...");
                }
                grid[y][x] = special;
                ships++;
                if (ships > nrOfShips) {
                    status = false;
                    //draw(grid);
                }
            }
        }
    }

    public static void playGame() throws InterruptedException {
        while (playerShips != 0 && computerShips != 0){
            //System.out.println();
            //System.out.println();
            playerTurn();
            System.out.println();
            System.out.println("------------------------------------------------------");
            Thread.sleep(1000);
            computerTurn();
            //System.out.println();
            //System.out.println();
            draw(grid);
            System.out.println();
            System.out.println();
            System.out.println("Your ships: " + playerShips + " |  Computer ships: "+ computerShips);
            System.out.println("-----------------------------------------------------------");
        }
        if (computerShips == 0) {
            System.out.println("Hooray you win!");
        } else {
            System.out.println("Loooser!");
        }

    }
}
