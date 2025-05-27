package repository;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private String filePath;
    private final String filePathforHR = System.getProperty("user.dir") + "\\src\\main\\resources\\EmployeeData.csv";
    private final String filePathforPayroll = System.getProperty("user.dir") + "\\src\\main\\resources\\Attendance Record.csv";
    private List<String[]> records = new ArrayList<>();

    public FileHandler(String filePath) {
        if (filePath.equalsIgnoreCase("HR")) {

            this.filePath = filePathforHR;
        }
        else if (filePath.equalsIgnoreCase("Payroll")) {
            this.filePath = filePathforPayroll;
        }
    }
    private List<String[]> readCSV() {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            records = reader.readAll();
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return records;
    }

    public boolean validateData(String data) {
        for (String[] record : records) {
            for (String value : record) {
                if (value.equals(data)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean validateData(int data) {
        for (String[] record : records) {
            for (String value : record) {
                if (value.equals(String.valueOf(data))) {
                    return true;
                }
            }
        }
        return false;
    }
    public List<String[]> getRecords() {
        readCSV();
        return records;
    }
}
