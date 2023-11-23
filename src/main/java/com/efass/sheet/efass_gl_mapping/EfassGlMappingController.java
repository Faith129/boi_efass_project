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

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public GlMappingGenericResponse<?>createGlMappingData(@RequestBody GlMappingRequest mappingRequest) {
        return glMappingService.createGlMappingData(mappingRequest);
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

    @GetMapping("getItemDesc")
    @ResponseStatus(HttpStatus.OK)
    public GlMappingGenericResponse<?> getItemDesc(@RequestParam String itemCode) {
        return glMappingService.getItemDescByItemCode(itemCode);
    }

    @DeleteMapping("deleteByItemCode")
    @ResponseStatus(HttpStatus.OK)
    public void deleteByItemCode(@RequestParam String itemCode) {
        glMappingService.deleteByItemCode(itemCode);
    }
}
