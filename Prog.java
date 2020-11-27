package cse3341.keith;
import java.io.IOException;
import java.util.ArrayList;

public class Prog{
    private DecSeq ds;
    private StateSeq ss;
    public Prog(){
        ds = null;
        ss = null;
        parseProg();
    }
    public void parseProg(){
            //skip first token
            Main.tokenizer.skipToken();
            ds = new DecSeq();
            //skip begin
            Main.tokenizer.skipToken();
            ss = new StateSeq();
            //skip end
            Main.tokenizer.skipToken();
        }

    void printProg(){
        System.out.println("program");
        //increment tab
        Tab.tabCountMore();
        //print tab
        Tab.printTab();
        ds.printDecSeq();
        System.out.println("begin");
        ss.printStateSeq();
        //decrement tab
        Tab.tabCountLess();
        System.out.println("end");
    }

    void execProg() throws IOException {
        ds.execDecSeq();
        try {
            ss.execStateSeq();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
