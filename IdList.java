package cse3341.keith;


import java.io.IOException;

public class IdList {
    private IdList idList;
    private Id identifier;
    public IdList() {
        idList = null;
        identifier = null;
        parseIdList();
    }

    private void parseIdList() {
        identifier = Id.parseId();
            //skip token
            Main.tokenizer.skipToken();
            //if not at end, there is another idlist
            if (Main.tokenizer.getTokenInt() !=12 ) {
                //skip ","
                Main.tokenizer.skipToken();
                idList = new IdList();
            }
    }
    void printIdList(){
        identifier.printIdentifier();
        if(idList!=null){
            System.out.print(",");
            idList.printIdList();
        }
        else{
            System.out.println(";");
        }
    }
    void outIdList() {
        identifier.outId();
        if (idList != null){
            idList.outIdList();
        }
    }
    public int inIdList(int position) {

        //call the read function to get current token

        identifier.setValue(In.getToken(position));
        if (idList != null){
            idList.inIdList(position+1);
        }
        //return the most updated postion of id list
        return (position+1);
    }

}
