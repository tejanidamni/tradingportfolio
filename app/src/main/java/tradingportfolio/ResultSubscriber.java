package tradingportfolio;


public class ResultSubscriber {

    public void listenAndPrint(PortfolioValuation valuation) {
        while (true) {
            valuation.calculateAndPrintNAV();
            try {
                Thread.sleep(2000); // Update every 2 seconds
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }

        }

    }

}
