package invoice_pg_ex23;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class InvoiceWriter {
	private BufferedWriter writer;

	public InvoiceWriter() throws IOException{
		this(new FileWriter("data/invoice.dat"));
	}

	public InvoiceWriter(Writer writer){
		this.writer = new BufferedWriter(writer);
	}

	public void write(Invoice invoice) throws IOException{
		writer.write("1 "+ invoice.ownerTelNumber);
		writer.newLine();
		writer.write("5 "+ invoice.getBasicCharge());
		writer.newLine();
		writer.write("7 "+ invoice.getCallCharge());
		writer.newLine();
		writer.write("9 =====================");
		writer.newLine();
	}

	public void close() throws IOException{
		writer.close();

	}


}
