package tradingportfolio;

public class Stock {

    private final String symbol;
    private final double mu;
    private final double sigma;
    private double price;

    public Stock(String symbol, double mu, double sigma, double price) {
        this.symbol = symbol;
        this.mu = mu;
        this.sigma = sigma;
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getExpectedReturn() {
        return mu;
    }

    public double getVolatility() {
        return sigma;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}