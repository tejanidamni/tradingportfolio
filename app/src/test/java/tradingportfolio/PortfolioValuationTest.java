package tradingportfolio;

 

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;

import java.util.Map;

 

class PortfolioValuationTest {

 

    @Test

    void testCalculateAndPrintNAV() {

        Stock stock = new Stock("AAPL", 0.05, 0.2, 150.0);

        Position position = new Position("AAPL", 10);

 

        Map<String, Stock> stocks = new HashMap<>();

        stocks.put(stock.getSymbol(), stock);

 

        List<Position> positions = new ArrayList<>();
        positions.add(position);

 

        PortfolioValuation valuation = new PortfolioValuation(stocks, positions);

        valuation.calculateAndPrintNAV(); // This should print the NAV without errors

    }

}
