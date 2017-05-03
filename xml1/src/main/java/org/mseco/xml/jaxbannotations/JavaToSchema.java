package org.mseco.xml.jaxbannotations;

import static java.lang.System.out;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
public class JavaToSchema {

	public static void main(String[] args) {

		Class[] classes = { Book.class };

		try {
			new JavaToSchema().execute(classes);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	SchemaOutputResolver resolver;
	/**
	 * Creates an instance of SchemaMaker with defaults.
	 */
	public JavaToSchema() {
		resolver = new MySchemaOutputResolver(".", "MyBook.xsd");
	}

	public void execute(Class... classes) throws JAXBException, IOException {
		JAXBContext context = JAXBContext.newInstance(classes);
		context.generateSchema(resolver);
		out.println("All done.");

	}

}

/**
 * Extends the resolver.
 */
class MySchemaOutputResolver extends SchemaOutputResolver {
    private File output;
    public MySchemaOutputResolver(String dir, String fileName){
        output = new File(dir, fileName);
    }
    public Result createOutput(String namespaceUri,
            String suggestedFileName) throws IOException {
        return new StreamResult(output);
    }
}
