package com.fileupload.dto;

import com.heidelsoft.fileupload.constants.ArchiveStatus;
import com.heidelsoft.fileupload.constants.Label;
import com.heidelsoft.fileupload.constants.MyEnums;

public class SystemStatusWrapper {
	
	private String storageStatus= Label.Disconnected;;
	private Double usedStorage=0.0;
	private String availableStorage="0";
	private ArchiveStatus status= MyEnums.ArchiveStatus.RED;

	public SystemStatusWrapper(char c, double d, String disconnected, String red) {
		// TODO Auto-generated constructor stub
	}

	public SystemStatusWrapper() {
		// TODO Auto-generated constructor stub
	}

	public String getStorageStatus() {
		return storageStatus;
	}

	public void setStorageStatus(String storageStatus) {
		this.storageStatus = storageStatus;
	}

	public Double getUsedStorage() {
		return usedStorage;
	}

	public void setUsedStorage(float f) {
		this.usedStorage = f;
	}

	public String getAvailableStorage() {
		return availableStorage;
	}

	public void setAvailableStorage(String availableStorage) {
		this.availableStorage = availableStorage;
	}

	public ArchiveStatus getStatus() {
		return status;
	}

	public void setStatus(String string) {
		this.status = string;
	}

}
