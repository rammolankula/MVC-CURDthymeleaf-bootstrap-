package thymeleafCurd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import thymeleafCurd.model.Student;

public interface Studentrepository extends JpaRepository<Student,Integer> {
	
	@Query("SELECT COUNT(stdId) FROM Student WHERE stdName=:stdName")
	Integer getStudentNameCount(String stdName);

}
