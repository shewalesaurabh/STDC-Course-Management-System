package com.cdac.controllers;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cdac.dto.AssignmentDTO;
import com.cdac.dto.MaterialUploadDTO;
import com.cdac.models.Faculty;
import com.cdac.services.AssignmentService;
import com.cdac.services.CourseService;
import com.cdac.services.FacultyService;
import com.cdac.services.MaterialService;
import com.cdac.services.NotificationService;
import com.cdac.services.SubjectService;

@Controller
public class FacultyController {

	@Autowired private FacultyService isrv;
	@Autowired private HttpSession session;
	@Autowired private SubjectService ssrv;
	@Autowired private CourseService csrv;
	@Autowired private MaterialService msrv;
	@Autowired private AssignmentService asrv;
	@Autowired private NotificationService nsrv;
	
	@GetMapping("/idashboard")
	public String dashboard(Model model) {
		int id=Integer.parseInt(session.getAttribute("id").toString());
		Faculty ins=isrv.findById(id);
		model.addAttribute("ins", ins);
		model.addAttribute("list", nsrv.listtop10());
		return "idashboard";
	}
	
	@GetMapping("/material")
	public String material(Optional<Integer> cid,Model model) {
		if(cid.isPresent()) {
			model.addAttribute("subs", ssrv.courseSubjects(cid.get()));
		}
		model.addAttribute("clist", csrv.listAll());
		int id=(int)session.getAttribute("id");
		model.addAttribute("list", msrv.listFacultyMaterial(id));
		return "material";
	}
	
	@PostMapping("/material")
	public String uploadmaterial(MaterialUploadDTO dto, RedirectAttributes ra) {
		System.out.println(dto);
		msrv.saveMaterial(dto);
		ra.addFlashAttribute("msg", "Material uploaded successfully");
		return "redirect:/material";
	}
	
	@GetMapping("/delmat/{id}")
	public String deleteMaterial(@PathVariable("id") int id, RedirectAttributes ra) {
		msrv.deleteMaterial(id);
		ra.addFlashAttribute("msg", "Material deleted successfully");
		return "redirect:/material";
	}
	
	@GetMapping("/assignments")
	public String assignments(Optional<Integer> cid,Model model) {
		if(cid.isPresent()) {
			model.addAttribute("subs", ssrv.courseSubjects(cid.get()));
		}
		model.addAttribute("clist", csrv.listAll());
		int id=(int)session.getAttribute("id");
		model.addAttribute("list", asrv.listFacultyMaterial(id));
		return "assignments";
	}
	
	@PostMapping("/assignments")
	public String uploadassignments(AssignmentDTO dto, RedirectAttributes ra) {
		System.out.println(dto);
		asrv.saveAssignment(dto);
		ra.addFlashAttribute("msg", "Assignments uploaded successfully");
		return "redirect:/assignments";
	}
	
	@GetMapping("/delass/{id}")
	public String deleteassignments(@PathVariable("id") int id, RedirectAttributes ra) {
		asrv.deleteAssignment(id);
		ra.addFlashAttribute("msg", "Assignments deleted successfully");
		return "redirect:/assignments";
	}
	
}
