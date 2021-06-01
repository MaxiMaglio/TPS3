package TPArchivosGrupo10;

import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        // 30 destination codes
        String[] destinationCodes = {"ARG", "MEX", "USA", "BOL", "CAN", "RUS", "CHL", "POR", "GER", "ITA",
                                    "PER", "HON", "HOL", "JAP", "CHI", "IND", "URU", "PAR", "COL", "BRA",
                                    "ECU", "VEN", "AUS", "NZE", "ING", "ISR", "NOR", "FIN", "SWE", "NIG"};
        Destination[] destinations = new Destination[destinationCodes.length];
        for (int i = 0; i < destinationCodes.length; i++) {
            destinations[i] = new Destination(destinationCodes[i], generateDescription(30));
        }
        // 12 annual prices
        MonthlyPrice[] prices = new MonthlyPrice[12];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = new MonthlyPrice(i+1, new Random().nextInt(100)+100);
        }

        // Archives
        AnnualSalesArchive annualSalesArchive = new AnnualSalesArchive();
        DestinationArchive destinationArchive = new DestinationArchive();
        USDPriceArchive usdPriceArchive = new USDPriceArchive();

        // Save data to archives
        annualSalesArchive.thousandSales(destinations);
        destinationArchive.thirtyDestinations(destinations);
        usdPriceArchive.yearPrices(prices);

        // Report
        Report report = new Report(destinationArchive, annualSalesArchive, usdPriceArchive);
        report.monthlyRevenue();
        report.destinationRevenue();
    }

    private static String generateDescription(int stringLength) { //Creates a random codeName
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int length = stringLength; //string length
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString().toUpperCase();
    }
}
