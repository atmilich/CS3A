import java.io.File;
import java.util.Scanner;


public class Bank {
 
    Scanner input = new Scanner(System.in);
    String bankName;
    String city;
    String state;
    String certNum;
    String acqInstitution;
    String closeDate;
    String updateDate;
    
    public Bank()
    {
    	// do stuff
    }
    
    
    public Bank(String input)
    {
      
      String[] line = input.split(",");
      bankName = line[0];
      state = line[2];
      certNum = line[3];
      acqInstitution = line[4];
      closeDate = line[5];
      updateDate = line[6];
    }

	public Scanner getInput() {
		return input;
	}

	public void setInput(Scanner input) {
		this.input = input;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCertNum() {
		return certNum;
	}

	public void setCertNum(String certNum) {
		this.certNum = certNum;
	}

	public String getAcqInstitution() {
		return acqInstitution;
	}

	public void setAcqInstitution(String acqInstitution) {
		this.acqInstitution = acqInstitution;
	}

	public String getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(String closeDate) {
		this.closeDate = closeDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

}

//done