package com.efass.sheet.efass_gl_mapping;

import com.efass.sheet.efass_statement_item_ref.StatementItemRefApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api/v1/efassGlMapping")
@RequiredArgsConstructor
public class EfassGlMappingController {
    private final EfassGlMappingService glMappingService;
    private final EfassGlMappingRepository glMappingRepo;

    @PostMapping
    public ResponseEntity<GlMappingGenericResponse<?>> createGlMappingData(@RequestBody GlMappingRequest mappingRequest) {
        boolean existingGl = glMappingRepo.findByStatementCode(mappingRequest.getStatementCode()).isPresent();
        if (existingGl) {
            return new ResponseEntity<>(GlMappingGenericResponse.builder()
                    .responseMessage("Statement code already exist " + mappingRequest.getStatementCode())
                    .data(null)
                    .build(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(glMappingService.createGlMappingData(mappingRequest), HttpStatus.ACCEPTED);
    }

    @GetMapping("fetchItemCodes")
    @ResponseStatus(HttpStatus.OK)
    public GlMappingGenericResponse<?> fetchItemCodes() {
        return glMappingService.fetchItemCodesFromStatementItemRef();
    }

    @GetMapping("fetchStatementCodes")
    @ResponseStatus(HttpStatus.OK)
    public GlMappingGenericResponse<?> fetchStatementCodes() {
        return glMappingService.fetchStatementCodesFromStatementRef();
    }

    @GetMapping("getStatementDesc")
    @ResponseStatus(HttpStatus.OK)
    public GlMappingGenericResponse<?> getStatementDesc(@RequestParam String statementCode) {
        return glMappingService.getStatementDescByStatementCode(statementCode);
    }

    @GetMapping("getAllGlData")
    @ResponseStatus(HttpStatus.OK)
    public GlMappingGenericResponse<?> getAllGlData() {
        return glMappingService.fetchAllGlData();
    }

    @PostMapping("updateGlData")
    @ResponseStatus(HttpStatus.OK)
    public GlMappingGenericResponse<?> updateGlData(@RequestBody GlMappingRequest glMappingRequest) {
        return glMappingService.updateGlData(glMappingRequest);
    }

    @GetMapping("getItemDesc")
    @ResponseStatus(HttpStatus.OK)
    public GlMappingGenericResponse<?> getItemDesc(@RequestParam String itemCode) {
        return glMappingService.getItemDescByItemCode(itemCode);
    }


    @DeleteMapping("deleteByStatementCode")
    @ResponseStatus(HttpStatus.OK)
    public GlMappingGenericResponse<?> deleteByStatementCode(@RequestParam String statementCode) {
       return glMappingService.deleteByStatementCode(statementCode);
    }
}
