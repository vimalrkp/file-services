package com.services.file.web;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.services.file.model.Request;
import com.services.file.services.FileServices;
import com.services.file.services.MasterDataServices;

@Controller
public class FileServicesController {

	@Autowired
	private FileServices fileServices;

	@Autowired
	private MasterDataServices dataServices;

	private Set<String> categoryList = new LinkedHashSet<>();

	private Set<String> subCategory1List = new LinkedHashSet<>();

	private Set<String> subCategory2List = new LinkedHashSet<>();

	@PostConstruct
	public void init() {
		categoryList.addAll(dataServices.getCategoryList());
		subCategory1List.addAll(dataServices.getSubCategory1List());
		subCategory2List.addAll(dataServices.getsubCategory2List());
	}

	@GetMapping(path = { "", "/index" })
	public String showHomePage(ModelMap map) {
		map.addAttribute("categoryList", categoryList);
		map.addAttribute("subCategory1List", subCategory1List);
		map.addAttribute("subCategory2List", subCategory2List);
		map.addAttribute("request", new Request());
		System.out.println("Returning home page");
		return "index";
	}

	@PostMapping(value = "/downloadFile", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public @ResponseBody ResponseEntity<byte[]> getFile(Request request, BindingResult result, Model model)
			throws IOException {
		if (StringUtils.isBlank(request.getCategory()) || StringUtils.isBlank(request.getSubCategory1())
				|| StringUtils.isBlank(request.getSubCategory2())) {
			throw new RuntimeException("");
		}
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION,
						"attachment; filename=" + request.getSubCategory2().toLowerCase() + ".xlsx")
				.contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
				.body(fileServices.getFileContents(request));
	}
}
