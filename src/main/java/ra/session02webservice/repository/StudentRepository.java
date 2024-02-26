package ra.session02webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.session02webservice.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

}
