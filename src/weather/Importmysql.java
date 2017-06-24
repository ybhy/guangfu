package weather;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * Excel to MySQL!
 *
 */
public class Importmysql {
//	public static void main(String[] args) {
//		Connectmysql connection = new Connectmysql();
//		connection.select();
//	}
	public static void main(String[] args) {
		String path = "G://weather//generate electricity/";
		File file = new File(path);
		File[] tempList = file.listFiles();
		Connectmysql Connection = new Connectmysql();
		for (int i = 0; i < tempList.length; i++) {
			String fileName = tempList[i].getName();
			System.out.println(fileName);
			double onetemp = 0;
			double twotemp = 0.0;
			double threetemp = 0.0;
			double fourtemp = 0.0;
			double fivetemp = 0.0;
			double sixtemp = 0.0;
			double seventemp = 0.0;
			try {
				Workbook wb = WorkbookFactory.create(new FileInputStream(tempList[i]));
				Sheet sheet = wb.getSheetAt(0);
				Row row = sheet.getRow(0);
				for(int j = 3; j < 6; j++)
				{
					try {
						row = sheet.getRow(j);
						if (row == null) {
							continue;
						}
						String date = tempList[i].getName().substring(0,fileName.indexOf('x') - 1).replace('_', '-');
						String time = row.getCell(0).toString();
						Cell onetempCell = row.getCell(1);
						Cell twotempCell = row.getCell(2);
						Cell threetempCell = row.getCell(3);
						Cell fourtempCell = row.getCell(4);
						Cell fivetempCell = row.getCell(5);
						Cell sixtempCell = row.getCell(6);
						Cell seventempCell = row.getCell(7);
						onetemp = onetempCell.getNumericCellValue();
						twotemp = twotempCell.getNumericCellValue();
						threetemp = threetempCell.getNumericCellValue();
						fourtemp = fourtempCell.getNumericCellValue();
						fivetemp = fivetempCell.getNumericCellValue();
						sixtemp = sixtempCell.getNumericCellValue();
						seventemp =seventempCell.getNumericCellValue();
						System.out.println(date + "---" + time + "---" +
								onetempCell.getNumericCellValue()
								+ "---" + twotempCell.getNumericCellValue()
								+ "---" + threetempCell.getNumericCellValue()
								+ "---" + fourtempCell.getNumericCellValue()
								+ "---" + fivetempCell.getNumericCellValue()
								+ "---" + sixtempCell.getNumericCellValue()
								+ "---" + seventempCell.getNumericCellValue()
								+ "---" + tempList[i].getName());
						Connection.upDateTemp(date, time, 
								onetemp,
								twotemp,
								threetemp,
								fourtemp,
								fivetemp,
								sixtemp,
								seventemp);
					} catch (Exception e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
				
				for (int j = 6; j < 27; j++) {
					try {
						row = sheet.getRow(j);
						if (row == null) {
							continue;
						}
						String date = tempList[i].getName().substring(0,fileName.indexOf('x') - 1).replace('_', '-');
						String time = row.getCell(0).toString();
						double oneTempT = row.getCell(1).getNumericCellValue() - onetemp;
						double twoTempT = row.getCell(2).getNumericCellValue() - twotemp;
						double threeTempT = row.getCell(3).getNumericCellValue() - threetemp;
						double fourTempT = row.getCell(4).getNumericCellValue() - fourtemp;
						double fiveTempT = row.getCell(5).getNumericCellValue() - fivetemp;
						double sixTempT = row.getCell(6).getNumericCellValue() - sixtemp;
						double sevenTempT = row.getCell(7).getNumericCellValue() - seventemp;
						onetemp = row.getCell(1).getNumericCellValue();
						twotemp = row.getCell(2).getNumericCellValue();
						threetemp = row.getCell(3).getNumericCellValue();
						fourtemp = row.getCell(4).getNumericCellValue();
						fivetemp = row.getCell(5).getNumericCellValue();
						sixtemp = row.getCell(6).getNumericCellValue();
						seventemp = row.getCell(7).getNumericCellValue();
						System.out.println(date + "---" + time + "---" +
								oneTempT + "---" + twoTempT + "---" + threeTempT + "---"
								+ fourTempT + "---" + fiveTempT + "---" + sixTempT + "---" + sevenTempT 
								+ "---" + tempList[i].getName());
						Connection.upDateTemp(date, time, 
								oneTempT,
								twoTempT,
								threeTempT,
								fourTempT,
								fiveTempT,
								sixTempT,
								sevenTempT);
						
					}catch(Exception e)
					{
						e.printStackTrace();
						System.out.println(e.getMessage());
					}
					
				}
			} catch (EncryptedDocumentException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (InvalidFormatException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		Connection.close();
	}
}
