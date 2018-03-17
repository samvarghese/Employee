package com.fileupload.controller;

import com.fileupload.dto.SystemStatusWrapper;
import com.fileupload.utility.FileArchiveStatus;

public class DropzoneController {
	
	
	
	
	
	@RequestMapping(value = "/uploadMultipleFile", method = RequestMethod.POST)
	public ArchiveResult uploadFile(@RequestParam("file") MultipartFile[] files){
		
		FileArchiveStatus fileArchiveStatus=new FileArchiveStatus();
		SystemStatusWrapper  systeminfo=fileArchiveStatus.getArchiveStatus();
		if(files.length<systeminfo.getAvailableStorage()){
			DropzoneService
			
		}
				
		
	}
//-------------------------------------------------------------------------
	// archives a file on the remote service

	...
	
	/**
	* write a log entry for each uploaded file
	*/
	public static void logFiles(List<String> fnames) {
	for (String uploadedFileName : fnames) {
	FileUploadLogEntry__c logEntry = new FileUploadLogEntry__c();
	logEntry.Name = uploadedFileName;
	insert logEntry;
		}
    }

	...

}
