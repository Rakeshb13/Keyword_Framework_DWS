package ExcelReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelDataReader {

	public static ArrayList<String> getTestCaseName() throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./TestData/TestCases.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("TestCases");
		int lastRow = sh.getPhysicalNumberOfRows();
		ArrayList testCaseNames = new ArrayList();
		for (int i = 1; i < lastRow; i++) {
			testCaseNames.add(sh.getRow(i).getCell(0).toString());
		}
		return testCaseNames;
	}

	public static ArrayList<String> getKeywords(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./TestData/TestCases.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetName);
		int lastRow = sh.getPhysicalNumberOfRows();
		ArrayList keywords = new ArrayList();
		for (int i = 1; i < lastRow; i++) {
			keywords.add(sh.getRow(i).getCell(6).toString());
		}
		return keywords;
	}

	public static String getTestData(String sheetName, int rowNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./TestData/TestCases.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetName);
		return sh.getRow(rowNum).getCell(5).toString();
	}

	public static String getXpathOfWebElement(String sheetName, int rowNum)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./TestData/TestCases.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetName);
		return sh.getRow(rowNum).getCell(7).toString();
	}
}
