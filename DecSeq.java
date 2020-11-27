package cse3341.keith;

public class DecSeq {
    private Declaration declaration;
    private DecSeq ds;
    public DecSeq(){
        declaration = null;
        ds = null;
        parseDecSeq();
    }
    public void parseDecSeq(){
        declaration = new Declaration();
        Main.tokenizer.skipToken();
        if (Main.tokenizer.getTokenInt()!=2){
            ds = new DecSeq();
        }

    }
    void printDecSeq(){
        declaration.printDeclaration();
        if (ds!= null){
            ds.printDecSeq();
        }

    }
    void execDecSeq(){
        //nothing exists here.
    }
}
