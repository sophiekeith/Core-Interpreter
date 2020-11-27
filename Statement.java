package cse3341.keith;

import java.io.IOException;

public class Statement {
    private Assign assign;
    private If ifTerminal;
    private Loop loop;
    private In in;
    private Out out;
    //flag for alternative
    private int flag;
    public Statement() {
        assign = null;
        ifTerminal = null;
        loop = null;
        in = null;
        out = null;
        flag = 0;
        parseStatement();
    }
    private void parseStatement(){
        if (Main.tokenizer.getTokenInt() == 5){
            ifTerminal = new If();
            flag =2;

        }
        else if (Main.tokenizer.getTokenInt() == 8){
            loop = new Loop();
            flag =3;
        }
        else if (Main.tokenizer.getTokenInt() == 10){
            in = new In();
            flag = 4;
        }
        else if (Main.tokenizer.getTokenInt() == 11){
            out  = new Out();
            flag =5;
        }
        else {
            assign = new Assign();
            flag =1;
        }
    }

    void printStatement(){
        if (flag == 1){
            assign.printAssign();
        }
        else if (flag == 2){
            ifTerminal.printIf();
        }
        else if (flag == 3){
            loop.printLoop();
        }else if(flag == 4){
            in.printIn();
        }else{
            out.printOut();
        }
    }

    void execStatement() throws IOException {
        if (flag == 1){
            assign.execAssign();
        }
        else if (flag == 2){
            ifTerminal.execIf();
        }
        else if (flag == 3){
            loop.execLoop();
        }else if(flag == 4){
            in.execIn();
        }else{
            out.execOut();
        }
    }
}
