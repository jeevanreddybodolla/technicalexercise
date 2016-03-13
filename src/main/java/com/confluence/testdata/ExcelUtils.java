package com.confluence.testdata;

import java.io.File;

import jxl.*; 

public class ExcelUtils {

	
	public static String[][] getTableArray(String xlFilePath, String sheetName, String tableName) throws Exception{
        String[][] tabArray=null;
        
            Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
            Sheet sheet = workbook.getSheet(sheetName); 
            int startRow,startCol, endRow, endCol,ci,cj; 
            int noofnoexec = 0;
            Cell tableStart=sheet.findCell(tableName);
            startRow=tableStart.getRow();
            startCol=tableStart.getColumn();

            Cell tableEnd= sheet.findCell(tableName, startCol+1,startRow+1, 100, 64000,  false);                

            endRow=tableEnd.getRow();
            endCol=tableEnd.getColumn();
            for(int x = startRow + 1; x < endRow; x++){
            	if(sheet.getCell(startCol+1,x).getContents().equalsIgnoreCase("No")){
            		noofnoexec++;
            	}
            }
            tabArray=new String[endRow-startRow-1-noofnoexec][endCol-startCol-1];
            ci=0;

            for (int i = startRow + 1;i < endRow; i++){
                cj=0;
               if(sheet.getCell(startCol+1,i).getContents().equalsIgnoreCase("Yes")){
            	   	for (int j = startCol+1;j < endCol; j++, cj++){
            	   		tabArray[ci][cj]=sheet.getCell(j,i).getContents();
                	}
            	   	ci++;
               }
            }
            

        return(tabArray);
    }
	
	}
