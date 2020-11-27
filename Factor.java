package cse3341.keith;

import java.util.ArrayList;

public class Factor {
    Operator operator;
    Factor factor;
    int flag;
    public Factor() {
        operator = null;
        factor = null;
        flag = 0;
        parseFactor();
    }

    private void parseFactor() {
        operator = new Operator();
        if (Main.tokenizer.getTokenInt()==24){
            //skip "*"
            Main.tokenizer.skipToken();
            factor = new Factor();
            flag = 1;
        }
    }
    public int getToken(){
        if (flag == 1){
            return operator.getToken()*factor.getToken();
        }else{
            return operator.getToken();
        }
    }

    void printFactor(){
        if (operator != null){
            operator.printOperator();
        }
        if (flag == 1){
            System.out.print("*");
        }
        if (factor != null){
            factor.printFactor();
        }

    }


}
