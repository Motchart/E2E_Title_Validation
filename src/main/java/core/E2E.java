package core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class E2E {
public String[][] a2d() throws IOException {
	String csvFile = "./src/main/resourcies/test.csv";
	BufferedReader b = null;
	String[] column = null;
	String line = null;
	int lines = 0;
	int columns = 0;
	String SplitBy = ",";
	String test_case_id = null;
	String url = null;
	String title_expected = null;
	
	b = new BufferedReader(new FileReader(csvFile));
	while ((line = b.readLine()) != null){
		lines++;
		column = line.split(SplitBy);
		columns = column.length;
	}
	b.close();
	String s2d[][] = new String[lines][columns];
	b = new BufferedReader(new FileReader(csvFile));
		WebDriver driver = new HtmlUnitDriver();
	int i = 0;
	while ((line = b.readLine()) != null) {
		
		String[] csv = line.split(SplitBy);
		
		test_case_id = csv[0];
		url = csv[1];
		title_expected=csv[2];
		
		d.get(url);
		d.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String title_actual = d.getTitle();
		
		s2d[i][0] = test_case_id;
		s2d[i][1] = title_expected;
		s2d[i][2] = title_actual;
		i++;
}
	d.quit();
	b.close();
	return s2d;
}
}