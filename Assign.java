package cse3341.keith;

import java.util.ArrayList;

public class Assign {
    private Id identifier;
    private Expression expression;
    public Assign() {
        identifier = null;
        expression = null;
        parseAssign();
    }
    private void parseAssign() {
        identifier = Id.parseId();
        //skip id
        Main.tokenizer.skipToken();
        //skip "="
        Main.tokenizer.skipToken();
        expression = new Expression();
        //skip ";"
        Main.tokenizer.skipToken();
    }

    void printAssign(){
        identifier.printIdentifier();
        System.out.print(" = ");
        expression.printExpression();
        System.out.println(";");
    }
    void execAssign(){
        identifier.setValue(expression.getToken());
    }
}
