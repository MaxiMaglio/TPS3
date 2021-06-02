package Grupo10Archivos;

import java.io.IOException;

public class Report {

    private DestinationArchive destinationArchive;
    private AnnualSalesArchive annualSalesArchive;
    private USDPriceArchive usdPriceArchive;

    public Report(DestinationArchive destinationArchive, AnnualSalesArchive annualSalesArchive, USDPriceArchive usdPriceArchive) {
        this.destinationArchive = destinationArchive;
        this.annualSalesArchive = annualSalesArchive;
        this.usdPriceArchive = usdPriceArchive;
    }

    public void monthlyRevenue() throws IOException {
        MonthlyPrice[] monthlyPrices = usdPriceArchive.monthlyPricesArr();
        int[] monthlyRevenue = new int[12];
        annualSalesArchive.goFirst();
        for (int i = 0; i < annualSalesArchive.cantReg(); i++) {
            Sale sale = annualSalesArchive.read();
            monthlyRevenue[sale.getSaleMonth() - 1] += sale.getUnitPriceInUSD() * sale.getQuantity() * monthlyPrice(sale.getSaleMonth());
        }
        for (int i = 0; i < monthlyRevenue.length; i++) {
            System.out.println("En el mes " + (i + 1) + " se recaudo: " + monthlyRevenue[i]);
        }
    }

    public int monthlyPrice(int month) throws IOException {
        MonthlyPrice[] monthlyPrices = usdPriceArchive.monthlyPricesArr();
        return monthlyPrices[month - 1].getPrice();
    }


    public void destinationRevenue() throws IOException {
        Destination[] destinationsArr = destinationArchive.destinationsArr();
        int[] destinationRevenue = new int[30];
        annualSalesArchive.goFirst();
        for (int i = 0; i < annualSalesArchive.cantReg(); i++) {
            Sale sale = annualSalesArchive.read();
            destinationRevenue[destinationPosition(destinationsArr, sale.getDestinationCode())] += sale.getUnitPriceInUSD() * sale.getQuantity() * monthlyPrice(sale.getSaleMonth());
        }
        for (int i = 0; i < destinationRevenue.length; i++) {
            System.out.println("Para el destino " + destinationsArr[i].getCode() + " se recaudo: " + destinationRevenue[destinationPosition(destinationsArr, destinationsArr[i].getCode())]);
        }
    }

    private int destinationPosition(Destination[] destinations, String destinationCode) {
        for (int i = 0; i < 30; i++) {
            if (destinations[i].getCode().equals(destinationCode)) {
                return i;
            }
        }
        return 0;
    }
}


