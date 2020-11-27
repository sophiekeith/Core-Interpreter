package cse3341.keith;

import java.util.ArrayList;

public class Out {
    IdList idListTokens;
    public Out() {
        idListTokens = null;
        parseOut();
    }

    private void parseOut() {
      //skip write
        Main.tokenizer.skipToken();
        idListTokens = new IdList();
        //skip ";"
        Main.tokenizer.skipToken();
    }

    void printOut(){
        System.out.print("write ");
        idListTokens.printIdList();
    }
    void execOut(){
        idListTokens.outIdList();
    }
}
