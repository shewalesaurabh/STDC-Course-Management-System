package com.cdac.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cdac.dto.SubjectDTO;
import com.cdac.models.Course;
import com.cdac.models.Faculty;
import com.cdac.models.Notification;
import com.cdac.models.StudentDTO;
import com.cdac.services.CourseService;
import com.cdac.services.FacultyService;
import com.cdac.services.FeedbackService;
import com.cdac.services.MaterialService;
import com.cdac.services.NotificationService;
import com.cdac.services.StudentService;
import com.cdac.services.SubjectService;
import com.cdac.services.UserService;

@Controller
public class AdminController {

	@Autowired private UserService usrv;
	@Autowired private CourseService csrv;
	@Autowired private SubjectService ssrv;
	@Autowired private StudentService stdsrv;
	@Autowired private FacultyService isrv;
	@Autowired private MaterialService msrv;
	@Autowired private NotificationService nsrv;
	@Autowired private HttpSession session;
	@Autowired private FeedbackService fbsrv;
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		model.addAttribute("users", usrv.getAllUser().size());
		model.addAttribute("courses", csrv.listAll().size());
		model.addAttribute("students", stdsrv.listAll().size());
		model.addAttribute("lecturers", isrv.listAll().size());
		model.addAttribute("materials", msrv.listAll().size());
		model.addAttribute("list", nsrv.listtop10());
		return "dashboard";
	}
	
	@GetMapping("/courses")
	public String Courses(Model model) {
		model.addAttribute("list", csrv.listAll());
		return "courses";
	}
	
	@GetMapping("/feedbacks")
	public String feedbacks(Model model) {
		model.addAttribute("list", fbsrv.listAll());
		return "feedbacks";
	}
	
	@GetMapping("/notifications")
	public String notifications(Model model) {
		if(session.getAttribute("role").toString().equals("Faculty")) {
			int id=(int)session.getAttribute("id");
			model.addAttribute("list",nsrv.listFacultyNotifications(id));
		}else {
			model.addAttribute("list",nsrv.listAll());
		}
		return "notification";
	}
	
	@GetMapping("/delnot/{id}")
	public String deleteNotification(@PathVariable("id") int id,RedirectAttributes ra) {
		nsrv.deleteNotification(id);
		ra.addFlashAttribute("msg", "Notification deleted");
		return "redirect:/notifications";
	}
	
	@GetMapping("/delfeedback/{id}")
	public String deleteFeedback(@PathVariable("id") int id,RedirectAttributes ra) {
		fbsrv.deleteById(id);
		ra.addFlashAttribute("msg", "Feedback deleted");
		return "redirect:/feedbacks";
	}
	
	@PostMapping("/notifications")
	public String saveNotification(Notification not,RedirectAttributes ra) {
		boolean fromAdmin=session.getAttribute("role").toString().equals("Admin");
		not.setFromAdmin(fromAdmin);
		nsrv.save(not);
		ra.addFlashAttribute("msg", "Notification saved..");
		return "redirect:/notifications";
	}
	
	@PostMapping("/courses")
	public String saveCourse(Course course,RedirectAttributes ra) {
		csrv.saveCourse(course);
		ra.addFlashAttribute("msg", "Course saved successfully");
		return "redirect:/courses";
	}
	
	@GetMapping("/delcourse/{id}")
	public String Courses(@PathVariable("id") int cid) {
		csrv.deleteCourse(cid);
		return "redirect:/courses";
	}
	
	@GetMapping("/subjects")
	public String Subjects(Model model) {
		model.addAttribute("clist", csrv.listAll());
		model.addAttribute("list", ssrv.listAll());
		return "subjects";
	}
	
	@PostMapping("/subjects")
	public String saveSubject(SubjectDTO dto,RedirectAttributes ra) {
		ssrv.saveSubject(dto);
		ra.addFlashAttribute("msg", "Subject saved successfully");
		return "redirect:/subjects";
	}
	
	@GetMapping("/delsubject/{id}")
	public String deleteSubject(@PathVariable("id") int sid,RedirectAttributes ra) {
		ssrv.deleteSubject(sid);
		ra.addFlashAttribute("msg", "Subject deleted successfully");
		return "redirect:/subjects";
	}
	
	@GetMapping("/students")
	public String Students(Model model) {
		model.addAttribute("clist", csrv.listAll());
		model.addAttribute("list", stdsrv.listAll());
		return "students";
	}
	
	@PostMapping("/students")
	public String saveStudent(StudentDTO std,RedirectAttributes ra) {
		stdsrv.saveStudent(std);
		ra.addFlashAttribute("msg", "Student saved successfully");
		return "redirect:/students";
	}
	
	@GetMapping("/delstudent/{id}")
	public String deleteStudent(@PathVariable("id") int id) {
		stdsrv.delete(id);
		return "redirect:/students";
	}
	
	@GetMapping("/faculty")
	public String Faculties(Model model) {
		model.addAttribute("list", isrv.listAll());
		return "faculty";
	}
	
	@PostMapping("/faculty")
	public String saveFaculty(Faculty ins,RedirectAttributes ra) {
		isrv.save(ins);
		ra.addFlashAttribute("msg", "Instructor saved successfully");
		return "redirect:/faculty";
	}
	
	@GetMapping("/dellect/{id}")
	public String deleteInstructor(@PathVariable("id") int id) {
		isrv.delete(id);
		return "redirect:/faculty";
	}
	
	@GetMapping("/users")
	public String Users(Model model) {
		model.addAttribute("list", usrv.getAllUser());
		return "users";
	}
}
