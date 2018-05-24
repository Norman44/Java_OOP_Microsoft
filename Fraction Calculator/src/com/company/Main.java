package com.company;

import java.util.Scanner;
//import com.company.Fraction;

public class Main {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        hello();

        while (true) {
            //Fraction x = new Fraction();
            String op = getOperation(input);
            if (op.equals("Q")) {
                System.out.println("Ëxit king!");
                break;
            }
            Fraction first = getFraction(input);
            Fraction second = getFraction(input);
            Fraction x;
            switch (op) {
                case "+":
                    x = first.add(second);
                    System.out.println(first + " + " + second + " = " + x);
                    break;
                case "-":
                    x = first.subtract(second);
                    System.out.println(first + " - " + second + " = " + x);
                    break;
                case "*":
                    x = first.multiply(second);
                    System.out.println(first + " * " + second + " = " + x);
                    break;
                case "/":
                    x = first.divide(second);
                    System.out.println(first + " / " + second + " = " + x);
                    break;
            }
        }
    }

    private static void hello() {
        System.out.println("This program is a fraction calculator");
        System.out.println("It will add, substract, multiply and divide");
        System.out.println("Enter fractions in form of (a/b) a and b are intigers");
    }

    private static String getOperation(Scanner input) {
        String[] operations = {"+", "-", "/", "*", "Q"};
        System.out.println("-----------------------------------------------------------------");
        System.out.print("Please enter an operation (+,-,/,*,= or Q to quit): ");
        String ip = input.nextLine();
        while (true) {
            for (String operation : operations) {
                String s = ip.toUpperCase();
                if (operation.equals(s)) {
                    return s;
                }
            }
            System.out.print("Invalid input (+,-,/,*,= or Q to quit): ");
            ip = input.nextLine();
        }
    }

    public static boolean validFraction(String input) {
//        System.out.print("Please enter a fraction (a/b) or integer (a): ");
//        String ip = input.nextLine();
        if (input.contains("/")) {
            String num = input.substring(0, input.indexOf('/'));
            String den = input.substring(input.indexOf('/') + 1);
            if (isNumber(num) && isNumber(den)) {
                return !(Integer.parseInt(den) == 0);
            } else {
                return false;
            }
        } else {
            return isNumber(input);
        }
    }

    private static boolean isNumber(String s) {
        return s.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    private static Fraction getFraction(Scanner input) {
        Fraction object = null;
        System.out.print("Please enter a fraction (a/b) or integer (a): ");
        String ip = input.nextLine();
        while (true) {
            if (ip.contains("/")) {
                String num = ip.substring(0, ip.indexOf('/'));
                String den = ip.substring(ip.indexOf('/') + 1);
                if (isNumber(num) && isNumber(den)) {
                    if (!(Integer.parseInt(den) == 0)) {
                        object = new Fraction(Integer.parseInt(num), Integer.parseInt(den));
                    }
                }
            } else {
                if (isNumber(ip)) {
                    int tmp = Integer.parseInt(ip);
                    if (tmp == 0) {
                        object = new Fraction();
                    } else {
                        object = new Fraction(tmp);
                    }
                }
            }

            if (object != null)
                return object;
            else {
                System.out.print("Invalid fraction! Please enter a fraction (a/b) or integer (a): ");
                ip = input.nextLine();
            }
        }

    }
}
