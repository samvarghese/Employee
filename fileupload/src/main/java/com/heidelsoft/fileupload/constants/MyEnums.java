package com.heidelsoft.fileupload.constants;

import com.heidelsoft.fileupload.constants.MyEnums.FileArchiveStatus;

public class MyEnums {
	
	
	

	public class FileArchiveStatus {

		public static final FileArchiveStatus created = null;
		public static final FileArchiveStatus noChange = null;
		public static final FileArchiveStatus fileForbidden = null;

	}

	private static ArchiveStatus ArchiveStatus;

	public static String fromStringArchiveStatus(String string){
		string.equals(ArchiveStatus.RED);
		return "";  
	}

}
