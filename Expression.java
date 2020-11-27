package cse3341.keith;

import java.util.ArrayList;

public class Expression {
    Factor factor;
    Expression expression;
    int flag;
    public Expression() {
        factor = null;
        expression = null;
        flag = 0;
        parseExpression();
    }

    private void parseExpression() {
       factor = new Factor();
       //check to see if "+" or "-"
        if(Main.tokenizer.getTokenInt() == 22){
            //skip "+"
            Main.tokenizer.skipToken();
            expression = new Expression();
            flag = 1;
        }
        else if (Main.tokenizer.getTokenInt() == 23){
            //skip "-"
            Main.tokenizer.skipToken();
            expression = new Expression();
            flag = 2;
        }
    }

    public int getToken(){
        if (expression == null) {
            return factor.getToken();
        } else {
            if (flag ==1) {
                return factor.getToken() + expression.getToken();
            } else if (flag == 2) {
                return factor.getToken() - expression.getToken();
            }
        }

        return 0;

    }
    void printExpression(){
        if (factor!=null){
            factor.printFactor();
        }
        if (flag ==1){
            System.out.print("+");
        }
        if (flag == 2){
            System.out.print("-");
        }
        if (expression != null){
            expression.printExpression();
        }
    }
}
