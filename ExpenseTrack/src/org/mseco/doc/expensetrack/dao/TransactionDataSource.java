package org.mseco.doc.expensetrack.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class TransactionDataSource {
	// Database fields
	private SQLiteDatabase database;
	private ExpTrackStore transactionStore;
	private String[] allColumns = { ExpTrackStore.COLUMN_ID,
			ExpTrackStore.COLUMN_VALUE, ExpTrackStore.COLUMN_TYPEID,
			ExpTrackStore.COLUMN_DATE, ExpTrackStore.COLUMN_LOCATION, };

	public TransactionDataSource(Context context) {
		transactionStore = new ExpTrackStore(context);
	}

	public void open() throws SQLException {
		database = transactionStore.getWritableDatabase();
	}

	public void close() {		
		transactionStore.close();
	}

	public Transaction insert(Transaction transaction) {

		ContentValues values = new ContentValues();
		values.put(ExpTrackStore.COLUMN_VALUE, transaction.getValue());
		values.put(ExpTrackStore.COLUMN_TYPEID, transaction.getTypeId());
		values.put(ExpTrackStore.COLUMN_DATE, transaction.getDate());
		values.put(ExpTrackStore.COLUMN_LOCATION, transaction.getLocation());

		long insertId = database.insert(ExpTrackStore.TABLE_TRANSACTION, null,
				values);

		Cursor cursor = database.query(ExpTrackStore.TABLE_TRANSACTION, allColumns,
				ExpTrackStore.COLUMN_ID + " = " + insertId, null, null,
				null, null);
		cursor.moveToFirst();

		Transaction newTransaction = toTransaction(cursor);
		cursor.close();
		return newTransaction;

	}

	public void delete(Transaction transaction) {
		long id = transaction.getId();

		database.delete(ExpTrackStore.TABLE_TRANSACTION, ExpTrackStore.COLUMN_ID
				+ " = " + id, null);
	}

	public List<Transaction> findAll() {
		List<Transaction> transactions = new ArrayList<Transaction>();

		Cursor cursor = database.rawQuery("select * from " + ExpTrackStore.TABLE_TRANSACTION + " t inner join " + ExpTrackStore.TABLE_TRANSACTIONTYPE + " tt on t.typeId = tt._id", null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Transaction transaction = toTransaction(cursor);
			transactions.add(transaction);
			cursor.moveToNext();
		}
		// Make sure to close the cursor
		cursor.close();
		return transactions;
	}

	private Transaction toTransaction(Cursor cursor) {
		Transaction transaction = new Transaction();
		transaction.setId(cursor.getLong(0));
		transaction.setValue(cursor.getLong(1));
		transaction.setTypeId(cursor.getLong(2));		
		transaction.setDate(cursor.getString(3));
		transaction.setLocation(cursor.getString(4));
		
		if (cursor.getColumnCount() > 5){
			transaction.setTypeAsString(cursor.getString(6));
		}
		return transaction;
	}
}
