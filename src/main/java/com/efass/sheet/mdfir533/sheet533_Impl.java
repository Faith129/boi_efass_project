package com.efass.sheet.mdfir533;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.sheet.mdfir423.sheet423DAO;
import com.efass.sheet.mdfir423.sheetQdfir423DAO;
import com.efass.sheet.table.TabController;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

@Service
public class sheet533_Impl implements sheet533_Service{
    private static final String contentType ="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

    @Autowired
    Qdfir533Repo qdfir533Repo;
    @Autowired
   sheet533Repository sheet533Repo;
    List<GenericXml> genericXmlList;

    public List<GenericXml> getSheet533XmlList() {
        return genericXmlList;
    }

    public void setSheet533XmlList(List<GenericXml> genericXmlList) {
        this.genericXmlList = genericXmlList;
    }

    @Override
    public ResponseEntity<?> fetchAllData() {
        Iterable<sheet533DAO> data = null;
        Iterable<sheetQdfir533DAO> qdfirData = null;
        List<GenericXml> genericXmls = new ArrayList<>();
        List<String> result = new ArrayList<>();
        List<String> codes = new ArrayList<>();

        String reportName = "";
        Class<?> daoClass = null;

        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            reportName = "MDFIR533";
            daoClass = sheet533DAO.class;
            data = sheet533Repo.findAll();

            data.forEach((e) ->
            {
            	try {
        			//System.out.println("i am here 533");
                codes.add(e.getCode() == null ? "" :e.getCode());
                //    result.add(e.getDescription() == null ? "" :e.getDescription());
                result.add(e.getGross_amount() == null ? ".00" :String.valueOf(e.getGross_amount().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getAdditions() == null ? ".00" :String.valueOf(e.getAdditions().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getAccumulated_depreciation() == null ? ".00" :String.valueOf(e.getAccumulated_depreciation().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getImpairment()== null ? ".00" :String.valueOf(e.getImpairment().setScale(2, RoundingMode.HALF_EVEN)));
               // result.add(e.getCarrying_amount() == null ? ".00" :String.valueOf(e.getCarrying_amount().setScale(2, RoundingMode.HALF_EVEN)));
            }
			 catch(NullPointerException ex)
	            {
	    			System.out.println("NullPointerException thrown!");
	            }
            });
            List<String> skipCodes =Arrays.asList("11399", "11400");
            GenericXml.writeIntoXmlFormat(XmlParameters.builder()
                    .isSpecial(true)
                    .prefix("")
                    .isSkipRows(false)
                    .daoClass(daoClass)
                    .reportName(reportName)
                    .result(result)
                    .genericXmls(genericXmls).isSkipRows(true)
                    .skipRows(skipCodes)
                    .codes(codes)
                    .build());
            setSheet533XmlList(genericXmls);
            Response res = new Response();
            res.setSheet533(data);
            res.setResponseMessage("Success");
            res.setResponseCode(00);
            return new ResponseEntity<>(res, HttpStatus.OK);

        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            reportName = "QDFIR533";
            daoClass = sheetQdfir533DAO.class;
            qdfirData = qdfir533Repo.findAll();


            qdfirData.forEach((e) -> {
            	try {
        			//System.out.println("i am here 533");
                codes.add(e.getCode() == null ? "" :e.getCode());
                //    result.add(e.getDescription() == null ? "" :e.getDescription());
                result.add(e.getGross_amount() == null ? ".00" :String.valueOf(e.getGross_amount().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getAdditions() == null ? ".00" :String.valueOf(e.getAdditions().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getAccumulated_depreciation() == null ? ".00" :String.valueOf(e.getAccumulated_depreciation().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getImpairment()== null ? ".00" :String.valueOf(e.getImpairment().setScale(2, RoundingMode.HALF_EVEN)));
               // result.add(e.getCarrying_amount() == null ? ".00" :String.valueOf(e.getCarrying_amount().setScale(2, RoundingMode.HALF_EVEN)));
            }
			 catch(NullPointerException ex)
	            {
	    			System.out.println("NullPointerException thrown!");
	            }
            });
        }
        List<String> skipCodes =Arrays.asList("11399", "11400");
        GenericXml.writeIntoXmlFormat(XmlParameters.builder()
                .isSpecial(true)
                .prefix("")
                .isSkipRows(false)
                .daoClass(daoClass)
                .reportName(reportName)
                .result(result)
                .genericXmls(genericXmls).isSkipRows(true)
                .skipRows(skipCodes)
                .codes(codes)
                .build());
        setSheet533XmlList(genericXmls);
        ResponseQuarterly res = new ResponseQuarterly();
        res.setQdfir533(qdfirData);
        res.setResponseMessage("Success");
        res.setResponseCode(00);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateData(int id, sheet533DAO Data) throws ResourceNotFoundException {
        Optional<sheet533DAO> DataDb = sheet533Repo.findById(id);

        if (DataDb.isPresent()) {
        	sheet533DAO DataUpdate = DataDb.get();

            DataUpdate.setGross_amount(Data.getGross_amount());
            DataUpdate.setAdditions(Data.getAdditions());
            DataUpdate.setAccumulated_depreciation(Data.getAccumulated_depreciation());
            DataUpdate.setImpairment(Data.getImpairment());
            sheet533Repo.save(DataUpdate);
            Response res = new Response();
            res.setResponseMessage("Record Updated");
            res.setResponseCode(00);
            res.setS533Data(DataUpdate);
            return new ResponseEntity<>(res, HttpStatus.OK);

        } else {
            throw new ResourceNotFoundException("Record not found : " + Data.getId());
        }
    }

    @Override
    public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
    	sheet533DAO data = sheet533Repo.findById(dataId)
            .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

        Response res = new Response();
        res.setResponseMessage("Record Found");
        res.setResponseCode(00);
        res.setS533Data(data);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

	@Override
	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> fetchAllDataQ() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir533DAO Data) throws ResourceNotFoundException {
		 Optional<sheetQdfir533DAO> DataDb = qdfir533Repo.findById(id);

	        if (DataDb.isPresent()) {
	        	sheetQdfir533DAO DataUpdate = DataDb.get();

	            DataUpdate.setGross_amount(Data.getGross_amount());
	            DataUpdate.setAdditions(Data.getAdditions());
	            DataUpdate.setAccumulated_depreciation(Data.getAccumulated_depreciation());
	            DataUpdate.setImpairment(Data.getImpairment());
	           // DataUpdate.setCarrying_amount(Data.getCarrying_amount());
	            qdfir533Repo.save(DataUpdate);
	            ResponseQuarterly res = new ResponseQuarterly();
	            res.setResponseMessage("Record Updated");
	            res.setResponseCode(00);
	            res.setS533Data(DataUpdate);
	            return new ResponseEntity<>(res, HttpStatus.OK);

	        } else {
	            throw new ResourceNotFoundException("Record not found : " + Data.getId());
	        }
	}

	@Override
	public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException {
		sheetQdfir533DAO data = qdfir533Repo.findById(dataId)
	            .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

	        ResponseQuarterly res = new ResponseQuarterly();
	        res.setResponseMessage("Record Found");
	        res.setResponseCode(00);
	        res.setS533Data(data);
	        return new ResponseEntity<>(res, HttpStatus.OK);
	}

    @Override
    public void saveSheet533ToDataBase(MultipartFile file, String sheetNo) {
        if (isValidExcelFile(file)) {
            try {
                List<sheet533DAO> excelData = getSheetDataFromExcel(file.getInputStream(), sheetNo);
                updateOrSaveSheet533Data(excelData);

            } catch (IOException e) {
                throw new IllegalArgumentException("File is not a valid excel file");
            }
        }
    }
    private static List<sheet533DAO> getSheetDataFromExcel(InputStream inputStream, String sheetNumber) {
        List<sheet533DAO> sheet193s = new ArrayList<>();
        List<ExcelSheet533Data> excelSheet533Data = new ArrayList<>();
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
                    if (rowIndex == 1) {
                        rowIndex++;
                        continue;
                    }
                    Iterator<Cell> cellIterator = row.iterator();
                    int cellIndex = 0;

                    sheet533DAO sheet533 = new sheet533DAO();
                    ExcelSheet533Data excelSheet533  = new ExcelSheet533Data();
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        switch (cellIndex) {
                            case 0 -> excelSheet533.setCode(String.format("%.0f", cell.getNumericCellValue()));
                            case 1 -> excelSheet533.setDescription(cell.getStringCellValue());
                            case 2 -> excelSheet533.setGross_amount(BigDecimal.valueOf(cell.getNumericCellValue()));
                            case 3 -> excelSheet533.setAdditions(BigDecimal.valueOf(cell.getNumericCellValue()));
                            case 4 -> excelSheet533.setAccumulated_depreciation(BigDecimal.valueOf(cell.getNumericCellValue()));
                            case 5 -> excelSheet533.setImpairment(BigDecimal.valueOf(cell.getNumericCellValue()));
                            default -> {
                            }
                        }
                        cellIndex++;
                    }
//					sheet193s.add(sheet533);
                    excelSheet533Data.add(excelSheet533);
                    excelSheet533Data.forEach(sheet533Data -> {
                        sheet533.setCode(excelSheet533.getCode());
                        sheet533.setDescription(excelSheet533.getDescription());
                        sheet533.setGross_amount(excelSheet533.getGross_amount());
                        sheet533.setAdditions(excelSheet533.getAdditions());
                        sheet533.setAccumulated_depreciation(excelSheet533.getAccumulated_depreciation());
                        sheet533.setImpairment(excelSheet533.getImpairment());
                    });
                    sheet193s.add(sheet533);
                }
            }
            else {
                throw new RuntimeException("Sheet is null. Verify the sheet name in the Excel file.");
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("file too large");
        }
        return sheet193s;
    }

    private static boolean isValidExcelFile(MultipartFile file) {
        return Objects.equals(file.getContentType(), contentType);
    }

    private void updateOrSaveSheet533Data(List<sheet533DAO> excelData) {
        // Update existing record
        sheet533DAO newSheetRecord = new sheet533DAO();
        for (sheet533DAO sheet533 : excelData) {
            sheet533DAO existingRecord = sheet533Repo.findByCode(sheet533.getCode().trim()).orElse(null);
            if (existingRecord != null) {
                existingRecord.setGross_amount(sheet533.getGross_amount());
                existingRecord.setAdditions(sheet533.getAdditions());
                existingRecord.setAccumulated_depreciation(sheet533.getAccumulated_depreciation());
                existingRecord.setImpairment(sheet533.getImpairment());
                sheet533Repo.save(existingRecord);

            } else {
                throw new RuntimeException("Sheet with code "+sheet533.getCode()+" does not exist");
            }
        }
    }

}
