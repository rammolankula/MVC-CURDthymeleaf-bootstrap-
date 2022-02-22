package thymeleafCurd.StudentIservice;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import thymeleafCurd.model.Student;
@Service
public interface StudentIService {
	
	public Integer saveStudnet(Student s);
	public void updateStudent(Student s);
	public void deleteStudent(Integer id);
	public Optional<Student> getoneStudent(Integer id);
	public List<Student> getAllStudents();
	public boolean isExist(Integer id);
	
	
	public Page<Student> getPageStudent(Pageable p);

}
