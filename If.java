package cse3341.keith;

import java.io.IOException;

public class If {
    private Condition condition;
    private StateSeq afterIf;
    private StateSeq afterElse;
    int flag;
    public If() {
        condition = null;
        afterIf = null;
        afterElse = null;
        flag = 0;
        parseIf();
    }

    private void parseIf() {
        //skip if
        Main.tokenizer.skipToken();
        condition = new Condition();
        //skip then
        Main.tokenizer.skipToken();
        afterIf = new StateSeq();
        //check to see if not at end
        if (Main.tokenizer.getTokenInt()!=3){
            //skip else
            Main.tokenizer.skipToken();
            afterElse = new StateSeq();
            //skip end
            Main.tokenizer.skipToken();
            //skip ";"
            Main.tokenizer.skipToken();
            flag = 1;
        }
        else{
            //skip end
            Main.tokenizer.skipToken();
            //skip ";"
            Main.tokenizer.skipToken();
            flag = 2;
        }

    }
    void printIf() {
        System.out.print("if ");
        condition.printCondition();
        System.out.println(" then");
        Tab.tabCountMore();
        afterIf.printStateSeq();
        if (afterElse != null) {
            Tab.printTab();
            System.out.println("else");
            afterElse.printStateSeq();
        }
        Tab.tabCountLess();
        Tab.printTab();
        System.out.println("end;");
    }

    void execIf() throws IOException {
        if (condition.evalCondition()) {
            afterIf.execStateSeq();
        } else {
            afterElse.execStateSeq();
        }

    }
}
