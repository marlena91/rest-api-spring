package pl.wsb.restexample.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wsb.restexample.models.WonderOfTheWorld;
import pl.wsb.restexample.models.WonderOfTheWorldDto;
import pl.wsb.restexample.services.WonderOfTheWorldService;

import java.util.List;

@RestController
@RequestMapping("wonders")
@AllArgsConstructor
public class WondersOfTheWorldController {

    private final WonderOfTheWorldService wonderOfTheWorldService;

    @GetMapping
    List<WonderOfTheWorld> getAll(){
        return wonderOfTheWorldService.getAll();
    }

    @GetMapping("{id}")
    ResponseEntity<WonderOfTheWorld> get(@PathVariable Long id) {
        return ResponseEntity.ok(wonderOfTheWorldService.get(id));
    }

    @PostMapping
    ResponseEntity<WonderOfTheWorld> create(@RequestBody WonderOfTheWorldDto wonderOfTheWorldDto) {
        WonderOfTheWorld wonderOfTheWorld = wonderOfTheWorldService.create(wonderOfTheWorldDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(wonderOfTheWorld);
    }

    @PutMapping("{id}")
    ResponseEntity<WonderOfTheWorld> update(@PathVariable Long id, @RequestBody WonderOfTheWorldDto wonderOfTheWorldDto){
        return ResponseEntity.ok(wonderOfTheWorldService.update(id, wonderOfTheWorldDto));
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> delete(@PathVariable Long id){
        wonderOfTheWorldService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
