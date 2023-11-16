package com.efass.memo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class EfassMemoService {

    private final EfassMemoRepository efassMemoRepository;
    public EfassMemoDto add(EfassMemoDto efassMemoDto) {
        EfassMemo efassMemo = mapDtoToEntity(efassMemoDto);
        efassMemo = efassMemoRepository.save(efassMemo);
        return mapEntityToDto(efassMemo);
    }

    private EfassMemoDto mapEntityToDto(EfassMemo efassMemo) {
        return EfassMemoDto.builder()
                .id(efassMemo.getId())
                .gl_code(efassMemo.getGl_code())
                .gl_description(efassMemo.getGl_description())
                .dr_cr_ind(efassMemo.getDr_cr_ind())
                .amount(efassMemo.getAmount())
                .period(efassMemo.getPeriod())
                .year(efassMemo.getYear())
                .posting_ind(efassMemo.getPosting_ind())
                .status(efassMemo.getStatus())
                .crncy_id(efassMemo.getCrncy_id())
                .crncy_cd_iso(efassMemo.getCrncy_cd_iso())
                .build();
    }

    private EfassMemo mapDtoToEntity(EfassMemoDto efassMemoDto) {
        System.out.println(efassMemoDto);
        return EfassMemo.builder()
                .id(efassMemoDto.getId())
                .gl_code(efassMemoDto.getGl_code())
                .gl_description(efassMemoDto.getGl_description())
                .dr_cr_ind(efassMemoDto.getDr_cr_ind())
                .amount(efassMemoDto.getAmount())
                .period(efassMemoDto.getPeriod())
                .year(efassMemoDto.getYear())
                .posting_ind(efassMemoDto.getPosting_ind())
                .status(efassMemoDto.getStatus())
                .crncy_id(efassMemoDto.getCrncy_id())
                .crncy_cd_iso(efassMemoDto.getCrncy_cd_iso())
                .build();
    }

    public void delete(Integer id) {
        efassMemoRepository.findById(id).ifPresent(efassMemoRepository::delete);
    }

    public EfassMemoDto edit(EfassMemoDto efassMemoDto) {
        EfassMemo efassMemo = efassMemoRepository.findById(efassMemoDto.getId()).orElseThrow(()-> new NoSuchElementException("No such ID !!!"));
        efassMemo.setStatus(efassMemoDto.getStatus());
        efassMemo = efassMemoRepository.save(efassMemo);
        return mapEntityToDto(efassMemo);
    }

    public Iterable<EfassMemo> getAll() {
        return efassMemoRepository.findAll();
    }

    public EfassMemo getOne(Integer id) {
        return efassMemoRepository.findById(id).orElseThrow(()-> new NoSuchElementException("No such ID !!!"));
    }
}
