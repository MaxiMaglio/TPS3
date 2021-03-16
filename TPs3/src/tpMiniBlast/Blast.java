package tpMiniBlast;

public class Blast {
    
    public double blast(String query, String reference){
        double sameLetterCount = 0;
        for(int i = 0; i < reference.length(); i++){
            //If similar characters are found, then sameLetterCount+=1
            if(Character.compare(reference.charAt(i), query.charAt(i)) == 0){
                sameLetterCount += 1;
            }
            else{
                sameLetterCount += 0;
            }
        }
        //Calculate the percentage of similar characters found
        double percentage = (sameLetterCount / reference.length());
        return percentage * 100;
    }
}
