package com.efass.sheet.mdfir100;

import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.efass.ReportGroupEnum;
import com.efass.download.xmlModels.GenericXml;
import com.efass.download.xmlModels.XmlParameters;
import com.efass.sheet.table.TabController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.efass.exceptions.ResourceNotFoundException;
import com.efass.payload.Response;
import com.efass.payload.ResponseQuarterly;

@Service
public class sheet100_Impl implements sheet100_Service {

	@Autowired
	sheet100Repository sheet100Repo;

	@Autowired
	Qdfir100Repo qdfir100repo;

	@Autowired
	TabController tabController;

    @Override
    public ResponseEntity<?> saveCBNDate(String date) {
        sheet100Repo.insertCBNdate(date);
     return new ResponseEntity<>(date, HttpStatus.OK);
      }

	List<GenericXml> genericXmlList;

	public List<GenericXml> getSheet100XmlList() {
		return genericXmlList;
	}

	public void setSheet100XmlList(List<GenericXml> genericXmlList) {
		this.genericXmlList = genericXmlList;
	}

	public ResponseEntity<?> fetchAllData() {

		Iterable<sheet100DAO> data;
		Iterable<sheetQdfirDAO> dqfir100Dao = null;
		List<GenericXml> genericXmls = new ArrayList<>();
		List<String> result = new ArrayList<>();
		List<String> codes = new ArrayList<>();

		String reportName = "";
		Class<?> daoClass = null;

        if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.MONTHLY) == 0) {
            reportName = "MDFIR100";
            daoClass = sheet100DAO.class;
            data = sheet100Repo.findAll();
            String date = sheet100Repo.findCbdCode("1");

            data.forEach((e) -> {
                //System.out.println(e.getCode());
                if (e.getCode().equals("21250")) {
                    //System.out.println("Entered");
                    codes.add(e.getCode());
                    result.add(date);
                    result.add(date);
                    result.add(date);
                    result.add(date);
                } else {
                    codes.add(e.getCode());
                    result.add(e.getNumber_1() == null ? ".00"
                        : String.valueOf(e.getNumber_1().setScale(2, RoundingMode.HALF_EVEN)));
                    result.add(e.getValue_1() == null ? ".00"
                        : String.valueOf(e.getValue_1().setScale(2, RoundingMode.HALF_EVEN)));
                    result.add(e.getNumber_2() == null ? ".00"
                        : String.valueOf(e.getNumber_2().setScale(2, RoundingMode.HALF_EVEN)));
                    result.add(e.getValue_2() == null ? ".00"
                        : String.valueOf(e.getValue_2().setScale(2, RoundingMode.HALF_EVEN)));
                }
            });

            List<String> skipCodes = Arrays.asList("21235", "21250", "21260", "21265", "21275", "21280", "21285",
                "21295", "21300", "21305");
            GenericXml.writeIntoXmlFormat(XmlParameters.builder().isSpecialWithPrefix(true).prefix(".T0")
                .daoClass(daoClass).reportName(reportName)
                .result(result).
                genericXmls(genericXmls).isSkipRows(true)
                .skipRows(skipCodes).codes(codes).build());

			setSheet100XmlList(genericXmls);

			Response res = new Response();
			res.setSheet100(data);
			res.setResponseMessage("Success");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		if (TabController.getReportGroupEnum().compareTo(ReportGroupEnum.QUARTERLY) == 0) {
			reportName = "QDFIR100";
			daoClass = sheetQdfirDAO.class;
			dqfir100Dao = qdfir100repo.findAll();
			String date = qdfir100repo.findCbdCode("1");

			dqfir100Dao.forEach((e) -> {
				//System.out.println(e.getCode());
				if (e.getCode().equals("21250")) {
					//System.out.println("Entered");
					codes.add(e.getCode());
					result.add(date);
					result.add(date);
					result.add(date);
					result.add(date);
				} else {
					codes.add(e.getCode());
					result.add(e.getNumber_1() == null ? ".00"
							: String.valueOf(e.getNumber_1().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getValue_1() == null ? ".00"
							: String.valueOf(e.getValue_1().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getNumber_2() == null ? ".00"
							: String.valueOf(e.getNumber_2().setScale(2, RoundingMode.HALF_EVEN)));
					result.add(e.getValue_2() == null ? ".00"
							: String.valueOf(e.getValue_2().setScale(2, RoundingMode.HALF_EVEN)));
				}
			});

			List<String> skipCodes = Arrays.asList("21235", "21250", "21260", "21265", "21275", "21280", "21285",
					"21295", "21300", "21305");
			GenericXml.writeIntoXmlFormat(XmlParameters.builder().isSpecialWithPrefix(true).prefix(".T0")
					.daoClass(daoClass).reportName(reportName)
					.result(result).
					genericXmls(genericXmls).isSkipRows(true)
					.skipRows(skipCodes).codes(codes).build());

			setSheet100XmlList(genericXmls);

			ResponseQuarterly res = new ResponseQuarterly();
			res.setQdfir100(dqfir100Dao);
			res.setResponseMessage("Success");
			res.setResponseCode(00);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		return null;

	}

	public ResponseEntity<?> getDataById(int dataId) throws ResourceNotFoundException {
		sheet100DAO data = sheet100Repo.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Record not found for this id :: " + dataId));
		Response res = new Response();
		res.setResponseMessage("Record Found");
		res.setResponseCode(00);
		res.setS100Data(data);

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	public ResponseEntity<?> updateData(int id, sheet100DAO Data) throws ResourceNotFoundException {

		Optional<sheet100DAO> DataDb = sheet100Repo.findByCode(Data.getCode());

		if (DataDb.isPresent()) {
			sheet100DAO DataUpdate = DataDb.get();
			DataUpdate.setNumber_1(Data.getNumber_1());
			DataUpdate.setValue_1(Data.getValue_1());
			DataUpdate.setNumber_2(Data.getNumber_2());
			DataUpdate.setValue_2(Data.getValue_2());
			sheet100Repo.save(DataUpdate);
			Response res = new Response();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS100Data(DataUpdate);
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
	public ResponseEntity<?> updateDataQ(int id, sheetQdfirDAO Data) throws ResourceNotFoundException {
		Optional<sheetQdfirDAO> DataDb = qdfir100repo.findByCode(Data.getCode());

		if (DataDb.isPresent()) {
			sheetQdfirDAO DataUpdate = DataDb.get();
			DataUpdate.setNumber_1(Data.getNumber_1());
			DataUpdate.setValue_1(Data.getValue_1());
			DataUpdate.setNumber_2(Data.getNumber_2());
			DataUpdate.setValue_2(Data.getValue_2());
			qdfir100repo.save(DataUpdate);
			ResponseQuarterly res = new ResponseQuarterly();
			res.setResponseMessage("Record Updated");
			res.setResponseCode(00);
			res.setS100Data(DataUpdate);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			throw new ResourceNotFoundException("Record not found with id : " + Data.getId());
		}
	}

	@Override
	public ResponseEntity<?> getDataByIdQ(int dataId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}
