package com.efass.excelUpload.controller;
import com.efass.sheet.mcfpr1.sheetMcfpr1_Service;
import com.efass.sheet.mdfir1700.sheet1700_Service;
import com.efass.sheet.mdfir223.sheet223_Service;
import com.efass.sheet.mdfir271.sheet271_Service;
import com.efass.sheet.mdfir291.sheet291_Service;
import com.efass.sheet.mdfir311.sheet311_Service;
import com.efass.sheet.mdfir333.sheet333_Service;
import com.efass.sheet.mdfir371_3.sheet371_3_Service;
import com.efass.sheet.mdfir100.sheet100_Service;
import com.efass.sheet.mdfir372.sheet372_Service;
import com.efass.sheet.mdfir382.sheet382_Service;
import com.efass.sheet.mdfir533.sheet533_Service;
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
    private final sheet100_Service sheet100_Service;
    private final sheet372_Service sheet372Service;
    private final sheet382_Service sheet382Service;
    private final sheet533_Service sheet533Service;
    private final sheet223_Service sheet223Service;

    @PostMapping("uploadExcel/mdfir372/{mdfir372}")
    public ResponseEntity<?> uploadSheet372(@RequestParam("file") MultipartFile file, @PathVariable String mdfir372) {
        sheet372Service.saveSheet372ToDataBase(file,mdfir372);
        return ResponseEntity.ok(Map.of("Message","Sheet372 data uploaded and saved to database"));
    }
    @PostMapping("uploadExcel/mdfir382/{mdfir382}")
    public ResponseEntity<?> uploadSheet382(@RequestParam("file") MultipartFile file, @PathVariable String mdfir382) {
        sheet382Service.saveSheet382ToDataBase(file,mdfir382);
        return ResponseEntity.ok(Map.of("Message","Sheet382 data uploaded and saved to database"));
    }
    @PostMapping("uploadExcel/mdfir533/{mdfir533}")
    public ResponseEntity<?> uploadSheet533(@RequestParam("file") MultipartFile file, @PathVariable String mdfir533) {
        sheet533Service.saveSheet533ToDataBase(file,mdfir533);
        return ResponseEntity.ok(Map.of("Message","Sheet533 data uploaded and saved to database"));
    }

    @PostMapping("uploadExcel/mdfir223/{mdfir223}")
    public ResponseEntity<?> uploadSheet223(@RequestParam("file") MultipartFile file, @PathVariable String mdfir223) {
        sheet223Service.saveSheet223ToDataBase(file,mdfir223);
        return ResponseEntity.ok(Map.of("Message","Sheet223 data uploaded and saved to database"));
    }
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

    @PostMapping("uploadExcel/mdfir333/{mdfir333}")
    public ResponseEntity<?> uploadSheet333(@RequestParam("file") MultipartFile file, @PathVariable String mdfir333) {
        sheet333Service.saveSheet333ToDataBase(file,mdfir333);
        return ResponseEntity.ok(Map.of("Message","Sheet333 data uploaded and saved to database"));
    }

    @PostMapping("uploadExcel/mdfir311/{mdfir311}")
    public ResponseEntity<?> uploadSheet311(@RequestParam("file") MultipartFile file, @PathVariable String mdfir311) {
        sheet311Service.saveSheet311ToDataBase(file,mdfir311);
        return ResponseEntity.ok(Map.of("Message","Sheet311 data uploaded and saved to database"));
    }

    @PostMapping("uploadExcel/mdfir371_3/{mdfir371_3}")
    public ResponseEntity<?> uploadSheet371_3(@RequestParam("file") MultipartFile file, @PathVariable String mdfir371_3) {
        sheet371_3Service.saveSheet371_3ToDataBase(file,mdfir371_3);
        return ResponseEntity.ok(Map.of("Message","Sheet371_3 data uploaded and saved to database"));
    }

    @PostMapping("uploadExcel/mcfpr1/{mcfpr1}")
    public ResponseEntity<?> uploadSheetMcfpr1(@RequestParam("file") MultipartFile file, @PathVariable String mcfpr1) {
        sheetMcfpr1Service.saveSheetMcfpr1ToDataBase(file,mcfpr1);
        return ResponseEntity.ok(Map.of("Message","SheetMcfpr1 data uploaded and saved to database"));
    }

    @PostMapping("uploadSheet/{sheet100}")
    public ResponseEntity<?> uploadSheet(@RequestParam("file") MultipartFile file, @PathVariable String sheet100) {
        sheet100_Service.saveSheet100ToDataBase(file,sheet100);
        return ResponseEntity.ok(Map.of("Message","Sheet100 data uploaded and saved to database"));
    }
}

