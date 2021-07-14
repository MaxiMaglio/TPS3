package HashTables;

public class Soundex implements Hashable {
    String value;

    public Soundex(String value){
        this.value = value;
    }

    public static String getCode(String s)
    {
        char[] x = s.toUpperCase().toCharArray();


        char firstLetter = x[0];

        //RULE [ 2 ]
        //Convert letters to numeric code
        for (int i = 0; i < x.length; i++) {
            switch (x[i]) {
                case 'B':
                case 'F':
                case 'P':
                case 'V': {
                    x[i] = '1';
                    break;
                }

                case 'C':
                case 'G':
                case 'J':
                case 'K':
                case 'Q':
                case 'S':
                case 'X':
                case 'Z': {
                    x[i] = '2';
                    break;
                }

                case 'D':
                case 'T': {
                    x[i] = '3';
                    break;
                }

                case 'L': {
                    x[i] = '4';
                    break;
                }

                case 'M':
                case 'N': {
                    x[i] = '5';
                    break;
                }

                case 'R': {
                    x[i] = '6';
                    break;
                }

                default: {
                    x[i] = '0';
                    break;
                }
            }
        }

        //Remove duplicates
        //RULE [ 1 ]
        String output = "" + firstLetter;

        //RULE [ 3 ]
        for (int i = 1; i < x.length; i++)
            if (x[i] != x[i - 1] && x[i] != '0')
                output += x[i];

        //RULE [ 4 ]
        //Pad with 0's or truncate
        output = output + "0000";
        return output.substring(0, 4);
    }

    @Override
    public int hash(int M) {
        String code, previous, soundex;
        code = value.toUpperCase().charAt(0) + "";
        previous = "7";
        for (int i = 1; i < value.length(); i++) {
            String current = getCode(value);
            if (current.length() > 0 && !current.equals(previous)) {
                code = code + current;
            }
            previous = current;
        }
        soundex = (code + "0000").substring(0, 4);
        Integer value = Integer.parseInt(soundex);
        return (int) value;
    }
}