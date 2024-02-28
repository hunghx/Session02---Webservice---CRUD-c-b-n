package ra.session02webservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.session02webservice.dto.DataResponseSuccess;
import ra.session02webservice.entity.Classes;
import ra.session02webservice.exception.ResourceNotFoundException;
import ra.session02webservice.service.IClassesService;

import java.util.Date;

@RestController
@RequestMapping("/api.com/v1/classes")
@RequiredArgsConstructor
public class ClassNameController {
    private final IClassesService classesService;
    // laays danh sách tất cả các class
    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(new DataResponseSuccess(classesService.findAll(),HttpStatus.OK), HttpStatus.OK);
    }
    @GetMapping("/pagination")
    public ResponseEntity<?> getAll(Pageable pageable){
        return new ResponseEntity<>(new DataResponseSuccess(classesService.findAllWithPagination(pageable),HttpStatus.OK), HttpStatus.OK);
    }
    // api tim theo id
    @GetMapping("/{id}")
    public ResponseEntity<DataResponseSuccess> getById(@PathVariable String id) throws ResourceNotFoundException {
        return new ResponseEntity<>(new DataResponseSuccess(classesService.findById(id),HttpStatus.OK),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<DataResponseSuccess> deleteById(@PathVariable String id) throws ResourceNotFoundException {
        classesService.findById(id);
        classesService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping
    public ResponseEntity<DataResponseSuccess> add(@RequestBody Classes classes) {
        return new ResponseEntity<>(new DataResponseSuccess(classesService.save(classes),HttpStatus.CREATED),HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<DataResponseSuccess> update(@RequestBody Classes classes, @PathVariable String id) throws ResourceNotFoundException {
        classesService.findById(id);
        classes.setClassId(id);
        return new ResponseEntity<>(new DataResponseSuccess(classesService.save(classes),HttpStatus.OK),HttpStatus.OK);
    }
    @GetMapping("/count-student-by-classes")
    public ResponseEntity<?> getClassesWithTotalStudent(){
        return new ResponseEntity<>(new DataResponseSuccess(classesService.getClassesWithTotalStudent(),HttpStatus.OK), HttpStatus.OK);
    }
}
