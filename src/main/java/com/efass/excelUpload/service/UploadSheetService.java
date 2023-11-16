package com.efass.excelUpload.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadSheetService {
    public void saveSheet100ToDataBase(MultipartFile file, String sheetNo);
}
