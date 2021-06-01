package TPArchivosGrupo10;

public class Sale {
    private String destinationCode;
    private int articleCode;
    private int quantity;
    private int unitPriceInUSD;
    private int saleDate;
    private int saleMonth;
    private int saleYear;


    public Sale(String destinationCode, int articleCode, int quantity, int unitPriceInUSD,
                int saleDate, int saleMonth, int saleYear) {
        this.destinationCode = destinationCode;
        this.articleCode = articleCode;
        this.quantity = quantity;
        this.unitPriceInUSD = unitPriceInUSD;
        this.saleDate = saleDate;
        this.saleMonth = saleMonth;
        this.saleYear = saleYear;
    }

    public String getDestinationCode() {
        return destinationCode;
    }

    public int getArticleCode() {
        return articleCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getUnitPriceInUSD() {
        return unitPriceInUSD;
    }

    public int getSaleDate() {
        return saleDate;
    }

    public int getSaleMonth() {
        return saleMonth;
    }

    public int getSaleYear() {
        return saleYear;
    }
}
