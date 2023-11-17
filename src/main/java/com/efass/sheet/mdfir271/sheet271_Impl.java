package com.efass.sheet.mdfir271;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.sheet.table.TabController;
import lombok.extern.log4j.Log4j2;
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
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Log4j2
public class sheet271_Impl implements sheet271_Service {
	//@Value("${app.contentType}")
	private static final String contentType ="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	@Autowired
	Qdfir271Repo qdfir271Repo;
	@Autowired
	sheet271Repository sheet271Repository;
	List<GenericXml> genericXmlList;

	public List<GenericXml> getSheet271XmlList() {
		return genericXmlList;
	}

	public void setSheet271XmlList(List<GenericXml> genericXmlList) {
		this.genericXmlList = genericXmlList;
	}
// ############################## MDFIR271 CRUD OPERATIONS

	public ResponseEntity<?> createData(sheet271DAO data) throws ResourceNotFoundException {
		sheet271Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS271Data(data);

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> createDataQ(sheetQdfir271DAO data) throws ResourceNotFoundException {
		qdfir271Repo.save(data);
		ResponseQuarterly res = new ResponseQuarterly();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS271Data(data);

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet271DAO> data = null;
		Iterable<sheetQdfir271DAO> qdfirData = null;
		List<GenericXml> genericXmls = new ArrayList<>();
		List<String> result = new ArrayList<>();
		AtomicInteger counter = new AtomicInteger(0);

		String reportName = "";
		Class<?> daoClass = null;

		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			reportName = "MDFIR271";
			daoClass = sheet271DAO.class;
			data = sheet271Repository.findAll();

			data.forEach((e) -> {
				counter.getAndIncrement();
				result.add(String.valueOf(counter));
				result.add(e.getBank_name() == null ? "" : e.getBank_name());
				result.add(e.getBank_code() == null ? "" : e.getBank_code());
				result.add(e.getAccount_number() == null ? "" : e.getAccount_number());
				result.add(e.getAmount().toString() == null ? ".00"
						: String.valueOf(e.getAmount().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getRemarks().toString() == null ? ".00"
                    : String.valueOf(e.getAmount().setScale(2, RoundingMode.HALF_EVEN)));
			});
			GenericXml.writeIntoXmlFormat(XmlParameters.builder().genericXmls(genericXmls).prefix("").result(result)
					.daoClass(daoClass).reportName(reportName).isNoneSpecialWithPrefix(true).isIdPresent(true).build());
			setSheet271XmlList(genericXmls);
			Response res = new Response();
			res.setSheet271(data);
			res.setResponseMessage("Success");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			reportName = "QDFIR271";
			daoClass = sheetQdfir271DAO.class;
			qdfirData = qdfir271Repo.findAll();

			qdfirData.forEach((e) -> {
				try {

					counter.getAndIncrement();
					result.add(String.valueOf(counter));
					result.add(e.getBank_name() == null ? "" : e.getBank_name());
					result.add(e.getBank_code() == null ? "" : e.getBank_code());
					result.add(e.getAccount_number() == null ? "" : e.getAccount_number());
					result.add(e.getAmount().toString() == null ? ".00"
							: String.valueOf(e.getAmount().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getRemarks() == null ? "" : e.getRemarks());
					// result.add(e.getRemarks() == null ?".00" :
					// String.valueOf(e.getRemarks().setScale(2, RoundingMode.HALF_EVEN)));
				} catch (NullPointerException ex) {
					System.out.println("NullPointerException thrown!");
				}
			});
			GenericXml.writeIntoXmlFormat(XmlParameters.builder().genericXmls(genericXmls).prefix("").result(result)
					.daoClass(daoClass).reportName(reportName).isNoneSpecialWithPrefix(true).isIdPresent(true).build());
			setSheet271XmlList(genericXmls);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setQdfir271(qdfirData);
			res.setResponseMessage("Success");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		return null;

	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			Optional<sheet271DAO> data = sheet271Repository.findById(dataId);

			if (data.isPresent()) {
				sheet271Repository.delete(data.get());
			} else {
				throw new ResourceNotFoundException("Record not found with id : " + dataId);
			}
			Response res = new Response();
			res.setResponseMessage("Record Deleted");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			Optional<sheetQdfir271DAO> data = qdfir271Repo.findById(dataId);

			if (data.isPresent()) {
				qdfir271Repo.delete(data.get());
			} else {
				throw new ResourceNotFoundException("Record not found with id : " + dataId);
			}
			Response res = new Response();
			res.setResponseMessage("Record Deleted");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		return null;
	}

	@Override
	public ResponseEntity<?> updateData(int id, sheet271DAO Data) throws ResourceNotFoundException {
		Optional<sheet271DAO> DataDb = sheet271Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet271DAO DataUpdate = DataDb.get();

			DataUpdate.setId(Data.getId());
			DataUpdate.setAmount(Data.getAmount());
			DataUpdate.setBank_name(Data.getBank_name());
			DataUpdate.setBank_code(Data.getBank_code());
			DataUpdate.setAccount_number(Data.getAccount_number());
			sheet271Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS271Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found : " + Data.getId());
		}
	}

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir271DAO Data) throws ResourceNotFoundException {
		Optional<sheetQdfir271DAO> DataDb = qdfir271Repo.findById(id);

		if (DataDb.isPresent()) {
			sheetQdfir271DAO DataUpdate = DataDb.get();

			DataUpdate.setId(Data.getId());
			DataUpdate.setAmount(Data.getAmount());
			DataUpdate.setBank_name(Data.getBank_name());
			DataUpdate.setBank_code(Data.getBank_code());
			DataUpdate.setAccount_number(Data.getAccount_number());
			qdfir271Repo.save(DataUpdate);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS271Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found : " + Data.getId());
		}
	}

	@Override
	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			sheet271DAO data = sheet271Repository.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

			Response res = new Response();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS271Data(data);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			sheetQdfir271DAO data = qdfir271Repo.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS271Data(data);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}

