package pro1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class FileManagement {

    private final String path;

    public FileManagement(String path) {
        this.path = path;
    }

    public String[] read() {
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(this.path))) {
            return reader.lines().toArray(String[]::new);
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return new String[0];
        }
    }

    private String normalizeDelimiters(String line) {
        return line.replaceAll("\\s*[:;=]\\s*", ",");
    }

    private String[] parseRow(String line) {
        line = normalizeDelimiters(line.trim());

        String[] parts = line.split(",", 2);

        if (parts.length < 2) {
            return new String[0];
        }

        String name = parts[0].trim();
        String data = parts[1].trim();

        return new String[]{name, data};
    }

    public String[] parse(String[] lines) {
        String[] result = new String[lines.length];

        for (int i = 0; i < lines.length; i++) {
            String[] parts = parseRow(lines[i]);

            if (parts.length == 2) {
                String name = parts[0];
                String data = parts[1];

                try {
                    Fraction fraction = Fraction.parse(data);
                    result[i] = name + "," + fraction.toString();
                } catch (Exception e) {
                    result[i] = lines[i];
                }
            } else {
                result[i] = lines[i];
            }
        }

        return result;
    }

    public void writeOutput(String[] data, String outputDir) {
        try {
            java.nio.file.Files.createDirectories(Paths.get(outputDir));

            String fileName = Paths.get(path).getFileName().toString();
            String outputPath = Paths.get(outputDir, fileName).toString();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
                for (String line : data) {
                    writer.write(line);
                    writer.newLine();
                }
            }

            System.out.println("Soubor zapsán: " + outputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void processAndSave(String outputDir) {
        String[] rawData = read();
        String[] processedData = parse(rawData);
        writeOutput(processedData, outputDir);
    }
}
