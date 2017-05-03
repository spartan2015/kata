package excelviews;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class ExcelView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map model, HSSFWorkbook workbook,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		HSSFSheet sheet = workbook.createSheet("OurFirstExcelSheet");
		HSSFRow header = sheet.createRow(0);
		header.createCell((short) 0).setCellValue("Date");
		header.createCell((short) 1).setCellValue("Text");

		HSSFCellStyle cellStyle = workbook.createCellStyle();

		cellStyle.setDataFormat(

		HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
		int rowNum = 1;

		for (int i = 0; i < 3; i++) {
			HSSFRow row = sheet.createRow(rowNum++);
			row.createCell((short) 0).setCellValue("cell1");
			row.createCell((short) 1).setCellValue("cell2");
			row.getCell((short) 1).setCellStyle(cellStyle);
		}

	}
}
