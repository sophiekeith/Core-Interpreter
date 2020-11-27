package cse3341.keith;
import java.io.IOException;
import java.util.ArrayList;

public class Loop {
    private Condition condition;
    private StateSeq statementSequence;
    public Loop() {
        parseLoop();
    }

    private void parseLoop() {
        //skip while
        Main.tokenizer.skipToken();
        condition = new Condition();
        //skip loop
        Main.tokenizer.skipToken();
        statementSequence = new StateSeq();
        //skip end
        Main.tokenizer.skipToken();
        //skip ";"
        Main.tokenizer.skipToken();
    }

    void printLoop() {
        System.out.print("while ");
        condition.printCondition();
        System.out.println(" loop");
        Tab.tabCountMore();
        statementSequence.printStateSeq();
        Tab.tabCountLess();
        Tab.printTab();
        System.out.println("end;");
    }

    void execLoop() throws IOException {
        while (condition.evalCondition()) {
            try {
                statementSequence.execStateSeq();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
