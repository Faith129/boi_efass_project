//package com.efass.sheet.mdfir920;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import static com.efass.sheet.mdfir920.query.report920;
//@RequiredArgsConstructor
//public class sheet920AltRepo {
//    private final JdbcTemplate jdbcTemplate;
//    public boolean insertData920(sheet920DAO data) {
//        int result = jdbcTemplate.update(report920, data.getAddress(), data.getBranch_code(),
//            data.getDate_from(), data.getDate_of_birth(), data.getDate_reinstated(), data.getDate_terminated_or_dismissed(),
//            data.getDate_to(), data.getDepartment(), data.getDesignation(), data.getFirst_name(),
//            data.getMiddle_name(), data.getName(), data.getNational_id_card_number(), data.getOrganization(),
//            data.getPermanent_home_address(), data.getReason_for_reinstatement(), data.getReasons_for_termination(),
//            data.getState_code(), data.getSurname());
//        return result == 0 ? true : false;
//    }
//}
