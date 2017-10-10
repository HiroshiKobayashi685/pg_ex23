package invoice_pg_ex23;

public class DayService extends TimeService{

	private static int START_TIME = 8;
	private static int END_TIME = 17;
	private static String SERVICE_CODE = "E1";
	private static int BASIC_CHARGE = 200;

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
		return 5;
	}

	public int getBasicCharge(){
		return BASIC_CHARGE;
	}

}
