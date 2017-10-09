package invoice_pg_ex23;

public class ServiceColletion implements Service{

	private Service[] services = { new DayService() , new FamilyService() };

	@Override
	public void clear() {
		for(int i =0;i<services.length;i++){
			services[i].clear();
		}
	}

	@Override
	public void checkService(Record record) {
		for(int i =0;i<services.length;i++){
			services[i].checkService(record);
		}
	}

	public int calcUnitPrice(Record record, int unitPrice) {
		for(int i=0; i<services.length;i++){
			unitPrice = services[i].calcUnitPrice(record, unitPrice);
		}
		return unitPrice;
	}

	@Override
	public int calcBasicCharge(int basicCharge) {
		for(int i=0; i<services.length;i++){
			basicCharge += services[i].calcBasicCharge(basicCharge);
		}
		return basicCharge;
	}

}
