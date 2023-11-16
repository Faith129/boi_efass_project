package com.efass.excelUpload.service;

import org.springframework.web.multipart.MultipartFile;

public interface Sheet100Service {
    public void saveSheetToDataBase(MultipartFile file, String sheetNo);
}
