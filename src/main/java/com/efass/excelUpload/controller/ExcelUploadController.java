package com.efass.excelUpload.controller;

import com.efass.sheet.mdfir100.sheet100_Service;
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
    @PostMapping("uploadSheet/{sheet100}")
    public ResponseEntity<?> uploadSheet(@PathParam("file") MultipartFile file, @PathVariable String sheet100) {
        sheet100_Service.saveSheet100ToDataBase(file,sheet100);
        return ResponseEntity.ok(Map.of("Message","Sheet100 data uploaded and saved to database"));
    }
}