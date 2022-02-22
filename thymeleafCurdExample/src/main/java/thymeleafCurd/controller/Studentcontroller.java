package thymeleafCurd.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import thymeleafCurd.StudentIservice.StudentIService;
import thymeleafCurd.model.Student;

@Controller
@RequestMapping("/student")
public class Studentcontroller {
	
	@Autowired
	private StudentIService service;
	
	@GetMapping("/register")
	public String showreg(Model model) {
		model.addAttribute("student",new Student());
		System.out.println("data=--{}}}}}}}}}}}}}}}----");
		return "studentregister";
	}
	@PostMapping("/save")
	public String save(@ModelAttribute Student student,Model model) {
		Integer id=service.saveStudnet(student);
		model.addAttribute("message","data'"+id+"'successfully");
		return "studentregister";
	}
	//@GetMapping("/getALL")
	public String showAll(Model model) {
		List<Student> list=service.getAllStudents();
		model.addAttribute("list",list);
		return "StudentData";
	}
	// ..../all?Page=2
	//...../all(no input in URL default page=0,size=10
	@GetMapping("/getALL")
	public String showPage(@PageableDefault(page=0,size=3) Pageable p,Model model) {
		Page<Student> page=service.getPageStudent(p);
		model.addAttribute("page",page); 
		return "StudentData";
	}
	
	
	
	
	
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam Integer id,Model model) {
		String message=null;
		if(service.isExist(id)) {
			service.deleteStudent(id);
			message="student'"+id+"deleted";
		}else {
			message="student'"+id+"'not deleted";
		}
		model.addAttribute("message",message);
		List<Student> list=service.getAllStudents();
		model.addAttribute("list",list);
		return  "StudentData";
	}
	@GetMapping("/edit")
	public String showEdit(@RequestParam Integer id,Model model) {
		String page=null;
		Optional<Student> opt=service.getoneStudent(id);
		if(opt.isPresent()) {
			model.addAttribute("student",opt.get());
			page="studentEdit";
		}else {
			page="redirect:getALL";
		}
		return page;
	}
	@PostMapping("/update")
	public String updateStudent(@ModelAttribute Student student) {
		service.updateStudent(student);
		return "redirect:getALL";
		
	}

}
