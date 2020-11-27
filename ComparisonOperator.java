package cse3341.keith;

public class ComparisonOperator {
    String flag;
    public ComparisonOperator() {
        flag = "";
        parseComparisonOperator();
    }

    private void parseComparisonOperator() {
        //check operators
        if(Main.tokenizer.getTokenInt() == 25){
            flag ="!=";
        }else if (Main.tokenizer.getTokenInt() == 26){
            flag ="==";
        }else if (Main.tokenizer.getTokenInt() == 27){
            flag = "<";
        }else if (Main.tokenizer.getTokenInt() == 28){
            flag = ">";
        }else if (Main.tokenizer.getTokenInt() == 29){
            flag = "<=";
        }else{
            flag = ">=";
        }
        //skip token
        Main.tokenizer.skipToken();
    }
    void printComparisonOperator() {
        System.out.print(flag);
    }

    public String getOp() {
        return flag;
    }
}
