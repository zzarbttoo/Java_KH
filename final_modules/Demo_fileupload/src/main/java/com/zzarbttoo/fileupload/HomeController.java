package com.zzarbttoo.fileupload;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.http.HttpHeaders;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.zzarbttoo.fileupload.validate.FileValidator;
import com.zzarbttoo.fileupload.validate.UploadFile;
import com.zzarbttoo.restTemplate.PersonService;

@Controller
public class HomeController {

	@Autowired
	private FileValidator fileValidator;
	
	private PersonService personService;
	

	@RequestMapping("/form")
	public String uploadForm() {
		return "upload";
	}

	// httpclient로 flask와 통신할 것이다
	// 글자 전송 -> 파일 전송
	@RequestMapping("/sendflask")
	public String sendflask() {
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
	
		String url = "http://127.0.0.1:5000/";
		
		

		return null;

	}

	@RequestMapping("/upload")
	public String fileUpload(HttpServletRequest request, Model model, UploadFile uploadFile, BindingResult result) {

		if (uploadFile.getMpfile() == null) {
			MultipartFile file = uploadFile.getMpfile();
			String name = file.getOriginalFilename();

			System.out.println("originalname = " + name);

			UploadFile fileObj = new UploadFile();
			fileObj.setName(name);
			fileObj.setDesc(uploadFile.getDesc());

			InputStream inputStream = null;
			OutputStream outputStream = null;

			try {
				inputStream = file.getInputStream();
				String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/resources/storage");

				System.out.println("path : " + path);

				File storage = new File(path);
				if (!storage.exists()) {

					storage.mkdir();
				}

				File newFile = new File(path + "/" + name);
				if (!newFile.exists()) {
					newFile.createNewFile();
				}

				outputStream = new FileOutputStream(newFile);

				int read = 0;
				byte[] b = new byte[(int) file.getSize()];

				while ((read = inputStream.read(b)) != -1) {
					outputStream.write(b, 0, read);
				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {

				try {
					inputStream.close();
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

			model.addAttribute("fileObj", fileObj);
		}

		System.out.println(uploadFile.getDesc());

		return "download";

	}

	@RequestMapping("/download")
	@ResponseBody
	public byte[] fileDownload(HttpServletRequest request, HttpServletResponse response, String name) {

		byte[] down = null;

		try {
			String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/resources/storage");

			File file = new File(path + "/" + name);

			// exception 처리
			down = FileCopyUtils.copyToByteArray(file);
			String filename = new String(file.getName().getBytes(), "8859_1");

			System.out.println(filename);

			response.setHeader("Content-Disposition", "attachment; filename = \"" + filename + "\"");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return down;

	}
	
	
	
	
	/*
	//API 구축
	@PostMapping(value = "/createPerson", consumes = "application/json", produces = "application/json")
	public Person createPerson(@RequestBody Person person) {
		return personService.saveUpdatePerson(person);
	}
	
	@PostMapping(value = "/updatePerson", consumes = "application/json", produces  ="application/json")
	public Person updatePerson(@RequestBody Person person, HttpServletResponse response) {
		
		response.setHeader("Location", ServletUriComponentsBuilder.fromCurrentContextPath().path("/findPerson/" + person.getId()).toString());
		
		return personService.saveUpdatePerson(person);
		
	}
	
	*/
	

}
