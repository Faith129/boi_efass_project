package com.efass.sheet.mdfir371_3;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.sheet.mdfir333.ExcelSheet333Data;
import com.efass.sheet.mdfir333.sheet333DAO;
import com.efass.sheet.table.TabController;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class sheet371_3_Impl implements sheet371_3_Service {
    private static final String contentType ="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

    @Autowired
    Qdfir371_3Repo qdfir371_3Repo;
    @Autowired
    sheet371_3Repository _371_3Repository;

    List<GenericXml> genericXmlList;
    public List<GenericXml> getSheet371_3XmlList() {
        return genericXmlList;
    }
    public void setSheet371_3XmlList(List<GenericXml> genericXmlList) {
        this.genericXmlList = genericXmlList;
    }

    // ############################## MMFBR371_3 CRUD OPERATIONS #################################

    public ResponseEntity<?> createData(sheet371_3DAO data) throws ResourceNotFoundException {

        _371_3Repository.save(data);
        Response res = new Response();
        res.setResponseMessage("Success");
        res.setResponseCode(00);
        res.setS371_3Data(data);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    public ResponseEntity<?> fetchAllData() {
        Iterable<sheet371_3DAO> data = null;
        Iterable<sheetQdfir371_3DAO> qdfirData = null;
        List<GenericXml> genericXmls = new ArrayList<>();
        List<String> result = new ArrayList<>();
        AtomicInteger counter = new AtomicInteger(0);


        String reportName = "";
        Class<?> daoClass = null;

        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            reportName = "MDFIR371";
            daoClass = sheet371_3DAO.class;
            data = _371_3Repository.findAll();

            data.forEach((e) -> {
                        counter.getAndIncrement();
                        result.add(String.valueOf(counter));
                        result.add(e.getDerivative_financial_assets()== null ? "" :e.getDerivative_financial_assets());
                        result.add(e.getNotional_amount().toString() == null ? ".00" : String.valueOf(e.getNotional_amount().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getCarrying_value().toString() == null ? ".00" : String.valueOf(e.getCarrying_value().setScale(2, RoundingMode.HALF_EVEN)));
                    }
            );

            GenericXml.writeIntoXmlFormat(XmlParameters.builder()
                    .genericXmls(genericXmls)
                    .prefix(".T3")
                    .result(result)
                .daoClass(daoClass)
                    .reportName(reportName)
                            .isNoneSpecialWithPrefix(true)
                    .isIdPresent(true)
                    .build());

            setSheet371_3XmlList(genericXmls);
            Response res = new Response();
            res.setSheet371_3(data);
            res.setResponseCode(00);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            reportName = "QDFIR371";
            daoClass = sheetQdfir371_3DAO.class;
            qdfirData = qdfir371_3Repo.findAll();

            qdfirData.forEach((e) ->
            {
            	try {
        			   counter.getAndIncrement();
                        result.add(String.valueOf(counter));
                        result.add(e.getDerivative_financial_assets()== null ? "" :e.getDerivative_financial_assets());
                        result.add(e.getNotional_amount().toString() == null ? ".00" : String.valueOf(e.getNotional_amount().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getCarrying_value().toString() == null ? ".00" : String.valueOf(e.getCarrying_value().setScale(2, RoundingMode.HALF_EVEN)));
            	}
   			 catch(NullPointerException ex)
   	            {
   	    			System.out.println("NullPointerException thrown!");
   	            }
            	});
        }
        GenericXml.writeIntoXmlFormat(XmlParameters.builder()
                .genericXmls(genericXmls)
                .prefix(".T3")
                .result(result)
            .daoClass(daoClass)
                .reportName(reportName)
                        .isNoneSpecialWithPrefix(true)
                .isIdPresent(true)
                .build());

        setSheet371_3XmlList(genericXmls);
        ResponseQuarterly res = new ResponseQuarterly();
        res.setQdfir371_3(qdfirData);
        res.setResponseCode(00);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }



    public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
        sheet371_3DAO data = _371_3Repository.findById(dataId)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
        Response res = new Response();
        res.setResponseMessage("Record Found");
        res.setResponseCode(00);
        res.setS371_3Data(data);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

        Optional<sheet371_3DAO> data = _371_3Repository.findById(dataId);

        if (data.isPresent()) {
            _371_3Repository.delete(data.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + dataId);
        }
        Response res = new Response();
        res.setResponseMessage("Record Deleted");
        res.setResponseCode(00);
        return new ResponseEntity<>(res, HttpStatus.OK);

    }

    public ResponseEntity<?> updateData(int id , sheet371_3DAO Data) throws ResourceNotFoundException {

        Optional<sheet371_3DAO> DataDb = _371_3Repository.findById(id);

        if (DataDb.isPresent()) {
            sheet371_3DAO DataUpdate = DataDb.get();
            DataUpdate.setId(Data.getId());
            DataUpdate.setCarrying_value(Data.getCarrying_value());
            DataUpdate.setDerivative_financial_assets(Data.getDerivative_financial_assets());
            DataUpdate.setNotional_amount(Data.getNotional_amount());

            _371_3Repository.save(DataUpdate);
            Response res = new Response();
            res.setResponseMessage("Record Updated");
            res.setResponseCode(00);
            res.setS371_3Data(DataUpdate);
            return new ResponseEntity<>(res, HttpStatus.OK);

        } else {
            throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
        }
    }

	@Override
	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> createDataQ(sheetQdfir371_3DAO data) throws ResourceNotFoundException {
		qdfir371_3Repo.save(data);
        ResponseQuarterly res = new ResponseQuarterly();
        res.setResponseMessage("Success");
        res.setResponseCode(00);
        res.setS371_3Data(data);
        return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> fetchAllDataQ() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException {
		sheetQdfir371_3DAO data = qdfir371_3Repo.findById(dataId)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
        ResponseQuarterly res = new ResponseQuarterly();
        res.setResponseMessage("Record Found");
        res.setResponseCode(00);
        res.setS371_3Data(data);

        return new ResponseEntity<>(res, HttpStatus.OK);
	}
	@Override
	public ResponseEntity<?> deleteByIdQ(int dataId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir371_3DAO Data) throws ResourceNotFoundException {
		 Optional<sheetQdfir371_3DAO> DataDb = qdfir371_3Repo.findById(id);

	        if (DataDb.isPresent()) {
	        	sheetQdfir371_3DAO DataUpdate = DataDb.get();
	            DataUpdate.setId(Data.getId());
	            DataUpdate.setCarrying_value(Data.getCarrying_value());
	            DataUpdate.setDerivative_financial_assets(Data.getDerivative_financial_assets());
	            DataUpdate.setNotional_amount(Data.getNotional_amount());

	            qdfir371_3Repo.save(DataUpdate);
	            ResponseQuarterly res = new ResponseQuarterly();
	            res.setResponseMessage("Record Updated");
	            res.setResponseCode(00);
	            res.setS371_3Data(DataUpdate);
	            return new ResponseEntity<>(res, HttpStatus.OK);

	        } else {
	            throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
	        }
	}

    @Override
    public void saveSheet371_3ToDataBase(MultipartFile file, String sheetNo) {
        if (isValidExcelFile(file)) {
            try {
                List<sheet371_3DAO> excelData = getSheetDataFromExcel(file.getInputStream(), sheetNo);
                _371_3Repository.saveAll(excelData);

            } catch (IOException e) {
                throw new IllegalArgumentException("File is not a valid excel file");
            }
        }
    }
    private static List<sheet371_3DAO> getSheetDataFromExcel(InputStream inputStream, String sheetNumber) {
        List<sheet371_3DAO> sheet371_3s = new ArrayList<>();
        List<ExcelSheet371_3Data> excelSheet371_3Data = new ArrayList<>();

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

                    ExcelSheet371_3Data excelSheet371_3 = new ExcelSheet371_3Data();
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        switch (cellIndex) {
                            case 0 -> {
                                excelSheet371_3.setId((int) cell.getNumericCellValue());
                                System.out.println(excelSheet371_3.getId());
                            }

                            case 1 -> {
                                excelSheet371_3.setDerivative_financial_assets(cell.getStringCellValue());
                                System.out.println(excelSheet371_3.getDerivative_financial_assets());
                            }

                            case 2 -> {
                                excelSheet371_3.setNotional_amount(BigDecimal.valueOf(cell.getNumericCellValue()));
                                System.out.println(excelSheet371_3.getNotional_amount());
                            }
                            case 3 -> {
                                excelSheet371_3.setCarrying_value(BigDecimal.valueOf(cell.getNumericCellValue()));
                                System.out.println(excelSheet371_3.getCarrying_value());
                            }



                            default -> {

                            }
                        }
                        cellIndex++;
                    }
                    sheet371_3DAO mdfir371_3 = new sheet371_3DAO();
                    excelSheet371_3Data.add(excelSheet371_3);
                    for (ExcelSheet371_3Data ignored : excelSheet371_3Data) {
                        mdfir371_3.setCarrying_value(excelSheet371_3.getCarrying_value());
                        mdfir371_3.setDerivative_financial_assets(excelSheet371_3.getDerivative_financial_assets());
                        mdfir371_3.setNotional_amount(excelSheet371_3.getNotional_amount());

                    }
                    sheet371_3s.add(mdfir371_3);

                }
            }
            else {
                throw new RuntimeException("Sheet is null. Verify the sheet name in the Excel file.");
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("file too large");
        }
        return sheet371_3s;
    }
    private static boolean isValidExcelFile(MultipartFile file) {
        return Objects.equals(file.getContentType(), contentType);
    }
}
