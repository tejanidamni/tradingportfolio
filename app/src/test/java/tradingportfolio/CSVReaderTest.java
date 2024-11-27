package tradingportfolio;

 

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import java.util.List;

 

class CSVReaderTest {

 

    @Test

    void testReadPositions() throws IOException {

        CSVReader csvReader = new CSVReader();

        List<Position> positions = csvReader.readPositions("src/test/resources/test_positions.csv");

 

        assertNotNull(positions, "Positions should not be null");

        assertFalse(positions.isEmpty(), "Positions list should not be empty");

        assertEquals("AAPL", positions.get(0).getSymbol(), "First position symbol should be AAPL");


    }

}
