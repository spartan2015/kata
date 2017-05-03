package database.transactions;

import java.util.List;

import database.beans.Motorist;

public interface MotoristDao {
	void saveMotorist(Motorist motorist);
	List<Motorist> getMotorists();
}
