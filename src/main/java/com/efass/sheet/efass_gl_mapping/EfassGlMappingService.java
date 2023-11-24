package com.efass.sheet.efass_gl_mapping;

import com.efass.sheet.efass_statement_item_ref.StatementItemRef;
import com.efass.sheet.efass_statement_item_ref.StatementItemRefApiResponse;
import com.efass.sheet.efass_statement_item_ref.StatementItemRefRepository;
import com.efass.sheet.efass_statement_ref.StatementRef;
import com.efass.sheet.efass_statement_ref.StatementRefRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EfassGlMappingService {

    private final EfassGlMappingRepository glMappingRepo;
    private final StatementItemRefRepository StatementItemRefRepo;
    private final StatementRefRepository statementRefRepo;


    public GlMappingGenericResponse<?> createGlMappingData(GlMappingRequest request) {
        EfassGlMapping glMapping = new EfassGlMapping();
        glMapping.setStatementCode(request.getStatementCode());
        glMapping.setStatementDesc(request.getStatementDesc());
        glMapping.setItemCode(request.getItemCode());
        glMapping.setItemDesc(request.getItemDesc());
        glMapping.setLedgerNo(request.getLedgerNo());
        glMapping.setCategory("DEFAULT");

        glMappingRepo.save(glMapping);
        return GlMappingGenericResponse.builder()
                .data(glMapping)
                .responseMessage("SUCCESS")
                .build();
    }

    public GlMappingGenericResponse<?> fetchItemCodesFromStatementItemRef() {
        List<StatementItemRef> statementItemRefs = StatementItemRefRepo.findAll();
        return GlMappingGenericResponse.builder()
                .responseMessage("SUCCESS")
                .data(statementItemRefs.stream().map(StatementItemRef::getItemCode))
                .build();
    }

    public GlMappingGenericResponse<?> fetchStatementCodesFromStatementRef() {
        List<StatementRef> statementRefs = statementRefRepo.findAll();
        return GlMappingGenericResponse.builder()
                .responseMessage("SUCCESS")
                .data(statementRefs.stream().map(StatementRef::getStatementCode))
                .build();
    }

    public GlMappingGenericResponse<?> getStatementDescByStatementCode(@RequestParam String statementCode) {
        StatementRef statementRef = statementRefRepo.findByStatementCode(statementCode);
        if (statementRef == null) {
            throw new RuntimeException("FAILED: statement code does not exist");
        }
        return GlMappingGenericResponse.builder()
                .responseMessage("SUCCESS")
                .data(statementRef.getStatementDesc())
                .build();
    }


    public GlMappingGenericResponse<?> getItemDescByItemCode(@RequestParam String itemCode) {
        StatementItemRef statementRef = StatementItemRefRepo.findByItemCode(itemCode);
        if (statementRef == null){
            throw new RuntimeException("FAILED: Item code does not exist");
        }
        return GlMappingGenericResponse.builder()
                .responseMessage("SUCCESS")
                .data(statementRef.getItemDescription())
                .build();
    }

    public GlMappingGenericResponse<?> fetchAllGlData() {
        List<EfassGlMapping> statementRef = glMappingRepo.findAll();

        return GlMappingGenericResponse.builder()
                .responseMessage("SUCCESS")
                .data(statementRef)
                .build();
    }

    @Transactional
    public GlMappingGenericResponse<?> deleteByStatementCode(String statementCode) {
        EfassGlMapping glMappingData = glMappingRepo.findByStatementCode(statementCode).orElse(null);
        if (glMappingData == null) {
            throw new RuntimeException("Invalid statement code");
        }
        glMappingRepo.deleteByStatementCode(statementCode);
        return GlMappingGenericResponse.builder()
                .responseMessage("Item deleted successfully")
                .data(null)
                .build();
    }

    public GlMappingGenericResponse<?> updateGlData(GlMappingRequest glMappingRequest) {
        EfassGlMapping glMapping = glMappingRepo.findByStatementCode(glMappingRequest.getStatementCode()).orElse(null);
        if (glMapping != null) {
            glMapping.setStatementDesc(glMappingRequest.getStatementDesc());
            glMapping.setLedgerNo(glMappingRequest.getLedgerNo());
            glMapping.setStatementCode(glMappingRequest.getStatementCode());
            glMapping.setStatementDesc(glMappingRequest.getStatementDesc());
            glMappingRequest.setItemCode(glMappingRequest.getItemCode());
            glMappingRepo.save(glMapping);
            return GlMappingGenericResponse.builder()
                    .responseMessage("SUCCESS")
                    .data(glMapping)
                    .build();
        }
        else throw new RuntimeException("Invalid StatementCode");
    }
}