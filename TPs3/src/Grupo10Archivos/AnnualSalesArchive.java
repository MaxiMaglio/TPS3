package Grupo10Archivos;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class AnnualSalesArchive {

    private final int recordByteSize = 31;
    public File file;
    public RandomAccessFile raf;

    public AnnualSalesArchive() {
        this.file = new File("AnnualSalesArchive");
        try{
            this.raf = new RandomAccessFile(file, "rw");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void write(Sale sale) throws IOException {
        raf.seek(raf.length());
        raf.writeUTF(sale.getDestinationCode());
        raf.writeInt(sale.getArticleCode());
        raf.writeInt(sale.getQuantity());
        raf.writeInt(sale.getUnitPriceInUSD());
        raf.writeInt(sale.getSaleDate());
        raf.writeInt(sale.getSaleMonth());
        raf.writeInt(sale.getSaleYear());
    }

    public Sale read() throws IOException {
        return new Sale(raf.readUTF(), raf.readInt(), raf.readInt(), raf.readInt(), raf.readInt(), raf.readInt(), raf.readInt());
    }

    public long cantReg() throws IOException {
        return raf.length()/recordByteSize;
    }

    public Sale[] saleArra() throws IOException {
        Sale[] sales = new Sale[(int)cantReg()];
        raf.seek(0);
        for (int i = 0; i < sales.length; i++) {
            sales[i] = read();
        }
        return sales;
    }

    public void goFirst() throws IOException {
        raf.seek(0);
    }

    public void thousandSales(Destination[] destinations) throws IOException {
        for (int i = 0; i < 1000; i++) {
            int random = new Random().nextInt(destinations.length);
            String code = destinations[random].getCode();
            int artCode = new Random().nextInt(1000) + 1000;
            int quantity = new Random().nextInt(1000) + 1;
            int unitPrice = new Random().nextInt(100) + 1;
            int month = new Random().nextInt(12) + 1;
            int day = new Random().nextInt(monthDays(month)) + 1;
            Sale sale = new Sale(code, artCode, quantity, unitPrice, day, month, 2020);
            write(sale);
        }
    }

    private static int monthDays(int mes) {
        switch (mes) {
            case 1:  // Enero
            case 3:  // Marzo
            case 5:  // Mayo
            case 7:  // Julio
            case 8:  // Agosto
            case 10:  // Octubre
            case 12: // Diciembre
                return 31;
            case 4:  // Abril
            case 6:  // Junio
            case 9:  // Septiembre
            case 11: // Noviembre
                return 30;
            case 2:  // Febrero
                return 29;
            default:
                return -1;
        }
    }
}
