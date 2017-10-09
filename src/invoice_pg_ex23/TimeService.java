package invoice_pg_ex23;

public abstract class TimeService implements Service{

	boolean joined = false;

	public void clear(){
		joined = false;
	}

	public void joined(){
	}

	public boolean isJoined(){
		return joined;
	}

	public abstract boolean isServiceTime(int hour);

	public void checkService(Record record){
		if(record.getServiceCode().equals(getServiceCode())){
			joined = true;
		}
		System.out.println(record.getServiceCode());
	}

	public abstract String getServiceCode();

	public int calcUnitPrice(Record record, int unitPrice) {
		if(isJoined()){
			return unitPrice -= getDiscount();
		}
		return unitPrice;
	}

	public abstract int getDiscount();

	public int calcBasicCharge(int basicCharge){
		if(isJoined()){
			return getBasicCharge();
		}
		return 0;
	}

	public abstract int getBasicCharge();


}

