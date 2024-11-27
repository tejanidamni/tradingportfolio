package tradingportfolio;

 

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

 

class OptionPricingEngineTest {

 

    private final OptionPricingEngine engine = new OptionPricingEngine();

 

    @Test

    void testCalculateCallPrice() {

        double S = 100; // Current stock price

        double K = 100; // Strike price

        double t = 1;   // Time to expiration in years

        double r = 0.05; // Risk-free interest rate

        double sigma = 0.2; // Volatility

 

        double callPrice = engine.calculateCallPrice(S, K, t, r, sigma);

        assertTrue(callPrice > 0, "Call price should be greater than zero");

    }

 

    @Test

    void testCalculatePutPrice() {

        double S = 100; // Current stock price

        double K = 100; // Strike price

        double t = 1;   // Time to expiration in years

        double r = 0.05; // Risk-free interest rate

        double sigma = 0.2; // Volatility

 

        double putPrice = engine.calculatePutPrice(S, K, t, r, sigma);

        assertTrue(putPrice > 0, "Put price should be greater than zero");

    }

}
