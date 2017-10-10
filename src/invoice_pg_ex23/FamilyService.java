package invoice_pg_ex23;

public class FamilyService  implements Service{

	private static int TEL_NUMBER = 2;
	private static String SERVICE_CODE = "C1";
	private static int BASIC_CHARGE = 100;

	private boolean joined = false;
	private String[] telNumbers = new String[TEL_NUMBER];
	private int telNumberCount = 0;

	public void clear(){
		joined = false;
		telNumbers = new String[TEL_NUMBER];
		telNumberCount = 0;
	}

	public void appendFamilyTelNumber(String telNumber){
		telNumbers[telNumberCount] = telNumber;
		telNumberCount++;
	}

	public boolean isJoined(){
		return joined;
	}

	public void checkService(Record record){
		if(record.getServiceCode().equals(SERVICE_CODE)){
			joined = true;
			appendFamilyTelNumber(record.getServiceOption());
		}
	}

	public int calcUnitPrice(Record record, int unitPrice) {
		for(int i =0 ; i<telNumbers.length;i++){
			if(record.getCallNumber().equals(telNumbers[i]) && isJoined()){
				unitPrice = unitPrice /2;
			}
		}
		return unitPrice;
	}

	public int calcBasicCharge(int basicCharge){
		if(isJoined()) {
			return BASIC_CHARGE;
		}
		return 0;
	}

}
