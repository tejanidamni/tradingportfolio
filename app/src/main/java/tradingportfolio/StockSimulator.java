package tradingportfolio;

import java.util.Random;

public class StockSimulator {

    private final Random random = new Random();

    public double simulatePrice(double currentPrice, double mu, double sigma, double deltaT) {
        
        double epsilon = random.nextGaussian();
        double deltaS = currentPrice * (mu * (deltaT / 7257600) + sigma * epsilon * Math.sqrt(deltaT / 7257600));
        return Math.max(currentPrice + deltaS, 0);

    }

}
