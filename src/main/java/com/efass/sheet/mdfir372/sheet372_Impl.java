package com.efass.sheet.mdfir372;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.sheet.mdfir372.ExcelSheet372Data;
import com.efass.sheet.mdfir372.sheet372DAO;
import com.efass.sheet.mdfir371_1.sheet371_1DAO;
import com.efass.sheet.mdfir371_1.sheetQdfir371_1DAO;
import com.efass.sheet.mdfir371_3.sheet371_3DAO;
import com.efass.sheet.mdfir371_3.sheet371_3Repository;
import com.efass.sheet.mdfir371_3.sheet371_3_Service;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class sheet372_Impl implements sheet372_Service {
    private static final String contentType ="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

    @Autowired
    sheet372Repository _372Repository;

    @Autowired
    Qdfir372Repo qdfir372Repo;
    List<GenericXml> genericXmlList;
    public List<GenericXml> getSheet372XmlList() {
        return genericXmlList;
    }
    public void setSheet372XmlList(List<GenericXml> genericXmlList) {
        this.genericXmlList = genericXmlList;
    }

    // ############################## MMFBR372 CRUD OPERATIONS #################################

    public ResponseEntity<?> createData(sheet372DAO data) throws ResourceNotFoundException {

        _372Repository.save(data);
        Response res = new Response();
        res.setResponseMessage("Success");
        res.setResponseCode(00);
        res.setS372Data(data);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    public ResponseEntity<?> fetchAllData() {
        Iterable<sheet372DAO> data = null;
        Iterable<sheetQdfir372DAO> qdfirData = null;
        List<GenericXml> genericXmls = new ArrayList<>();
        List<String> result = new ArrayList<>();
        AtomicInteger counter = new AtomicInteger(0);


        String reportName = "";
        Class<?> daoClass = null;

        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            reportName = "MDFIR372";
            daoClass = sheet372DAO.class;
            data = _372Repository.findAll();

            data.forEach((e) ->
            {
            	try {
                        counter.getAndIncrement();
                        result.add(String.valueOf(counter));
                        result.add(e.getCustomer_code()== null ? "" : e.getCustomer_code());
                        result.add(e.getCustomer_name() == null ? "" :e.getCustomer_name());
                        result.add(e.getPrincipal_granted().toString() == null ? ".00" : String.valueOf(e.getPrincipal_granted().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getPurpose() == null ? "" :e.getPurpose());
                        result.add(e.getDate_granted().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate_granted().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
        				result.add(e.getDue_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDue_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                        result.add(e.getPrincipal_outstanding().toString() == null ? ".00" : String.valueOf(e.getPrincipal_outstanding().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getInterest_rate().toString() == null ? ".00" : String.valueOf(e.getInterest_rate().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getUpfront_interest().toString() == null ? ".00" : String.valueOf(e.getUpfront_interest().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getInterest_payable().toString() == null ? ".00" : String.valueOf(e.getInterest_payable().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getUnpaid_principal_interest().toString() == null ? ".00" : String.valueOf(e.getUnpaid_principal_interest().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getTimes_rolled_over() == null ? "" :e.getTimes_rolled_over());
                        result.add(e.getColl_or_value() == null ? "" :e.getColl_or_value());
        	}
			 catch(NullPointerException ex)
	            {
	    			System.out.println("NullPointerException thrown!");
	            }
                    });

            GenericXml.writeIntoXmlFormat(XmlParameters.builder()
                    .genericXmls(genericXmls)
                    .prefix("")
                    .result(result)
                .daoClass(daoClass)
                    .reportName(reportName)
                .isNoneSpecialWithPrefix(true)
                    .isIdPresent(true)

                    .build());

            setSheet372XmlList(genericXmls);
            Response res = new Response();
            res.setSheet372(data);
            res.setResponseCode(00);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            reportName = "QDFIR372";
            daoClass = sheetQdfir372DAO.class;
            qdfirData = qdfir372Repo.findAll();

            qdfirData.forEach((e) -> {
                        counter.getAndIncrement();
                        result.add(String.valueOf(counter));
                        result.add(e.getCustomer_code()== null ? "" : e.getCustomer_code());
                        result.add(e.getCustomer_name() == null ? "" :e.getCustomer_name());
                        result.add(e.getPrincipal_granted().toString() == null ? ".00" : String.valueOf(e.getPrincipal_granted().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getPurpose() == null ? "" :e.getPurpose());
                        result.add(e.getDate_granted().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate_granted().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
        				result.add(e.getDue_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDue_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                        result.add(e.getPrincipal_outstanding().toString() == null ? ".00" : String.valueOf(e.getPrincipal_outstanding().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getInterest_rate().toString() == null ? ".00" : String.valueOf(e.getInterest_rate().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getUpfront_interest().toString() == null ? ".00" : String.valueOf(e.getUpfront_interest().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getInterest_payable().toString() == null ? ".00" : String.valueOf(e.getInterest_payable().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getUnpaid_principal_interest().toString() == null ? ".00" : String.valueOf(e.getUnpaid_principal_interest().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getTimes_rolled_over() == null ? "" :e.getTimes_rolled_over());
                        result.add(e.getColl_or_value() == null ? "" :e.getColl_or_value());

                    }
            );
        }
        GenericXml.writeIntoXmlFormat(XmlParameters.builder()
                .genericXmls(genericXmls)
                .prefix("")
                .result(result)
            .daoClass(daoClass)
                .reportName(reportName)
            .isNoneSpecialWithPrefix(true)
                .isIdPresent(true)

                .build());

        setSheet372XmlList(genericXmls);
        ResponseQuarterly res = new ResponseQuarterly();
        res.setQdfir372(qdfirData);
        res.setResponseCode(00);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }



    public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
        sheet372DAO data = _372Repository.findById(dataId)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
        Response res = new Response();
        res.setResponseMessage("Record Found");
        res.setResponseCode(00);
        res.setS372Data(data);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

        Optional<sheet372DAO> data = _372Repository.findById(dataId);

        if (data.isPresent()) {
            _372Repository.delete(data.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + dataId);
        }
        Response res = new Response();
        res.setResponseMessage("Record Deleted");
        res.setResponseCode(00);
        return new ResponseEntity<>(res, HttpStatus.OK);

    }

    public ResponseEntity<?> updateData(int id , sheet372DAO Data) throws ResourceNotFoundException {

        Optional<sheet372DAO> DataDb = _372Repository.findById(id);

        if (DataDb.isPresent()) {
            sheet372DAO DataUpdate = DataDb.get();
            DataUpdate.setId(Data.getId());
            DataUpdate.setCustomer_code(Data.getCustomer_code());
            DataUpdate.setCustomer_name(Data.getCustomer_name());
            DataUpdate.setPrincipal_granted(Data.getPrincipal_granted());
            DataUpdate.setPurpose(Data.getPurpose());
            DataUpdate.setDate_granted(Data.getDate_granted());
            DataUpdate.setDue_date(Data.getDue_date());
            DataUpdate.setPrincipal_outstanding(Data.getPrincipal_outstanding());
            DataUpdate.setInterest_rate(Data.getInterest_rate());
            DataUpdate.setUpfront_interest(Data.getUpfront_interest());
            DataUpdate.setInterest_payable(Data.getInterest_payable());
            DataUpdate.setUnpaid_principal_interest(Data.getUnpaid_principal_interest());
            DataUpdate.setTimes_rolled_over(Data.getTimes_rolled_over());
            DataUpdate.setColl_or_value(Data.getColl_or_value());

            _372Repository.save(DataUpdate);
            Response res = new Response();
            res.setResponseMessage("Record Updated");
            res.setResponseCode(00);
            res.setS372Data(DataUpdate);
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
	public ResponseEntity<?> createDataQ(sheetQdfir372DAO data) throws ResourceNotFoundException {
		qdfir372Repo.save(data);
	        ResponseQuarterly res = new ResponseQuarterly();
	        res.setResponseMessage("Success");
	        res.setResponseCode(00);
	        res.setS372Data(data);
	        return new ResponseEntity<>(res, HttpStatus.OK);
	}
	@Override
	public ResponseEntity<?> fetchAllDataQ() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException {
		sheetQdfir372DAO data = qdfir372Repo.findById(dataId)
	                .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
	        ResponseQuarterly res = new ResponseQuarterly();
	        res.setResponseMessage("Record Found");
	        res.setResponseCode(00);
	        res.setS372Data(data);

	        return new ResponseEntity<>(res, HttpStatus.OK);
	}
	@Override
	public ResponseEntity<?> deleteByIdQ(int dataId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir372DAO Data) throws ResourceNotFoundException {
		Optional<sheetQdfir372DAO> DataDb = qdfir372Repo.findById(id);

        if (DataDb.isPresent()) {
        	sheetQdfir372DAO DataUpdate = DataDb.get();
            DataUpdate.setId(Data.getId());
            DataUpdate.setCustomer_code(Data.getCustomer_code());
            DataUpdate.setCustomer_name(Data.getCustomer_name());
            DataUpdate.setPrincipal_granted(Data.getPrincipal_granted());
            DataUpdate.setPurpose(Data.getPurpose());
            DataUpdate.setDate_granted(Data.getDate_granted());
            DataUpdate.setDue_date(Data.getDue_date());
            DataUpdate.setPrincipal_outstanding(Data.getPrincipal_outstanding());
            DataUpdate.setInterest_rate(Data.getInterest_rate());
            DataUpdate.setUpfront_interest(Data.getUpfront_interest());
            DataUpdate.setInterest_payable(Data.getInterest_payable());
            DataUpdate.setUnpaid_principal_interest(Data.getUnpaid_principal_interest());
            DataUpdate.setTimes_rolled_over(Data.getTimes_rolled_over());
            DataUpdate.setColl_or_value(Data.getColl_or_value());

            qdfir372Repo.save(DataUpdate);
            ResponseQuarterly res = new ResponseQuarterly();
            res.setResponseMessage("Record Updated");
            res.setResponseCode(00);
            res.setS372Data(DataUpdate);
            return new ResponseEntity<>(res, HttpStatus.OK);

        } else {
            throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
        }
    }
    @Override
    public void saveSheet372ToDataBase(MultipartFile file, String sheetNo) {
        if (isValidExcelFile(file)) {
            try {
                List<sheet372DAO> excelData = getSheetDataFromExcel(file.getInputStream(), sheetNo);
                _372Repository.saveAll(excelData);

            } catch (IOException e) {
                throw new IllegalArgumentException("File is not a valid excel file");
            }
        }
    }

    private static List<sheet372DAO> getSheetDataFromExcel(InputStream inputStream, String sheetNumber) {
        List<sheet372DAO> sheet372s = new ArrayList<>();
        List<ExcelSheet372Data> excelSheet372Data = new ArrayList<>();

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

                    ExcelSheet372Data excelSheet372 = new ExcelSheet372Data();
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        switch (cellIndex) {
                            case 0 -> {
                                excelSheet372.setId((int) cell.getNumericCellValue());
                                System.out.println(excelSheet372.getId());
                            }

                            case 1 -> {
                                excelSheet372.setCustomer_code(cell.getStringCellValue());
                                System.out.println(excelSheet372.getCustomer_code());
                            }

                            case 2 -> {
                                excelSheet372.setCustomer_name(cell.getStringCellValue());
                                System.out.println(excelSheet372.getCustomer_name());
                            }

                            case 3 -> {
                                excelSheet372.setPrincipal_granted(BigDecimal.valueOf(cell.getNumericCellValue()));
                                System.out.println(excelSheet372.getPrincipal_granted());
                            }

                            case 4 -> {
                                excelSheet372.setPurpose(cell.getStringCellValue());
                                System.out.println(excelSheet372.getPurpose());
                            }

                            case 5 -> {
                                excelSheet372.setDate_granted(String.valueOf(cell.getDateCellValue()));
                                System.out.println(excelSheet372.getDate_granted());
                            }

                            case 6 -> {
                                excelSheet372.setDue_date(String.valueOf(cell.getDateCellValue()));
                                System.out.println(excelSheet372.getDue_date());
                            }

                            case 7 -> {
                                excelSheet372.setPrincipal_outstanding(BigDecimal.valueOf(cell.getNumericCellValue()));
                                System.out.println(excelSheet372.getPrincipal_outstanding());
                            }case 8 -> {
                                excelSheet372.setInterest_rate(BigDecimal.valueOf(cell.getNumericCellValue()));
                                System.out.println(excelSheet372.getInterest_rate());

                        }case 9 -> {
                            excelSheet372.setUpfront_interest(BigDecimal.valueOf(cell.getNumericCellValue()));
                            System.out.println(excelSheet372.getUpfront_interest());
                        }

                            case 10 -> {
                                excelSheet372.setInterest_payable(BigDecimal.valueOf(cell.getNumericCellValue()));
                                System.out.println(excelSheet372.getInterest_payable());
                            }

                            case 11 -> {
                                excelSheet372.setUnpaid_principal_interest(BigDecimal.valueOf(cell.getNumericCellValue()));
                                System.out.println(excelSheet372.getUnpaid_principal_interest());
                            }

                            case 12 -> {
                                excelSheet372.setTimes_rolled_over(cell.getStringCellValue());
                                System.out.println(excelSheet372.getTimes_rolled_over());
                            }

                            case 13 -> {
                                excelSheet372.setColl_or_value(cell.getStringCellValue());
                                System.out.println(excelSheet372.getInterest_rate());
                            }

                            default -> {

                            }
                        }
                        cellIndex++;
                    }
                    sheet372DAO mdfir372 = new sheet372DAO();
                    excelSheet372Data.add(excelSheet372);
                    for(ExcelSheet372Data ignored: excelSheet372Data){
                        mdfir372.setCustomer_code(excelSheet372.getCustomer_code());
                        mdfir372.setCustomer_name(excelSheet372.getCustomer_name());
                        mdfir372.setPrincipal_granted(excelSheet372.getPrincipal_granted());
                        mdfir372.setPurpose(excelSheet372.getPurpose());
                        mdfir372.setDate_granted(LocalDate.parse(excelSheet372.getDate_granted()));
                        mdfir372.setDue_date(LocalDate.parse(excelSheet372.getDue_date()));
                        mdfir372.setPrincipal_outstanding(excelSheet372.getPrincipal_outstanding());
                        mdfir372.setInterest_rate(excelSheet372.getInterest_rate());
                        mdfir372.setInterest_payable(excelSheet372.getInterest_payable());
                        mdfir372.setUnpaid_principal_interest(excelSheet372.getUnpaid_principal_interest());
                        mdfir372.setTimes_rolled_over(excelSheet372.getTimes_rolled_over());
                        mdfir372.setColl_or_value(excelSheet372.getColl_or_value());
                    }
                    sheet372s.add(mdfir372);
                }
            }
            else {
                throw new RuntimeException("Sheet is null. Verify the sheet name in the Excel file.");
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("file too large");
        }
        return sheet372s;
    }
    private static boolean isValidExcelFile(MultipartFile file) {
        return Objects.equals(file.getContentType(), contentType);
    }

}

