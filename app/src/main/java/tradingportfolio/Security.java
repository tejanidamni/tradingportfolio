package tradingportfolio;

public abstract class Security {

    private final String symbol;

    public Security(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

}
