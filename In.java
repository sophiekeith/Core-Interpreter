package cse3341.keith;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class In {

    private static int position = 0;
    private static List<String> inputString = new ArrayList<>();

    static {
        //split based on spaces
        inputString = Arrays.asList(Main.dataString.split("\\s+"));
    }
    IdList idListTokens;

    public In() {
        idListTokens = null;
        parseIn();
    }

    private void parseIn() {
        //skip read
        Main.tokenizer.skipToken();
        idListTokens = new IdList();
        //skip ";"
        Main.tokenizer.skipToken();
    }

    public static int getToken(int postion) {
        if (position >= inputString.size()) {
            System.out.println("Position greater than length");
        }
        return Integer.valueOf(inputString.get(postion));

    }
    void printIn(){
        System.out.print("read ");
        idListTokens.printIdList();
    }
    void execIn()  {
        position = idListTokens.inIdList(position);
    }
}