		return null;
	}

	@Override
	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void saveSheet271ToDataBase(MultipartFile file, String sheetNo) {
		if (isValidExcelFile(file)) {
			try {
				List<sheet271DAO> excelData = getSheetDataFromExcel(file.getInputStream(), sheetNo);
				sheet271Repository.saveAll(excelData);

			} catch (IOException e) {
				throw new IllegalArgumentException("File is not a valid excel file");
			}
		}
	}
	private static List<sheet271DAO> getSheetDataFromExcel(InputStream inputStream, String sheetNumber) {
		List<ExcelSheetData> sheetData = new ArrayList<>();
        List<sheet271DAO> sheet271s = new ArrayList<>();
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
                    ExcelSheetData excelSheetData = new ExcelSheetData();

					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
//                        if (cellIndex == 0) {
//                            cellIndex++;
//                            continue;
//                        }

						switch (cellIndex) {
                            case 0-> excelSheetData.setId((int) cell.getNumericCellValue());
                   			case 1 -> excelSheetData.setBank_name(cell.getStringCellValue());
							case 2 -> excelSheetData.setBank_code(String.format("% .0f",cell.getNumericCellValue()));
							case 3 -> excelSheetData.setAccount_number(String.format("% .0f",cell.getNumericCellValue()));
							case 4-> excelSheetData.setAmount(BigDecimal.valueOf(cell.getNumericCellValue()));
							case 5 -> excelSheetData.setRemarks(BigDecimal.valueOf(cell.getNumericCellValue()));
							default -> {

							}
						}
						cellIndex++;
					}
//					sheet271s.add(sheet271);
                    sheet271DAO sheet271 = new sheet271DAO();
                    sheetData.add(excelSheetData);
                    for(ExcelSheetData ignored : sheetData) {
                       sheet271.setBank_name(excelSheetData.getBank_name());
                       sheet271.setBank_code(excelSheetData.getBank_code());
                       sheet271.setAccount_number(excelSheetData.getAccount_number());
                       sheet271.setAmount(excelSheetData.getAmount());
                       sheet271.setRemarks(excelSheetData.getRemarks());
                    }
                    sheet271s.add(sheet271);
				}
			}
			else {
				throw new RuntimeException("Sheet is null. Verify the sheet name in the Excel file.");
			}

		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("file too large");
		}
		return sheet271s;
	}

	private static boolean isValidExcelFile(MultipartFile file) {
		return Objects.equals(file.getContentType(), contentType);
	}


}
