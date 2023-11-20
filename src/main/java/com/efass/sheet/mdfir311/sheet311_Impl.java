package com.efass.sheet.mdfir311;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.sheet.mdfir311.ExcelSheet311Data;
import com.efass.sheet.mdfir311.sheet311DAO;
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
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class sheet311_Impl implements sheet311_Service {
    private static final String contentType ="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

	@Autowired
	Qdfir311Repo qdfir311Repo;

	@Autowired
	sheet311Repository _311Repository;

	List<GenericXml> genericXmlList;

	public List<GenericXml> getSheet311XmlList() {
		return genericXmlList;
	}

	public void setSheet311XmlList(List<GenericXml> genericXmlList) {
		this.genericXmlList = genericXmlList;
	}

	// ############################## MMFBR311 CRUD OPERATIONS
	// #################################

	public ResponseEntity<?> createData(sheet311DAO data) throws ResourceNotFoundException {

		_311Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS311Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> createDataQ(sheetQdfir311DAO data) throws ResourceNotFoundException {
		qdfir311Repo.save(data);
		ResponseQuarterly res = new ResponseQuarterly();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS311Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet311DAO> data = null;
		Iterable<sheetQdfir311DAO> qdfirData = null;
		List<GenericXml> genericXmls = new ArrayList<>();
		List<String> result = new ArrayList<>();
		AtomicInteger counter = new AtomicInteger(0);

		String reportName = "";
		Class<?> daoClass = null;

		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			reportName = "MDFIR311";
			daoClass = sheet311DAO.class;
			data = _311Repository.findAll();

			data.forEach((e) -> {
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
					result.add(e.getTenor() == null ? "" : e.getTenor());result.add(e.getEffective_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null
                        ? String.valueOf(.00)
                        : e.getEffective_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
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
					result.add(e.getRemarks() == null ? "" : e.getRemarks());

				} catch (NullPointerException ex) {
					System.out.println("NullPointerException thrown!");
				}
			});
			GenericXml.writeIntoXmlFormat(XmlParameters.builder().genericXmls(genericXmls).prefix("").result(result)
					.daoClass(daoClass).reportName(reportName).isNoneSpecialWithPrefix(true).isIdPresent(true).build());

			setSheet311XmlList(genericXmls);
			Response res = new Response();
			res.setSheet311(data);
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);

		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			reportName = "QDFIR311";
			daoClass = sheetQdfir311DAO.class;
			qdfirData = qdfir311Repo.findAll();

			qdfirData.forEach((e) -> {
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
				result.add(e.getEffective_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null
						? String.valueOf(.00)
						: e.getEffective_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
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
				result.add(e.getRemarks() == null ? "" : e.getRemarks());
			});
			GenericXml.writeIntoXmlFormat(XmlParameters.builder().genericXmls(genericXmls).prefix("").result(result)
					.daoClass(daoClass).reportName(reportName).isNoneSpecialWithPrefix(true).isIdPresent(true).build());

			setSheet311XmlList(genericXmls);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setQdfir311(qdfirData);
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);

		}
		return null;
	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			sheet311DAO data = _311Repository.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
			Response res = new Response();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS311Data(data);

			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			sheetQdfir311DAO data = qdfir311Repo.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS311Data(data);

			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		return null;
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			Optional<sheet311DAO> data = _311Repository.findById(dataId);

			if (data.isPresent()) {
				_311Repository.delete(data.get());
			} else {
				throw new ResourceNotFoundException("Record not found with id : " + dataId);
			}
			Response res = new Response();
			res.setResponseMessage("Record Deleted");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			Optional<sheetQdfir311DAO> data = qdfir311Repo.findById(dataId);

			if (data.isPresent()) {
				qdfir311Repo.delete(data.get());
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

	public ResponseEntity<?> updateData(int id, sheet311DAO Data) throws ResourceNotFoundException {

		Optional<sheet311DAO> DataDb = _311Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet311DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setBankName(Data.getBankName());
			DataUpdate.setBankCode(Data.getBankCode());
			DataUpdate.setType_of_placements(Data.getType_of_placements());
			DataUpdate.setAccount_number(Data.getAccount_number());
			DataUpdate.setAmount(Data.getAmount());
			DataUpdate.setAmount_2(Data.getAmount_2());
			DataUpdate.setTenor(Data.getTenor());
			DataUpdate.setEffective_date(Data.getEffective_date());
			DataUpdate.setMaturity_date(Data.getMaturity_date());
			DataUpdate.setInterest_rate(Data.getInterest_rate());
			DataUpdate.setUpfront_interest_received(Data.getUpfront_interest_received());
			DataUpdate.setAccrued_interest_receivable(Data.getAccrued_interest_receivable());
			DataUpdate.setTimes_rolled_over(Data.getTimes_rolled_over());
			DataUpdate.setRemarks(Data.getRemarks());

			_311Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS311Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir311DAO Data) throws ResourceNotFoundException {
		Optional<sheetQdfir311DAO> DataDb = qdfir311Repo.findById(id);

		if (DataDb.isPresent()) {
			sheetQdfir311DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setBankName(Data.getBankName());
			DataUpdate.setBankCode(Data.getBankCode());
			DataUpdate.setType_of_placements(Data.getType_of_placements());
			DataUpdate.setAccount_number(Data.getAccount_number());
			DataUpdate.setAmount(Data.getAmount());
			DataUpdate.setAmount_2(Data.getAmount_2());
			DataUpdate.setTenor(Data.getTenor());
			DataUpdate.setEffective_date(Data.getEffective_date());
			DataUpdate.setMaturity_date(Data.getMaturity_date());
			DataUpdate.setInterest_rate(Data.getInterest_rate());
			DataUpdate.setUpfront_interest_received(Data.getUpfront_interest_received());
			DataUpdate.setAccrued_interest_receivable(Data.getAccrued_interest_receivable());
			DataUpdate.setTimes_rolled_over(Data.getTimes_rolled_over());
			DataUpdate.setRemarks(Data.getRemarks());

			qdfir311Repo.save(DataUpdate);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS311Data(DataUpdate);
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
	public void saveSheet311ToDataBase(MultipartFile file, String sheetNo) {
		if (isValidExcelFile(file)) {
			try {
				List<sheet311DAO> excelData = getSheetDataFromExcel(file.getInputStream(), sheetNo);
				_311Repository.saveAll(excelData);

			} catch (IOException e) {
				throw new IllegalArgumentException("File is not a valid excel file");
			}
		}
	}
    private static List<sheet311DAO> getSheetDataFromExcel(InputStream inputStream, String sheetNumber) {
        List<ExcelSheet311Data> excelSheet311Data = new ArrayList<>();
        List<sheet311DAO> sheet311s = new ArrayList<>();
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
                    ExcelSheet311Data excelSheet311 = new ExcelSheet311Data();
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        switch (cellIndex) {

                            case 0 -> {
                                excelSheet311.setId((int) cell.getNumericCellValue());
                                System.out.println(excelSheet311.getId());
                            }
                            case 1 -> {
                                excelSheet311.setBankName(cell.getStringCellValue());
                                System.out.println(excelSheet311.getBankName());
                            }
                            case 2 -> {
                                excelSheet311.setBankCode(String.format("% .0f",cell.getNumericCellValue()));
                                System.out.println(excelSheet311.getBankCode());
                            }
                            case 3 -> {
                                excelSheet311.setType_of_placements(cell.getStringCellValue());
                                System.out.println(excelSheet311.getType_of_placements());
                            }
                            case 4 -> {
                                excelSheet311.setAccount_number(String.format("% .0f",cell.getNumericCellValue()));
                                System.out.println(excelSheet311.getAccount_number());
                            }

                            case 5 -> {
                                excelSheet311.setAmount(BigDecimal.valueOf(cell.getNumericCellValue()));
                                System.out.println(excelSheet311.getAmount());
                            }
                            case 6 -> {
                                excelSheet311.setAmount_2(BigDecimal.valueOf(cell.getNumericCellValue()));
                                System.out.println(excelSheet311.getAmount_2());
                            }
                            case 7 -> {
                                excelSheet311.setTenor(String.format("% .0f",cell.getNumericCellValue()));
                                System.out.println(excelSheet311.getTenor());
                            }
                            case 8 -> {
                                excelSheet311.setEffective_date(cell.getDateCellValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                                System.out.println(excelSheet311.getEffective_date());
                            }
                            case 9 -> {
                                excelSheet311.setMaturity_date(cell.getDateCellValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                                System.out.println(excelSheet311.getMaturity_date());
                            }
                            case 10 -> {
                                excelSheet311.setInterest_rate(BigDecimal.valueOf(cell.getNumericCellValue()));
                                System.out.println(excelSheet311.getInterest_rate());
                            }
                            case 11 -> {
                                excelSheet311.setUpfront_interest_received(BigDecimal.valueOf(cell.getNumericCellValue()));
                                System.out.println(excelSheet311.getUpfront_interest_received());
                            }
                            case 12 -> {
                                excelSheet311.setAccrued_interest_receivable(BigDecimal.valueOf(cell.getNumericCellValue()));
                                System.out.println(excelSheet311.getAccrued_interest_receivable());
                            }
                            case 13 -> {
                                excelSheet311.setTimes_rolled_over(BigDecimal.valueOf(cell.getNumericCellValue()));
                                System.out.println(excelSheet311.getTimes_rolled_over());
                            }
                            default -> {
                                System.out.println(excelSheet311);
                            }
                        }
                        cellIndex++;
                    }
                    sheet311DAO mdfir311 = new sheet311DAO();
                    excelSheet311Data.add(excelSheet311);
                    for(ExcelSheet311Data ignored: excelSheet311Data){
                        mdfir311.setBankName(excelSheet311.getBankName());
                        mdfir311.setBankCode(excelSheet311.getBankCode());
                        mdfir311.setType_of_placements(excelSheet311.getType_of_placements());
                        mdfir311.setAccount_number(excelSheet311.getAccount_number());
                        mdfir311.setAmount(excelSheet311.getAmount());
                        mdfir311.setAmount_2(excelSheet311.getAmount_2());
                        mdfir311.setTenor(excelSheet311.getTenor());
                        mdfir311.setEffective_date(excelSheet311.getEffective_date());
                        mdfir311.setMaturity_date(excelSheet311.getMaturity_date());
                        mdfir311.setInterest_rate(excelSheet311.getInterest_rate());
                        mdfir311.setUpfront_interest_received(excelSheet311.getUpfront_interest_received());
                        mdfir311.setAccrued_interest_receivable(excelSheet311.getAccrued_interest_receivable());
                        mdfir311.setTimes_rolled_over(excelSheet311.getTimes_rolled_over());
                    }
                    sheet311s.add(mdfir311);
                }
            } else {
                throw new RuntimeException("Sheet is null. Verify the sheet name in the Excel file.");
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("file too large");
        }
        return sheet311s;
    }
	private static boolean isValidExcelFile(MultipartFile file) {
		return Objects.equals(file.getContentType(), contentType);
	}


}
