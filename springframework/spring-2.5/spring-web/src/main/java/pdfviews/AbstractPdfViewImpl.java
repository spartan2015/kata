package pdfviews;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.hyphenation.TernaryTree.Iterator;

public class AbstractPdfViewImpl extends AbstractPdfView{
	
	@Override
	protected void buildPdfDocument(Map model, Document document,
			PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

        Table table = new Table(4);
        table.setWidth(90);
        table.setBorderWidth(1);
        table.addCell("State");
                                            
        table.addCell("Plate");
                                            
        table.addCell("Date Posted");   
        table.addCell("Text");
        for (int i = 0; i < 1000; i++) {
          
          table.addCell("" + i);      
          table.addCell("" + i);
          table.addCell("" + i);   
          table.addCell("" + i);
        }
        document.add(table);

	}
}
