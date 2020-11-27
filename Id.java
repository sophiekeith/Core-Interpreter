package cse3341.keith;

import java.util.HashMap;

public class Id {
    //use a hash to store strings and corresponding ids
    private static HashMap<String,Id> idHash = new HashMap<>();
    String id;
    Integer value;


    public Id(String name) {
        id = name;
        value= null;
    }

    //returns an id, whether new or already existing
    public static Id parseId() {
       String currentToken = Main.tokenizer.getToken();

       //check to see if current token is in hash
        if (idHash.containsKey(currentToken)){
            //return the token
            return idHash.get(currentToken);
        }
        else{
            //create new id and add it to hash
            Id id = new Id(currentToken);
            idHash.put(currentToken, id);
            return id;
        }
    }

    void printIdentifier(){
        System.out.print(id);
    }

    void outId(){
        System.out.println(id + "=" + value);
    }

    public int getValue(){
        return value;
    }
    public void setValue(int value){
        this.value = value;
    }


}
