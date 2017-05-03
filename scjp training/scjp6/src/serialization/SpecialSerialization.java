package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SpecialSerialization {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.name="Dog";
		dog.collar = new Collar();
		dog.collar.size=1;
		
		System.out.println(dog);
		
		try{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dog.txt"));
		oos.writeObject(dog);
		oos.flush();
		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dog.txt"));
		Dog d2 = (Dog)ois.readObject();
		
		System.out.println(d2);
		}catch(IOException ioe){ioe.printStackTrace();}
		catch(ClassNotFoundException cnfe){cnfe.printStackTrace();}
	}

}

class Dog implements Serializable{
	String name;
	transient Collar collar;
	
	public String toString(){
		return name + " collar: " + collar.size;
	}
	private void writeObject(ObjectOutputStream oos){
		try{
			oos.defaultWriteObject();
			oos.writeInt(collar.size);
		}catch(IOException ioe){ioe.printStackTrace();}		
	}
	
	private void readObject(ObjectInputStream ois){
		try{
			ois.defaultReadObject();
			collar = new Collar();
			collar.size = ois.readInt();
		}catch(IOException ioe){ioe.printStackTrace();
		}catch(ClassNotFoundException cnfe){cnfe.printStackTrace();
		}
	}
}

class Collar{
	int size;
}