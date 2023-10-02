package com.cdac.services;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cdac.dto.AssignmentDTO;
import com.cdac.models.Assignment;
import com.cdac.repos.AssignmentRepository;

@Service
public class AssignmentService {
	@Autowired private AssignmentRepository mrepo;
	@Autowired private HttpSession session;
	@Autowired private ServletContext ctx;
	@Autowired private FacultyService isrv;
	@Autowired private SubjectService ssrv;
	@Autowired private CourseService csrv;
	
	public List<Assignment> listAll(){
		return mrepo.findAll();
	}
	
	public List<Assignment> listFacultyMaterial(int id){
		return mrepo.findByFacultyId(id);
	}
	
	public List<Assignment> listCourseMaterial(int id){
		return mrepo.findByCourseCid(id);
	}
	
	public void deleteAssignment(int id) {
		Assignment mat=mrepo.findById(id).get();
		try {
		Files.delete(Paths.get(ctx.getRealPath(mat.getFilename())));
		}
		catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
		mrepo.delete(mat);
	}
	
	public void saveAssignment(AssignmentDTO dto) {
		String filename="Assignment"+ (mrepo.count()+1)+"."+getExtensionByStringHandling(dto.getMaterial().getOriginalFilename()).get();
		save(dto.getMaterial(),"assignment",filename);
		Assignment mat=new Assignment();
		mat.setFilename("assigns/"+filename);
		int ins=(int)session.getAttribute("id");
		mat.setFaculty(isrv.findById(ins));
		mat.setSubject(ssrv.findById(dto.getSid()));
		mat.setCourse(csrv.findById(dto.getCid()));
		mat.setMarks(dto.getMarks());
		mat.setSubmitdate(dto.getSubmitdate());
		mrepo.save(mat);
	}
	
	public Assignment findById(int id) {
		return mrepo.findById(id).get();
	}
	
	public void save(MultipartFile file,String type,String filename) {
		try {
			String folder=type.equals("assignment") ? "/assigns/":"/uploads/";			
		      Files.copy(file.getInputStream(),Paths.get(ctx.getRealPath(folder),filename),StandardCopyOption.REPLACE_EXISTING);
		    } catch (Exception e) {
		      throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
		    }
	}
	
	public Optional<String> getExtensionByStringHandling(String filename) {
	    return Optional.ofNullable(filename)
	      .filter(f -> f.contains("."))
	      .map(f -> f.substring(filename.lastIndexOf(".") + 1));
	}
}
