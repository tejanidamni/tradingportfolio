package tradingportfolio;

import java.util.*;

public class MarketDataProvider implements Runnable {

    private final Map<String, Stock> stocks;
    private final Random random = new Random();
    private final PortfolioValuation valuation;
    private int updateCount = 1;

    public MarketDataProvider(Map<String, Stock> stocks, PortfolioValuation valuation) {
        this.stocks = stocks;
        this.valuation = valuation;
    }

 
    @Override
    public void run() {
        while (true) {
            System.out.println("## " + updateCount + " Market Data Update");
            boolean updated = false;

            for (Stock stock : stocks.values()) {

                double oldPrice = stock.getPrice();
                double mu = stock.getExpectedReturn();
                double sigma = stock.getVolatility();
                double epsilon = random.nextGaussian();
                double deltaT = 1.0 / 7257600;

                double newPrice = oldPrice * (1 + mu * deltaT + sigma * epsilon * Math.sqrt(deltaT));
                stock.setPrice(Math.max(newPrice, 0));

                if (Math.abs(newPrice - oldPrice) > 0.01){
                    System.out.printf("%s change to %.2f%n",stock.getSymbol(), stock.getPrice());
                    updated = true;
                }

            }

            if (updated) {
                valuation.calculateAndPrintNAV();
            }

            updateCount++;

            try {
                Thread.sleep(500 + random.nextInt(1500));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }

        }

    }

}
 