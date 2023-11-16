package com.efass.memo;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("api/v1/memo")
@RestController
@RequiredArgsConstructor
public class EfassMemoController {
    private final EfassMemoService efassMemoService;
    @PutMapping
    public ResponseEntity<EfassMemoDto> edit(@Valid @RequestBody EfassMemoDto data) {
        data = efassMemoService.edit(data);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<EfassMemoDto> add(@Valid @RequestBody EfassMemoDto efassMemoDto) {
        efassMemoDto = efassMemoService.add(efassMemoDto);
        return new ResponseEntity<>(efassMemoDto, HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam @NonNull Integer id) {
        efassMemoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("all")
    public ResponseEntity<Iterable<EfassMemo>> getAll() {
        Iterable<EfassMemo> data = efassMemoService.getAll();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<EfassMemo> get(@RequestParam @NonNull Integer id) {
        EfassMemo data = efassMemoService.getOne(id);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
