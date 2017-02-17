import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;


public class Main {

    public static void main(String[] args) throws IOException {
        Properties property = new GetEndpointProperty().load("config.properties");
        String endpoint = property.getProperty("endpoint");
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");

        String s="";
        String filename = "BNM.xls" ;
        HSSFWorkbook wb = null;
        wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("CURSXMLJSON");
        for(int h=0;h<10;h++) {
            Row row = sheet.createRow(h);
            row.setHeightInPoints(110);
            Cell daterate = row.createCell(0);
            DataFormat format = wb.createDataFormat();
            CellStyle dateStyle = wb.createCellStyle();
            dateStyle.setDataFormat(format.getFormat("dd.mm.yyyy"));
            daterate.setCellStyle(dateStyle);

            daterate.setCellValue(format1.format(calendar.getTime()));
            sheet.autoSizeColumn(0);
            try
            {
                XMLfromEndpoint xmlfe = new XMLfromEndpoint();
                s=xmlfe.importing(endpoint+format1.format(calendar.getTime()));
                DeserializeXML convertfromxml=new DeserializeXML();
                ValCurs Obj=convertfromxml.convert(s);
                String CellContentXML=new ConverttoXML().convert(Obj);
                Cell DataXML = row.createCell(1);
                DataXML.setCellValue(CellContentXML);
                sheet.autoSizeColumn(1);
                String CellContentJSON = new ConverttoJSON().convert(Obj);
                Cell DataJSON = row.createCell(2);
                DataJSON.setCellValue(CellContentJSON);
                sheet.autoSizeColumn(2);
            }catch (Exception e){
                e.printStackTrace();}
            calendar.add(Calendar.DAY_OF_MONTH, -1);
        } try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            wb.write(fileOut);
            fileOut.close();
            System.out.println("File BNM.xls has been generated !");}
        catch ( Exception ex ) {
            System.out.println(ex);
        }
        try {
            wb.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
