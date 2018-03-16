package com.heidelsoft.fileupload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.heidelsoft.fileupload.constants.ArchiveStatus;
import com.heidelsoft.fileupload.constants.DtoParser;
import com.heidelsoft.fileupload.constants.Label;
import com.heidelsoft.fileupload.constants.MyDto;
import com.heidelsoft.fileupload.constants.MyEnums;
import com.heidelsoft.fileupload.constants.RestClient;
import com.heidelsoft.fileupload.constants.SystemInformation;

@Controller
public class AdminController {
	private SystemStatusWrapper systemStatus;
	 private DtoParser dtoParser = new DtoParser();
	 private RestClient restClient;
     private String clturl;
     private final String activeClass = "active";
     

	public AdminController() {
		systemStatus = new SystemStatusWrapper();
		CredentialsService credentialsManager = new CredentialsManager();
		setClturl(credentialsManager.getTechnicalUser().EndPoint__c);
		updateArchiveStatus();
	}

	private void updateArchiveStatus() {
        // Default values
	    
		
		RestClient restClient = new RestClient();
        String statusResult = ""; 
		
        try {
                statusResult = restClient.getFullStatus();
        } catch (CalloutException e) {
                pageCtx.addmessage(new MessageFactory.Message(MessageFactory.Severity.Error, "issue_with_the_remote_server"));
                return;
        } catch (Exceptions.HttpException e) {
                pageCtx.addmessage(new MessageFactory.Message(MessageFactory.Severity.Error, "Communication_Error"));
                return;
        } catch (Exceptions.TechnicalUserNotSetException e) {
                pageCtx.addmessage(new MessageFactory.Message(MessageFactory.Severity.Error, "TechnicalUserNotSet"));
                return;
        } catch (Exceptions.Customer410Exception e) {
                pageCtx.addmessage(new MessageFactory.Message(MessageFactory.Severity.Error, "NoResourceFoundExceptionMessage"));
                return;
        } catch (Exception e) {
                pageCtx.addmessage(new MessageFactory.Message(MessageFactory.Severity.Error, "Communication_Error"));
				return;
        }
        
        // RestClient returns a null string in case the status could not be retrieve
        if (!statusResult.equals("")) {
        		MyDto mytdo=new MyDto();
        		SystemInformation systemInformation =this.dtoParser.parseSystemStatus(statusResult);
        		//cgeck
        		mytdo.setSystemInformation(systemInformation);
        		
            	systemStatus.setUsedStorage(mytdo.getSystemInformation().getStatus().getStorageSizeUsed());
            	
                if (systemInformation.getStatus().getStorageSizeAvailable()!= null) {
                	systemStatus.setAvailableStorage(String.valueOf(systemInformation.getStatus().getStorageSizeAvailable()));
                } else {
                	systemStatus.setAvailableStorage(Label.NoLimit);
                }
                
                systemStatus.setStorageStatus(mytdo.getSystemInformation().getStatus().getStatusText());
                systemStatus.setStatus(MyEnums.fromStringArchiveStatus((mytdo.getSystemInformation().getStatus().getState()));
        }
}

	/**
	 * -------------------------------------------------------------------------
	 * Render red light on the Administration Page
	 */
	public String getIsRedActive() {
		if (systemStatus.getStatus() != null && systemStatus.getStatus() == MyEnums.ArchiveStatus.RED) {
			return activeClass;
		}
		return "";
	}

	/**
	 * Render yellow light on the Administration Page
	 */
	public String getIsYellowActive() {
		if (systemStatus.getStatus() != null && systemStatus.getStatus()== MyEnums.ArchiveStatus.YELLOW) {
			return activeClass;
		}
		return "";
	}

	/**
	 * Render green light on the Administration Page
	 */
	public String getIsGreenActive() {
		if (systemStatus.getStatus() != null && systemStatus.getStatus() == MyEnums.ArchiveStatus.GREEN) {
			return activeClass;
		}
		return "";
	}

	@GetMapping("/")
	public String getfile() {

		return "/upload";

	}

}
