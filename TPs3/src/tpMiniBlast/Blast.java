package tpMiniBlast;

public class Blast {

    //BLAST (Basic Local Alignment Search Tool) es un algoritmo que realiza un
    //alineamiento de secuencias (ya sea de ADN, ARN o de proteínas). El programa es
    //capaz de comparar una secuencia problema (también denominada en la literatura
    //secuencia query) contra una gran cantidad de secuencias que se encuentren en una
    //base de datos. El algoritmo encuentra las secuencias de la base de datos que tienen
    //mayor parecido a la secuencia problema.
    //El programa que usted debe realizar tendrá que recibir dos parámetros:
    //• secuencia de referencia.
    //• secuencia query.
    //El output del programa es un porcentaje que refleja cuán parecidas son las dos
    //secuencias.
    //NOTA: suponer que ambas secuencias tienen la misma longitud.

    public double blast(char[] query, char[] reference){
        double sameLetterCount = 0;
        for(int i = 0; i < reference.length; i++){
            //If similar characters are found, then sameLetterCount+=1
            if(Character.compare(reference[i], query[i]) == 0){
                sameLetterCount += 1;
            }
            else{
                sameLetterCount += 0;
            }
        }
        //Calculate the percentage of similar characters found
        double percentage = (sameLetterCount / reference.length);
        return percentage * 100;
    }
}