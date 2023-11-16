package com.efass.sheet.mdfir1700;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.sheet.mdfir1650.sheet1650DAO;
import com.efass.sheet.mdfir1650.sheet1650Repository;
import com.efass.sheet.mdfir1650.sheet1650_Service;
import com.efass.sheet.mdfir1650.sheetQdfir1650DAO;
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
public class sheet1700_Impl implements sheet1700_Service {

	@Autowired
	sheet1700Repository _1700Repository;

	@Autowired
	Qdfir1700Repo qdfir1700Repo;

	List<GenericXml> genericXmlList;

	public List<GenericXml> getSheet1700XmlList() {
		return genericXmlList;
	}

	public void setSheet1700XmlList(List<GenericXml> genericXmlList) {
		this.genericXmlList = genericXmlList;
	}

	// ############################## MMFBR1700 CRUD OPERATIONS
	// #################################

	public ResponseEntity<?> createData(sheet1700DAO data) throws ResourceNotFoundException {
		_1700Repository.save(data);
		Response res = new Response();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS1700Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> createDataQ(sheetQdfir1700DAO data) throws ResourceNotFoundException {
		qdfir1700Repo.save(data);
		ResponseQuarterly res = new ResponseQuarterly();
		res.setResponseMessage("Success");
		res.setResponseCode(00);
		res.setS1700Data(data);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchAllData() {
		Iterable<sheet1700DAO> data = null;
		Iterable<sheetQdfir1700DAO> qdfir1700DAOS = null;

		List<GenericXml> genericXmls = new ArrayList<>();
		List<String> result = new ArrayList<>();
		AtomicInteger counter = new AtomicInteger(0);

		String reportName = "";
		Class<?> daoClass = null;

		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			reportName = "MDFIR1700";
			daoClass = sheet1700DAO.class;
			data = _1700Repository.findAll();

			data.forEach((e) -> {
				counter.getAndIncrement();
				result.add(String.valueOf(counter));
				result.add(e.getName() == null ? "" : e.getName());
				result.add(e.getSector() == null ? "" : e.getSector());
				result.add(e.getCrms_borrower_code() == null ? "" : e.getCrms_borrower_code());
				result.add(e.getRc_or_br_or_sr_no().toString() == null ? ".00"
						: String.valueOf(e.getRc_or_br_or_sr_no().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getTotal().toString() == null ? ".00"
						: String.valueOf(e.getTotal().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getClassified_as_npa() == null ? "" : e.getClassified_as_npa());
				result.add(e.getInvestment().toString() == null ? ".00"
						: String.valueOf(e.getInvestment().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getLiabilities().toString() == null ? ".00"
						: String.valueOf(e.getLiabilities().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getTotal_exposure().toString() == null ? ".00"
						: String.valueOf(e.getTotal_exposure().setScale(2, RoundingMode.HALF_EVEN)));
			});
			GenericXml.writeIntoXmlFormat(XmlParameters.builder().genericXmls(genericXmls).prefix("").result(result)
					.daoClass(daoClass).reportName(reportName).isNoneSpecialWithPrefix(true).isIdPresent(true)

					.build());

			setSheet1700XmlList(genericXmls);
			Response res = new Response();
			res.setSheet1700(data);
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			reportName = "QDFIR1700";
			daoClass = sheetQdfir1700DAO.class;
			qdfir1700DAOS = qdfir1700Repo.findAll();

			qdfir1700DAOS.forEach((e) -> {
				try {
					// System.out.println("i am here 1700");

					counter.getAndIncrement();
					result.add(String.valueOf(counter));
					result.add(e.getName() == null ? "" : e.getName());
					result.add(e.getSector() == null ? "" : e.getSector());
					result.add(e.getCrms_borrower_code() == null ? "" : e.getCrms_borrower_code());
					result.add(e.getRc_or_br_or_sr_no().toString() == null ? ".00"
							: String.valueOf(e.getRc_or_br_or_sr_no().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getTotal().toString() == null ? ".00"
							: String.valueOf(e.getTotal().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getClassified_as_npa() == null ? "" : e.getClassified_as_npa());
					result.add(e.getInvestment().toString() == null ? ".00"
							: String.valueOf(e.getInvestment().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getLiabilities().toString() == null ? ".00"
							: String.valueOf(e.getLiabilities().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getTotal_exposure().toString() == null ? ".00"
							: String.valueOf(e.getTotal_exposure().setScale(2, RoundingMode.HALF_EVEN)));
				} catch (NullPointerException ex) {
					System.out.println("NullPointerException thrown!");
				}
			});
			GenericXml.writeIntoXmlFormat(XmlParameters.builder().genericXmls(genericXmls).prefix("").result(result)
					.daoClass(daoClass).reportName(reportName).isNoneSpecialWithPrefix(true).isIdPresent(true)

					.build());

			setSheet1700XmlList(genericXmls);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setQdfir1700(qdfir1700DAOS);
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		return null;
		
	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
		sheet1700DAO data = _1700Repository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		Response res = new Response();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS1700Data(data);

		return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			sheetQdfir1700DAO data = qdfir1700Repo.findById(dataId)
					.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Found");
			res.setResponseCode(00);
			res.setS1700Data(data);

			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		return null;
	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
		Optional<sheet1700DAO> data = _1700Repository.findById(dataId);

		if (data.isPresent()) {
			_1700Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
			Optional<sheetQdfir1700DAO> data = qdfir1700Repo.findById(dataId);

			if (data.isPresent()) {
				qdfir1700Repo.delete(data.get());
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

	public ResponseEntity<?> updateData(int id, sheet1700DAO Data) throws ResourceNotFoundException {

		Optional<sheet1700DAO> DataDb = _1700Repository.findById(id);

		if (DataDb.isPresent()) {
			sheet1700DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setName(Data.getName());
			DataUpdate.setSector(Data.getSector());
			DataUpdate.setCrms_borrower_code(Data.getCrms_borrower_code());
			DataUpdate.setRc_or_br_or_sr_no(Data.getRc_or_br_or_sr_no());
			DataUpdate.setTotal(Data.getTotal());
			DataUpdate.setClassified_as_npa(Data.getClassified_as_npa());
			DataUpdate.setInvestment(Data.getInvestment());
			DataUpdate.setLiabilities(Data.getLiabilities());
			DataUpdate.setTotal_exposure(Data.getTotal_exposure());

			_1700Repository.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS1700Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}
	
	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir1700DAO Data) throws ResourceNotFoundException {
		Optional<sheetQdfir1700DAO> DataDb = qdfir1700Repo.findById(id);

		if (DataDb.isPresent()) {
			sheetQdfir1700DAO DataUpdate = DataDb.get();
			DataUpdate.setId(Data.getId());
			DataUpdate.setName(Data.getName());
			DataUpdate.setSector(Data.getSector());
			DataUpdate.setCrms_borrower_code(Data.getCrms_borrower_code());
			DataUpdate.setRc_or_br_or_sr_no(Data.getRc_or_br_or_sr_no());
			DataUpdate.setTotal(Data.getTotal());
			DataUpdate.setClassified_as_npa(Data.getClassified_as_npa());
			DataUpdate.setInvestment(Data.getInvestment());
			DataUpdate.setLiabilities(Data.getLiabilities());
			DataUpdate.setTotal_exposure(Data.getTotal_exposure());

			qdfir1700Repo.save(DataUpdate);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS1700Data(DataUpdate);
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
}
