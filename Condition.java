package cse3341.keith;

import java.util.ArrayList;

public class Condition {
    Comparison comparison;
    Condition firstCondition;
    Condition secondCondition;
    int flag;

    public Condition() {
        comparison = null;
        firstCondition = null;
        secondCondition = null;
        flag = 0;
        parseCondition();
    }

    private void parseCondition() {
        //check to see if first token fits comparison
        if(Main.tokenizer.getTokenInt()== 20){
            //skip "("
            Main.tokenizer.skipToken();
            flag = 1;
            comparison = new Comparison();
        }
        else if (Main.tokenizer.getTokenInt()==15){
            //skip "!"
            Main.tokenizer.skipToken();
            flag =2;
            firstCondition = new Condition();
        }
        else{
            //skip "["
            Main.tokenizer.skipToken();
            firstCondition = new Condition();
            //check to see if && or |||
            if (Main.tokenizer.getTokenInt() == 18){
                //skip &&
                Main.tokenizer.skipToken();
                secondCondition = new Condition();
                //skip "]"
                Main.tokenizer.skipToken();
                flag =3;
            }
            else{
                //skip ||
                Main.tokenizer.skipToken();
                secondCondition = new Condition();
                //skip "]"
                Main.tokenizer.skipToken();
                flag = 4;
            }
        }
    }
    void printCondition(){
        if (flag ==2) {
            System.out.print("!");
        }
        if (flag ==3) {
            System.out.print("[");
            firstCondition.printCondition();
            System.out.print("&&");
            secondCondition.printCondition();
            System.out.print("]");
        } else if (flag == 4) {
            System.out.print("[");
            firstCondition.printCondition();
            System.out.print("||");
            secondCondition.printCondition();
            System.out.print("]");
        } else {
            if (firstCondition != null) {
                firstCondition.printCondition();
            } else {
                comparison.printComparison();
            }
        }
    }
    public boolean evalCondition(){
        if (flag ==3) {
            return (firstCondition.evalCondition() && secondCondition.evalCondition());
        } else if (flag ==4) {
            return (firstCondition.evalCondition() || secondCondition.evalCondition());
        } else {
            if (firstCondition != null) {
                return firstCondition.evalCondition();
            } else {
                return comparison.evalComparison();
            }
        }
    }
}
