package com.efass.excelUpload.controller;

import com.efass.sheet.mdfir100.sheet100_Service;
import com.efass.sheet.mdfir101.sheet101_Service;
import com.efass.sheet.mdfir1300.sheet1300_Service;
import com.efass.sheet.mdfir250.sheet250_Service;
import com.efass.sheet.mdfir600.sheet600_Service;
import com.efass.sheet.mdfir601.sheet601_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/uploadExcel")
@RequiredArgsConstructor
public class ExcelUploadController {

    private final sheet100_Service sheet100_Service;

    private final sheet101_Service _sheet101_Service;
    private final sheet250_Service _sheet250_Service;
    private final sheet600_Service _sheet600_service;
    private final sheet601_Service _sheet601_service;
    private final sheet1300_Service _sheet1300_service;

    @PostMapping("uploadSheet/{sheet100}")
    public ResponseEntity<?> uploadSheet(@PathParam("file") MultipartFile file, @PathVariable String sheet100) {
        sheet100_Service.saveSheet100ToDataBase(file, sheet100);
        return ResponseEntity.ok(Map.of("Message", "Sheet100 data uploaded and saved to database"));
    }

    @PostMapping("mdfir101/{mdfir101}")
    public ResponseEntity<?> uploadSheet101(@PathParam("file") MultipartFile file, @PathVariable String mdfir101) {
        _sheet101_Service.saveSheet101ToDataBase(file, mdfir101);
        return ResponseEntity.ok(Map.of("Message", "MDFIR101 data uploaded and saved to database"));
    }

    @PostMapping("mdfir250/{mdfir250}")
    public ResponseEntity<?> uploadSheet250(@PathParam("file") MultipartFile file, @PathVariable String mdfir250) {
        _sheet250_Service.saveSheet250ToDataBase(file, mdfir250);
        return ResponseEntity.ok(Map.of("Message", "MDFIR250 data uploaded and saved to database"));
    }

    @PostMapping("mdfir600/{mdfir600}")
    public ResponseEntity<?> uploadSheet600(@PathParam("file") MultipartFile file, @PathVariable String mdfir600) {
        _sheet600_service.saveSheet600ToDataBase(file, mdfir600);
        return ResponseEntity.ok(Map.of("Message", "Sheet600 data uploaded and saved to database"));
    }

    @PostMapping("mdfir601/{mdfir601}")
    public ResponseEntity<?> uploadSheet601(@PathParam("file") MultipartFile file, @PathVariable String mdfir601) {
        _sheet601_service.saveSheet601ToDataBase(file, mdfir601);
        return ResponseEntity.ok(Map.of("Message", "Sheet601 data uploaded and saved to database"));
    }

    @PostMapping("mdfir1300/{mdfir1300}")
    public ResponseEntity<?> uploadSheet1300(@PathParam("file") MultipartFile file, @PathVariable String mdfir1300) {
        _sheet1300_service.saveSheet1300ToDataBase(file, mdfir1300);
        return ResponseEntity.ok(Map.of("Message", "Sheet1300 data uploaded and saved to database"));
    }
}
