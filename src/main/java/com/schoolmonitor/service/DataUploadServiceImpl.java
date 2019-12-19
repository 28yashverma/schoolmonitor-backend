/**
 * 
 */
package com.schoolmonitor.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author PrabhjeetS
 * @version 1.0
   Dec 20, 2019
 */
public class DataUploadServiceImpl {

	void massDataUpload(File file) throws IOException {
		FileInputStream excelFile = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet datatypeSheet = workbook.getSheetAt(0);
        /*Iterator<Row> iterator = datatypeSheet.iterator();
        while (iterator.hasNext()) {

            Row currentRow = iterator.next();
            Iterator<Cell> cellIterator = currentRow.iterator();

            while (cellIterator.hasNext()) {*/
	}
	

}
