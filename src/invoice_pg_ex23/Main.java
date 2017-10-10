package invoice_pg_ex23;

import java.io.IOException;

public class Main {

	private static final int INITIAL_BASIC_CHARGE = 1000;
	private static final int INITIAL_CALL_UNIT_PRICE=20;
	private static final char RC_OWNER_INFO = '1';
	private static final char RC_SERVICE_INFO = '2';
	private static final char RC_CALL_LOG = '5';
	private static final char RC_SEPARATOR = '0';

	public static void main(String args[]) throws IOException {

		RecordReader reader = new RecordReader();
		String ownerTelNumber = null;

		Invoice invoice = new Invoice();
		ServiceColletion service = new ServiceColletion();
		InvoiceWriter writer = new InvoiceWriter();

		for (Record record = reader.read(); record != null; record = reader.read()){

			char recordCode = record.getRecordCode();

			switch (recordCode){
			case RC_OWNER_INFO:
				ownerTelNumber = record.getOwnerTelNumber();
				invoice.setOwnerTelNumber(ownerTelNumber);
				break;

			case RC_SERVICE_INFO:
				service(service,record);
				break;

			case RC_CALL_LOG:
				call(invoice, service, record);
				break;

			case RC_SEPARATOR:
				separate(invoice, service, writer);
				break;
			}
		}

		reader.close();
		writer.close();
	}

	private static void service(Service service, Record record){
		service.checkService(record);
	}

	private static void call(Invoice invoice,Service service, Record record){
		int callCharge = service.calcUnitPrice(record, INITIAL_CALL_UNIT_PRICE) * record.getCallMinutes();
		invoice.addCallCharge(callCharge);
	}

	private static void separate(Invoice invoice,Service service, InvoiceWriter writer) throws IOException {
		int basicCharge = service.calcBasicCharge(INITIAL_BASIC_CHARGE);
		invoice.setBasicCharge(basicCharge);
		if(invoice.getOwnerTelNumber() != null){
			writer.write(invoice);
		}
		invoice.clear();
		service.clear();
	}

}

