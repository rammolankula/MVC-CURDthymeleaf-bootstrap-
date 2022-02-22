package thymeleafCurd.Studentserviceimple;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import thymeleafCurd.StudentIservice.StudentIService;
import thymeleafCurd.model.Student;
import thymeleafCurd.repository.Studentrepository;
@Service
public class Srudentserviceimpl implements StudentIService {

	@Autowired
	private Studentrepository repo;
	
	@Override
	public Integer saveStudnet(Student s) {
		// TODO Auto-generated method stub
		return repo.save(s).getStdId();
	}

	@Override
	public void updateStudent(Student s) {
		repo.save(s);
	}

	@Override
	public void deleteStudent(Integer id) {
          repo.deleteById(id);		
	}

	@Override
	public Optional<Student> getoneStudent(Integer id) {
		return repo.findById(id);
		
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public boolean isExist(Integer id) {
		return repo.existsById(id);
	}

	@Override
	public Page<Student> getPageStudent(Pageable p) {
		// TODO Auto-generated method stub
		return repo.findAll(p);
	}

}
