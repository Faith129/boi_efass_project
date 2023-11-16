package com.efass.excelUpload.controller;

import com.efass.excelUpload.service.UploadSheetService;
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

    private final UploadSheetService sheet100Service;
    @PostMapping("uploadSheet/{sheet100}")
    public ResponseEntity<?> uploadSheet(@RequestParam("file") MultipartFile file, @PathVariable String sheet100) {
        sheet100Service.saveSheet100ToDataBase(file,sheet100);
        return ResponseEntity.ok(Map.of("Message","Sheet100 data uploaded and saved to database"));
    }

}
