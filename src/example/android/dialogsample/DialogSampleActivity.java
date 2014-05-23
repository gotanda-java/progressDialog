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
			// TODO �����������ꂽ���\�b�h�E�X�^�u
		Intent intent = new Intent(DialogSampleActivity.this, ContentProviderSample2Activity.class);
		startActivityForResult(intent, 0);
		}

		private void showDialog() {
			// TODO �����������ꂽ���\�b�h�E�X�^�u
			AlertDialog.Builder dialog = new AlertDialog.Builder(
					DialogSampleActivity.this);
			dialog.setTitle("�ʏ�_�C�A���O");
			dialog.setMessage("�I�����Ă�������");
			dialog.setPositiveButton("OK",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog,
								int whichButton) {
							label.setText("�ʏ�_�C�A���O:OK���I������܂���");
							// TODO �����������ꂽ���\�b�h�E�X�^�u

						}
					});
			dialog.setNegativeButton("NG",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							label.setText("�ʏ�_�C�A���O:NG���I������܂���");
							// TODO �����������ꂽ���\�b�h�E�X�^�u

						}
					});
			dialog.show();
		}

		private void showTextDialog() {
			// TODO �����������ꂽ���\�b�h�E�X�^�u
			final EditText editText = new EditText(DialogSampleActivity.this);
			AlertDialog.Builder dialog = new AlertDialog.Builder(
					DialogSampleActivity.this);
			dialog.setTitle("�e�L�X�g�_�C�A���O");
			dialog.setMessage("�e�L�X�g����͂��Ă�������");
			dialog.setView(editText);
			dialog.setPositiveButton("OK",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO �����������ꂽ���\�b�h�E�X�^�u
							label.setText("�e�L�X�g�_�C�A���O�F"
									+ editText.getText().toString()
									+ "�����͂���܂���");
						}
					});
			dialog.show();

		}

		final String[] items = new String[] { "��", "�~", "��" };
		int which = 0;

		private void showSSDialog() {
			// TODO �����������ꂽ���\�b�h�E�X�^�u
			AlertDialog.Builder dialog = new AlertDialog.Builder(
					DialogSampleActivity.this);
			dialog.setTitle("�P��I���_�C�A���O");
			dialog.setSingleChoiceItems(items, 0,
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int whichButton) {
							// TODO �����������ꂽ���\�b�h�E�X�^�u
							which = whichButton;
						}
					});
			dialog.setPositiveButton("OK",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int whichButton) {
							// TODO �����������ꂽ���\�b�h�E�X�^�u
							String selected = items[which];
							label.setText("�P��I���_�C�A���O" + selected + "�����͂���܂����B");
						}
					});
			dialog.show();
		}

		private void showDPDialog() {
			// TODO �����������ꂽ���\�b�h�E�X�^�u
			Calendar cal = Calendar.getInstance();

			DatePickerDialog dialog = new DatePickerDialog(
					DialogSampleActivity.this,
					new DatePickerDialog.OnDateSetListener() {

						@Override
						public void onDateSet(DatePicker picker, int year,
								int month, int day) {
							// TODO �����������ꂽ���\�b�h�E�X�^�u
							label.setText("���t�I���_�C�A���O�F" + year + "�N"
									+ (month + 1) + "��" + day + "��");
						}
					}, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
					cal.get(Calendar.DAY_OF_MONTH));
			dialog.show();

		}

		private void showTPDialog() {
			// TODO �����������ꂽ���\�b�h�E�X�^�u
			TimePickerDialog dialog = new TimePickerDialog(
					DialogSampleActivity.this,
					new TimePickerDialog.OnTimeSetListener() {
						public void onTimeSet(TimePicker picker, int hour,
								int min) {
							// TODO �����������ꂽ���\�b�h�E�X�^�u
							label.setText("���ԑI���_�C�A���O:" + hour + "��" + min + "��");
						}
					}, 0, 0, true);
			dialog.show();
		}

		ProgressDialog dialog;
		private void showProgressDialog() {
			// TODO �����������ꂽ���\�b�h�E�X�^�u
			dialog = new ProgressDialog(DialogSampleActivity.this);
			dialog.setTitle("�v���O���X�o�[�_�C�A���O");
			dialog.setMessage("���΂炭���҂����������E�E�E");
			dialog.setIndeterminate(false);
			dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			dialog.setMax(100);
			dialog.setCancelable(false);
			dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
				public void onCancel(DialogInterface dialog) {
					// TODO �����������ꂽ���\�b�h�E�X�^�u
				}
			});

			dialog.show();
			new Thread(new Runnable() {
				public void run() {
					// TODO �����������ꂽ���\�b�h�E�X�^�u
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
		// TODO �����������ꂽ���\�b�h�E�X�^�u

	}

}
