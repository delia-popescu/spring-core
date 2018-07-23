package com.training.spring.core.injectiontypes.resource;

import java.io.File;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class FileService {
	
	@Resource(name = "namedFile")
	private  File file;


	private  File defaultFile;

	public File getFile() {
		return file;
	}

	public File getDefaultFile() {
		return defaultFile;
	}

	@Resource(name = "defaultFile")
	public void setDefaultFile(File defaultFile) {
		this.defaultFile = defaultFile;
	}

	
}
