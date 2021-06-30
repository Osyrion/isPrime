package cz.durovic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {

    public static void main(String[] args) throws IOException {
        //File excelFile = new File("src\\cz\\durovic\\vzorek.xlsx");
        File excelFile = new File(args[0]);
        FileInputStream fis = new FileInputStream(excelFile);


        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        XSSFSheet sheet = workbook.getSheetAt(0);

        for (Row row: sheet) { // For each Row.
            // choose B column
            Cell cell = row.getCell(1);

            try {
                String NumString = cell.toString();
                Long cellLong = Long.parseLong(NumString);

                // test if number is prime
                if (isPrime(cellLong)) {
                    // if prime print out
                    System.out.println(cellLong);
                }
            } catch (NumberFormatException e) {
                // continue if value in the row is not numeric
            }

        }

        workbook.close();
        fis.close();
    }

    public static boolean isPrime(Long longNumb) {
        if(longNumb < 2) {
            return false;
        }

        // 2 and 3 are prime numbers
        if (longNumb == 2  || longNumb == 3) {
            return true;
        }

        // check even numbers
        if (longNumb % 2 == 0) {
            return false;
        }

        // check odd numbers
        for (int i = 3; i <= Math.sqrt(longNumb); i += 2)
        {
            if (longNumb % i == 0)
                return false;
        }

        return true;
    }

}