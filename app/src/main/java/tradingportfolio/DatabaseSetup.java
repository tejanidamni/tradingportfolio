package tradingportfolio;

import java.sql.*;
import java.util.*;


public class DatabaseSetup {

    private Connection connection;
    public void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
    }

    public void setupSchema() throws SQLException {
        Statement stmt = connection.createStatement();
        // Create the table if it doesn't exist
        stmt.execute("CREATE TABLE IF NOT EXISTS securities (symbol VARCHAR, type VARCHAR, mu DOUBLE, sigma DOUBLE, price DOUBLE)");
    
        String[] inserts = new String[]{

            "INSERT INTO securities (symbol, type, mu, sigma, price) VALUES ('AAPL', 'Stock', 0.05, 0.2, 150.0)",
            "INSERT INTO securities (symbol, type, mu, sigma, price) VALUES ('AAPL-OCT-2020-110-C', 'Call', 0.05, 0.2, 5.55)",
            "INSERT INTO securities (symbol, type, mu, sigma, price) VALUES ('AAPL-OCT-2020-110-P', 'Put', 0.05, 0.2, 3.20)",
            "INSERT INTO securities (symbol, type, mu, sigma, price) VALUES ('TELSA', 'Stock', 0.06, 0.3, 750.0)",
            "INSERT INTO securities (symbol, type, mu, sigma, price) VALUES ('TELSA-NOV-2020-400-C', 'Call', 0.06, 0.3, 27.25)",
            "INSERT INTO securities (symbol, type, mu, sigma, price) VALUES ('TELSA-DEC-2020-400-P', 'Put', 0.06, 0.3, 6.35)"
        };

        for (String sql : inserts) {
            stmt.execute(sql);
        }
        stmt.close();

    }

 

    public Map<String, Stock> loadStocks() throws SQLException {
        Map<String, Stock> stocks = new HashMap<>();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM securities");
        while (rs.next()) {
            String symbol = rs.getString("symbol");
            double mu = rs.getDouble("mu");
            double sigma = rs.getDouble("sigma");
            double price = rs.getDouble("price");
            stocks.put(symbol, new Stock(symbol, mu, sigma, price));
        }

        rs.close();
        stmt.close();
        return stocks;

    }

    public Connection getConnection() {
        return connection;
    }
}
