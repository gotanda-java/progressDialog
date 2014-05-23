package example.android.dialogsample;

import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class DialogSampleActivity extends Activity {

	TextView label = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dialog_sample);

		label = (TextView) findViewById(R.id.tv_message);

		Button dialogBtn = (Button) findViewById(R.id.bt_dialog);
		dialogBtn.setTag("Dialog");
		dialogBtn.setOnClickListener(new BCL());

		Button txtDialogBtn = (Button) findViewById(R.id.bt_textdialog);
		txtDialogBtn.setTag("textDialog");
		txtDialogBtn.setOnClickListener(new BCL());

		Button SSDialogBtn = (Button) findViewById(R.id.bt_selectdialog);
		SSDialogBtn.setTag("SSDialog");
		SSDialogBtn.setOnClickListener(new BCL());

		Button DPDialogBtn = (Button) findViewById(R.id.bt_datedialog);
		DPDialogBtn.setTag("dateDialog");
		DPDialogBtn.setOnClickListener(new BCL());

		Button TPDialogBtn = (Button) findViewById(R.id.bt_timedialog);
		TPDialogBtn.setTag("TPDialog");
		TPDialogBtn.setOnClickListener(new BCL());

		Button PDialogBtn = (Button) findViewById(R.id.bt_progressdialog);
		PDialogBtn.setTag("progressDialog");
		PDialogBtn.setOnClickListener(new BCL());

		Button hackDialogBtn = (Button) findViewById(R.id.bt_hack);
		hackDialogBtn.setTag("hack");
		hackDialogBtn.setOnClickListener(new BCL());

	}

	class BCL implements OnClickListener {
		public void onClick(View v) {
			String tag = (String) v.getTag();
			if (tag.equals("Dialog")) {
				showDialog();
			} else if (tag.equals("textDialog")) {
				showTextDialog();
			} else if (tag.equals("SSDialog")) {
				showSSDialog();
			} else if (tag.equals("dateDialog")) {
				showDPDialog();
			} else if (tag.equals("TPDialog")) {
				showTPDialog();
			} else if (tag.equals("progressDialog")) {
				showProgressDialog();
			}else{
				showhack();
			}
		}

		private void showhack() {
			//P214
			// TODO 自動生成されたメソッド・スタブ
		Intent intent = new Intent(DialogSampleActivity.this, ContentProviderSample2Activity.class);
		startActivityForResult(intent, 0);
		}

		private void showDialog() {
			// TODO 自動生成されたメソッド・スタブ
			AlertDialog.Builder dialog = new AlertDialog.Builder(
					DialogSampleActivity.this);
			dialog.setTitle("通常ダイアログ");
			dialog.setMessage("選択してください");
			dialog.setPositiveButton("OK",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog,
								int whichButton) {
							label.setText("通常ダイアログ:OKが選択されました");
							// TODO 自動生成されたメソッド・スタブ

						}
					});
			dialog.setNegativeButton("NG",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							label.setText("通常ダイアログ:NGが選択されました");
							// TODO 自動生成されたメソッド・スタブ

						}
					});
			dialog.show();
		}

		private void showTextDialog() {
			// TODO 自動生成されたメソッド・スタブ
			final EditText editText = new EditText(DialogSampleActivity.this);
			AlertDialog.Builder dialog = new AlertDialog.Builder(
					DialogSampleActivity.this);
			dialog.setTitle("テキストダイアログ");
			dialog.setMessage("テキストを入力してください");
			dialog.setView(editText);
			dialog.setPositiveButton("OK",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO 自動生成されたメソッド・スタブ
							label.setText("テキストダイアログ："
									+ editText.getText().toString()
									+ "が入力されました");
						}
					});
			dialog.show();

		}

		final String[] items = new String[] { "桃", "梅", "桜" };
		int which = 0;

		private void showSSDialog() {
			// TODO 自動生成されたメソッド・スタブ
			AlertDialog.Builder dialog = new AlertDialog.Builder(
					DialogSampleActivity.this);
			dialog.setTitle("単一選択ダイアログ");
			dialog.setSingleChoiceItems(items, 0,
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int whichButton) {
							// TODO 自動生成されたメソッド・スタブ
							which = whichButton;
						}
					});
			dialog.setPositiveButton("OK",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int whichButton) {
							// TODO 自動生成されたメソッド・スタブ
							String selected = items[which];
							label.setText("単一選択ダイアログ" + selected + "が入力されました。");
						}
					});
			dialog.show();
		}

		private void showDPDialog() {
			// TODO 自動生成されたメソッド・スタブ
			Calendar cal = Calendar.getInstance();

			DatePickerDialog dialog = new DatePickerDialog(
					DialogSampleActivity.this,
					new DatePickerDialog.OnDateSetListener() {

						@Override
						public void onDateSet(DatePicker picker, int year,
								int month, int day) {
							// TODO 自動生成されたメソッド・スタブ
							label.setText("日付選択ダイアログ：" + year + "年"
									+ (month + 1) + "月" + day + "日");
						}
					}, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
					cal.get(Calendar.DAY_OF_MONTH));
			dialog.show();

		}

		private void showTPDialog() {
			// TODO 自動生成されたメソッド・スタブ
			TimePickerDialog dialog = new TimePickerDialog(
					DialogSampleActivity.this,
					new TimePickerDialog.OnTimeSetListener() {
						public void onTimeSet(TimePicker picker, int hour,
								int min) {
							// TODO 自動生成されたメソッド・スタブ
							label.setText("時間選択ダイアログ:" + hour + "時" + min + "分");
						}
					}, 0, 0, true);
			dialog.show();
		}

		ProgressDialog dialog;
		private void showProgressDialog() {
			// TODO 自動生成されたメソッド・スタブ
			dialog = new ProgressDialog(DialogSampleActivity.this);
			dialog.setTitle("プログレスバーダイアログ");
			dialog.setMessage("しばらくお待ちください・・・");
			dialog.setIndeterminate(false);
			dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			dialog.setMax(100);
			dialog.setCancelable(false);
			dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
				public void onCancel(DialogInterface dialog) {
					// TODO 自動生成されたメソッド・スタブ
				}
			});

			dialog.show();
			new Thread(new Runnable() {
				public void run() {
					// TODO 自動生成されたメソッド・スタブ
					try {
						for (int i = 0; i < dialog.getMax(); i++) {
							dialog.setProgress(i);
							Thread.sleep(100);
						}
					} catch (Exception e) {

					}
					dialog.dismiss();
				}
			}).start();

		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dialog_sample, menu);
		return true;
	}

	public void ContentProviderSample2Activity() {
		// TODO 自動生成されたメソッド・スタブ

	}

}
