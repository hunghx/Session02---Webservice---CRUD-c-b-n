package ra.session02webservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String classId;
    private String className;
    @OneToMany(mappedBy = "classes")
    @JsonIgnore
    private List<Student> studentList;

    public Classes(String classId, String className) {
        this.classId = classId;
        this.className = className;
    }
}
