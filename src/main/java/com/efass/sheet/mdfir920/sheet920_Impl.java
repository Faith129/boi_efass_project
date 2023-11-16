package com.efass.sheet.mdfir920;

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

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;


@Service
public class sheet920_Impl implements sheet920_Service{

    @Autowired
    sheet920Repository _920Repository;

    @Autowired Qdfir920Repo qdfir920Repo;

    List<GenericXml> genericXmlList;

    public List<GenericXml> getSheet920XmlList() {
        return genericXmlList;
    }

    public void setSheet920XmlList(List<GenericXml> genericXmlList) {
        this.genericXmlList = genericXmlList;
    }

    public ResponseEntity<?> fetchAllData(){
        Iterable<sheet920DAO> data = null;
        Iterable<sheetQdfir920DAO> qdfir920DAOS = null;

        List<GenericXml> genericXmls = new ArrayList<>();
        List<String> result = new ArrayList<>();
        AtomicInteger counter = new AtomicInteger(0);

        String reportName = "";
        Class<?> daoClass = null;

        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            reportName = "MDFIR920";
            daoClass = sheet920DAO.class;
            data = _920Repository.findAll();

            data.forEach((e) -> {
                    counter.getAndIncrement();
                    result.add(String.valueOf(counter));
                    result.add(e.getSurname()== null ? "" : e.getSurname());
                    result.add(e.getFirst_name()== null ? "" : e.getFirst_name());
                    result.add(e.getMiddle_name()== null ? "" : e.getMiddle_name());
                    result.add(e.getDesignation() == null ? "" :e.getDesignation());
                    result.add(e.getDate_of_birth().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate_of_birth().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                    result.add(e.getNational_id_card_number() == null ? "" :e.getNational_id_card_number());
                    result.add(e.getPermanent_home_address()== null ? "" : e.getPermanent_home_address());
                    result.add(e.getName() == null ? "" :e.getName());
                    result.add(e.getBranch_code() == null ? "" :e.getBranch_code());
                    result.add(e.getState_code() == null ? "" :e.getState_code());
                    result.add(e.getDepartment() == null ? "" :e.getDepartment());
                    result.add(e.getDate_terminated_or_dismissed().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate_terminated_or_dismissed().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                    result.add(e.getReasons_for_termination() == null ? "" :e.getReasons_for_termination());
                    result.add(e.getDate_reinstated().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate_reinstated().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                    result.add(e.getReason_for_reinstatement() == null ? "" :e.getReason_for_reinstatement());
                    result.add(e.getOrganization()== null ? "" : e.getOrganization());
                    result.add(e.getAddress() == null ? "" :e.getAddress());
                    result.add(e.getDate_from().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate_from().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                    result.add(e.getDate_to().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate_to().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());

                }
            );

            GenericXml.writeIntoXmlFormat(XmlParameters.builder()
                    .genericXmls(genericXmls)
                    .prefix("")
                    .result(result)
                    .daoClass(daoClass)
                    .reportName(reportName)
                    .isNoneSpecialWithPrefix(true)
                    .isIdPresent(true)
                    .build());
            setSheet920XmlList(genericXmls);

            Response resp = new Response();
            resp.setSheet920(data);

            resp.setResponseMessage("Success");
            resp.setResponseCode(00);

            return  new ResponseEntity<>(resp, HttpStatus.OK);
        }
        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
            reportName = "QDFIR920";
            daoClass = sheetQdfir920DAO.class;
            qdfir920DAOS = qdfir920Repo.findAll();

            qdfir920DAOS.forEach((e) ->
            {
            	try {
        			//System.out.println("i am here 920");
                        counter.getAndIncrement();
                        result.add(String.valueOf(counter));
                        result.add(e.getSurname()== null ? "" : e.getSurname());
                        result.add(e.getFirst_name()== null ? "" : e.getFirst_name());
                        result.add(e.getMiddle_name()== null ? "" : e.getMiddle_name());
                        result.add(e.getDesignation() == null ? "" :e.getDesignation());
                        result.add(e.getDate_of_birth().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate_of_birth().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                        result.add(e.getNational_id_card_number() == null ? "" :e.getNational_id_card_number());
                        result.add(e.getPermanent_home_address()== null ? "" : e.getPermanent_home_address());
                        result.add(e.getName() == null ? "" :e.getName());
                        result.add(e.getBranch_code() == null ? "" :e.getBranch_code());
                        result.add(e.getState_code() == null ? "" :e.getState_code());
                        result.add(e.getDepartment() == null ? "" :e.getDepartment());
                        result.add(e.getDate_terminated_or_dismissed().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate_terminated_or_dismissed().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                        result.add(e.getReasons_for_termination() == null ? "" :e.getReasons_for_termination());
                        result.add(e.getDate_reinstated().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate_reinstated().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                        result.add(e.getReason_for_reinstatement() == null ? "" :e.getReason_for_reinstatement());
                        result.add(e.getOrganization()== null ? "" : e.getOrganization());
                        result.add(e.getAddress() == null ? "" :e.getAddress());
                        result.add(e.getDate_from().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate_from().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
                        result.add(e.getDate_to().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString() == null ? String.valueOf(.00) :e.getDate_to().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());

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
        setSheet920XmlList(genericXmls);

    ResponseQuarterly resp = new ResponseQuarterly();
        resp.setQdfir920(qdfir920DAOS);

        resp.setResponseMessage("Success");
        resp.setResponseCode(00);

        return  new ResponseEntity<>(resp, HttpStatus.OK);

    }

   public ResponseEntity<?> createData(sheet920DAO data) throws ResourceNotFoundException
   {
       _920Repository.save(data);
 		Response res = new Response();
 		res.setResponseMessage("Success");
        res.setResponseCode(00);
 		res.setS920Data(data);

 		return new ResponseEntity<>(res, HttpStatus.OK);
 	}


   public ResponseEntity<?> deleteById(int dataId) throws ResourceNotFoundException {

		Optional<sheet920DAO> data = _920Repository.findById(dataId);

		if (data.isPresent()) {
            _920Repository.delete(data.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + dataId);
		}
		Response res = new Response();
		res.setResponseMessage("Record Deleted");
		res.setResponseCode(00);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

    public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
        sheet920DAO data = _920Repository.findById(dataId)
                .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id::" + dataId));
        Response resp = new Response();
        resp.setResponseMessage("Record Found");
        resp.setResponseCode(00);
        resp.setS920Data(data);

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }


    public ResponseEntity<?> updateData(int id, sheet920DAO Data) throws ResourceNotFoundException{
        Optional<sheet920DAO> DataDb = _920Repository.findById(id);

        if (DataDb.isPresent()){
            sheet920DAO DataUpdate = DataDb.get();
            DataUpdate.setId(Data.getId());
//            DataUpdate.setDescription(Data.getDescription());
            DataUpdate.setSurname(Data.getSurname());
            DataUpdate.setMiddle_name(Data.getMiddle_name());
            DataUpdate.setFirst_name(Data.getFirst_name());
            DataUpdate.setDate_of_birth(Data.getDate_of_birth());
            DataUpdate.setNational_id_card_number(Data.getNational_id_card_number());
            DataUpdate.setDesignation(Data.getDesignation());
            DataUpdate.setPermanent_home_address(Data.getPermanent_home_address());
            DataUpdate.setName(Data.getName());
            DataUpdate.setBranch_code(Data.getBranch_code());
            DataUpdate.setState_code(Data.getState_code());
            DataUpdate.setDepartment(Data.getDepartment());
            DataUpdate.setDate_terminated_or_dismissed(Data.getDate_terminated_or_dismissed());
            DataUpdate.setReasons_for_termination(Data.getReasons_for_termination());
            DataUpdate.setDate_reinstated(Data.getDate_reinstated());
            DataUpdate.setReason_for_reinstatement(Data.getReason_for_reinstatement());
            DataUpdate.setOrganization(Data.getOrganization());
            DataUpdate.setAddress(Data.getAddress());
            DataUpdate.setDate_from(Data.getDate_from());
            DataUpdate.setDate_to(Data.getDate_to());

            _920Repository.save(DataUpdate);

            Response resp = new Response();
            resp.setResponseMessage("Record Updated");
            resp.setResponseCode(00);
            resp.setS920Data(DataUpdate);

            return new ResponseEntity<>(resp, HttpStatus.OK);
        }
        else  {
            throw new ResourceNotFoundException("Record not Found with id : " + Data.getId());
        }
    }

	@Override
	public ResponseEntity<?> callPrepareTableProcedures(String start_date, String end_date)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> createDataQ(sheetQdfir920DAO data) throws ResourceNotFoundException {
		qdfir920Repo.save(data);
	 		ResponseQuarterly res = new ResponseQuarterly();
	 		res.setResponseMessage("Success");
	        res.setResponseCode(00);
	 		res.setS920Data(data);

	 		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> fetchAllDataQ() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException {
		sheetQdfir920DAO data = qdfir920Repo.findById(dataId)
	                .orElseThrow(() -> new ResourceNotFoundException("Record not found for this id::" + dataId));
	        ResponseQuarterly resp = new ResponseQuarterly();
	        resp.setResponseMessage("Record Found");
	        resp.setResponseCode(00);
	        resp.setS920Data(data);

	        return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> updateDataQ(int id, sheetQdfir920DAO Data) throws ResourceNotFoundException {
		 Optional<sheetQdfir920DAO> DataDb = qdfir920Repo.findById(id);

	        if (DataDb.isPresent()){
	        	sheetQdfir920DAO DataUpdate = DataDb.get();
	            DataUpdate.setId(Data.getId());
//	            DataUpdate.setDescription(Data.getDescription());
	            DataUpdate.setSurname(Data.getSurname());
	            DataUpdate.setMiddle_name(Data.getMiddle_name());
	            DataUpdate.setFirst_name(Data.getFirst_name());
	            DataUpdate.setDate_of_birth(Data.getDate_of_birth());
	            DataUpdate.setNational_id_card_number(Data.getNational_id_card_number());
	            DataUpdate.setDesignation(Data.getDesignation());
	            DataUpdate.setPermanent_home_address(Data.getPermanent_home_address());
	            DataUpdate.setName(Data.getName());
	            DataUpdate.setBranch_code(Data.getBranch_code());
	            DataUpdate.setState_code(Data.getState_code());
	            DataUpdate.setDepartment(Data.getDepartment());
	            DataUpdate.setDate_terminated_or_dismissed(Data.getDate_terminated_or_dismissed());
	            DataUpdate.setReasons_for_termination(Data.getReasons_for_termination());
	            DataUpdate.setDate_reinstated(Data.getDate_reinstated());
	            DataUpdate.setReason_for_reinstatement(Data.getReason_for_reinstatement());
	            DataUpdate.setOrganization(Data.getOrganization());
	            DataUpdate.setAddress(Data.getAddress());
	            DataUpdate.setDate_from(Data.getDate_from());
	            DataUpdate.setDate_to(Data.getDate_to());

	            qdfir920Repo.save(DataUpdate);

	            ResponseQuarterly resp = new ResponseQuarterly();
	            resp.setResponseMessage("Record Updated");
	            resp.setResponseCode(00);
	            resp.setS920Data(DataUpdate);

	            return new ResponseEntity<>(resp, HttpStatus.OK);
	        }
	        else  {
	            throw new ResourceNotFoundException("Record not Found with id : " + Data.getId());
	        }
	}



}
