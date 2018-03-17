package com.fileupload.utility;

import com.fileupload.controller.CredentialsManager;
import com.fileupload.controller.CredentialsService;
import com.fileupload.dto.SystemInformation;
import com.fileupload.dto.SystemStatusWrapper;

public class FileArchiveStatus {
	
	private SystemStatusWrapper systemStatus;
	
	
	public getCreditialData(){
		  CredentialsService credentialsManager = new CredentialsManager();
	}
	

	public  SystemStatusWrapper getArchiveStatus(){
		 String statusResult = ""; 
		 SystemStatusWrapper systemStatus;
		 RestClient restClient;
	
		 restClient = new RestClient();
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
		
         if (statusResult.equals("")) {
        	 systemStatus=setArchiveStatus(statusResult);
         }
		return systemStatus;
		
	}
	
	
	private SystemStatusWrapper setArchiveStatus(String statusResult){
		 systemStatus= new SystemStatusWrapper();
		 systemStatus.setAvailableStorage('0');
         systemStatus.setUsedStorage(0.0);
         systemStatus.setStorageStatus(Label.Disconnected);
         systemStatus.setStatus(MyEnums.ArchiveStatus.RED);
       
		   
		  DtoParser dtoParser = new DtoParser();
		  SystemInformation systemStatusDto =dtoParser.parseSystemStatus(statusResult);
		  
		  systemStatus.setUsedStorage(systemStatusDto.getStatus().getStorageSizeUsed());
			
          if (systemStatusDto.getStatus().getStorageSizeAvailable()!= null) {
          	systemStatus.setAvailableStorage(String.valueOf(systemStatusDto.getStatus().getStorageSizeAvailable()));
          } else {
          	systemStatus.setAvailableStorage(Constants.Label.NoLimited);
          }
          
          systemStatus.setStorageStatus(systemStatusDto.getStatus().getStatusText());
          systemStatus.setStatus(MyEnums.fromStringArchiveStatus((mytdo.getSystemInformation().getStatus().getState()));
	
	}
	
	

}
