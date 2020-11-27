package cse3341.keith;

public class Operator {
    Integer intConstruct;
    Id idConstruct;
    Expression expression;
    int flag;
    public Operator() {
        intConstruct = null;
        idConstruct = null;
        expression = null;
        flag = 0;
        parseOperator();
    }

    private void parseOperator() {
       if(Main.tokenizer.getTokenInt() == 20){
           flag = 1;
           //skip "("
           Main.tokenizer.skipToken();
           expression = new Expression();
           //skip ")"
           Main.tokenizer.skipToken();
       } else if (Main.tokenizer.getToken().matches("\\d*") ) {
           flag = 2;

           System.out.println(Main.tokenizer.getToken());
           intConstruct = Integer.valueOf(Main.tokenizer.getToken());
           //skip int
           Main.tokenizer.skipToken();
       }
       else{
           flag = 3;
           System.out.println(Main.tokenizer.getToken());
           //call parseId class on this construct because it returns, not just creates
           idConstruct = Id.parseId();
           //skip id
           Main.tokenizer.skipToken();
       }
    }
    public int getToken(){
        if (intConstruct != null){
            return intConstruct;
        }
        else if (idConstruct != null){
            return idConstruct.getValue();
        }
        else if (expression != null){
            return expression.getToken();
        }
        return 0;
    }
    void printOperator(){
        if (intConstruct!= null){
            System.out.println(intConstruct + ";");
        }
        if (idConstruct != null){
            idConstruct.printIdentifier();
        }
        if (expression != null){
            System.out.print("(");
            expression.printExpression();
            System.out.print(")");
        }
    }
}
