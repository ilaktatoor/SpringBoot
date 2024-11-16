package com.example.CRUD.service;

import com.example.CRUD.entity.Student;
import com.example.CRUD.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentsService {
    @Autowired
    private StudentsRepository studentsRepository;

    //guardar
    public Student saveStudent(Student student){
        if(student.getId() == null){
            return studentsRepository.save(student);
        }
        return null;
    }

    //listar
    public Page<Student> getAllStudent(Integer page, Integer size, Boolean enablePagination){
        return studentsRepository.findAll(enablePagination ? PageRequest.of(page,size) : Pageable.unpaged());
    }

    //delete
    public void deleteStudent(Long id){
        studentsRepository.deleteById(id);
    }

    //Editar
    public Student editStudent(Student student){
        if (student.getId() != null && studentsRepository.existsById(student.getId())){
            return studentsRepository.save(student);
        }
        return null;
    }

    public boolean existById(Long id) {
        return studentsRepository.existsById(id);
    }

    //findbyid
    public Optional<Student> findById(Long id){
        return studentsRepository.findById(id);
    }
}
