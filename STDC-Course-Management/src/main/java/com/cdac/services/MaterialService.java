package com.cdac.services;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cdac.dto.MaterialUploadDTO;
import com.cdac.models.Material;
import com.cdac.repos.MaterialRepository;

@Service
public class MaterialService {

	@Autowired private MaterialRepository mrepo;
	@Autowired private HttpSession session;
	@Autowired private ServletContext ctx;
	@Autowired private FacultyService isrv;
	@Autowired private SubjectService ssrv;
	@Autowired private CourseService csrv;
	
	public List<Material> listAll(){
		return mrepo.findAll();
	}
	
	public List<Material> listFacultyMaterial(int id){
		return mrepo.findByFacultyId(id);
	}
	
	public List<Material> listCourseMaterial(int id){
		return mrepo.findByCourseCid(id);
	}
	
	public void deleteMaterial(int id) {
		Material mat=mrepo.findById(id).get();
		try {
		Files.delete(Paths.get(ctx.getRealPath(mat.getFilename())));
		}
		catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
		mrepo.delete(mat);
	}
	
	public void saveMaterial(MaterialUploadDTO dto) {
		String filename="Material"+ (mrepo.count()+1)+"."+getExtensionByStringHandling(dto.getMaterial().getOriginalFilename()).get();
		save(dto.getMaterial(),"material",filename);
		Material mat=new Material();
		mat.setFilename("uploads/"+filename);
		int ins=(int)session.getAttribute("id");
		mat.setInstructor(isrv.findById(ins));
		mat.setSubject(ssrv.findById(dto.getSid()));
		mat.setCourse(csrv.findById(dto.getCid()));
		mrepo.save(mat);
	}
	
	public void save(MultipartFile file,String type,String filename) {
		try {
			String folder=type.equals("material") ? "/uploads/":"/assigns/";			
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
