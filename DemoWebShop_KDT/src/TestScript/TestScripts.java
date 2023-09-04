package TestScript;

import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.EncryptedDocumentException;
import ExcelReader.ExcelDataReader;
import Keywords.TestKeywords;

public class TestScripts {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {

		//Step 1: To get the Test Cases Name
		ArrayList<String> sheetNames = ExcelDataReader.getTestCaseName();
		for (String sheetName : sheetNames) {
			
		//Step 2: To get the Keywords from the Test Cases
			ArrayList<String> keywords = ExcelDataReader.getKeywords(sheetName);
			int cellNumber = 1;
			
		//Step 3: Performing Actions based on the keywords	
			for (String keyword : keywords) {
				TestKeywords tk = new TestKeywords();
				switch (keyword) {
				case "launchBrowser":
					tk.launchBrowser();
					break;
				case "enterUrl":
					String url = ExcelDataReader.getTestData(sheetName, cellNumber);
					tk.enterUrl(url);
					break;
				case "click":
					tk.click(ExcelDataReader.getXpathOfWebElement(sheetName, cellNumber));
					break;
				case "enterData":
					tk.enterData(ExcelDataReader.getXpathOfWebElement(sheetName, cellNumber),
							ExcelDataReader.getTestData(sheetName, cellNumber));
					break;
				case "verify":
					tk.verify(ExcelDataReader.getXpathOfWebElement(sheetName, cellNumber), sheetName);
					tk.closeBrowser();
					break;
				default:
					break;
				}
				cellNumber++;
			}
		}
	}

}
