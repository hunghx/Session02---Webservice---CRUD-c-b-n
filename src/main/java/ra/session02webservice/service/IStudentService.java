package ra.session02webservice.service;

import ra.session02webservice.entity.Student;
import ra.session02webservice.exception.ResourceNotFoundException;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    Student findById(Integer id) throws ResourceNotFoundException;
    Student save(Student student);
    void delete(Integer id);
}
