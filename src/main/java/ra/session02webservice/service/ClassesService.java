package ra.session02webservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ra.session02webservice.dto.ClassesWithTotalStudentDto;
import ra.session02webservice.dto.PageDto;
import ra.session02webservice.entity.Classes;
import ra.session02webservice.exception.ResourceNotFoundException;
import ra.session02webservice.repository.ClassesRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassesService implements IClassesService{
    private final ClassesRepository classesRepository;
    @Override
    public List<Classes> findAll() {
        return classesRepository.findAll();
    }

    @Override
    public Page<Classes> findAllWithPagination(Pageable pageable) {
        Page<Classes> page = classesRepository.findAll(pageable);
        return page;
//        return PageDto.builder().data(page.getContent())
//                .pages(page.getTotalPages())
//                .hasNext(page.hasNext())
//                .hasPrev(page.hasPrevious())
//                .number(page.getNumber())
//                .totalElements(page.getTotalElements())
//                .sort(page.getSort())
//                .build();
    }

    @Override
    public Classes findById(String id) throws ResourceNotFoundException {
        return classesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Classes not found"));
    }

    @Override
    public Classes save(Classes classes) {
        return classesRepository.save(classes);
    }

    @Override
    public void delete(String id) {
        classesRepository.deleteById(id);
    }

    @Override
    public List<ClassesWithTotalStudentDto> getClassesWithTotalStudent() {
        return classesRepository.getTotalStudentByClasses();
    }
}
