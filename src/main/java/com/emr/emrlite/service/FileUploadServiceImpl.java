package com.emr.emrlite.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;

import com.emr.emrlite.dto.FileuploadDTO;
import com.emr.emrlite.interceptor.TenantContext;

@Service
public class FileUploadServiceImpl implements FileUploadService {

	@Override
	public String uploadFile(FileuploadDTO fileuploadDTO) {

		String DIRECTORY = "uploads/" + TenantContext.getCurrentTenant() + "/" + fileuploadDTO.getRegSeqid();
		if (fileuploadDTO.getFile().isEmpty()) {
			return "Please select a file to upload.";
		}

		try {
			Path directoryPath = Paths.get(DIRECTORY);
			if (!Files.exists(directoryPath)) {
				Files.createDirectories(directoryPath);
			}

			// Save the file to the directory
			Path filePath = directoryPath.resolve(fileuploadDTO.getFile().getOriginalFilename());
			Files.copy(fileuploadDTO.getFile().getInputStream(), filePath);

			return "File uploaded successfully: " + filePath.toAbsolutePath();
		} catch (IOException e) {
			e.printStackTrace();
			return "Failed to upload file: " + e.getMessage();
		}

	}

}
