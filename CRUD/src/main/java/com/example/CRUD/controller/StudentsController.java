package com.example.CRUD.controller;

import com.example.CRUD.entity.Student;
import com.example.CRUD.service.StudentsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    @PostMapping
    public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentsService.saveStudent(student));
    }

    @GetMapping
    public ResponseEntity<Page<Student>>getAllStudent(@RequestParam(required = false, defaultValue = "0") Integer page,
                                                      @RequestParam(required = false, defaultValue = "10") Integer size,
                                                      @RequestParam(required = false, defaultValue = "false") Boolean enablePagination){

        return ResponseEntity.ok(studentsService.getAllStudent(page, size, enablePagination));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteStudent(@PathVariable("id") Long id){
        studentsService.deleteStudent(id);
        ResponseEntity.ok(!studentsService.existById(id));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Student>> findStudentById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(studentsService.findById(id));
    }

    @PutMapping
    public ResponseEntity<Student> editStudent(@Valid @RequestBody Student student){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentsService.saveStudent(student));
    }
}
