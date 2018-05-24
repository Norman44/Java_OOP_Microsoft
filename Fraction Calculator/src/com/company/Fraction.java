package com.company;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator){
        if (denominator == 0) {
            throw new IllegalArgumentException("Make denominator negative or positive!");
        } else if (denominator < 0) {
            this.denominator = denominator * (-1);
            this.numerator = numerator * (-1);
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    public Fraction(int numerator){
        this(numerator, 1);
    }

    public Fraction(){
        this(0,1);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public String toString() {
        if (this.numerator == 0)
            return "0";
        else
            return this.numerator + "/" + this.denominator;
    }

    public double toDouble(){
        return (this.numerator * 1.0)/this.denominator;
    }

    public Fraction add(Fraction other){
        int num, den;
        if (this.denominator == other.denominator) {
            den = this.denominator;
            num = this.numerator + other.numerator;
        }else{
            den = this.denominator * other.denominator;
            num = (this.numerator * other.denominator) + (other.numerator * this.denominator);
        }
        Fraction fr = new Fraction(num, den);
        return fr;
    }

    public Fraction subtract(Fraction other) {
        int num, den;
        if (this.denominator == other.denominator) {
            den = this.denominator;
            num = this.numerator - other.numerator;
        }else{
            den = this.denominator * other.denominator;
            num = (this.numerator * other.denominator) - (other.numerator * this.denominator);
        }
        Fraction fr = new Fraction(num, den);
        return fr;
    }

    public Fraction multiply(Fraction other) {
        int num, den;
        num = this.numerator * other.numerator;
        den = this.denominator * other.denominator;
        Fraction fr = new Fraction(num, den);
        return fr;
    }

    public  Fraction divide(Fraction other) {
        int num, den;
        if (other.numerator == 0){
            throw new IllegalArgumentException("No devision with zero!");
        }
        num = this.numerator * other.denominator;
        den = this.denominator * other.numerator;
        Fraction fr = new Fraction(num, den);
        return fr;
    }

    public boolean equals(Object other) {
//        must take in an "Object" to properly override the Object
//        class's equals method, but should ultimately check if two fractions are equal
        if(other instanceof Fraction){
            return (this.numerator*((Fraction) other).denominator==((Fraction) other).numerator*this.denominator);
        } else {
            return false;
        }
    }

    public void toLowestTerms(){
        int rem = gcd(this.numerator,this.denominator);
        this.numerator = this.numerator / rem;
        this.denominator = this.denominator / rem;
    }

    public int gcd(int num, int den){
        while (num != 0 && den != 0) {// a and b are not zero
            int rem = num % den; //find the remainder of a divided by b
            num = den; // set a to b
            den = rem; // set b to the remainder you found
        }
        return num;
    }
}
