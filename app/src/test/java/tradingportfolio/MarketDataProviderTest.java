package tradingportfolio;

 

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

 

class MarketDataProviderTest {

 

    @Test

    void testMarketDataProvider() {

        // Mock or create instances of Stock and PortfolioValuation

        Stock stock = new Stock("AAPL", 150, 0.05, 0.2);
        Position position = new Position("AAPL", 10);

        

 

        Map<String, Stock> stocks = new HashMap<>();
        stocks.put(stock.getSymbol(), stock);

        List<Position> positions = new ArrayList<>();
        positions.add(position);
        
        PortfolioValuation valuation = new PortfolioValuation(stocks, positions);
        MarketDataProvider provider = new MarketDataProvider(stocks, valuation);

 

        // Run the provider in a separate thread and stop after a short period

        Thread thread = new Thread(provider);

        thread.start();

 

        try {

            Thread.sleep(2000); // Let it run for 2 seconds

        } catch (InterruptedException e) {

            fail("Test interrupted");

        } finally {

            thread.interrupt(); // Stop the thread

        }

        // Assertions can be added here based on expected state changes

        assertNotNull(stocks.get("AAPL"));

    }

}