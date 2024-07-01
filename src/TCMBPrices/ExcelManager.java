package TCMBPrices;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelManager {
    public ExcelManager() {
        System.out.println("Excel Manager Initialize");
    }

    public String readExcel(String SheetName, int rNum, int cNum){
        String data = "";

        try {
            FileInputStream fis = new FileInputStream("/home/murat/test/test.xlsx");
            Workbook wb = WorkbookFactory.create(fis);

//            XSSFWorkbook wb = new XSSFWorkbook(fis);
            Sheet s = wb.getSheet(SheetName);
            Row r = s.getRow(rNum);
            Cell c = r.getCell(cNum);
            data = c.getStringCellValue();

        } catch (Exception e){
            System.out.println("Read Error");
            e.printStackTrace();
        }

        return data;
    }
}
