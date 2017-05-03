package org.mseco.doc.expensetrack.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ExpTrackStore extends SQLiteOpenHelper {
	
	private static final String DATABASE_NAME = "extrack.db";
	private static final int DATABASE_VERSION = 2;

	public static final String PREFIX = "extrack_";
	
	public static final String TABLE_TRANSACTION = PREFIX + "transaction";
	
	public static final String TABLE_TRANSACTIONTYPE = PREFIX + "transactionType";
	
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_VALUE = "value";
	public static final String COLUMN_TYPEID = "typeId";
	public static final String COLUMN_DATE = "date";
	public static final String COLUMN_LOCATION = "location";
	
	public static final String COLUMN_TYPE = "type";
	
	// Database creation sql statement
	private static final String DATABASE_CREATE1 = "create table "+TABLE_TRANSACTION + "("
			+ COLUMN_ID + "  integer primary key autoincrement"
			+ ","
			+ COLUMN_VALUE + " integer not null"
			+ ","
			+ COLUMN_TYPEID + " integer not null"
			+ ","
			+ COLUMN_DATE + " string not null"
			+ ","
			+ COLUMN_LOCATION + " string not null"
			+ ");";
	
	private static final String DATABASE_CREATE2 = "create table "+TABLE_TRANSACTIONTYPE + "("
			+ COLUMN_ID + "  integer primary key autoincrement"
			+ ","			
			+ COLUMN_TYPE + " string not null"
			
			+ ");";
	

	public ExpTrackStore(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DATABASE_CREATE1);
		db.execSQL(DATABASE_CREATE2);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(ExpTrackStore.class.getName(),
		        "Upgrading database from version " + oldVersion + " to "
		            + newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_TRANSACTION);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_TRANSACTIONTYPE);
		Log.w("upgrade database", "upgrade done");
	    onCreate(db);

	}

}
