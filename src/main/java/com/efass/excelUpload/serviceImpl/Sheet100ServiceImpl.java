package com.efass.excelUpload.serviceImpl;

import com.efass.excelUpload.service.UploadSheetService;
import com.efass.sheet.mdfir100.sheet100DAO;
import com.efass.sheet.mdfir100.sheet100Repository;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class Sheet100ServiceImpl implements UploadSheetService {

    private final sheet100Repository sheet100Repo;
    @Value("${app.contentType}")
    private static String contentType;
    @Override
    public void saveSheet100ToDataBase(MultipartFile file, String sheetNo) {
        if (isValidExcelFile(file)) {
            try {
                List<sheet100DAO> excelData = getSheetDataFromExcel(file.getInputStream(), sheetNo);
                sheet100Repo.saveAll(excelData);

            } catch (IOException e) {
                throw new IllegalArgumentException("File is not a valid excel file");
            }
        }
    }
        private static List<sheet100DAO> getSheetDataFromExcel(InputStream inputStream,String sheetNumber) {
            List<sheet100DAO> sheet100s = new ArrayList<>();
            try {
                XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
                XSSFSheet sheet = workbook.getSheet(sheetNumber.trim());


                if (sheet != null) {

                    int rowIndex = 0;
                    for (Row row : sheet) {
                        if (rowIndex == 0) {
                            rowIndex++;
                            continue;
                        }
                        Iterator<Cell> cellIterator = row.iterator();
                        int cellIndex = 0;

                        sheet100DAO sheet100 = new sheet100DAO();
                        while (cellIterator.hasNext()) {
                            Cell cell = cellIterator.next();
                            switch (cellIndex) {
                                case 0 -> sheet100.setCode(cell.getStringCellValue());
                                case 1 -> sheet100.setDescription(cell.getStringCellValue());
                                case 2 -> sheet100.setNumber_1(BigDecimal.valueOf(cell.getNumericCellValue()));
                                case 3 -> sheet100.setValue_1(BigDecimal.valueOf(cell.getNumericCellValue()));
                                case 4 -> sheet100.setNumber_2(BigDecimal.valueOf(cell.getNumericCellValue()));
                                case 5 -> sheet100.setValue_2(BigDecimal.valueOf(cell.getNumericCellValue()));
                                default -> {

                                }
                            }
                            cellIndex++;
                        }
                        sheet100s.add(sheet100);
                    }
                }
                else {
                    throw new RuntimeException("Sheet is null. Verify the sheet name in the Excel file.");
                }

            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("file too large");
            }
            return sheet100s;
        }

    private static boolean isValidExcelFile(MultipartFile file) {
        return Objects.equals(file.getContentType(), contentType);
    }
}

