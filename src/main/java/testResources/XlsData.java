package testResources;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import static org.apache.poi.ss.usermodel.Row.MissingCellPolicy.RETURN_BLANK_AS_NULL;
import static org.apache.poi.ss.usermodel.Row.MissingCellPolicy.RETURN_NULL_AND_BLANK;

public class XlsData {
    // Constant variables Test Data path and Test Data file name
    public static final String Path_TestData = "D:\\IntelliJ IDEA Community Edition 2017.2.3\\";

    public static final String File_TestData = "TestData.xlsx";

    private static XSSFSheet ExcelWSheet;

    private static XSSFWorkbook ExcelWBook;

    private static XSSFCell Cell;

    private static XSSFRow Row;

    //This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method

    public static void setExcelFile(String Path,String SheetName) throws Exception {

        try {

            // Open the Excel file

            FileInputStream ExcelFile = new FileInputStream(Path);

            // Access the required test data sheet

            ExcelWBook = new XSSFWorkbook(ExcelFile);

            ExcelWSheet = ExcelWBook.getSheet(SheetName);

        } catch (Exception e){

            throw (e);

        }

    }
    //This method is to set up a teble by naming columns by categories of data
    public static void setUpTable(String[] namings) throws Exception{
        try{
            int i=0;
            int j=0;
            for (String s:namings) {
                if(s.contains("Other")) {
                    setCellData(s, 2, j);
                    j++;
                } else {
                    setCellData(s, 0, i);
                    i++;
                }
            }

            } catch (Exception e){

            throw (e);

        }
    }
    //method to find a column# that matches a certain category of data
    public static int findColumn (String category) throws Exception {
        int i;
        try {
            i = 0;
            while (!category.matches(getCellData(0, i))) {
                i++;
            }

        } catch (Exception e) {

            throw (e);

        }
        return i;
    }
    //This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num

    public static String getCellData(int RowNum, int ColNum) throws Exception{

        try{

            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

            String CellData = Cell.getStringCellValue();

            return CellData;

        }catch (Exception e){

            return"";

        }

    }
    //This method is to write in the Excel cell, Row num and Col num are the parameters

    public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception	{
        FileOutputStream fileOut = new FileOutputStream(Path_TestData + File_TestData);

        try{

            if (ExcelWSheet.getRow(RowNum)==null) {
                Row = ExcelWSheet.createRow(RowNum);
            } else {Row =ExcelWSheet.getRow(RowNum);}
            Cell = Row.getCell(ColNum, RETURN_BLANK_AS_NULL);

            if (Cell == null) {

                Cell = Row.createCell(ColNum);

                Cell.setCellValue(Result);

            } else {

                Cell.setCellValue(Result);

            }

            ExcelWBook.write(fileOut);

            fileOut.flush();

            fileOut.close();

        }catch(Exception e){

            throw (e);

        }

    }

}
