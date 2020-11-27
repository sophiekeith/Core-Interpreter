package cse3341.keith.Tokenizer;
import java.io.*;
import java.util.StringTokenizer;

public class Tokenize {
    //of the tokens left
    private String tokenizeString;
    //current token
    private String currentToken;
    //current token, if int;
    private int currentTokenInt;
    //use tokenizer class of Java
    private StringTokenizer stringTokenize;
    //next token - needs to be empty, not null.
    private String nextToken = "";
    //boolean to say if tokens left
    private boolean remainTokens = true;

    //create the tokens
    public Tokenize(String inputFile) throws IOException
    {
        //Read in file
        tokenizeString = inputFile;
        //use java tokenizer to "tokenize"
        stringTokenize = new StringTokenizer(tokenizeString);
       //skip the first token
        skipToken();
    }

    //end of tokens
    private void noTokensRemain(){
        //no tokens left, string empty
        currentToken = "";
        //represents EOF
        currentTokenInt = 33;
        //reset boolean
        remainTokens = false;
    }
    //get the current token
    public String getToken(){
        return currentToken;
    }
    //get the integer value of the token
    public int getTokenInt(){
        return currentTokenInt;
    }
    //are there still tokens left?
    public boolean remainTokens(){
        return remainTokens;
    }

    //get the next token
    public void skipToken() {
        //this will be used for parsing
        //first check that not at end
        //next token is not blank and has been assigned
        if( nextToken != "" ){
            //reassign current token
            currentToken = nextToken;
            //make next token blank
            nextToken = "";
            //check the current token
            checkToken();
            //assign the current tokens int value
            setTokenToInt();
            //check that its not invalid
            if (currentTokenInt == -1){
                System.out.println("inlvalid token");
            }
        }
        else if (!stringTokenize.hasMoreTokens()){

            noTokensRemain();
        }
        //many tokens remain and hasnt been assigned
        else{
            currentToken = stringTokenize.nextToken();
            //check current token
            checkToken();
            //assign the current tokens int value
            setTokenToInt();
            //check that its not invalid
            if (currentTokenInt == -1){
                System.out.println("inlvalid token");
            }

        }

    }
    //used to accordingly check the token
    private void checkToken(){
        //this checks identifier, should be uppercase followed by digits
        if (Character.isUpperCase(currentToken.charAt(0)))
        {
            int currentChar = 1;
            //go until end of token or no more uppercase
            while(currentChar < currentToken.length() && Character.isUpperCase(currentToken.charAt(currentChar)))
            {
                currentChar++;
            }
            //go until end of token or no more digits
            while(currentChar < currentToken.length() && Character.isDigit(currentToken.charAt(currentChar)))
            {
                currentChar++;
            }
            //if not at end of token, reassign the current token and the next token
            if(currentChar != currentToken.length())
            {
                //the next token is the length of end of digit/letter to the end of token
                nextToken = currentToken.substring(currentChar, currentToken.length());
                //the current token is from beginning of token to the end of digit/letter
                currentToken = currentToken.substring(0, currentChar);
            }
        }
        //here, not upper case, but lower case, meaning keyword
        else if (Character.isLowerCase(currentToken.charAt(0))){
            int currentChar = 1;
            //this check that current char is less than length of token and is lowercase throughout
            while (currentChar < currentToken.length() && Character.isLowerCase(currentToken.charAt(currentChar))){
                currentChar++;
            }
            //if not at end of token, reassign the current token and the next token
            if(currentChar != currentToken.length())
            {
                //the next token is the length of end of digit/letter to the end of token
                nextToken = currentToken.substring(currentChar, currentToken.length());
                //the current token is from beginning of token to the end of digit/letter
                currentToken = currentToken.substring(0, currentChar);
            }
        }
        //here, we check to see if token is an integer
        else if(Character.isDigit(currentToken.charAt(0))){
            int currentChar = 1;
            while (currentChar < currentToken.length() && Character.isDigit(currentToken.charAt(currentChar))){
                currentChar++;
            }
            //if not at end of token, reassign the current token and the next token
            if(currentChar != currentToken.length())
            {
                //the next token is the length of end of digit/letter to the end of token
                nextToken = currentToken.substring(currentChar, currentToken.length());
                //the current token is from beginning of token to the end of digit/letter
                currentToken = currentToken.substring(0, currentChar);
            }
        }
        //last check, does it have a symbol
        else if(isSymbol(currentToken.charAt(0))){
            checkSymbol();
        }
    }

