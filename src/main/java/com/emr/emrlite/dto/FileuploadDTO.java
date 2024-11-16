package com.emr.emrlite.dto;

import org.springframework.web.multipart.MultipartFile;

public class FileuploadDTO {

	private Long regSeqid;

	private MultipartFile file;

	public Long getRegSeqid() {
		return regSeqid;
	}

	public void setRegSeqid(Long regSeqid) {
		this.regSeqid = regSeqid;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
