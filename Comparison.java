package cse3341.keith;

import java.util.ArrayList;

public class Comparison {
    Operator firstOperator;
    Operator secondOperator;
    ComparisonOperator compOperator;
    public Comparison() {
        firstOperator = null;
        secondOperator = null;
        compOperator = null;
        parseComparison();
    }

    private void parseComparison() {
        firstOperator = new Operator();
        compOperator = new ComparisonOperator();
        secondOperator = new Operator();
        //skip ")"
        Main.tokenizer.skipToken();
    }

    void printComparison() {
        System.out.print("(");
        firstOperator.printOperator();
        compOperator.printComparisonOperator();
        secondOperator.printOperator();
        System.out.print(")");
    }
    public boolean evalComparison() {
        Boolean result = false;
        if (compOperator.getOp() == "==") {
            result = firstOperator.getToken() == secondOperator.getToken();
        } else if (compOperator.getOp() == "!=") {
            result = firstOperator.getToken() != secondOperator.getToken();
        } else if (compOperator.getOp() == "<") {
            result = firstOperator.getToken() < secondOperator.getToken();
        } else if (compOperator.getOp() == ">") {
            result = firstOperator.getToken() > secondOperator.getToken();
        } else if (compOperator.getOp() == "<=") {
            result = firstOperator.getToken() <= secondOperator.getToken();
        } else if (compOperator.getOp() == ">=") {
            result = firstOperator.getToken() >= secondOperator.getToken();
        }

        return result;
    }
}
