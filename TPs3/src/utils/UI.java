package utils;

public class UI {
    public static void clear(){
        for (int i = 0; i < 30; ++i) System.out.println();
    }

    public static void message(String message){
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n " +
                message +
                "\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n ");
    }

    public static void title(String message){
        System.out.println( message + "\n_________________________________________");
    }
}
