package query;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

public class TableToInsert {

	@Test
	public void main() throws Exception{

		StringBuilder cols = new StringBuilder();
		cols.append("(");
		StringBuilder values = new StringBuilder();
		values.append("(");
		Files.readAllLines(Paths.get(TableToInsert.class.getResource("tableToInsert").toURI())).stream().forEach(l -> {
			String[] v = l.split("=");
			cols.append(v[0].trim()).append(",");
			values.append(v[1].trim()).append(",");
		});

		cols.deleteCharAt(cols.length()-1);
		values.deleteCharAt(values.length()-1);
		
		cols.append(")");
		values.append(")");
		
		System.out.println(cols.toString() + " values" + values.toString());
	}

}
