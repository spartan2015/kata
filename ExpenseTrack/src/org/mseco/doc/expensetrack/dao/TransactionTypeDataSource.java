package org.mseco.doc.expensetrack.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class TransactionTypeDataSource {
	// Database fields
	private SQLiteDatabase database;
	private ExpTrackStore expTrackStore;
	private String[] allColumns = { ExpTrackStore.COLUMN_ID,
			ExpTrackStore.COLUMN_TYPE,
			};

	public TransactionTypeDataSource(Context context) {
		expTrackStore = new ExpTrackStore(context);
	}

	public void open() throws SQLException {
		database = expTrackStore.getWritableDatabase();
	}

	public void close() {
		expTrackStore.close();
	}

	public TransactionType insert(TransactionType transactionType) {

		ContentValues values = new ContentValues();
		values.put(ExpTrackStore.COLUMN_TYPE, transactionType.getType());		

		long insertId = database.insert(ExpTrackStore.TABLE_TRANSACTIONTYPE, null,
				values);

		Cursor cursor = database.query(ExpTrackStore.TABLE_TRANSACTIONTYPE, allColumns,
				ExpTrackStore.COLUMN_ID + " = " + insertId, null, null,
				null, null);
		cursor.moveToFirst();

		TransactionType newTransactionType = toTransactionType(cursor);
		cursor.close();
		return newTransactionType;

	}

	public void delete(TransactionType transactionType) {
		long id = transactionType.getId();

		database.delete(ExpTrackStore.TABLE_TRANSACTIONTYPE, ExpTrackStore.COLUMN_ID
				+ " = " + id, null);
	}

	public List<TransactionType> findAll() {
		List<TransactionType> transactionTypes = new ArrayList<TransactionType>();

		Cursor cursor = database.query(ExpTrackStore.TABLE_TRANSACTIONTYPE, allColumns,
				null, null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			TransactionType transactionType = toTransactionType(cursor);
			transactionTypes.add(transactionType);
			cursor.moveToNext();
		}
		// Make sure to close the cursor
		cursor.close();
		return transactionTypes;
	}

	private TransactionType toTransactionType(Cursor cursor) {
		TransactionType transactionType = new TransactionType();
		transactionType.setId(cursor.getLong(0));		
		transactionType.setType(cursor.getString(1));		
		return transactionType;
	}
}
