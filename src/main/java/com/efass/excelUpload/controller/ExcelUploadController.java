package com.efass.excelUpload.controller;

import com.efass.excelUpload.service.Sheet100Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController("/api/v1")
@RequiredArgsConstructor
public class ExcelUploadController {

    private final Sheet100Service sheet100Service;
    @PostMapping("uploadSheet/{sheet100}")
    public ResponseEntity<?> uploadSheet(@RequestParam("file") MultipartFile file, @PathVariable String sheet100) {
        sheet100Service.saveSheetToDataBase(file,sheet100);
        return ResponseEntity.ok(Map.of("Message","Sheet100 data uploaded and saved to database"));
    }
}
