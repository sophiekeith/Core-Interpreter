package cse3341.keith;

import java.io.IOException;

public class StateSeq {
    private Statement statement;
    private StateSeq ss;
    public StateSeq(){
        statement = null;
        ss = null;
        parseStateSeq();
    }
    public void parseStateSeq(){
        statement = new Statement();
        //if statement coming from prog/if
        if (Main.tokenizer.getTokenInt()!=3 && Main.tokenizer.getTokenInt()!=7){
            ss = new StateSeq();
        }
    }
    void printStateSeq(){
        Tab.printTab();
        statement.printStatement();
        if (ss != null){
            ss.printStateSeq();
        }
    }
    void execStateSeq() throws IOException {
        statement.execStatement();
        if (ss != null){
            ss.execStateSeq();
        }
    }
}
