package com.efass.excelUpload.controller;

import com.efass.sheet.mcfpr1.sheetMcfpr1_Service;
import com.efass.sheet.mdfir271.sheet271_Service;
import com.efass.sheet.mdfir291.sheet291_Service;
import com.efass.sheet.mdfir311.sheet311_Service;
import com.efass.sheet.mdfir333.sheet333_Service;
import com.efass.sheet.mdfir371_3.sheet371_3_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ExcelUploadController {

    private final sheet271_Service sheet271Service;
    private final sheet291_Service sheet291Service;
    private final sheet311_Service sheet311Service;
    private final sheet333_Service sheet333Service;
    private final sheet371_3_Service sheet371_3Service;
    private final sheetMcfpr1_Service sheetMcfpr1Service;


    @PostMapping("uploadExcel/mdfir271/{mdfir271}")
    public ResponseEntity<?> uploadSheet271Sheet(@RequestParam("file") MultipartFile file, @PathVariable String mdfir271) {
        sheet271Service.saveSheet271ToDataBase(file,mdfir271);
        return ResponseEntity.ok(Map.of("Message","Sheet271 data uploaded and saved to database"));
    }
    @PostMapping("uploadExcel/mdfir291/{mdfir291}")
    public ResponseEntity<?> uploadSheet291(@RequestParam("file") MultipartFile file, @PathVariable String mdfir291) {
        sheet291Service.saveSheet291ToDataBase(file,mdfir291);
        return ResponseEntity.ok(Map.of("Message","Sheet291 data uploaded and saved to database"));
    }
    @PostMapping("uploadSheet333/{MDFIR333}")
    public ResponseEntity<?> uploadSheet333(@RequestParam("file") MultipartFile file, @PathVariable String sheet333) {
        sheet333Service.saveSheet333ToDataBase(file,sheet333);
        return ResponseEntity.ok(Map.of("Message","Sheet333 data uploaded and saved to database"));
    }
    @PostMapping("uploadSheet311/{MDFIR311}")
    public ResponseEntity<?> uploadSheet311(@RequestParam("file") MultipartFile file, @PathVariable String sheet311) {
        sheet311Service.saveSheet311ToDataBase(file,sheet311);
        return ResponseEntity.ok(Map.of("Message","Sheet311 data uploaded and saved to database"));
    }
    @PostMapping("uploadSheet371_3/{MDFIR371_3}")
    public ResponseEntity<?> uploadSheet371_3(@RequestParam("file") MultipartFile file, @PathVariable String sheet371_3) {
        sheet371_3Service.saveSheet371_3ToDataBase(file,sheet371_3);
        return ResponseEntity.ok(Map.of("Message","Sheet371_3 data uploaded and saved to database"));
    }
    @PostMapping("uploadMCFPR1/{MCFPR1}")
    public ResponseEntity<?> uploadSheetMcfpr1(@RequestParam("file") MultipartFile file, @PathVariable String sheetMcfpr1) {
        sheetMcfpr1Service.saveSheetMcfpr1ToDataBase(file,sheetMcfpr1);
        return ResponseEntity.ok(Map.of("Message","SheetMcfpr1 data uploaded and saved to database"));
    }
}
