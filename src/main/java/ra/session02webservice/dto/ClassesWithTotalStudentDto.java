package ra.session02webservice.dto;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ra.session02webservice.entity.Classes;
@NoArgsConstructor
@Getter
@Setter
public class ClassesWithTotalStudentDto extends Classes {
    private int totalStudent;

    public ClassesWithTotalStudentDto(String classId, String className, int totalStudent) {
        super(classId, className);
        this.totalStudent = totalStudent;
    }
}
