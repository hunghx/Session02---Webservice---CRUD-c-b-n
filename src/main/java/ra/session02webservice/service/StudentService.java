package ra.session02webservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.session02webservice.entity.Student;
import ra.session02webservice.exception.ResourceNotFoundException;
import ra.session02webservice.repository.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService{
    private final StudentRepository studentRepository;
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Integer id) throws ResourceNotFoundException {
        return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }
}
