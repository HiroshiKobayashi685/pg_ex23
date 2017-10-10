package invoice_pg_ex23;

public abstract class NightService extends TimeService {

	private static int START_TIME = 23;
	private static int END_TIME = 5;
	private static String SERVICE_CODE = "E2";
	private static int BASIC_CHARGE = 500;

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
