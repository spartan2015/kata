package searching;

import java.util.Date;

/**
 * hashcode implementation example
 * @author vasil
 *
 */
public class Transaction {
	private String who;
	private Date when;
	private double amount;

	public int hashCode() {
		int hash = 17;
		hash = 31 * hash + who.hashCode();
		hash = 31 * hash + when.hashCode();
		hash = 31 * hash + ((Double) amount).hashCode();
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Transaction))
			return false;
		Transaction other = (Transaction) obj;
		return who.equals(other.who) && when.equals(other.when) && amount == other.amount;
	}
}
