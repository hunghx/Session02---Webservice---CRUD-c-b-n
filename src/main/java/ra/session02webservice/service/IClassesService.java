package ra.session02webservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ra.session02webservice.dto.ClassesWithTotalStudentDto;
import ra.session02webservice.dto.PageDto;
import ra.session02webservice.entity.Classes;
import ra.session02webservice.entity.Student;
import ra.session02webservice.exception.ResourceNotFoundException;

import java.util.List;

public interface IClassesService {
    List<Classes> findAll();
    Page<Classes> findAllWithPagination(Pageable pageable);
    Classes findById(String id) throws ResourceNotFoundException;
    Classes save(Classes classes);
    void delete(String id);
    List<ClassesWithTotalStudentDto> getClassesWithTotalStudent();
}
