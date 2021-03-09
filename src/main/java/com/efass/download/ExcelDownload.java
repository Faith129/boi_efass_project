/*
 * package com.efass.download;
 * 
 * import java.io.ByteArrayInputStream; import java.io.File; import
 * java.io.IOException; import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.core.io.InputStreamResource; import
 * org.springframework.http.HttpHeaders; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * 
 * 
 * @RestController
 * 
 * @RequestMapping("/api/customers") public class ExcelDownload { // @Autowired
 * // CustomerRepository customerRepository;
 * 
 * @GetMapping(value = "/download/customers.xlsx") public
 * ResponseEntity<InputStreamResource> excelCustomersReport() throws IOException
 * { List<Customer> customers = (List<Customer>) customerRepository.findAll();
 * 
 * ByteArrayInputStream in = ExcelGenerator.customersToExcel(customers); //
 * return IOUtils.toByteArray(in);
 * 
 * HttpHeaders headers = new HttpHeaders(); headers.add("Content-Disposition",
 * "attachment; filename=customers.xlsx");
 * 
 * return ResponseEntity .ok() .headers(headers) .body(new
 * InputStreamResource(in)); }
 * 
 * 
 * 
 * 
 * 
 * public static ByteArrayInputStream retrieveByteArrayInputStream(File file) {
 * return new ByteArrayInputStream(FileUtils.readFileToByteArray(file)); } }
 */