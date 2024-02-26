package ra.session02webservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.session02webservice.entity.Student;
import ra.session02webservice.exception.ResourceNotFoundException;
import ra.session02webservice.service.IStudentService;

import java.util.List;

@RestController
@RequestMapping("/api.com/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private  final IStudentService studentService;
    // tạo ra 1 api lấy về danh sách tất cả sinh viên
    @GetMapping
    public ResponseEntity<List<Student>> findAllStudent(){
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }
    // tìm kiếm theo id
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(studentService.findById(id));
    }
    // xóa theo id
    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteById(@PathVariable Integer id){
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }
    // thêm mới
    @PostMapping
    public ResponseEntity<Student> createNewStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.save(student),HttpStatus.CREATED);
    }
    // chỉnh sửa theo id
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable Integer id) throws ResourceNotFoundException {
        findById(id);
        student.setId(id);
        return new ResponseEntity<>(studentService.save(student),HttpStatus.OK);
    }
}
