package ra.session02webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ra.session02webservice.dto.ClassesWithTotalStudentDto;
import ra.session02webservice.entity.Classes;

import java.util.List;

@Repository
public interface ClassesRepository extends JpaRepository<Classes,String> {
    @Query("select new ra.session02webservice.dto.ClassesWithTotalStudentDto(C.classId,C.className,0) from Classes C")
    List<ClassesWithTotalStudentDto> getTotalStudentByClasses();
}
