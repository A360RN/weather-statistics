package pe.unmsm.fisi.controller;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.MongoClient;

import pe.unmsm.fisi.dto.Stat;
import pe.unmsm.fisi.service.StatService;

@Controller
public class FileController {
	
	private final int TEMPERATURE_TYPE = 1;
	private final int PRECIPITATION_TYPE = 2;
	
	@Autowired
	private StatService statService;
	
	@RequestMapping(value = "/temperatureFile", method = RequestMethod.POST)
	@ResponseBody
	public void temperatureFileUpload(@RequestParam("file") MultipartFile excel) {
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(excel.getInputStream());

			XSSFSheet sheet = workbook.getSheetAt(0);

			Iterator<Row> itRow = sheet.iterator();
			int id = 0;
			int rows = 1;

			while (itRow.hasNext() && rows < 180) {
				Row currentRow = itRow.next();

				if (currentRow.getRowNum() > 0) {
					String ISOCountry = currentRow.getCell(0).getStringCellValue();
					for (int i = 1; i <= 12; i++) {
						Double stat = parseStatToDouble(currentRow, i);
						Stat entity = new Stat();
						entity.setType(TEMPERATURE_TYPE);
						entity.setMonth(i);
						entity.setId(id);
						entity.setCountryCode(ISOCountry);
						entity.setStat(stat);
						statService.insertStat(entity);
						id++;
					}
				}
				rows++;
			}

			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/precipitationFile", method = RequestMethod.POST)
	@ResponseBody
	public void precipitationFileUpload(@RequestParam("file") MultipartFile excel) {
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(excel.getInputStream());

			XSSFSheet sheet = workbook.getSheetAt(0);

			Iterator<Row> itRow = sheet.iterator();
			int id = 0;
			int rows = 1;

			while (itRow.hasNext() && rows < 180) {
				Row currentRow = itRow.next();

				if (currentRow.getRowNum() > 0) {
					String ISOCountry = currentRow.getCell(0).getStringCellValue();
					for (int i = 1; i <= 12; i++) {
						Double stat = parseStatToDouble(currentRow, i);
						System.out.println(stat);
						id++;
					}
				}
				rows++;
			}

			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Double parseStatToDouble(Row currentRow, int cellNumber) {
		return Double.parseDouble(currentRow.getCell(cellNumber).getStringCellValue());
	}
}
