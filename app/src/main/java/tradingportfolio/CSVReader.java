package tradingportfolio;

import java.io.*;

import java.util.*;

 

public class CSVReader {

    public List<Position> readPositions(String filePath) throws IOException {

        List<Position> positions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                positions.add(new Position(values[0], Integer.parseInt(values[1])));
            }
        }
        return positions;
    }

}
