package ra.session02webservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ra.session02webservice.dto.PageDto;
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
    public PageDto findAll(Pageable pageable) {
        Pageable custom = PageRequest.of(pageable.getPageNumber(),5,pageable.getSort());
        Page<Student> page = studentRepository.findAll(custom);
        return PageDto.builder().data(page.getContent())
                .pages(page.getTotalPages())
                .hasNext(page.hasNext())
                .hasPrev(page.hasPrevious())
                .size(page.getSize())
                .number(page.getNumber())
                .totalElements(page.getTotalElements())
                .sort(page.getSort())
                .build();
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
