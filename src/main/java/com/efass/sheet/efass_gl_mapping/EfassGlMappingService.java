package com.efass.sheet.efass_gl_mapping;

import com.efass.sheet.efass_statement_item_ref.StatementItemRef;
import com.efass.sheet.efass_statement_item_ref.StatementItemRefApiResponse;
import com.efass.sheet.efass_statement_item_ref.StatementItemRefRepository;
import com.efass.sheet.efass_statement_ref.StatementRef;
import com.efass.sheet.efass_statement_ref.StatementRefRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;

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
    @Transactional
    public void deleteByItemCode(String itemCode) {
        glMappingRepo.deleteByItemCode(itemCode);
    }
}