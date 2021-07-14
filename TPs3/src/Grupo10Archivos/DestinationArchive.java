package Grupo10Archivos;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class DestinationArchive {

    private final int recordByteSize = 37;
    public File file;
    public RandomAccessFile raf;

    public DestinationArchive() {
        this.file = new File("DestinationArchive");
        try{
            this.raf = new RandomAccessFile(file, "rw");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void write(Destination destination) throws IOException {
        raf.seek(raf.length());
        raf.writeUTF(destination.getCode());
        raf.writeUTF(destination.getDescription());
    }

    public Destination read() throws IOException {
        return new Destination(raf.readUTF(), raf.readUTF());
    }

    public long cantReg() throws IOException {
        return raf.length()/recordByteSize;
    }

    public Destination[] destinationsArr() throws IOException {
        Destination[] destinations = new Destination[(int)cantReg()];
        raf.seek(0);
        for (int i = 0; i < destinations.length; i++) {
            destinations[i] = read();
        }
        return destinations;
    }

    public void thirtyDestinations(Destination[] destinations) throws IOException {
        for (int i = 0; i < destinations.length; i++) {
            write(destinations[i]);
        }
    }
}
