package com.heidelsoft.fileupload.constants;

public class ArchiveResult {
    public MyEnums.FileArchiveStatus status {set; get;}
    public String message {set; get;}

    public ArchiveResult(MyEnums.FileArchiveStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
