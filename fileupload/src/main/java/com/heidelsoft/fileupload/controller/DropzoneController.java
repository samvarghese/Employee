package com.heidelsoft.fileupload.controller;

import java.awt.List;
import java.util.ArrayList;

import com.heidelsoft.fileupload.constant.Constants;
import com.heidelsoft.fileupload.constants.ArchiveResult;
import com.heidelsoft.fileupload.constants.Label;
import com.heidelsoft.fileupload.constants.MyDto;
import com.heidelsoft.fileupload.constants.MyEnums;
import com.heidelsoft.fileupload.constants.RestClient;

public class DropzoneController {
	
	
	//-------------------------------------------------------------------------
	// archives a file on the remote service
	//
   


	public static ArchiveResult archiveFile(String FileName, MultipartFile Base64Data, Double FileSiZE) {
        MyDto.NewFileVersion newFileArchive = new MyDto.NewFileVersion();

	newFileArchive.task = new MyDto.Task();
	newFileArchive.task.type = Constants.ARCHIVE_TYPE;
	newFileArchive.file = new MyDto.FileProperty();
	newFileArchive.file.href = FileName
	newFileArchive.file.data = Base64Data;
    newFileArchive.fields = new ArrayList<MyDto.ArchiveField>();

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
