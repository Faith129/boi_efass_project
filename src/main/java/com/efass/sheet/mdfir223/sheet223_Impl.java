package com.efass.sheet.mdfir223;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.sheet.mdfir192.sheet192DAO;
import com.efass.sheet.mdfir192.sheetQdfir192DAO;
import com.efass.sheet.mdfir321.sheet321DAO;
import com.efass.sheet.mdfir223.ExcelSheet223Data;
import com.efass.sheet.mdfir223.sheet223DAO;
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
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class sheet223_Impl implements sheet223_Service {
    private static final String contentType ="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

	@Autowired
	sheet223Repository sheet223Repository;

	@Autowired
	Qdfir223Repo qdfir223Repo;
	List<GenericXml> genericXmlList;

	public List<GenericXml> getSheet223XmlList() {
		return genericXmlList;
	}

	public void setSheet223XmlList(List<GenericXml> genericXmlList) {
		this.genericXmlList = genericXmlList;
	}

	// ############################## MDFIR223 CRUD OPERATIONS

	public ResponseEntity<?> createData(sheet223DAO data) throws ResourceNotFoundException {
		sheet223Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS223Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> createDataQ(sheetQdfir223DAO data) throws ResourceNotFoundException {
		qdfir223Repo.save(data);
		ResponseQuarterly res = new ResponseQuarterly();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS223Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet223DAO> data = null;
		Iterable<sheetQdfir223DAO> qdfirData = null;
		List<GenericXml> genericXmls = new ArrayList<>();
		List<String> result = new ArrayList<>();
		AtomicInteger counter = new AtomicInteger(0);

		String reportName = "";
		Class<?> daoClass = null;

		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			reportName = "MDFIR223";
			daoClass = sheet223DAO.class;
			data = sheet223Repository.findAll();

			data.forEach((e) -> {
				counter.getAndIncrement();
				result.add(String.valueOf(counter));

				result.add(e.getInvestee_name() == null ? "" : e.getInvestee_name());
				result.add(e.getType_of_investment() == null ? "" : e.getType_of_investment());
				result.add(e.getInvestement_cert_number() == null ? "" : e.getInvestement_cert_number());
				result.add(e.getAmount_invested().toString() == null ? ".00"
						: String.valueOf(e.getAmount_invested().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getFair_value_gain_or_loss().toString() == null ? ".00"
						: String.valueOf(e.getFair_value_gain_or_loss().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getImpairment().toString() == null ? ".00"
						: String.valueOf(e.getImpairment().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getCarrying_amt_quoted_eq_inv().toString() == null ? ".00"
						: String.valueOf(e.getCarrying_amt_quoted_eq_inv().setScale(2, RoundingMode.HALF_EVEN)));

			});
			GenericXml.writeIntoXmlFormat(XmlParameters.builder().genericXmls(genericXmls).prefix("").result(result)
					.daoClass(daoClass).reportName(reportName).isNoneSpecialWithPrefix(true).isIdPresent(true).build());

			setSheet223XmlList(genericXmls);
			Response res = new Response();
			res.setSheet223(data);
			res.setResponseMessage("Success");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			reportName = "QDFIR223";
			daoClass = sheetQdfir223DAO.class;
			qdfirData = qdfir223Repo.findAll();

			qdfirData.forEach((e) -> {
				try {

					counter.getAndIncrement();
					result.add(String.valueOf(counter));

					result.add(e.getInvestee_name() == null ? "" : e.getInvestee_name());
					result.add(e.getType_of_investment() == null ? "" : e.getType_of_investment());
					result.add(e.getInvestement_cert_number() == null ? "" : e.getInvestement_cert_number());
					result.add(e.getAmount_invested().toString() == null ? ".00"
							: String.valueOf(e.getAmount_invested().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getFair_value_gain_or_loss().toString() == null ? ".00"
							: String.valueOf(e.getFair_value_gain_or_loss().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getImpairment().toString() == null ? ".00"
							: String.valueOf(e.getImpairment().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getCarrying_amt_quoted_eq_inv().toString() == null ? ".00"
							: String.valueOf(e.getCarrying_amt_quoted_eq_inv().setScale(2, RoundingMode.HALF_EVEN)));
				} catch (NullPointerException ex) {
					System.out.println("NullPointerException thrown!");
				}
			});
			GenericXml.writeIntoXmlFormat(XmlParameters.builder().genericXmls(genericXmls).prefix("").result(result)
					.daoClass(daoClass).reportName(reportName).isNoneSpecialWithPrefix(true).isIdPresent(true).build());

			setSheet223XmlList(genericXmls);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setQdfir223(qdfirData);
			res.setResponseMessage("Success");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		return null;
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			Optional<sheet223DAO> data = sheet223Repository.findById(dataId);

			if (data.isPresent()) {
				sheet223Repository.delete(data.get());
			} else {
				throw new ResourceNotFoundException("Record not found with id : " + dataId);
			}
			Response res = new Response();
			res.setResponseMessage("Record Deleted");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			Optional<sheetQdfir223DAO> data = qdfir223Repo.findById(dataId);

			if (data.isPresent()) {
				qdfir223Repo.delete(data.get());
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

	@Override
	public ResponseEntity<?> updateData(int id, sheet223DAO Data) throws ResourceNotFoundException {
		Optional<sheet223DAO> DataDb = sheet223Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet223DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setInvestee_name(Data.getInvestee_name());
			DataUpdate.setType_of_investment(Data.getType_of_investment());
			DataUpdate.setInvestement_cert_number(Data.getInvestement_cert_number());
			DataUpdate.setAmount_invested(Data.getAmount_invested());
			DataUpdate.setFair_value_gain_or_loss(Data.getFair_value_gain_or_loss());
			DataUpdate.setImpairment(Data.getImpairment());
			DataUpdate.setCarrying_amt_quoted_eq_inv(Data.getCarrying_amt_quoted_eq_inv());
			sheet223Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS223Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found : " + Data.getId());
		}
	}

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir223DAO Data) throws ResourceNotFoundException {
		Optional<sheetQdfir223DAO> DataDb = qdfir223Repo.findById(id);

		if (DataDb.isPresent()) {
			sheetQdfir223DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setInvestee_name(Data.getInvestee_name());
			DataUpdate.setType_of_investment(Data.getType_of_investment());
			DataUpdate.setInvestement_cert_number(Data.getInvestement_cert_number());
			DataUpdate.setAmount_invested(Data.getAmount_invested());
			DataUpdate.setFair_value_gain_or_loss(Data.getFair_value_gain_or_loss());
			DataUpdate.setImpairment(Data.getImpairment());
			DataUpdate.setCarrying_amt_quoted_eq_inv(Data.getCarrying_amt_quoted_eq_inv());
			qdfir223Repo.save(DataUpdate);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS223Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found : " + Data.getId());
		}
	}

	@Override
	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			sheet223DAO data = sheet223Repository.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

			Response res = new Response();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS223Data(data);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			sheetQdfir223DAO data = qdfir223Repo.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS223Data(data);
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
    public void saveSheet223ToDataBase(MultipartFile file, String sheetNo) {
        if (isValidExcelFile(file)) {
            try {
                sheet223Repository.deleteAll();
                List<sheet223DAO> excelData = getSheetDataFromExcel(file.getInputStream(), sheetNo);
                sheet223Repository.saveAll(excelData);

            } catch (IOException e) {
                throw new IllegalArgumentException("File is not a valid excel file");
            }
        }
    }
    private static List<sheet223DAO> getSheetDataFromExcel(InputStream inputStream, String sheetNumber) {
        List<sheet223DAO> sheet223s = new ArrayList<>();
        List<ExcelSheet223Data> excelSheet223Data = new ArrayList<>();

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

                    ExcelSheet223Data excelSheet223 = new ExcelSheet223Data();
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        switch (cellIndex) {
                            case 0 -> {
                                excelSheet223.setId((int) cell.getNumericCellValue());
                                System.out.println(excelSheet223.getId());
                            }

                            case 1 -> {
                                excelSheet223.setInvestee_name(cell.getStringCellValue());
                                System.out.println(excelSheet223.getInvestee_name());
                            }

                            case 2 -> {
                                excelSheet223.setType_of_investment(cell.getStringCellValue());
                                System.out.println(excelSheet223.getType_of_investment());
                            }

                            case 3 -> {
                                excelSheet223.setInvestment_cert_number(cell.getStringCellValue());
                                System.out.println(excelSheet223.getInvestment_cert_number());
                            }

                            case 4 -> {
                                excelSheet223.setAmount_invested(BigDecimal.valueOf(cell.getNumericCellValue()));
                                System.out.println(excelSheet223.getAmount_invested());
                            }

                            case 5 -> {
                                excelSheet223.setFair_value_gains(BigDecimal.valueOf(cell.getNumericCellValue()));
                                System.out.println(excelSheet223.getFair_value_gains());
                            }

                            case 6 -> {
                                excelSheet223.setImpairment(BigDecimal.valueOf(cell.getNumericCellValue()));
                                System.out.println(excelSheet223.getImpairment());
                            }

                            case 7 -> {
                                excelSheet223.setCarrying_value_unquoted_eq_inv(BigDecimal.valueOf(cell.getNumericCellValue()));
                                System.out.println(excelSheet223.getCarrying_value_unquoted_eq_inv());
                            }

                            default -> {

                            }
                        }
                        cellIndex++;
                    }
                    sheet223DAO mdfir223 = new sheet223DAO();
                    excelSheet223Data.add(excelSheet223);
                    for(ExcelSheet223Data ignored: excelSheet223Data){
                        mdfir223.setInvestee_name(excelSheet223.getInvestee_name());
                        mdfir223.setType_of_investment(excelSheet223.getType_of_investment());
                        mdfir223.setInvestement_cert_number(excelSheet223.getInvestment_cert_number());
                        mdfir223.setAmount_invested(excelSheet223.getAmount_invested());
                        mdfir223.setFair_value_gain_or_loss(excelSheet223.getFair_value_gains());
                        mdfir223.setImpairment(excelSheet223.getImpairment());
                        mdfir223.setCarrying_amt_quoted_eq_inv(excelSheet223.getCarrying_value_unquoted_eq_inv());
                    }
                    sheet223s.add(mdfir223);
                }
            }
            else {
                throw new RuntimeException("Sheet is null. Verify the sheet name in the Excel file.");
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("file too large");
        }
        return sheet223s;
    }
    private static boolean isValidExcelFile(MultipartFile file) {
        return Objects.equals(file.getContentType(), contentType);
    }

}
