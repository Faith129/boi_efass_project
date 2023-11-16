package com.efass.sheet.mdfir921;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;
import com.efass.sheet.table.TabController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class sheet921_Impl implements sheet921_Service {

    @Autowired
    Qdfir921Repo qdfir921Repo;

    @Autowired
    sheet921Repository _921Repository;

    List<GenericXml> genericXmlList;

    public List<GenericXml> getSheet921XmlList() {
        return genericXmlList;
    }

    public void setSheet921XmlList(List<GenericXml> genericXmlList) {
        this.genericXmlList = genericXmlList;
    }

    // ############################## MMFBR921 CRUD OPERATIONS #################################


    public ResponseEntity<?> createData(sheet921DAO data) throws ResourceNotFoundException {

        _921Repository.save(data);
        Response res = new Response();
        res.setResponseMessage("Success");
        res.setResponseCode(00);
        res.setS921Data(data);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


    public ResponseEntity<?> fetchAllData() {
        Iterable<sheet921DAO> data = null;
        Iterable<sheetQdfir921DAO> sheetQdfir921DAOS = null;
        List<GenericXml> genericXmls = new ArrayList<>();
        List<String> result = new ArrayList<>();
        AtomicInteger counter = new AtomicInteger(0);


        String reportName = "";
        Class<?> daoClass = null;

        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            reportName = "MDFIR921";
            daoClass = sheet921DAO.class;
            data = _921Repository.findAll();

            data.forEach((e) -> {
                    counter.getAndIncrement();
                    result.add(String.valueOf(counter));
                    result.add(e.getSurname() == null ? "" :e.getSurname());
                    result.add(e.getFirst_name() == null ? "" :e.getFirst_name());
                    result.add(e.getMiddle_name() == null ? "" :e.getMiddle_name());
                    result.add(e.getDesignation() == null ? "" :e.getDesignation());
                    result.add(e.getSex()== null ? "" : e.getSex());
                    result.add(e.getDate_of_birth().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate_of_birth().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                    result.add(e.getNationality() == null ? "" :e.getNationality());
                    result.add(e.getState_of_origin() == null ? "" :e.getState_of_origin());
                    result.add(e.getPassport_number() == null ? "" :e.getPassport_number());
                    result.add(e.getNational_id_card_number()== null ? "" : e.getNational_id_card_number());
                    result.add(e.getBranch_name() == null ? "" :e.getBranch_name());
                    result.add(e.getBranch_code() == null ? "" :e.getBranch_code());
                    result.add(e.getState_code()== null ? "" :e.getState_code());
                    result.add(e.getDepartment()== null ? "" : e.getDepartment());
                    result.add(e.getDate_of_fraud().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate_of_fraud().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                    result.add(e.getDate_discovered().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate_discovered().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                    result.add(e.getAmount_involved().toString() == null ? ".00" :String.valueOf(e.getAmount_involved().setScale(2, RoundingMode.HALF_EVEN)));
                    result.add(e.getStatus()== null ? "" : e.getStatus());
                    result.add(e.getAmount_recovered().toString() == null ? BigDecimal.ZERO.toString() :e.getAmount_recovered().toString());
                    // result.add(e.getActual_loss().toString() == null ? ".00" :String.valueOf(e.getActual_loss().setScale(2, RoundingMode.HALF_EVEN)));
                    result.add(e.getType()== null ? "" : e.getType());
                    result.add(e.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());

                }
            );

            Field[] declaredFields = sheet921DAO.class.getDeclaredFields();
            Field field = null;
      			try {
      			    field = sheet921DAO.class.getField("actual_loss");
      			} catch (NoSuchFieldException e) {
      			    e.printStackTrace();
      			}
      			List<Integer> list = Collections.singletonList(Arrays.asList(declaredFields).indexOf(field));
      			GenericXml.writeIntoXmlFormat(XmlParameters.builder()

      		   .genericXmls(genericXmls)
                  .prefix("")
                  .result(result)
                  .daoClass(daoClass)
                  .reportName(reportName)
                  .isNoneSpecialWithPrefix(true)
                  .isIdPresent(true)
                  .isSkipColumns(true)
                  .skipColumns(list)
                  .build());

              setSheet921XmlList(genericXmls);
              Response res = new Response();
              res.setSheet921(data);
              res.setResponseCode(00);
              return new ResponseEntity<>(res, HttpStatus.OK);
        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            reportName = "QDFIR921";
            daoClass = sheetQdfir921DAO.class;
            sheetQdfir921DAOS = qdfir921Repo.findAll();

            sheetQdfir921DAOS.forEach((e) ->
            {
            	try {
                        counter.getAndIncrement();
                        result.add(String.valueOf(counter));
                        result.add(e.getSurname() == null ? "" :e.getSurname());
                        result.add(e.getFirst_name() == null ? "" :e.getFirst_name());
                        result.add(e.getMiddle_name() == null ? "" :e.getMiddle_name());
                        result.add(e.getDesignation() == null ? "" :e.getDesignation());
                        result.add(e.getSex()== null ? "" : e.getSex());
                        result.add(e.getDate_of_birth().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate_of_birth().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                        result.add(e.getNationality() == null ? "" :e.getNationality());
                        result.add(e.getState_of_origin() == null ? "" :e.getState_of_origin());
                        result.add(e.getPassport_number() == null ? "" :e.getPassport_number());
                        result.add(e.getNational_id_card_number()== null ? "" : e.getNational_id_card_number());
                        result.add(e.getBranch_name() == null ? "" :e.getBranch_name());
                        result.add(e.getBranch_code() == null ? "" :e.getBranch_code());
                        result.add(e.getState_code()== null ? "" :e.getState_code());
                        result.add(e.getDepartment()== null ? "" : e.getDepartment());
                        result.add(e.getDate_of_fraud().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate_of_fraud().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                        result.add(e.getDate_discovered().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate_discovered().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                        result.add(e.getAmount_involved().toString() == null ? ".00" :String.valueOf(e.getAmount_involved().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getStatus()== null ? "" : e.getStatus());
                        result.add(e.getAmount_recovered().toString() == null ? BigDecimal.ZERO.toString() :e.getAmount_recovered().toString());
                       // result.add(e.getActual_loss().toString() == null ? ".00" :String.valueOf(e.getActual_loss().setScale(2, RoundingMode.HALF_EVEN)));
                        result.add(e.getType()== null ? "" : e.getType());
                        result.add(e.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
            	}
            	 catch(NullPointerException ex)
  	            {
  	    			System.out.println("NullPointerException thrown!");
  	            }
                });
     };
      Field[] declaredFields = sheetQdfir921DAO.class.getDeclaredFields();
      Field field = null;
			try {
			    field = sheetQdfir921DAO.class.getField("actual_loss");
			} catch (NoSuchFieldException e) {
			    e.printStackTrace();
			}
			List<Integer> list = Collections.singletonList(Arrays.asList(declaredFields).indexOf(field));
			GenericXml.writeIntoXmlFormat(XmlParameters.builder()

		   .genericXmls(genericXmls)
            .prefix("")
            .result(result)
            .daoClass(daoClass)
            .reportName(reportName)
            .isNoneSpecialWithPrefix(true)
            .isIdPresent(true)
            .isSkipColumns(true)
            .skipColumns(list)
            .build());

        setSheet921XmlList(genericXmls);
        ResponseQuarterly res = new ResponseQuarterly();
        res.setQdfir921(sheetQdfir921DAOS);
        res.setResponseCode(00);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }



    public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
        sheet921DAO data = _921Repository.findById(dataId)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
        Response res = new Response();
        res.setResponseMessage("Record Found");
        res.setResponseCode(00);
        res.setS921Data(data);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

        Optional<sheet921DAO> data = _921Repository.findById(dataId);

        if (data.isPresent()) {
            _921Repository.delete(data.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + dataId);
        }
        Response res = new Response();
        res.setResponseMessage("Record Deleted");
        res.setResponseCode(00);
        return new ResponseEntity<>(res, HttpStatus.OK);

    }

    public ResponseEntity<?> updateData(int id , sheet921DAO Data) throws ResourceNotFoundException {

        Optional<sheet921DAO> DataDb = _921Repository.findById(id);

        if (DataDb.isPresent()) {
            sheet921DAO DataUpdate = DataDb.get();
            DataUpdate.setId(Data.getId());
            DataUpdate.setSurname(Data.getSurname());
            DataUpdate.setFirst_name(Data.getFirst_name());
            DataUpdate.setMiddle_name(Data.getMiddle_name());
            DataUpdate.setDesignation(Data.getDesignation());
            DataUpdate.setSex(Data.getSex());
            DataUpdate.setDate_of_birth(Data.getDate_of_birth());
            DataUpdate.setNationality(Data.getNationality());
            DataUpdate.setState_of_origin(Data.getState_of_origin());
            DataUpdate.setPassport_number(Data.getPassport_number());
            DataUpdate.setNational_id_card_number(Data.getNational_id_card_number());
            DataUpdate.setBranch_name(Data.getBranch_name());
            DataUpdate.setBranch_code(Data.getBranch_code());
            DataUpdate.setState_code(Data.getState_code());
            DataUpdate.setDepartment(Data.getDepartment());
            DataUpdate.setDate_of_fraud(Data.getDate_of_fraud());
            DataUpdate.setDate_discovered(Data.getDate_discovered());
            DataUpdate.setAmount_involved(Data.getAmount_involved());
            DataUpdate.setStatus(Data.getStatus());
            DataUpdate.setAmount_recovered(Data.getAmount_recovered());
            DataUpdate.setType(Data.getType());
            DataUpdate.setDate(Data.getDate());
            _921Repository.save(DataUpdate);
            Response res = new Response();
            res.setResponseMessage("Record Updated");
            res.setResponseCode(00);
            res.setS921Data(DataUpdate);
            return new ResponseEntity<>(res, HttpStatus.OK);

        } else {
            throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
        }
    }


  /*  public ResponseEntity<?> updateDataQDFIR921(int id , sheetQdfir921DAO Data) throws ResourceNotFoundException {

        Optional<sheetQdfir921DAO> DataDb = qdfir921Repo.findById(id);

        if (DataDb.isPresent()) {
        	sheetQdfir921DAO DataUpdate = DataDb.get();
            DataUpdate.setId(Data.getId());
            DataUpdate.setSurname(Data.getSurname());
            DataUpdate.setFirst_name(Data.getFirst_name());
            DataUpdate.setMiddle_name(Data.getMiddle_name());
            DataUpdate.setDesignation(Data.getDesignation());
            DataUpdate.setSex(Data.getSex());
            DataUpdate.setDate_of_birth(Data.getDate_of_birth());
            DataUpdate.setNationality(Data.getNationality());
            DataUpdate.setState_of_origin(Data.getState_of_origin());
            DataUpdate.setPassport_number(Data.getPassport_number());
            DataUpdate.setNational_id_card_number(Data.getNational_id_card_number());
            DataUpdate.setBranch_name(Data.getBranch_name());
            DataUpdate.setBranch_code(Data.getBranch_code());
            DataUpdate.setState_code(Data.getState_code());
            DataUpdate.setDepartment(Data.getDepartment());
            DataUpdate.setDate_of_fraud(Data.getDate_of_fraud());
            DataUpdate.setDate_discovered(Data.getDate_discovered());
            DataUpdate.setAmount_involved(Data.getAmount_involved());
            DataUpdate.setStatus(Data.getStatus());
            DataUpdate.setAmount_recovered(Data.getAmount_recovered());
           // DataUpdate.setActual_loss(Data.getActual_loss());
            DataUpdate.setType(Data.getType());
            DataUpdate.setDate(Data.getDate());
            qdfir921Repo.save(DataUpdate);
            Response res = new Response();
            res.setResponseMessage("Record Updated");
            res.setResponseCode(00);
            res.s921QDFIRData(DataUpdate);
            return new ResponseEntity<>(res, HttpStatus.OK);

        } else {
            throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
        }
    }*/

	@Override
	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> createDataQ(sheetQdfir921DAO data) throws ResourceNotFoundException {
		qdfir921Repo.save(data);
	        ResponseQuarterly res = new ResponseQuarterly();
	        res.setResponseMessage("Success");
	        res.setResponseCode(00);
	        res.setS921Data(data);
	        return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> fetchAllDataQ() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException {
		sheetQdfir921DAO data = qdfir921Repo.findById(dataId)
	                .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
	        ResponseQuarterly res = new ResponseQuarterly();
	        res.setResponseMessage("Record Found");
	        res.setResponseCode(00);
	        res.setS921Data(data);

	        return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> deleteByIdQ(int dataId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir921DAO Data) throws ResourceNotFoundException {
		Optional<sheetQdfir921DAO> DataDb = qdfir921Repo.findById(id);

        if (DataDb.isPresent()) {
        	sheetQdfir921DAO DataUpdate = DataDb.get();
            DataUpdate.setId(Data.getId());
            DataUpdate.setSurname(Data.getSurname());
            DataUpdate.setFirst_name(Data.getFirst_name());
            DataUpdate.setMiddle_name(Data.getMiddle_name());
            DataUpdate.setDesignation(Data.getDesignation());
            DataUpdate.setSex(Data.getSex());
            DataUpdate.setDate_of_birth(Data.getDate_of_birth());
            DataUpdate.setNationality(Data.getNationality());
            DataUpdate.setState_of_origin(Data.getState_of_origin());
            DataUpdate.setPassport_number(Data.getPassport_number());
            DataUpdate.setNational_id_card_number(Data.getNational_id_card_number());
            DataUpdate.setBranch_name(Data.getBranch_name());
            DataUpdate.setBranch_code(Data.getBranch_code());
            DataUpdate.setState_code(Data.getState_code());
            DataUpdate.setDepartment(Data.getDepartment());
            DataUpdate.setDate_of_fraud(Data.getDate_of_fraud());
            DataUpdate.setDate_discovered(Data.getDate_discovered());
            DataUpdate.setAmount_involved(Data.getAmount_involved());
            DataUpdate.setStatus(Data.getStatus());
            DataUpdate.setAmount_recovered(Data.getAmount_recovered());
            DataUpdate.setType(Data.getType());
            DataUpdate.setDate(Data.getDate());
            qdfir921Repo.save(DataUpdate);
            ResponseQuarterly res = new ResponseQuarterly();
            res.setResponseMessage("Record Updated");
            res.setResponseCode(00);
            res.setS921Data(DataUpdate);
            return new ResponseEntity<>(res, HttpStatus.OK);

        } else {
            throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
        }
	}


}

