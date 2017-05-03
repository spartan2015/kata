package org.mseco.doc.expensetrack;

import java.util.List;

import org.mseco.doc.expensetrack.dao.TransactionType;
import org.mseco.doc.expensetrack.dao.TransactionTypeDataSource;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class ManageTransactionTypes extends Activity {

	private TransactionTypeDataSource transactionTypeDataSource;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_manage_transaction_types);

		populateView();
	}

	public void populateView() {		
		
		TableLayout tableLayout = (TableLayout) findViewById(R.id.transactionTypes);
		tableLayout.removeAllViews();

		List<TransactionType> transactionTypes = getTransactionTypeDataSource()
				.findAll();
		for (TransactionType transactionType : transactionTypes) {
			TableRow tableRow = new TableRow(this);
			tableLayout.addView(tableRow);

			TextView id = new TextView(this);
			id.setText(transactionType.getId() + "");
			tableRow.addView(id);

			TextView value = new TextView(this);
			id.setText(transactionType.getType() + "");
			tableRow.addView(value);

		}
	}
	
	@Override
	protected void onResume() {
		populateView();
		super.onResume();
	}

	public void add(View view){
		TransactionType transactionType = new TransactionType();
		
		EditText editText = ((EditText)findViewById(R.id.transactionType));
		transactionType.setType(editText.getText().toString());
		
		try{
		getTransactionTypeDataSource().insert(transactionType);
		}catch(Exception e){
			Toast.makeText(this, "Insert failed", Toast.LENGTH_SHORT).show();
		}
		populateView();
		
		editText.setText("");
		Toast.makeText(this, "Insert success", Toast.LENGTH_SHORT).show();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.manage_transaction_types, menu);
		return true;
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
		if (getTransactionTypeDataSource() != null) {
			getTransactionTypeDataSource().close();
		}
	}

}
