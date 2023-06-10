package at.technikum.tourplannerbackend.controller;

import at.technikum.tourplannerbackend.service.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
public abstract class Controller<T> {

    private final Service<T> service;

    public Controller(Service<T> service) {
        this.service = service;
        log.info("Controller created");
    }

    @PostMapping()
    public ResponseEntity<T> addNew(@RequestBody T t) {
        try {
            log.info("addNew");
            System.out.println(t);
            T addedT = service.addNew(t);
            return ResponseEntity.status(HttpStatus.CREATED).body(addedT);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/getList")
    public ResponseEntity<List<T>> getList() {
        try {
            List<T> tList = service.getList();
            return ResponseEntity.ok(tList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> findById(@PathVariable("id") Long id) {
        try {
            T t = service.findById(id);
            return t == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(t);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        try {
            T t = service.findById(id);
            if (t == null) {
                return ResponseEntity.notFound().build();
            }
            service.delete(t);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping
    public ResponseEntity<T> update(@RequestBody T t) {
        try {
            return service.update(t) == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(t);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
