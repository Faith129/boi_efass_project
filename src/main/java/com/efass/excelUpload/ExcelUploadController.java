package com.efass.excelUpload;

import com.efass.sheet.mdfir100.sheet100_Service;
import com.efass.sheet.mdfir1301.sheet1301_Service;
import com.efass.sheet.mdfir1600.sheet1600_Service;
import com.efass.sheet.mdfir1700.sheet1700_Service;
import com.efass.sheet.mdfir920.sheet920_Service;
import com.efass.sheet.mdfir921.sheet921_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
import java.util.Map;

@RestController
@RequestMapping("/api/excel")
@RequiredArgsConstructor
public class ExcelUploadController {
    private final sheet100_Service sheet100_Service;
    private final sheet1600_Service sheet1600_service;
    private final sheet920_Service sheet920_Service;
    private final sheet921_Service sheet921_service;
    private final sheet1700_Service sheet1700_service;
    private final sheet1301_Service sheet1301_service;

    @PostMapping("uploadSheet100/{sheet100}")
    public ResponseEntity<?> uploadSheet100(@PathParam("file") MultipartFile file, @PathVariable String sheet100) {
        sheet100_Service.saveSheet100ToDataBase(file, sheet100);
        return ResponseEntity.ok(Map.of("Message", "Sheet100 data uploaded and saved to database"));
    }

    @PostMapping("uploadSheet1600/{sheet1600}")
    public ResponseEntity<?> uploadSheet1600(@PathParam("file") MultipartFile file, @PathVariable String sheet1600) {
        sheet1600_service.saveSheet1301ToDataBase(file, sheet1600);
        return ResponseEntity.ok(Map.of("Message", "sheet1600 data uploaded and saved to database"));
    }

    @PostMapping("uploadSheet920/{sheet920}")
    public ResponseEntity<?> uploadSheet920(@PathParam("file") MultipartFile file, @PathVariable String sheet920) {
        sheet920_Service.saveSheet920ToDataBase(file, sheet920);
        return ResponseEntity.ok(Map.of("Message", "sheet920 data uploaded and saved to database"));
    }
    @PostMapping("uploadSheet921/{sheet921}")
    public ResponseEntity<?> uploadSheet921(@PathParam("file") MultipartFile file, @PathVariable String sheet921) {
        sheet921_service.saveSheet921ToDataBase(file, sheet921);
        return ResponseEntity.ok(Map.of("Message", "sheet921 data uploaded and saved to database"));
    }

    @PostMapping("uploadSheet1700/{sheet1700}")
    public ResponseEntity<?> uploadSheet1700(@PathParam("file") MultipartFile file, @PathVariable String sheet1700) {
        sheet1700_service.saveSheet1700ToDataBase(file, sheet1700);
        return ResponseEntity.ok(Map.of("Message", "sheet1700 data uploaded and saved to database"));
    }

    @PostMapping("uploadSheet1301/{sheet1301}")
    public ResponseEntity<?> uploadSheet1301(@PathParam("file") MultipartFile file, @PathVariable String sheet1301) {
        sheet1301_service.saveSheet1301ToDataBase(file, sheet1301);
        return ResponseEntity.ok(Map.of("Message", "sheet1301 data uploaded and saved to database"));
    }
}