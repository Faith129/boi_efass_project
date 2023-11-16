package com.efass.sheet.mdfir601;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.Validation;

import com.efass.sheet.mdfir423.sheet423DAO;
import com.efass.sheet.mdfir423.sheetQdfir423DAO;
import com.efass.sheet.mdfir493.sheet493DAO;
import com.efass.sheet.table.TabController;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class sheet601_Impl implements sheet601_Service{

	@Autowired
	Qdfir601Repo qdfir601Repo;
    @Autowired
    sheet601Repository sheet601Repository;
	List<GenericXml> genericXmlList;

	public List<GenericXml> getSheet601XmlList() {
		return genericXmlList;
	}

	public void setSheet601XmlList(List<GenericXml> genericXmlList) {
		this.genericXmlList = genericXmlList;
	}


	// ############################## MDFIR601 CRUD OPERATIONS

 	public ResponseEntity<?> createData(sheet601DAO data) throws ResourceNotFoundException {


		sheet601Repository.save(data);
 		Response res = new Response();
 		res.setResponseMessage("Success");
        res.setResponseCode(00);
 		res.setS601Data(data);


 		return new ResponseEntity<>(res, HttpStatus.OK);
 	}

 	public ResponseEntity<?> fetchAllData() {
 		Iterable<sheet601DAO> data = null;
		Iterable<sheetQdfir601DAO> qdfirData = null;
		List<GenericXml> genericXmls = new ArrayList<>();
		List<String> result = new ArrayList<>();
		AtomicInteger counter = new AtomicInteger(0);

        String reportName = "";
        Class<?> daoClass = null;

        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            reportName = "MDFIR601";
            daoClass = sheet601DAO.class;
			data = sheet601Repository.findAll();

			data.forEach((e) -> {
				counter.getAndIncrement();
				result.add(String.valueOf(counter));
				result.add(e.getCustomer_name()== null ? "" :e.getCustomer_name());

                result.add(e.getDate_approved().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate_approved().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
				result.add(e.getForeign_currency().toString() == null ? ".00" :String.valueOf(e.getForeign_currency().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getRate_of_exchange().toString() == null ? ".00" :String.valueOf(e.getRate_of_exchange().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getApproved_limit().toString() == null ? ".00" :String.valueOf(e.getApproved_limit().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getAmount_drawn().toString() == null ? ".00" :String.valueOf(e.getAmount_drawn().setScale(2, RoundingMode.HALF_EVEN)));

			});

			GenericXml.writeIntoXmlFormat(XmlParameters.builder()
					.genericXmls(genericXmls)
					.prefix("")
					.result(result)
					.daoClass(daoClass)
					.reportName(reportName)
					.isNoneSpecialWithPrefix(true)
					.isIdPresent(true)
					.build());
			setSheet601XmlList(genericXmls);
	 		Response res = new Response();
	 		res.setSheet601(data);
	 		res.setResponseMessage("Success");
	 		res.setResponseCode(00);
	 		return new ResponseEntity<>(res, HttpStatus.OK);
        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            reportName = "QDFIR601";
            daoClass = sheetQdfir601DAO.class;
			qdfirData = qdfir601Repo.findAll();

			qdfirData.forEach((e) ->
			{
				try {
        			//System.out.println("i am here 601");
				counter.getAndIncrement();
				result.add(String.valueOf(counter));
				result.add(e.getCustomer_name()== null ? "" :e.getCustomer_name());
				result.add(e.getDate_approved().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate_approved().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
				result.add(e.getForeign_currency().toString() == null ? ".00" :String.valueOf(e.getForeign_currency().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getRate_of_exchange().toString() == null ? ".00" :String.valueOf(e.getRate_of_exchange().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getApproved_limit().toString() == null ? ".00" :String.valueOf(e.getApproved_limit().setScale(2, RoundingMode.HALF_EVEN)));
				result.add(e.getAmount_drawn().toString() == null ? ".00" :String.valueOf(e.getAmount_drawn().setScale(2, RoundingMode.HALF_EVEN)));
			}
			 catch(NullPointerException ex)
	            {
	    			System.out.println("NullPointerException thrown!");
	            }
			});
        }
		GenericXml.writeIntoXmlFormat(XmlParameters.builder()
				.genericXmls(genericXmls)
				.prefix("")
				.result(result)
				.daoClass(daoClass)
				.reportName(reportName)
				.isNoneSpecialWithPrefix(true)
				.isIdPresent(true)
				.build());
		setSheet601XmlList(genericXmls);
 		ResponseQuarterly res = new ResponseQuarterly();
 		res.setQdfir601(qdfirData);
 		res.setResponseMessage("Success");
 		res.setResponseCode(00);
 		return new ResponseEntity<>(res, HttpStatus.OK);
 	}

	public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet601DAO> data = sheet601Repository.findById(dataId);

		if (data.isPresent()) {
			sheet601Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

    @Override
    public ResponseEntity<?> updateData(int id, sheet601DAO Data) throws ResourceNotFoundException {
        Optional<sheet601DAO> DataDb = sheet601Repository.findById(id);

        if (DataDb.isPresent()) {
        	sheet601DAO DataUpdate = DataDb.get();

			DataUpdate.setId(Data.getId());
			DataUpdate.setAmount_drawn(Data.getAmount_drawn());
			DataUpdate.setRate_of_exchange(Data.getRate_of_exchange());
			DataUpdate.setApproved_limit(Data.getApproved_limit());
			DataUpdate.setCustomer_name(Data.getCustomer_name());
			DataUpdate.setDate_approved(Data.getDate_approved());
			DataUpdate.setForeign_currency(Data.getForeign_currency());
            sheet601Repository.save(DataUpdate);
            Response res = new Response();
            res.setResponseMessage("Record Updated");
            res.setResponseCode(00);
            res.setS601Data(DataUpdate);
            return new ResponseEntity<>(res, HttpStatus.OK);

        } else {
            throw new ResourceNotFoundException("Record not found : " + Data.getId());
        }
    }

    @Override
    public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
    	sheet601DAO data = sheet601Repository.findById(dataId)
            .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

        Response res = new Response();
        res.setResponseMessage("Record Found");
        res.setResponseCode(00);
        res.setS601Data(data);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

	@Override
	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> createDataQ(sheetQdfir601DAO data) throws ResourceNotFoundException {
		qdfir601Repo.save(data);
 		ResponseQuarterly res = new ResponseQuarterly();
 		res.setResponseMessage("Success");
        res.setResponseCode(00);
 		res.setS601Data(data);


 		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> fetchAllDataQ() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException {
		sheetQdfir601DAO data = qdfir601Repo.findById(dataId)
	            .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));

	        ResponseQuarterly res = new ResponseQuarterly();
	        res.setResponseMessage("Record Found");
	        res.setResponseCode(00);
	        res.setS601Data(data);
	        return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deleteByIdQ(int dataId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir601DAO Data) throws ResourceNotFoundException {
		 Optional<sheetQdfir601DAO> DataDb = qdfir601Repo.findById(id);

	        if (DataDb.isPresent()) {
	        	sheetQdfir601DAO DataUpdate = DataDb.get();

				DataUpdate.setId(Data.getId());
				DataUpdate.setAmount_drawn(Data.getAmount_drawn());
				DataUpdate.setRate_of_exchange(Data.getRate_of_exchange());
				DataUpdate.setApproved_limit(Data.getApproved_limit());
				DataUpdate.setCustomer_name(Data.getCustomer_name());
				DataUpdate.setDate_approved(Data.getDate_approved());
				DataUpdate.setForeign_currency(Data.getForeign_currency());
	            qdfir601Repo.save(DataUpdate);
	            ResponseQuarterly res = new ResponseQuarterly();
	            res.setResponseMessage("Record Updated");
	            res.setResponseCode(00);
	            res.setS601Data(DataUpdate);
	            return new ResponseEntity<>(res, HttpStatus.OK);

	        } else {
	            throw new ResourceNotFoundException("Record not found : " + Data.getId());
	        }
	}

}
