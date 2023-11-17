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

					sheet291DAO sheet291 = new sheet291DAO();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						switch (cellIndex) {
							case 0 ->
									sheet291.setId((int) cell.getNumericCellValue());

							case 1 ->
									sheet291.setBankName(cell.getStringCellValue());

							case 2->
								sheet291.setBankCode(cell.getStringCellValue());

							case 3->
								sheet291.setType_of_placements(cell.getStringCellValue());

							case 4->
								sheet291.setAccount_number(cell.getStringCellValue());

							case 5->
								sheet291.setAmount(BigDecimal.valueOf(cell.getNumericCellValue()));

							case 6->
								sheet291.setAmount_2(BigDecimal.valueOf(cell.getNumericCellValue()));

							case 7->
								sheet291.setTenor(cell.getStringCellValue());
							case 8->
								sheet291.setEffective_date(cell.getDateCellValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

							case 9->
								sheet291.setMaturity_date(cell.getDateCellValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
							case 10->
								sheet291.setInterest_rate(BigDecimal.valueOf(cell.getNumericCellValue()));
							case 11->
								sheet291.setUpfront_interest_received(BigDecimal.valueOf(cell.getNumericCellValue()));
							case 12->
								sheet291.setAccrued_interest_receivable(BigDecimal.valueOf(cell.getNumericCellValue()));
							case 13->
								sheet291.setTimes_rolled_over(BigDecimal.valueOf(cell.getNumericCellValue()));
							default -> {

							}
						}
						cellIndex++;
					}
					sheet291s.add(sheet291);
				}
			}
			else {
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
