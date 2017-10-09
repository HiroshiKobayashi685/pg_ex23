package invoice_pg_ex23;

public abstract class NightService extends TimeService {

	int START_TIME = 23;
	int END_TIME = 5;
	String SERVICE_CODE = "E2";
	int BASIC_CHARGE = 500;

	public boolean isServiceTime(int hour){
		if (START_TIME <= hour && hour < END_TIME  ){
			return true;
		}
		return false;
	}

	public String getServiceCode(){
		return SERVICE_CODE;
	}

	public int getDiscount(){
		return 0;
	}

	public int getBasicCharge(){
		return BASIC_CHARGE;
	}

}
