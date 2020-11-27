package cse3341.keith;

public class Declaration {
    private IdList idList;

    public Declaration() {
        idList = null;
        ParseDecl();
    }

    private void ParseDecl() {
        //check to make sure first token is "int"
            if (Main.tokenizer.getTokenInt() !=4) {
                System.out.print("Not correct declaration:");
                System.out.println(Main.tokenizer.getToken());
            }
            //skip token "int"
            Main.tokenizer.skipToken();

        //now assign id list
        idList = new IdList();
    }

    void printDeclaration() {
        System.out.print("int ");
        idList.printIdList();
    }
    void execDeclaration(){
        //nothing
    }
}