    //checks the symbols
    private void checkSymbol() {
        //handle "||"
        if (currentToken.charAt(0) == '|') {
            if (currentToken.length() > 2 && currentToken.charAt(1) == '|') {
                //the next token is the length of end of digit/letter to the end of token
                nextToken = currentToken.substring(2, currentToken.length());
                //the current token is from beginning of token to the end of digit/letter
                currentToken = currentToken.substring(0, 2);
            }
        }
        //handle "&&"
        else if (currentToken.charAt(0) == '&') {
            if (currentToken.length() > 2 && currentToken.charAt(1) == '&') {
                //the next token is the length of end of digit/letter to the end of token
                nextToken = currentToken.substring(2, currentToken.length());
                //the current token is from beginning of token to the end of digit/letter
                currentToken = currentToken.substring(0, 2);
            }
        }
        //handle other symbols that are double
        else if (currentToken.charAt(0) == '=' || currentToken.charAt(0) == '!' || currentToken.charAt(0) == '>' || currentToken.charAt(0) == '<') {
            //make sure size 2
            if (currentToken.length() >= 2) {
                //meaning == != >= <=
                if (currentToken.charAt(1) == '=') {
                    //here, it would be a combo token- split
                    if (currentToken.length() > 2) {
                        nextToken = currentToken.substring(2, currentToken.length());
                    }
                    //assign current token to the first two, since, combo is handled
                    currentToken = currentToken.substring(0, 2);
                }


                //meaning just single token
                else {
                    nextToken = currentToken.substring(1, currentToken.length());
                    currentToken = currentToken.substring(0, 1);
                }
            }
        }
        //every other single symbol
        else{
            if(currentToken.length() > 1)
            {
                nextToken = currentToken.substring(1, currentToken.length());
                currentToken = currentToken.substring(0,1);
            }
        }
    }

    //this method returns if that char is actually a symbol
    private boolean isSymbol(char symbol){
        if(symbol == ';' || symbol == ',' || symbol == '=' || symbol == '!' || symbol == ']' || symbol == '[' || symbol == '&' || symbol =='|' || symbol == '(' || symbol == ')' || symbol == '+' || symbol == '-' ||  symbol == '*' || symbol =='<' || symbol == '>')
        {
            return true;
        }
        else {
            return false;
        }
    }
    //check to see if int is an int
    private boolean isInt(String token){
        boolean isInt = true;
        //try to parse
        try{
            Integer.parseInt(token);
        }catch(NumberFormatException error){
            isInt = false;
        }
        return isInt;
    }
    //return true if its actually an id
    private boolean isId(String token){
        //boolean to check if upper case
        boolean upCase = true;
        //make sure first char is upper
        if(!Character.isUpperCase(token.charAt(0))) {
            return false;
        }
        //loop through whole token
        for(int i = 0; i < token.length(); i++)
        {
            //if not upper case, check why
            if(upCase == false)
            {
                //not upper case and not a digit
                if(!Character.isDigit(token.charAt(i)))
                {
                    return false;
                }
            }
            //not an uppercase, change boolean
            else if(!Character.isUpperCase(token.charAt(i)))
            {
                upCase = false;
                //again, not an upper case and not a digit
                if(!Character.isDigit(token.charAt(i))){
                    return false;
                }
            }
        }
        return true;
    }
    private void setTokenToInt(){
        //its an id
        if (isId(currentToken)){
            currentTokenInt = 32;
        }
        //its an int
        else if (isInt(currentToken)){
            currentTokenInt = 21;
        }
        else {
            switch (currentToken){
                //use a switch statement to assign keywords and symbols
                    case "program":
                        currentTokenInt = 1;
                        break;
                    case "begin":
                        currentTokenInt = 2;
                        break;
                    case "end":
                        currentTokenInt = 3;
                        break;
                    case "int":
                        currentTokenInt = 4;
                        break;
                    case "if":
                        currentTokenInt = 5;
                        break;
                    case "then":
                        currentTokenInt = 6;
                        break;
                    case "else":
                        currentTokenInt = 7;
                        break;
                    case "while":
                        currentTokenInt = 8;
                        break;
                    case "loop":
                        currentTokenInt = 9;
                        break;
                    case "read":
                        currentTokenInt = 10;
                        break;
                    case "write":
                        currentTokenInt = 11;
                        break;
                    case ";":
                        currentTokenInt = 12;
                        break;
                    case ",":
                        currentTokenInt = 13;
                        break;
                    case "=":
                        currentTokenInt = 14;
                        break;
                    case "!":
                        currentTokenInt = 15;
                        break;
                    case "[":
                        currentTokenInt = 16;
                        break;
                    case "]":
                        currentTokenInt = 17;
                        break;
                    case "&&":
                        currentTokenInt = 18;
                        break;
                    case "||":
                        currentTokenInt = 19;
                        break;
                    case "(":
                        currentTokenInt = 20;
                        break;
                    case ")":
                        currentTokenInt = 21;
                        break;
                    case "+":
                        currentTokenInt = 22;
                        break;
                    case "-":
                        currentTokenInt = 23;
                        break;
                    case "*":
                        currentTokenInt = 24;
                        break;
                    case "!=":
                        currentTokenInt = 25;
                        break;
                    case "==":
                        currentTokenInt = 26;
                        break;
                    case "<":
                        currentTokenInt = 27;
                        break;
                    case ">":
                        currentTokenInt = 28;
                        break;
                    case "<=":
                        currentTokenInt = 29;
                        break;
                    case ">=":
                        currentTokenInt = 30;
                        break;
                    //here, invalid token
                    default:
                        currentTokenInt = -1;
                        break;
            }
        }
    }

}