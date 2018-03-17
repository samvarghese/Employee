package com.fileupload.dto;

import com.fileupload.dto.FileTransferObject.Task;

public class FileTransferObject {

	public class FileProperty {

	}

	public class Task {

		public String type;

	}

	public class NewFileVersion {

		public Task task;
		public Object file;

	}

}
