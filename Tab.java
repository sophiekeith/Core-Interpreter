package cse3341.keith;

public class Tab {
    private static int tabCount = 0;
    public static int tabCountGet(){
        return tabCount;
    }

    public static void printTab(){
        for (int i = tabCount; i>0; i--){
            System.out.print("\t");
        }
    }

    public static void tabCountMore(){
        Tab.tabCount +=1;
    }

    public static void tabCountLess(){
        Tab.tabCount -=1;
    }
}

