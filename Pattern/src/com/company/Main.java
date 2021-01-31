package com.company;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.io.*;

class InvalidemailException extends Exception{
    private String detail;
    InvalidemailException(String detail)
    {
        this.detail = detail;
    }

    @Override
    public String toString()
    {
        return "Invalid email address exception caught: " + detail;
    }

}
class InValidPasswordException extends Exception{
    private String detail;
    InValidPasswordException(String detail)
    {
        this.detail = detail;
    }

    @Override
    public String toString()
    {
        return "Invalid password exception caught: " + detail;
    }
}


public class Main {
    static void emailvalidation() throws InvalidemailException {
        String email;
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter your email address: ");
        email = obj.nextLine();
        if (!Pattern.matches("[!-~]+@[A-Za-z]+(\\.[a-zA-z0-9]+)*(\\.[A-Za-z]{2,})$", email)) {
            throw new InvalidemailException(email);
        }
        else
            System.out.println("Your email is valid.");
    }
    static void Passwordvalidation() throws InValidPasswordException {
        String pass;
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter your password: ");
        pass = obj.nextLine();
        if (!Pattern.matches("(?=.[a-z])(?=.[0-9])(?=.[A-Z])(?=.[!@#$%]+)[a-zA-Z0-9!@#$%]+.{7,20}", pass)) {
            throw new InValidPasswordException(pass);
        }
        else
            System.out.println("Your password is valid.");
    }
    public static void main(String[] args) {
        // write your code here
        //  System.out.println(Pattern.matches("(?=.[a-z])(?=.[0-9])(?=.[A-Z])(?=.[!@#$%])[a-zA-Z0-9!@#$%]+.{8,}","awaistalhaA!2"));
        try {
            Main.emailvalidation();
        }
        catch (InvalidemailException e)
        {
            System.out.println(e);
        }
        try{
            Main.Passwordvalidation();
        }catch (InValidPasswordException e)
        {
            System.out.println(e);
        }
        // System.out.println(Pattern.matches("[!-~]+@[A-Za-z]+(\\.[a-zA-z0-9]+)*(\\.[A-Za-z]{2,})$", "awaistopper20@gmail.net"));
    }
}