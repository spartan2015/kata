package learning.hibernate.entities;

import java.sql.Clob;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
/*
 *             Note that for all cases, except properties that are of java.sql.Clob or
java.sql.Blob type, the values are again loaded immediately by Hibernate, and
not lazily on demand. Instrumenting bytecode with interception code is again an
option to enable lazy loading of individual properties transparently.
   To create and set a java.sql.Blob or java.sql.Clob value, if you have these
property types in your domain model, use the static Hibernate.createBlob()
and Hibernate.createClob() methods and provide a byte array, an input stream,
or a string.

 */
public class LobExample {
	@Id
	Long id;
	
	@Lob /*       If you want to map a java.lang.String, char[], Character[], or even a
java.sql.Clob typed property to a CLOB column, you need to map it with the
@Lob annotation:
*/
	byte[] image;
	
	@Lob
	Clob movie;
}
