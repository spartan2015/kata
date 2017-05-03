package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationExample {

	public static void main(String[] args) {

		Person person = new Person();
		person.setNume("IRI");
		person.setPrenume("A");
		person.setAge(26);
		person.setPassword(new char[] { 's', '3', 'c', 'r', '3', 't' });
System.out.println("Person before serialization: ");
System.out.println(person);
		
		
		try {
			// serialize with ObjectOutputStream
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream("serialization.txt")); // throws
																// IOException
			oos.writeObject(person);
			oos.flush();
			oos.close();

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
					"serialization.txt"));
			Person person2 = (Person) ois.readObject(); // throws
														// ClassNotFoundException
			System.out.println("Person after deserialization: ");
			System.out.println(person2);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}

	}

}

class Person implements Serializable {
	private String nume;
	private String prenume;
	private int age;
	private transient char[] password;

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	public String toString() {
		StringBuilder sb =  new StringBuilder().append("Nume: ").append(nume).append(
				", Prenume: ").append(prenume).append(", age: ").append(age)
				.append(",password: ");
				
		if (password != null){
			sb. append(password);
			
		}
		
		return sb.toString();
	}
}
