package cse3341.keith;

import cse3341.keith.Tokenizer.Tokenize;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    //assign public constructors
    //tab count, used for pretty print
    public static int tabCount;
    //date string used for variables
    public static String dataString;
    //create universal tokenizer
    public static Tokenize tokenizer = null;
    public static void main(String[] args) throws IOException {
        //create a Prog object and then call parseProg, etc.. on that object.
        //read its input from two files whose names will be specified as command line arguments.
        //  first is core program to be interpreted, second is data file
       if (args.length != 2){
            System.out.println("Invalid input");
        }
        else{
            String progFileName = args[0];
            String dataFileName = args[1];

            Path p1 = Paths.get(progFileName);
            Path p2 = Paths.get(dataFileName);

            String p1S = p1.toString();
            String p2S = p2.toString();


            Scanner programScanner = null;
            Scanner dataScanner = null;
            String programString = "";

            //uses Java's file class to create "file"
            File programFile = new File(p1S);
            File dataFile = new File(p2S);

            //Try to read file and put into String
            try {
                programScanner = new Scanner(programFile);
            } catch (FileNotFoundException e1) {
                // TODO Auto-generated catch block
                //e1.printStackTrace();
                System.out.println("Invalid");
            }
            while(programScanner.hasNext())
            {
                programString += programScanner.nextLine();
            }

            //Try to read data and put into string
            try {
                dataScanner = new Scanner(dataFile);
            } catch (FileNotFoundException e1) {
                // TODO Auto-generated catch block
                //e1.printStackTrace();
                System.out.println("Invalid");
            }
            while(dataScanner.hasNext())
            {
                dataString = "";
                dataString += dataScanner.nextLine();

            }

            //Assign tokenizer with program string
            try {
                tokenizer = new Tokenize(programString);
            } catch (IOException e1) { //if first token is invalid
               // e1.printStackTrace();
            }


            //Now, to begin the parsing, call parse program
            Prog program = new Prog();
            program.printProg();
            try{
                program.execProg();
            } catch (RuntimeException e3){
                System.out.print(e3.getMessage());
            }



        }
    }
}
