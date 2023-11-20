package com.efass.sheet.mdfir291;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.sheet.mdfir271.ExcelSheet271Data;
import com.efass.sheet.mdfir271.sheet271DAO;
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

import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import org.springframework.web.multipart.MultipartFile;

@Service
public class sheet291_Impl implements sheet291_Service {
    private static final String contentType ="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    @Autowired
    Qdfir291Repo qdfir291Repo;

    @Autowired
    sheet291Repository _291Repository;
    List<GenericXml> genericXmlList;

    public List<GenericXml> getSheet291XmlList() {
        return genericXmlList;
    }

    public void setSheet291XmlList(List<GenericXml> genericXmlList) {
        this.genericXmlList = genericXmlList;
    }

    public ResponseEntity<?> createData(sheet291DAO data) throws ResourceNotFoundException {
        _291Repository.save(data);
        Response res = new Response();
        res.setResponseMessage("Success");
        res.setResponseCode(00);
        res.setS291Data(data);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> createDataQ(sheetQdfir291DAO data) throws ResourceNotFoundException {
        qdfir291Repo.save(data);
        ResponseQuarterly res = new ResponseQuarterly();
        res.setResponseMessage("Success");
        res.setResponseCode(00);
        res.setS291Data(data);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    public ResponseEntity<?> fetchAllData() {

        Iterable<sheet291DAO> data = null;
        Iterable<sheetQdfir291DAO> qdfirData = null;
        List<GenericXml> genericXmls = new ArrayList<>();
        List<String> result = new ArrayList<>();
        AtomicInteger counter = new AtomicInteger(0);

        String reportName = "";
        Class<?> daoClass = null;

        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            reportName = "MDFIR291";
            daoClass = sheet291DAO.class;
            data = _291Repository.findAll();

            data.forEach((e) -> {
                counter.getAndIncrement();
                result.add(String.valueOf(counter));
                result.add(e.getBankName() == null ? "" : e.getBankName());
                result.add(e.getBankCode() == null ? "" : e.getBankCode());
                result.add(e.getType_of_placements() == null ? "" : e.getType_of_placements());
                result.add(e.getAccount_number() == null ? "" : e.getAccount_number());
                result.add(e.getAmount().toString() == null ? ".00"
                    : String.valueOf(e.getAmount().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getAmount_2().toString() == null ? ".00"
                    : String.valueOf(e.getAmount_2().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getTenor() == null ? "" : e.getTenor());

                result.add(e.getEffective_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null? String.valueOf(.00)
                    : e.getEffective_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                    .toString());
                result.add(e.getMaturity_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null
                    ? String.valueOf(.00)
                    : e.getMaturity_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
            result.add(e.getInterest_rate().toString() == null ? ".00"
                : String.valueOf(e.getInterest_rate().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getUpfront_interest_received().toString() == null ? ".00"
                    : String.valueOf(e.getUpfront_interest_received().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getAccrued_interest_receivable().toString() == null ? ".00"
                    : String.valueOf(e.getAccrued_interest_receivable().setScale(2, RoundingMode.HALF_EVEN)));
                result.add(e.getTimes_rolled_over().toString() == null ? ".00"
                    : String.valueOf(e.getTimes_rolled_over().setScale(2, RoundingMode.HALF_EVEN)));
            });
            GenericXml.writeIntoXmlFormat(XmlParameters.builder().genericXmls(genericXmls).prefix("").result(result)
                .daoClass(daoClass).reportName(reportName).isNoneSpecialWithPrefix(true).isIdPresent(true).build());
            setSheet291XmlList(genericXmls);
            Response res = new Response();
            res.setSheet291(data);
            res.setResponseMessage("Success");
            res.setResponseCode(00);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            reportName = "QDFIR291";
            daoClass = sheetQdfir291DAO.class;
            qdfirData = qdfir291Repo.findAll();

            qdfirData.forEach((e) -> {
                try {

                    counter.getAndIncrement();
                    result.add(String.valueOf(counter));
                    result.add(e.getBankName() == null ? "" : e.getBankName());
                    result.add(e.getBankCode() == null ? "" : e.getBankCode());
                    result.add(e.getType_of_placements() == null ? "" : e.getType_of_placements());
                    result.add(e.getAccount_number() == null ? "" : e.getAccount_number());
                    result.add(e.getAmount().toString() == null ? ".00"
                        : String.valueOf(e.getAmount().setScale(2, RoundingMode.HALF_EVEN)));
                    result.add(e.getAmount_2().toString() == null ? ".00"
                        : String.valueOf(e.getAmount_2().setScale(2, RoundingMode.HALF_EVEN)));
                    result.add(e.getTenor() == null ? "" : e.getTenor());
                    result.add(e.getEffective_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null? String.valueOf(.00)
                        : e.getEffective_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                        .toString());
                    result.add(e.getMaturity_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null
                        ? String.valueOf(.00)
                        : e.getMaturity_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                    result.add(e.getInterest_rate().toString() == null ? ".00"
                        : String.valueOf(e.getInterest_rate().setScale(2, RoundingMode.HALF_EVEN)));
                    result.add(e.getUpfront_interest_received().toString() == null ? ".00"
                        : String.valueOf(e.getUpfront_interest_received().setScale(2, RoundingMode.HALF_EVEN)));
                    result.add(e.getAccrued_interest_receivable().toString() == null ? ".00"
                        : String.valueOf(e.getAccrued_interest_receivable().setScale(2, RoundingMode.HALF_EVEN)));
                    result.add(e.getTimes_rolled_over().toString() == null ? ".00"
                        : String.valueOf(e.getTimes_rolled_over().setScale(2, RoundingMode.HALF_EVEN)));
                } catch (NullPointerException ex) {
                    System.out.println("NullPointerException thrown!");
                }
            });
            GenericXml.writeIntoXmlFormat(XmlParameters.builder().genericXmls(genericXmls).prefix("").result(result)
                .daoClass(daoClass).reportName(reportName).isNoneSpecialWithPrefix(true).isIdPresent(true).build());
            setSheet291XmlList(genericXmls);
            ResponseQuarterly res = new ResponseQuarterly();
            res.setQdfir291(qdfirData);
            res.setResponseMessage("Success");
            res.setResponseCode(00);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        return null;
    }

    public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            sheet291DAO data = _291Repository.findById(dataId)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
            Response res = new Response();
            res.setResponseMessage("Record Found");
            res.setResponseCode(00);
            res.setS291Data(data);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            sheetQdfir291DAO data = qdfir291Repo.findById(dataId)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
            ResponseQuarterly res = new ResponseQuarterly();
            res.setResponseMessage("Record Found");
            res.setResponseCode(00);
            res.setS291Data(data);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        return null;
    }

    public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            Optional<sheet291DAO> data = _291Repository.findById(dataId);

            if (data.isPresent()) {
                _291Repository.delete(data.get());
            } else {
                throw new ResourceNotFoundException("Record not found with id : " + dataId);
            }
            Response res = new Response();
            res.setResponseMessage("Record Deleted");
            res.setResponseCode(00);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            Optional<sheetQdfir291DAO> data = qdfir291Repo.findById(dataId);

            if (data.isPresent()) {
                qdfir291Repo.delete(data.get());
            } else {
                throw new ResourceNotFoundException("Record not found with id : " + dataId);
            }
            ResponseQuarterly res = new ResponseQuarterly();
            res.setResponseMessage("Record Deleted");
            res.setResponseCode(00);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        return null;
    }

    public ResponseEntity<?> updateData(int id, sheet291DAO Data) throws ResourceNotFoundException {

        Optional<sheet291DAO> DataDb = _291Repository.findById(id);

        if (DataDb.isPresent()) {
            sheet291DAO DataUpdate = DataDb.get();
            DataUpdate.setId(Data.getId());
            DataUpdate.setBankCode(Data.getBankCode());
            DataUpdate.setBankName(Data.getBankName());
            DataUpdate.setAmount(Data.getAmount());
            DataUpdate.setAmount_2(Data.getAmount_2());
            DataUpdate.setMaturity_date(Data.getMaturity_date());
            DataUpdate.setInterest_rate(Data.getInterest_rate());
            DataUpdate.setAccrued_interest_receivable(Data.getAccrued_interest_receivable());
            DataUpdate.setTenor(Data.getTenor());
            DataUpdate.setUpfront_interest_received(Data.getUpfront_interest_received());
            DataUpdate.setType_of_placements(Data.getType_of_placements());
            DataUpdate.setAmount_2(Data.getAmount_2());
            _291Repository.save(DataUpdate);
            Response res = new Response();
            res.setResponseMessage("Record Updated");
            res.setResponseCode(00);
            res.setS291Data(DataUpdate);
            return new ResponseEntity<>(res, HttpStatus.OK);

        } else {
            throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
        }
    }

    @Override
    public ResponseEntity<?> updateDataQ(int id, sheetQdfir291DAO Data) throws ResourceNotFoundException {
        Optional<sheetQdfir291DAO> DataDb = qdfir291Repo.findById(id);

        if (DataDb.isPresent()) {
            sheetQdfir291DAO DataUpdate = DataDb.get();
            DataUpdate.setId(Data.getId());
            DataUpdate.setBankCode(Data.getBankCode());
            DataUpdate.setBankName(Data.getBankName());
            DataUpdate.setAmount(Data.getAmount());
            DataUpdate.setAmount_2(Data.getAmount_2());
            DataUpdate.setMaturity_date(Data.getMaturity_date());
            DataUpdate.setInterest_rate(Data.getInterest_rate());
            DataUpdate.setAccrued_interest_receivable(Data.getAccrued_interest_receivable());
            DataUpdate.setTenor(Data.getTenor());
            DataUpdate.setUpfront_interest_received(Data.getUpfront_interest_received());
            DataUpdate.setType_of_placements(Data.getType_of_placements());
            DataUpdate.setAmount_2(Data.getAmount_2());
            qdfir291Repo.save(DataUpdate);
            ResponseQuarterly res = new ResponseQuarterly();
            res.setResponseMessage("Record Updated");
            res.setResponseCode(00);
            res.setS291Data(DataUpdate);
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
    public void saveSheet291ToDataBase(MultipartFile file, String sheetNo) {
        if (isValidExcelFile(file)) {
            try {
                List<sheet291DAO> excelData = getSheetDataFromExcel(file.getInputStream(), sheetNo);
                _291Repository.saveAll(excelData);

            } catch (IOException e) {
                throw new IllegalArgumentException("File is not a valid excel file");
            }
        }
    }

    private static List<sheet291DAO> getSheetDataFromExcel(InputStream inputStream, String sheetNumber) {
        List<ExcelSheet291Data> excelSheet291Data = new ArrayList<>();
        List<sheet291DAO> sheet291s = new ArrayList<>();
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
                    ExcelSheet291Data excelSheet291 = new ExcelSheet291Data();
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        switch (cellIndex) {

                            case 0 -> {
                                excelSheet291.setId((int) cell.getNumericCellValue());
                                System.out.println(excelSheet291.getId());
                            }
                            case 1 -> {
                                excelSheet291.setBankName(cell.getStringCellValue());
                                System.out.println(excelSheet291.getBankName());
                            }
                            case 2 -> {
                                excelSheet291.setBankCode(cell.getStringCellValue());
                                System.out.println(excelSheet291.getBankCode());
                            }
                            case 3 -> {
                                excelSheet291.setType_of_placements(cell.getStringCellValue());
                                System.out.println(excelSheet291.getType_of_placements());
                            }
                            case 4 -> {
                                excelSheet291.setAccount_number(String.format("% .0f",cell.getNumericCellValue()));
                                System.out.println(excelSheet291.getAccount_number());
                            }

                            case 5 -> {
                                excelSheet291.setAmount(BigDecimal.valueOf(cell.getNumericCellValue()));
                                System.out.println(excelSheet291.getAmount());
                            }
                            case 6 -> {
                                excelSheet291.setAmount_2(BigDecimal.valueOf(cell.getNumericCellValue()));
                                System.out.println(excelSheet291.getAmount_2());
                            }
                            case 7 -> {
                                excelSheet291.setTenor(String.format("% .0f",cell.getNumericCellValue()));
                                System.out.println(excelSheet291.getTenor());
                            }
                            case 8 -> {
                                excelSheet291.setEffective_date(cell.getDateCellValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                                System.out.println(excelSheet291.getEffective_date());
                            }
                            case 9 -> {
                                excelSheet291.setMaturity_date(cell.getDateCellValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                                System.out.println(excelSheet291.getMaturity_date());
                            }
                            case 10 -> {
                                excelSheet291.setInterest_rate(BigDecimal.valueOf(cell.getNumericCellValue()));
                                System.out.println(excelSheet291.getInterest_rate());
                            }
                            case 11 -> {
                                excelSheet291.setUpfront_interest_received(BigDecimal.valueOf(cell.getNumericCellValue()));
                                System.out.println(excelSheet291.getUpfront_interest_received());
                            }
                            case 12 -> {
                                excelSheet291.setAccrued_interest_receivable(BigDecimal.valueOf(cell.getNumericCellValue()));
                                System.out.println(excelSheet291.getAccrued_interest_receivable());
                            }
                            case 13 -> {
                                excelSheet291.setTimes_rolled_over(BigDecimal.valueOf(cell.getNumericCellValue()));
                                System.out.println(excelSheet291.getTimes_rolled_over());
                            }
                            default -> {
                                System.out.println(excelSheet291);
                            }
                        }
                        cellIndex++;
                    }
                    sheet291DAO mdfir291 = new sheet291DAO();
                    excelSheet291Data.add(excelSheet291);
                    for(ExcelSheet291Data ignored: excelSheet291Data){
                        mdfir291.setBankName(excelSheet291.getBankName());
                        mdfir291.setBankCode(excelSheet291.getBankCode());
                        mdfir291.setType_of_placements(excelSheet291.getType_of_placements());
                        mdfir291.setAccount_number(excelSheet291.getAccount_number());
                        mdfir291.setAmount(excelSheet291.getAmount());
                        mdfir291.setAmount_2(excelSheet291.getAmount_2());
                        mdfir291.setTenor(excelSheet291.getTenor());
                        mdfir291.setEffective_date(excelSheet291.getEffective_date());
                        mdfir291.setMaturity_date(excelSheet291.getMaturity_date());
                        mdfir291.setInterest_rate(excelSheet291.getInterest_rate());
                        mdfir291.setUpfront_interest_received(excelSheet291.getUpfront_interest_received());
                        mdfir291.setAccrued_interest_receivable(excelSheet291.getAccrued_interest_receivable());
                        mdfir291.setTimes_rolled_over(excelSheet291.getTimes_rolled_over());
                    }
                    sheet291s.add(mdfir291);
                }
            } else {
                throw new RuntimeException("Sheet is null. Verify the sheet name in the Excel file.");
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("file too large");
        }
        return sheet291s;
    }

    private static boolean isValidExcelFile(MultipartFile file) {
        return Objects.equals(file.getContentType(), contentType);
    }

}
