package invoice_pg_ex23;

public class Invoice {

	String ownerTelNumber = null;
	int basicCharge = 0;
	int callCharge = 0;

	public void clear(){
		ownerTelNumber = null;
		basicCharge = 0;
		callCharge = 0;
	}

	public void setOwnerTelNumber(String ownerTelNumber){
		this.ownerTelNumber = ownerTelNumber;
	}

	public String getOwnerTelNumber() {
		return ownerTelNumber;

	}

	public void setBasicCharge(int basicCharge){
		this.basicCharge = basicCharge;
	}

	public int getBasicCharge(){
		return basicCharge;
	}

	public void addCallCharge(int callCharge){
		this.callCharge += callCharge;
	}

	public int getCallCharge(){
		return callCharge;
	}

}
