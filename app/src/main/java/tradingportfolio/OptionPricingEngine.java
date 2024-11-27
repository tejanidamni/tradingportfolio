package tradingportfolio;

public class OptionPricingEngine {

 

    public double calculateCallPrice(double S, double K, double t, double r, double sigma) {

        double d1 = (Math.log(S / K) + (r + 0.5 * sigma * sigma) * t) / (sigma * Math.sqrt(t));
        double d2 = d1 - sigma * Math.sqrt(t);
        return S * cumulativeNormalDistribution(d1) - K * Math.exp(-r * t) * cumulativeNormalDistribution(d2);

    }

 

    public double calculatePutPrice(double S, double K, double t, double r, double sigma) {
        double d1 = (Math.log(S / K) + (r + 0.5 * sigma * sigma) * t) / (sigma * Math.sqrt(t));
        double d2 = d1 - sigma * Math.sqrt(t);
        return K * Math.exp(-r * t) * cumulativeNormalDistribution(-d2) - S * cumulativeNormalDistribution(-d1);

    }

    private double cumulativeNormalDistribution(double x) {

        double mean = 0.0;
        double stdDev = 1.0;
        return 0.5 * (1.0 + erf((x - mean) / (stdDev * Math.sqrt(2.0))));

    }

 

    private double erf(double x) {

        // Abramowitz and Stegun approximation

        double sign = (x < 0) ? -1 : 1;
        x = Math.abs(x);

        double a1 =  0.254829592;
        double a2 = -0.284496736;
        double a3 =  1.421413741;
        double a4 = -1.453152027;
        double a5 =  1.061405429;
        double p  =  0.3275911;

        double t = 1.0 / (1.0 + p * x);
        double y = 1.0 - (((((a5 * t + a4) * t) + a3) * t + a2) * t + a1) * t * Math.exp(-x * x);

        return sign * y;

    }

}