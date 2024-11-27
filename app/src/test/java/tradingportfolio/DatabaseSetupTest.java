package tradingportfolio;

 

import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import java.util.Map;

 

import static org.junit.jupiter.api.Assertions.*;

 

class DatabaseSetupTest {

 

    private DatabaseSetup dbSetup;

 

    @BeforeEach

    void setUp() throws SQLException {

        dbSetup = new DatabaseSetup();

        dbSetup.connect();

        dbSetup.setupSchema();

    }

 

    @AfterEach

    void tearDown() throws SQLException {

        if (dbSetup != null && dbSetup.getConnection() != null) {

            dbSetup.getConnection().close();

        }

    }

 

    @Test

    void testLoadStocks() throws SQLException {

        Map<String, Stock> stocks = dbSetup.loadStocks();

        assertNotNull(stocks, "Stocks map should not be null");

        assertTrue(stocks.containsKey("AAPL"), "Stocks map should contain AAPL");

        assertTrue(stocks.containsKey("TELSA"), "Stocks map should contain TELSA");

    }

}
