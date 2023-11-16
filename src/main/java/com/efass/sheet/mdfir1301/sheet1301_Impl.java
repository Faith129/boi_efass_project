package com.efass.sheet.mdfir1301;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.sheet.mdfir1000.sheet1000DAO;
import com.efass.sheet.mdfir1000.sheetQdfir1000DAO;
import com.efass.sheet.mdfir1300.sheet1300DAO;
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
public class sheet1301_Impl implements sheet1301_Service {

	@Autowired
	sheet1301Repository sheet1301Repository;

	@Autowired
	Qdfir1301Repo qdfir1301Repo;

	List<GenericXml> genericXmlList;

	public List<GenericXml> getSheet1301XmlList() {
		return genericXmlList;
	}

	public void setSheet1301XmlList(List<GenericXml> genericXmlList) {
		this.genericXmlList = genericXmlList;
	}

	// ############################## MDFIR1301 CRUD OPERATIONS

	public ResponseEntity<?> createData(sheet1301DAO data) throws ResourceNotFoundException {
		sheet1301Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS1301Data(data);

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> createDataQ(sheetQdfir1301DAO data) throws ResourceNotFoundException {
		qdfir1301Repo.save(data);
		ResponseQuarterly res = new ResponseQuarterly();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS1301Data(data);

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet1301DAO> data = null;
		Iterable<sheetQdfir1301DAO> qdfir1301DAOS = null;
		List<GenericXml> genericXmls = new ArrayList<>();
		List<String> result = new ArrayList<>();
		AtomicInteger counter = new AtomicInteger(0);

		String reportName = "";
		Class<?> daoClass = null;

		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			reportName = "MDFIR1301";
			daoClass = sheet1301DAO.class;
			data = sheet1301Repository.findAll();
			data.forEach((e) -> {
				counter.getAndIncrement();
				result.add(String.valueOf(counter));
				result.add(e.getCustomer_code() == null ? "" : e.getCustomer_code());
				result.add(e.getCustomer_name() == null ? "" : e.getCustomer_name());
				result.add(e.getTotal_credit().toString() == null ? ".00"
						: String.valueOf(e.getTotal_credit().setScale(2, RoundingMode.HALF_EVEN)));

				result.add(e.getPrincipal_payment_due_and_unpaid().toString() == null ? ".00"
						: String.valueOf(e.getPrincipal_payment_due_and_unpaid().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getAccrued_interest_unpaid().toString() == null ? ".00"
						: String.valueOf(e.getAccrued_interest_unpaid().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getTotal_impaired_credits().toString() == null ? ".00"
						: String.valueOf(e.getTotal_impaired_credits().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getImpairment().toString() == null ? ".00"
						: String.valueOf(e.getImpairment().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getCustomer_code() == null ? "" : e.getCustomer_code());
				result.add(e.getRemarks()  == null ? "" : e.getRemarks());
			});
			GenericXml.writeIntoXmlFormat(
					XmlParameters.builder().genericXmls(genericXmls).prefix("").isNoneSpecialWithPrefix(true)
							.result(result).daoClass(daoClass).reportName(reportName).isIdPresent(true).build());

			setSheet1301XmlList(genericXmls);

			Response res = new Response();
			res.setSheet1301(data);
			res.setResponseMessage("Success");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);

		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			reportName = "QDFIR1301";
			daoClass = sheetQdfir1301DAO.class;
			qdfir1301DAOS = qdfir1301Repo.findAll();

			qdfir1301DAOS.forEach((e) -> {
				try {

					counter.getAndIncrement();
					result.add(String.valueOf(counter));
					result.add(e.getCustomer_code() == null ? "" : e.getCustomer_code());
					result.add(e.getCustomer_name() == null ? "" : e.getCustomer_name());
					result.add(e.getTotal_credit().toString() == null ? ".00"
							: String.valueOf(e.getTotal_credit().setScale(2, RoundingMode.HALF_EVEN)));

					result.add(e.getPrincipal_payment_due_and_unpaid().toString() == null ? ".00"
							: String.valueOf(
									e.getPrincipal_payment_due_and_unpaid().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getAccrued_interest_unpaid().toString() == null ? ".00"
							: String.valueOf(e.getAccrued_interest_unpaid().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getTotal_impaired_credits().toString() == null ? ".00"
							: String.valueOf(e.getTotal_impaired_credits().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getImpairment().toString() == null ? ".00"
							: String.valueOf(e.getImpairment().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getRemarks() == null ? "" : e.getRemarks());
					// result.add(e.getRemarks() == null ? ".00"
					// :String.valueOf(e.getRemarks().setScale(2, RoundingMode.HALF_EVEN)));

				} catch (NullPointerException ex) {
					System.out.println("NullPointerException thrown!");
				}
			});
			GenericXml.writeIntoXmlFormat(
					XmlParameters.builder().genericXmls(genericXmls).prefix("").isNoneSpecialWithPrefix(true)
							.result(result).daoClass(daoClass).reportName(reportName).isIdPresent(true).build());

			setSheet1301XmlList(genericXmls);

			ResponseQuarterly res = new ResponseQuarterly();
			res.setQdfir1301(qdfir1301DAOS);
			res.setResponseMessage("Success");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		return null;

	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			Optional<sheet1301DAO> data = sheet1301Repository.findById(dataId);

			if (data.isPresent()) {
				sheet1301Repository.delete(data.get());
			} else {
				throw new ResourceNotFoundException("Record not found with id : " + dataId);
			}
			Response res = new Response();
			res.setResponseMessage("Record Deleted");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			Optional<sheetQdfir1301DAO> data = qdfir1301Repo.findById(dataId);

			if (data.isPresent()) {
				qdfir1301Repo.delete(data.get());
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
	public ResponseEntity<?> updateData(int id, sheet1301DAO Data) throws ResourceNotFoundException {
		Optional<sheet1301DAO> DataDb = sheet1301Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet1301DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setCustomer_code(Data.getCustomer_code());
			DataUpdate.setCustomer_name(Data.getCustomer_name());
			DataUpdate.setTotal_credit(Data.getTotal_credit());
			DataUpdate.setPrincipal_payment_due_and_unpaid(Data.getPrincipal_payment_due_and_unpaid());
			DataUpdate.setAccrued_interest_unpaid(Data.getAccrued_interest_unpaid());
			DataUpdate.setTotal_impaired_credits(Data.getTotal_impaired_credits());
			DataUpdate.setImpairment(Data.getImpairment());
			DataUpdate.setRemarks(Data.getRemarks());
			sheet1301Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS1301Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found : " + Data.getId());
		}
	}

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir1301DAO Data) throws ResourceNotFoundException {
		Optional<sheetQdfir1301DAO> DataDb = qdfir1301Repo.findById(id);

		if (DataDb.isPresent()) {
			sheetQdfir1301DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setCustomer_code(Data.getCustomer_code());
			DataUpdate.setCustomer_name(Data.getCustomer_name());
			DataUpdate.setTotal_credit(Data.getTotal_credit());
			DataUpdate.setPrincipal_payment_due_and_unpaid(Data.getPrincipal_payment_due_and_unpaid());
			DataUpdate.setAccrued_interest_unpaid(Data.getAccrued_interest_unpaid());
			DataUpdate.setTotal_impaired_credits(Data.getTotal_impaired_credits());
			DataUpdate.setImpairment(Data.getImpairment());
			DataUpdate.setRemarks(Data.getRemarks());

			qdfir1301Repo.save(DataUpdate);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS1301Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found : " + Data.getId());
		}
	}

	@Override
	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			sheet1301DAO data = sheet1301Repository.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

			Response res = new Response();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS1301Data(data);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			sheetQdfir1301DAO data = qdfir1301Repo.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS1301Data(data);
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
