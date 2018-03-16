package com.heidelsoft.fileupload.constants;

public class Status {
	private float storageSizeUsed;
	private String storageSizeAvailable;
	private String statusText;
	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStatusText() {
		return statusText;
	}

	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}

	public String getStorageSizeAvailable() {
		return storageSizeAvailable;
	}

	public void setStorageSizeAvailable(String storageSizeAvailable) {
		this.storageSizeAvailable = storageSizeAvailable;
	}

	public float getStorageSizeUsed() {
		return storageSizeUsed;
	}

	public void setStorageSizeUsed(float storageSizeUsed) {
		this.storageSizeUsed = storageSizeUsed;
	}

}
