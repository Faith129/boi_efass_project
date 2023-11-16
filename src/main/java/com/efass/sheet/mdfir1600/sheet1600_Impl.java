package com.efass.sheet.mdfir1600;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.sheet.mdfir1000.sheet1000DAO;
import com.efass.sheet.mdfir1000.sheetQdfir1000DAO;
import com.efass.sheet.mdfir1300.sheetQdfir1300DAO;
import com.efass.sheet.mdfir1500.sheet1500DAO;
import com.efass.sheet.table.TabController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class sheet1600_Impl implements sheet1600_Service {

	@Autowired
	sheet1600Repository sheet1600Repository;

	@Autowired
	Qdfir1600Repo qdfir1600Repo;
	List<GenericXml> genericXmlList;

	public List<GenericXml> getSheet1600XmlList() {
		return genericXmlList;
	}

	public void setSheet1600XmlList(List<GenericXml> genericXmlList) {
		this.genericXmlList = genericXmlList;
	}

// ############################## MDFIR1600 CRUD OPERATIONS

	public ResponseEntity<?> createData(sheet1600DAO data) throws ResourceNotFoundException {
		sheet1600Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS1600Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> createDataQ(sheetQdfir1600DAO data) throws ResourceNotFoundException {
		qdfir1600Repo.save(data);
		ResponseQuarterly res = new ResponseQuarterly();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS1600Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet1600DAO> data = null;
		Iterable<sheetQdfir1600DAO> qdfir1600DAO = null;
		List<GenericXml> genericXmls = new ArrayList<>();
		List<String> result = new ArrayList<>();
		AtomicInteger counter = new AtomicInteger(0);

		String reportName = "";
		Class<?> daoClass = null;

		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			reportName = "MDFIR1600";
			daoClass = sheet1600DAO.class;
			data = sheet1600Repository.findAll();

			data.forEach((e) -> {
				counter.getAndIncrement();
				result.add(String.valueOf(counter));
				result.add(e.getLoan_or_facilities_type() == null ? ".00"
						: String.valueOf(e.getLoan_or_facilities_type().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getAggregate_amt_principal().toString() == null ? ".00"
						: String.valueOf(e.getAggregate_amt_principal().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getAggregate_amt_accrued_interest().toString() == null ? ".00"
						: String.valueOf(e.getAggregate_amt_accrued_interest().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getAggregate_amt_total_outstanding().toString() == null ? ".00"
						: String.valueOf(e.getAggregate_amt_total_outstanding().setScale(2, RoundingMode.HALF_EVEN)));

			});
			GenericXml.writeIntoXmlFormat(
					XmlParameters.builder().genericXmls(genericXmls).prefix("").isNoneSpecialWithPrefix(true)
							.result(result).daoClass(daoClass).reportName(reportName).isIdPresent(true).build());
			setSheet1600XmlList(genericXmls);
			Response res = new Response();
			res.setSheet1600(data);
			res.setResponseMessage("Success");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			reportName = "QDFIR1600";
			daoClass = sheetQdfir1600DAO.class;
			qdfir1600DAO = qdfir1600Repo.findAll();

			qdfir1600DAO.forEach((e) -> {
				try {
					// System.out.println("i am here 1600");

					counter.getAndIncrement();
					result.add(String.valueOf(counter));
					result.add(e.getLoan_or_facilities_type() == null ? ".00"
							: String.valueOf(e.getLoan_or_facilities_type().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getAggregate_amt_principal().toString() == null ? ".00"
							: String.valueOf(e.getAggregate_amt_principal().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getAggregate_amt_accrued_interest().toString() == null ? ".00"
							: String.valueOf(
									e.getAggregate_amt_accrued_interest().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getAggregate_amt_total_outstanding().toString() == null ? ".00"
							: String.valueOf(
									e.getAggregate_amt_total_outstanding().setScale(2, RoundingMode.HALF_EVEN)));

				} catch (NullPointerException ex) {
					System.out.println("NullPointerException thrown!");
				}
			});
			GenericXml.writeIntoXmlFormat(
					XmlParameters.builder().genericXmls(genericXmls).prefix("").isNoneSpecialWithPrefix(true)
							.result(result).daoClass(daoClass).reportName(reportName).isIdPresent(true).build());
			setSheet1600XmlList(genericXmls);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setQdfir1600(qdfir1600DAO);
			res.setResponseMessage("Success");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		return null;

	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			Optional<sheet1600DAO> data = sheet1600Repository.findById(dataId);

			if (data.isPresent()) {
				sheet1600Repository.delete(data.get());
			} else {
				throw new ResourceNotFoundException("Record not found with id : " + dataId);
			}
			Response res = new Response();
			res.setResponseMessage("Record Deleted");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			Optional<sheetQdfir1600DAO> data = qdfir1600Repo.findById(dataId);

			if (data.isPresent()) {
				qdfir1600Repo.delete(data.get());
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
	public ResponseEntity<?> updateData(int id, sheet1600DAO Data) throws ResourceNotFoundException {
		Optional<sheet1600DAO> DataDb = sheet1600Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet1600DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setLoan_or_facilities_type(Data.getLoan_or_facilities_type());
			DataUpdate.setAggregate_amt_principal(Data.getAggregate_amt_principal());
			DataUpdate.setAggregate_amt_accrued_interest(Data.getAggregate_amt_accrued_interest());
			DataUpdate.setAggregate_amt_total_outstanding(Data.getAggregate_amt_total_outstanding());
			sheet1600Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS1600Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found : " + Data.getId());
		}
	}

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir1600DAO Data) throws ResourceNotFoundException {
		Optional<sheetQdfir1600DAO> DataDb = qdfir1600Repo.findById(id);

		if (DataDb.isPresent()) {
			sheetQdfir1600DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setLoan_or_facilities_type(Data.getLoan_or_facilities_type());
			DataUpdate.setAggregate_amt_principal(Data.getAggregate_amt_principal());
			DataUpdate.setAggregate_amt_accrued_interest(Data.getAggregate_amt_accrued_interest());
			DataUpdate.setAggregate_amt_total_outstanding(Data.getAggregate_amt_total_outstanding());
			qdfir1600Repo.save(DataUpdate);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS1600Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found : " + Data.getId());
		}
	}

	@Override
	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			sheet1600DAO data = sheet1600Repository.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

			Response res = new Response();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS1600Data(data);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			sheetQdfir1600DAO data = qdfir1600Repo.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS1600Data(data);
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
