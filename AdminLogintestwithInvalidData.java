package orangehrm_testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import orangehrm.library.LoginPage;
import utils.AppUtils;
import utils.XLutils;

public class AdminLogintestwithInvalidData extends AppUtils {

	
	String  datafile="C:\\SeleniumQedge\\Orange_DDL\\TestDataFiles\\TestData.xlsx";
	String datasheet="AdminLoginInvalidData";
	
	@Test
	public void checkAdminLogin() throws IOException
	{
       int rowcount;
       rowcount=XLutils.getRowCount(datafile,datasheet);
       
       String uid,pwd;
       LoginPage lp = new LoginPage();
       	
       for(int i=1;i<=rowcount;i++)
       {
    	   uid=XLutils.getStringCellData(datafile,datasheet,i,0);
    	   pwd=XLutils.getStringCellData(datafile,datasheet,i,1);
    	   lp.login(uid,pwd);
    	   boolean res=lp.isErrMsgDisplayed();
    	   Assert.assertTrue(res);
    	   
    	   if(res)
    	   {
    		   XLutils.setCellData(datafile,datasheet,i,2,"Pass");
    		   XLutils.fillGreenColor(datafile,datasheet,i,2);
    	   }
    	   else
    	   {
    		   XLutils.setCellData(datafile,datasheet,i,2,"Fail");
    		   XLutils.fillRedColor(datafile,datasheet,i,2);
    	   }
       }
	}
}
