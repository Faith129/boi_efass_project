package com.efass.sheet.efass_gl_mapping;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EfassGlMappingRepository extends JpaRepository<EfassGlMapping,Integer> {
   Optional<EfassGlMapping> findByStatementCode(String statementCode);
    void deleteByStatementCode(String statementCode);
}
