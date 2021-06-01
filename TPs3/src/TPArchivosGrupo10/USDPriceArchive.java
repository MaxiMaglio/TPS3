package TPArchivosGrupo10;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class USDPriceArchive {

    private final int recordByteSize = 8;
    public File file;
    public RandomAccessFile raf;

    public USDPriceArchive() {
        this.file = new File("USDPriceArchive");
        try{
            this.raf = new RandomAccessFile(file, "rw");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void write(MonthlyPrice monthlyPrice) throws IOException {
        raf.seek(raf.length());
        raf.writeInt(monthlyPrice.getMonth());
        raf.writeInt(monthlyPrice.getPrice());
    }

    public MonthlyPrice read() throws IOException {
        return new MonthlyPrice(raf.readInt(), raf.readInt());
    }

    public long cantReg() throws IOException {
        return raf.length()/recordByteSize;
    }

    public MonthlyPrice[] monthlyPricesArr() throws IOException {
        MonthlyPrice[] monthlyPrices = new MonthlyPrice[(int)cantReg()];
        raf.seek(0);
        for (int i = 0; i < monthlyPrices.length; i++) {
            monthlyPrices[i] = read();
        }
        return monthlyPrices;
    }

    public void yearPrices(MonthlyPrice[] monthlyPrices) throws IOException {
        for (int i = 0; i < 12; i++) {
            write(monthlyPrices[i]);
        }
    }
}
