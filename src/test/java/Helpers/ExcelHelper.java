package Helpers;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ExcelHelper {
    public static Object[][] readExcelFile(File file) throws IOException {
        InputStream inputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        int rowNumbers = sheet.getPhysicalNumberOfRows();
        int colNumbers = sheet.getRow(0).getPhysicalNumberOfCells();
        String [][] data = new String[rowNumbers-1][colNumbers];
        DataFormatter formatter= new DataFormatter();


        for (int i = 0; i <rowNumbers-1 ; i++) {
            for (int j = 0; j <colNumbers ; j++) {
                String value;
                Cell cell = sheet.getRow(i+1).getCell(j);
                if (cell==null){
                    value="";
                }
                else {
                    value=formatter.formatCellValue(cell);
                }
                data[i][j] = value;

            }
        }



        return data;
    }
}
