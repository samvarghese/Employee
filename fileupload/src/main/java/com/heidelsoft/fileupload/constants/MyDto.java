package com.heidelsoft.fileupload.constants;

import java.util.List;



public class MyDto {
	public class ArchiveField {

		public ArchiveField(Object _CATEGORY_FIELD, char c) {
			// TODO Auto-generated constructor stub
		}

	}

	public class FileProperty {

		public String href;
		public String data;

	}

	public class Task {

		public String type;

	}

	private SystemInformation SystemInformation;
	
	public class NewFileVersion{

		public Task task;
		public FileProperty file;
		public List<MyDto.ArchiveField> fields;
	
	}

	public SystemInformation getSystemInformation() {
		return SystemInformation;
	}

	public void setSystemInformation(SystemInformation systemInformation) {
		SystemInformation = systemInformation;
	}

}
