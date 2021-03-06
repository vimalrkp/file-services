package com.services.file.services;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.services.file.model.Request;

@Service
public class FileServices {

	@Value("${fs.docs.repo.root}")
	private String docRepoRootDirectory;
	
	public byte[] getFileContents(Request request) {
		Path path = Paths.get(docRepoRootDirectory, request.getCategory().toLowerCase(),
				request.getSubCategory1().toLowerCase(), request.getSubCategory2().toLowerCase() + ".xlsx");
		try (InputStream in = Files.newInputStream(path);) {
			return org.apache.commons.io.IOUtils.toByteArray(in);
		} catch (IOException ex) {
			System.err.println("Error while read the given file...");
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
}
