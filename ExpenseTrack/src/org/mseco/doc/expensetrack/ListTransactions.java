package org.mseco.doc.expensetrack;

import java.util.List;

import org.mseco.doc.expensetrack.dao.Transaction;
import org.mseco.doc.expensetrack.dao.TransactionDataSource;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ListTransactions extends Activity {

	private TransactionDataSource transactionDataSource;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_transactions);
		populateView();
	}

	public void populateView() {
		TableLayout tableLayout = (TableLayout) findViewById(R.id.transactionTable);
		tableLayout.removeAllViews();
		
		List<Transaction> transactions = getTransactionDataSource().findAll();
		for (Transaction transaction : transactions) {
			TableRow tableRow = new TableRow(this);
			tableLayout.addView(tableRow);

			TextView id = new TextView(this);
			id.setText(transaction.getId() + "");
			id.setPadding(2, 2, 2, 2);
			id.setBackgroundResource(R.drawable.cellshape);
			tableRow.addView(id);

			TextView value = new TextView(this);
			value.setText(transaction.getValue() + "");
			value.setPadding(2, 2, 2, 2);
			value.setBackgroundResource(R.drawable.cellshape);
			tableRow.addView(value);

			TextView date = new TextView(this);
			date.setText(transaction.getDate() + "");
			date.setPadding(2, 2, 2, 2);
			date.setBackgroundResource(R.drawable.cellshape);
			tableRow.addView(date);

			TextView type = new TextView(this);
			type.setText(transaction.getTypeAsString() + "");
			type.setPadding(2, 2, 2, 2);
			type.setBackgroundResource(R.drawable.cellshape);
			tableRow.addView(type);

			TextView location = new TextView(this);
			location.setText(transaction.getLocation() + "");
			location.setPadding(2, 2, 2, 2);
			location.setBackgroundResource(R.drawable.cellshape);
			tableRow.addView(location);
		}
	}
	
	@Override
	protected void onResume() {
		populateView();
		super.onResume();
	}

	public TransactionDataSource getTransactionDataSource() {
		if (transactionDataSource == null) {
			transactionDataSource = new TransactionDataSource(this);
			transactionDataSource.open();
		}
		return transactionDataSource;
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (getTransactionDataSource() != null) {
			getTransactionDataSource().close();
		}
	}

}
