package tradingportfolio;
import java.util.List;

import java.util.Map;

public class PortfolioValuation {

    private final Map<String, Stock> stocks;
    private final List<Position> positions;

 

    public PortfolioValuation(Map<String, Stock> stocks, List<Position> positions) {
        this.stocks = stocks;
        this.positions = positions;
    }

 

    public void calculateAndPrintNAV() {

        double totalNAV = 0.0;
        System.out.println("## Portfolio");
        System.out.printf("%-20s %-10s %-10s %-10s%n", "symbol", "price", "qty", "value");
        for (Position position : positions) {
            Stock stock = stocks.get(position.getSymbol());
            if (stock != null) {

                double price = stock.getPrice();
                double marketValue = position.getPositionSize() * price;
                totalNAV += marketValue;
                System.out.printf("%-20s %-10.2f %-10d %-10.2f%n",
                        position.getSymbol(), price, position.getPositionSize(), marketValue);

            }

        }

        System.out.printf("#Total portfolio: %.2f%n", totalNAV);

    }

}
