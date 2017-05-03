package org.mseco.doc.expensetrack;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.mseco.doc.expensetrack.dao.Transaction;
import org.mseco.doc.expensetrack.dao.TransactionDataSource;
import org.mseco.doc.expensetrack.dao.TransactionType;
import org.mseco.doc.expensetrack.dao.TransactionTypeDataSource;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
	private TransactionDataSource transactionDataSource;
	private TransactionTypeDataSource transactionTypeDataSource;
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm",
			Locale.US);
	private TransactionType transactionType = null;
	private LocationManager locationManager;
	private String provider;
	private static Location lastKnownLocation;

	List<TransactionType> transactionTypes;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Spinner typeSpinner = (Spinner) findViewById(R.id.transactionTypeInput);

		transactionTypes = getTransactionTypeDataSource().findAll();

		BaseAdapter adapter = new ListBaseAdapter(transactionTypes, this);

		// adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		typeSpinner.setAdapter(adapter);

		typeSpinner
				.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
					public void onItemSelected(AdapterView<?> parent,
							View view, int position, long id) {
						MainActivity.this.transactionType = transactionTypes
								.get(position);

					}

					public void onNothingSelected(AdapterView<?> parent) {
					}

				});
	}

	@Override
	protected void onResume() {
		transactionTypes.clear();
		transactionTypes.addAll(getTransactionTypeDataSource().findAll());

		Spinner typeSpinner = (Spinner) findViewById(R.id.transactionTypeInput);
		typeSpinner
		.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent,
					View view, int position, long id) {
				MainActivity.this.transactionType = transactionTypes
						.get(position);

			}

			public void onNothingSelected(AdapterView<?> parent) {
			}

		});
		super.onResume();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void add(View view) {

		try {

			if (this.transactionType == null){
				Toast.makeText(this, "Select type", Toast.LENGTH_SHORT).show();
				return;
			}
			
			EditText transactionValueEditText = (EditText) findViewById(R.id.transactionValue);

			Spinner typeSpinner = (Spinner) findViewById(R.id.transactionTypeInput);

			Transaction transaction = new Transaction();

			transaction.setValue(Long.valueOf(transactionValueEditText
					.getText().toString()));
			transaction.setDate(dateFormat.format(new Date()));
			
			
			transaction.setTypeId(this.transactionType.getId());
			transaction.setLocation(getLocationAsString());

			getTransactionDataSource().insert(transaction);

			Toast.makeText(this, "Insert success", Toast.LENGTH_SHORT).show();
			;
			
			transactionValueEditText.setText("");
		} catch (Exception e) {
			Log.w("Unable to save", e);
			Toast.makeText(this, "Insert failed", Toast.LENGTH_SHORT).show();
			;
		}
	}

	public void viewTransactions(View view) {
		Intent intent = new Intent(this, ListTransactions.class);

		// String message = editText.getText().toString();

		// intent.putExtra(EXTRA_MESSAGE, message);

		startActivity(intent);
	}

	public void manageTransactionTypes(View view) {
		Intent intent = new Intent(this, ManageTransactionTypes.class);

		// String message = editText.getText().toString();

		// intent.putExtra(EXTRA_MESSAGE, message);

		startActivity(intent);
	}

	public TransactionDataSource getTransactionDataSource() {
		if (transactionDataSource == null) {
			transactionDataSource = new TransactionDataSource(this);
			transactionDataSource.open();
		}
		return transactionDataSource;
	}

	public TransactionTypeDataSource getTransactionTypeDataSource() {
		if (transactionTypeDataSource == null) {
			transactionTypeDataSource = new TransactionTypeDataSource(this);
			transactionTypeDataSource.open();
		}
		return transactionTypeDataSource;
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (getTransactionDataSource() != null) {
			getTransactionDataSource().close();
		}
		if (getTransactionTypeDataSource() != null) {
			getTransactionTypeDataSource().close();
		}
	}

	class ListBaseAdapter extends BaseAdapter {
		List<TransactionType> list;
		Context context;

		public ListBaseAdapter(List<TransactionType> list, Context context) {
			this.list = list;
			this.context = context;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return list.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return list.get(position).getId();
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			TextView textView = new TextView(context);
			textView.setText(list.get(position).getType());
			return textView;
		}

	}

	public String getLocationAsString() {
		Location location = getLocation();
		if (location == null) {
			location = lastKnownLocation;
		}
		return location != null ? location.getLongitude() + "-"
				+ location.getLatitude() : "unknown";
	}

	public Location getLocation() {
		Location location = null;
		// Get the location manager
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		// Define the criteria how to select the locatioin provider -> use
		// default
		Criteria criteria = new Criteria();
		provider = locationManager.getBestProvider(criteria, false);
		if (provider != null) {
			location = locationManager.getLastKnownLocation(provider);
		} else {
			Log.w("Exception", "unable to find location services provider");
		}
		return location;

	}
}
