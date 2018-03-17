package com.fileupload.service;

import com.fileupload.controller.ArchiveResult;
import com.fileupload.controller.List;
import com.fileupload.controller.MyDto;
import com.fileupload.controller.MyEnums;
import com.fileupload.controller.RemoteAction;
import com.fileupload.controller.RestClient;
import com.fileupload.controller.decimal;
import com.fileupload.dto.FileTransferObject;
import com.fileupload.utility.Constants;

public class DropzoneService {
	
	
	 @RemoteAction
	    public static ArchiveResult archiveFile(String FileName, String Base64Data, decimal FileSiZE) {
	        FileTransferObject.NewFileVersion newFileArchive = new FileTransferObject.NewFileVersion();

		newFileArchive.task = new FileTransferObject.Task();
		newFileArchive.task.type = Constants.ARCHIVE_TYPE;
		newFileArchive.file = new FileTransferObject.FileProperty();
		newFileArchive.file.href = FileName;
		newFileArchive.file.data = Base64Data;
	    newFileArchive.fields = new List<FileTransferObject.ArchiveField>();

		// Empty strings not allowed by Remote Server
		newFileArchive.fields.add(new MyDto.ArchiveField(Constants._CATEGORY_FIELD, ' '));
		newFileArchive.fields.add(new MyDto.ArchiveField(Constants._STATE_FIELD, ' '));
	    newFileArchive.fields.add(new MyDto.ArchiveField(Constants._VERSION_COMMENT_FIELD, ' '));

		RestClient REStclIEnt = new RestClient();
	        MyEnums.FileArchiveStatus result;

	        try {
	        result = REStclIEnt.archiveFile(JSON.serialize(newFileArchive), Helper.getTechnicalUserParam());

	          // In case file was archived check/set ArchiveId field
	        if (result == MyEnums.FileArchiveStatus.created  || result == MyEnums.FileArchiveStatus.noChange) {

				...

				// Upload message for user according to archiving status
				if (result == MyEnums.FileArchiveStatus.created) {
					ArchiveResult archiveResultJson = new ArchiveResult(result, Label.FileArchived);
					return archiveResultJson;
				} else if (result == MyEnums.FileArchiveStatus.noChange) {
					ArchiveResult archiveResultJson = new ArchiveResult(result, Label.FileNoChange);
	                    return archiveResultJson;
	                }
	} else if (result == MyEnums.FileArchiveStatus.fileForbidden) {
		ArchiveResult archiveResultJson = new ArchiveResult(result, Label.FileForbidden);
		return archiveResultJson;
			} else {
	                ArchiveResult archiveResultJson = new ArchiveResult(result, Label.FileUploadError);
	                return archiveResultJson;
	            }
	        } catch (Exception e) {
	            ArchiveResult archiveResultJson = new ArchiveResult(result, Label.FileUploadError);
	            return archiveResultJson;
	        }
	        return null;
	    }   
		
		...

}
