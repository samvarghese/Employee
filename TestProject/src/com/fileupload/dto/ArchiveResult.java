package com.fileupload.dto;

public class ArchiveResult {
    public MyEnums.FileArchiveStatus status 
    public String message {set; get;}

    public ArchiveResult(MyEnums.FileArchiveStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
