# Portfolio Valuation System

This project simulates a trading system capable of handling stocks and European options. It includes components for reading portfolio positions, storing security definitions, simulating market data, calculating option prices, and outputting the portfolio's market value in real-time.

## Features

- **CSV Reader**: Reads portfolio positions from a CSV file.
- **Embedded Database**: Uses H2 to store security definitions.
- **Market Data Provider**: Simulates stock price movements using geometric Brownian motion.
- **Option Pricing Engine**: Calculates option prices using the Black-Scholes model.
- **Portfolio Valuation**: Computes the market value of each position and the total NAV.
- **Result Subscriber**: Prints updates to the console in real-time.

## Project Structure
/PortfolioValuationSystem ├── build.gradle ├── settings.gradle └── /src ├── /main │ ├── /java │ │ └── /com/example │ │ ├── Main.java │ │ ├── Position.java │ │ ├── Stock.java │ │ ├── Security.java │ │ ├── CSVReader.java │ │ ├── DatabaseSetup.java │ │ ├── MarketDataProvider.java │ │ ├── StockSimulator.java │ │ ├── OptionPricingEngine.java │ │ ├── PortfolioValuation.java │ │ └── ResultSubscriber.java │ └── /resources │ └── positions.csv └── /test ├── /java │ └── /com/example │ ├── CSVReaderTest.java │ ├── MarketDataProviderTest.java │ └── OptionPricingEngineTest.java


## Getting Started

### Prerequisites

- JDK 8 or higher
- Gradle
- H2 Database

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/PortfolioValuationSystem.git
   cd PortfolioValuationSystem

2. Build the project:

```bash
    ./gradlew build

3. Run the project:
```bash
    ./gradlew run

### Usage
CSV File: Update src/main/resources/positions.csv with your portfolio data.
Database: The DatabaseSetup class initializes the database with sample data.
Market Simulation: The MarketDataProvider class simulates market data and triggers portfolio valuation.

### Testing
```bash
./gradlew test