package com.efass.sheet.efass_gl_mapping;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EfassGlMappingRepository extends JpaRepository<EfassGlMapping,Integer> {
    EfassGlMapping findByStatementCode(String statementCode);

    EfassGlMapping findByItemCode(String itemCode);

    EfassGlMapping findByLedgerNo(String itemCode);

    void deleteByStatementCode(String statementCode);
    void deleteByItemCode(String itemCode);
    void deleteByLedgerNo(String itemCode);
    Optional<EfassGlMapping> findByItemCodeAndStatementCode(String itemCode, String statementCode);
}
