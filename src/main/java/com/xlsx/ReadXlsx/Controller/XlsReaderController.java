package com.xlsx.ReadXlsx.Controller;
import com.xlsx.ReadXlsx.Sevice.XlsReadService;
import com.xlsx.ReadXlsx.model.Custormer;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class XlsReaderController {

    @Autowired
    XlsReadService xlsReadService;

    @PostMapping("excel")
    public String excelReader(@RequestParam("file") MultipartFile excel) {

        try {
            XSSFWorkbook workbook = new XSSFWorkbook(excel.getInputStream());
            XSSFSheet sheet = workbook.getSheetAt(0);

//            XSSFCell header = sheet.getRow(0).getCell(1);
//            System.out.println("header : "+header);
            for(int i=0; i<sheet.getPhysicalNumberOfRows();i++) {
                XSSFRow row = sheet.getRow(i);
                Custormer custormer = new Custormer();
                for(int j=0;j<row.getPhysicalNumberOfCells();j++) {
//                    System.out.print(row.getCell(j) +" ");
                    custormer.setCustomerName(row.getCell(0).toString());
                    custormer.setCity(row.getCell(1).toString());
                    custormer.setCountry(row.getCell(2).toString());
                    custormer.setContactName(row.getCell(3).toString());
                }
                System.out.println(custormer.toString());
                System.out.println("");
                xlsReadService.createCustomer(custormer);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Error : "+e
            );
        }

        return "Success";
    }
}
