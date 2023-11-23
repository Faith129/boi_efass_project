package com.efass.sheet.efass_gl_mapping;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GlMappingRequest {
    private String statementCode;
    private String statementDesc;
    private String itemCode;
    private String itemDesc;
    private String ledgerNo;
}
