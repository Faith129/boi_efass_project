package com.efass.sheet.mdfir250;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.sheet.mdfir1000.sheet1000DAO;
import com.efass.sheet.mdfir192.sheet192DAO;
import com.efass.sheet.mdfir192.sheetQdfir192DAO;
import com.efass.sheet.mdfir453.sheet453DAO;
import com.efass.sheet.table.TabController;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class sheet250_Impl implements sheet250_Service {

	@Autowired
	Qdfir250Repo qdfir250Repo;
	@Autowired
	sheet250Repository sheet250Repository;
	List<GenericXml> genericXmlList;

	public List<GenericXml> getSheet250XmlList() {
		return genericXmlList;
	}

	public void setSheet250XmlList(List<GenericXml> genericXmlList) {
		this.genericXmlList = genericXmlList;
	}
	// ############################## MDFIR250 CRUD OPERATIONS

	public ResponseEntity<?> createData(sheet250DAO data) throws ResourceNotFoundException {
		sheet250Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS250Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> createDataQ(sheetQdfir250DAO data) throws ResourceNotFoundException {
		qdfir250Repo.save(data);
		ResponseQuarterly res = new ResponseQuarterly();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS250Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchAllData() {

		Iterable<sheet250DAO> data = null;
		Iterable<sheetQdfir250DAO> qdfirData = null;
		List<GenericXml> genericXmls = new ArrayList<>();
		List<String> codes = new ArrayList<>();
		List<String> result = new ArrayList<>();

		String reportName = "";
		Class<?> daoClass = null;

		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			reportName = "MDFIR250";
			daoClass = sheet250DAO.class;
			data = sheet250Repository.findAll();

			data.forEach((e) -> {
				codes.add(e.getCode() == null ? "" : e.getCode());
				result.add(e.getPercentage().toString() == null ? ".00"
						: String.valueOf(e.getPercentage().setScale(2, RoundingMode.HALF_EVEN)));
			});
			GenericXml.writeIntoXmlFormat(
					XmlParameters.builder().isUniquePrefixT(true).prefix("").daoClass(daoClass).reportName(reportName)
							.result(result).isSkipRows(false).genericXmls(genericXmls).codes(codes).build());
			setSheet250XmlList(genericXmls);
			Response res = new Response();
			res.setSheet250(data);

			res.setResponseMessage("Success");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			reportName = "QDFIR250";
			daoClass = sheetQdfir250DAO.class;
			qdfirData = qdfir250Repo.findAll();

			qdfirData.forEach((e) -> {
				try {
					codes.add(e.getCode() == null ? "" : e.getCode());
					result.add(e.getPercentage().toString() == null ? ".00"
							: String.valueOf(e.getPercentage().setScale(2, RoundingMode.HALF_EVEN)));
				} catch (NullPointerException ex) {
					System.out.println("NullPointerException thrown!");
				}
			});
			GenericXml.writeIntoXmlFormat(
					XmlParameters.builder().isUniquePrefixT(true).prefix("").daoClass(daoClass).reportName(reportName)
							.result(result).isSkipRows(false).genericXmls(genericXmls).codes(codes).build());
			setSheet250XmlList(genericXmls);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setQdfir250(qdfirData);

			res.setResponseMessage("Success");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		return null;
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			Optional<sheet250DAO> data = sheet250Repository.findById(dataId);

			if (data.isPresent()) {
				sheet250Repository.delete(data.get());
			} else {
				throw new ResourceNotFoundException("Record not found with id : " + dataId);
			}
			Response res = new Response();
			res.setResponseMessage("Record Deleted");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			Optional<sheetQdfir250DAO> data = qdfir250Repo.findById(dataId);

			if (data.isPresent()) {
				qdfir250Repo.delete(data.get());
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
	public ResponseEntity<?> updateData(int id, sheet250DAO Data) throws ResourceNotFoundException {
		Optional<sheet250DAO> DataDb = sheet250Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet250DAO DataUpdate = DataDb.get();

			DataUpdate.setId(Data.getId());
			DataUpdate.setPercentage(Data.getPercentage());
			DataUpdate.setDescription(Data.getDescription());
			sheet250Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS250Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found : " + Data.getId());
		}
	}

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir250DAO Data) throws ResourceNotFoundException {
		Optional<sheetQdfir250DAO> DataDb = qdfir250Repo.findById(id);

		if (DataDb.isPresent()) {
			sheetQdfir250DAO DataUpdate = DataDb.get();

			DataUpdate.setId(Data.getId());
			DataUpdate.setPercentage(Data.getPercentage());
			DataUpdate.setDescription(Data.getDescription());
			qdfir250Repo.save(DataUpdate);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS250Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found : " + Data.getId());
		}
	}

	@Override
	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			sheet250DAO data = sheet250Repository.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

			Response res = new Response();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS250Data(data);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			sheetQdfir250DAO data = qdfir250Repo.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS250Data(data);
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

}
