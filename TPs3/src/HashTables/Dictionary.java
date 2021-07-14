package HashTables;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Dictionary {
    OpenHashTable<Soundex> dictionaryHash;

    public Dictionary() {
        this.dictionaryHash = new OpenHashTable<Soundex>(20);
    }

    public void insertWord(File file) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(file,"rw");
        raf.seek(0);

        for (int i = 0; i < 7; i++) {
            String s = raf.readLine();
            Soundex word = new Soundex(s);
            dictionaryHash.insert(word);
        }
        raf.close();
    }

    public void containWords(File anotherFile) throws IOException {
        RandomAccessFile anotherRaf = new RandomAccessFile(anotherFile,"r");

        anotherRaf.seek(0);
        for (int i = 0; i < 8; i++) {
            String aux = anotherRaf.readUTF();
            checkWord(aux);

        }
        anotherRaf.close();
    }

    private void checkWord(String word) {
        if (dictionaryHash.contains(new Soundex(word))) System.out.println(word+" is in the dictionary.");
        else System.out.println(word+" is not in the dictionary.");
    }
}
