import com.fileupload.dto.SystemStatusWrapper;
import com.fileupload.utility.FileArchiveStatus;

/**
* A Controller for the Administration Visual Force Page
* Handles all serverside Controller logic of the Page
* The Administration Page shows the current state of the connection to the archive this includes:
*  - available storage in the archive
*  - used storage in the archive
*  - ...
*
* This Code was manually translated from the APEX programming language to Java
* It does not execute as it is written here, but that is not a problem for our little exercise here.
* You should be quite tolerant when it comes to compilability.
* Zero tolernace regarding Style and Design, please!
*/
public class AdminController  {
        
        public  SystemStatusWrapper systemStatus;
        public  String trafficLightColorActive;
        private DtoParser dtoParser = new DtoParser();
        private RestClient restClient;
        private String clturl;
        private final String activeClass = 'active';
        
       
        
       
        
		/** -------------------------------------------------------------------------
		* retrieves the status from an ecternal Service over an REST API
		* pageCtx is a contexObject that stores e.g. Messages that 
		* will be displayed on the Resulting Page
		*/
        private void updateArchiveStatus() {
                // Default values
        	FileArchiveStatus archiveStatus=new FileArchiveStatus();
        	systemStatus= archiveStatus.getArchiveStatus();
        }

        /** -------------------------------------------------------------------------
         * Render red light on the Administration Page
         */
        public String getStorageLevel() {
        	    String stoargeLevel="";
                if(systemStatus.getStatus()!=null){
                	if(systemStatus.getStatus()==ArchiveStatus.YELLOW){
                		return "YELLOW"
                	}
                	else if(systemStatus.getStatus()==MyEnums.ArchiveStatus.GREEN){
                		return "GREEN"
                	}
                	else if(systemStatus.getStatus()==MyEnums.ArchiveStatus.RED){
                		return "RED"
                	}
                  }
         return stoargeLevel;
        }

     
        
}