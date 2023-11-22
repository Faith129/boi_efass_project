package com.efass.sheet.efass_gl_mapping;

import com.efass.sheet.efass_statement_item_ref.StatementItemRefApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("deleteByItemCode")
    @ResponseStatus(HttpStatus.OK)
    public GlMappingGenericResponse<?> deleteByItemCode() {
        return null;
    }
}
