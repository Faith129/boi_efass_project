package com.efass.sheet.mdfir311;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
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
	@Value("${app.contentType}")
	private static String contentType;
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

					sheet311DAO sheet311 = new sheet311DAO();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						switch (cellIndex) {
							case 0 ->
									sheet311.setId((int) cell.getNumericCellValue());

							case 1 ->
									sheet311.setBankName(cell.getStringCellValue());

							case 2->
									sheet311.setBankCode(cell.getStringCellValue());

							case 3->
									sheet311.setType_of_placements(cell.getStringCellValue());

							case 4->
									sheet311.setAccount_number(cell.getStringCellValue());

							case 5->
									sheet311.setAmount(BigDecimal.valueOf(cell.getNumericCellValue()));

							case 6->
									sheet311.setAmount_2(BigDecimal.valueOf(cell.getNumericCellValue()));

							case 7->
									sheet311.setTenor(cell.getStringCellValue());
							case 8->
									sheet311.setEffective_date(cell.getDateCellValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

							case 9->
									sheet311.setMaturity_date(cell.getDateCellValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
							case 10->
									sheet311.setInterest_rate(BigDecimal.valueOf(cell.getNumericCellValue()));
							case 11->
									sheet311.setUpfront_interest_received(BigDecimal.valueOf(cell.getNumericCellValue()));
							case 12->
									sheet311.setAccrued_interest_receivable(BigDecimal.valueOf(cell.getNumericCellValue()));
							case 13->
									sheet311.setTimes_rolled_over(BigDecimal.valueOf(cell.getNumericCellValue()));
							default -> {

							}
						}
						cellIndex++;
					}
					sheet311s.add(sheet311);
				}
			}
			else {
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
