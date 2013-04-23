package net.xypenguin.soundpooltest;

import java.util.Random;

import net.xypenguin.soundpooltest.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SoundPoolActivity extends Activity implements OnClickListener {
	private RelativeLayout layout;
	private SoundPool pool;
	private int[] sound = new int[10];
	private Button[] buttons;
	private ImageButton imageButton;
	private TextView textView;
	private Random random;
	private int width;
	private int height;
	private final String[] MESSAGE = { "�͂��I", "�͂���", "�͂��͂��c", "������[", "�������[",
			"����", "������", "�Ȃ�قǁ[", "�킩��܂���" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sound_pool);

		// �R���|�[�l���g���֘A�t��
		layout = (RelativeLayout)this.findViewById(R.id.mainLayout);
		textView = (TextView) this.findViewById(R.id.textView1);
		imageButton = (ImageButton) this.findViewById(R.id.imageButton1);
		buttons = new Button[9];
		buttons[0] = (Button) this.findViewById(R.id.button1);
		buttons[1] = (Button) this.findViewById(R.id.button2);
		buttons[2] = (Button) this.findViewById(R.id.button3);
		buttons[3] = (Button) this.findViewById(R.id.button4);
		buttons[4] = (Button) this.findViewById(R.id.button5);
		buttons[5] = (Button) this.findViewById(R.id.button6);
		buttons[6] = (Button) this.findViewById(R.id.button7);
		buttons[7] = (Button) this.findViewById(R.id.button8);
		buttons[8] = (Button) this.findViewById(R.id.button9);

		// ���X�i�[���Z�b�g
		imageButton.setOnClickListener(this);
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].setOnClickListener(this);
		}

		// ��ʂ̏c�����擾����
		WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		width = display.getWidth();
		height = display.getHeight();

		// �����_���̃C���X�^���X���쐬
		random = new Random();
	}

	@Override
	protected void onResume() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		super.onResume();
		// ���̃A�N�e�B�r�e�B����A�N�e�B�u���畜�A�����Ƃ��ɉ��̃��\�[�X��ǂݍ���
		pool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
		sound[0] = pool.load(this, R.raw.hai_02, 1);
		sound[1] = pool.load(this, R.raw.hai_04, 1);
		sound[2] = pool.load(this, R.raw.haihai_01, 1);
		sound[3] = pool.load(this, R.raw.iiyo_01, 1);
		sound[4] = pool.load(this, R.raw.ok_01, 1);
		sound[5] = pool.load(this, R.raw.un_03, 1);
		sound[6] = pool.load(this, R.raw.oo_01, 1);
		sound[7] = pool.load(this, R.raw.naruhodoo_01, 1);
		sound[8] = pool.load(this, R.raw.wakarimashita_02, 1);
		sound[9] = pool.load(this, R.raw.daisuki_01,1);
		SharedPreferences pref = getSharedPreferences("preceding", MODE_PRIVATE);
		num2bg(pref.getInt("bgNum", 0));
	}

	@Override
	protected void onPause() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		super.onPause();
		// ���̃A�N�e�B�r�e�B���N�����Ă���Ƃ��͉��̃��\�[�X���J�����Ă���
		pool.release();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_sound_pool, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		// �N���W�b�g�\���̃A�N�e�B�r�e�B���J��
		Intent intent = new Intent(this,
				net.xypenguin.soundpooltest.CreditActivity.class);
		startActivity(intent);
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		// textView�̈ʒu����ʓ��ɓ���悤�ɒ����������_���Ŏ擾
		int pLeft = random.nextInt(width * 5 / 6) - (width / 6);
		int pTop = random.nextInt(height - (height / 2)) + (height / 6);
		// textView�̑傫���������������_���Ŏ擾
		int size = random.nextInt(150) + 40;
		// �������{�^���ɑΉ������{�C�X�ƃe�L�X�g�����s
		switch (v.getId()) {
		case R.id.button1:
			playVoice(0, pLeft, pTop, size);
			break;
		case R.id.button2:
			playVoice(1, pLeft, pTop, size);
			break;
		case R.id.button3:
			playVoice(2, pLeft, pTop, size);
			break;
		case R.id.button4:
			playVoice(3, pLeft, pTop, size);
			break;
		case R.id.button5:
			playVoice(4, pLeft, pTop, size);
			break;
		case R.id.button6:
			playVoice(5, pLeft, pTop, size);
			break;
		case R.id.button7:
			playVoice(6, pLeft, pTop, size);
			break;
		case R.id.button8:
			playVoice(7, pLeft, pTop, size);
			break;
		case R.id.button9:
			playVoice(8, pLeft, pTop, size);
			break;
		case R.id.imageButton1:
			// ���s����{�C�X�ƃe�L�X�g�������_���Ŏ擾
			if (1 <= random.nextInt(100)) {
				int ran = random.nextInt(9);
				playVoice(ran, pLeft, pTop, size);
			}else{
				playVoice(9,"��D��", pLeft, pTop, size);
			}
			break;
		default:
			break;
		}
	}

	// �w��ԍ��̃{�C�X�ƕ�����\�����郁�\�b�h
	private void playVoice(int playID, int left, int top, int size) {
		pool.play(sound[playID], 1.0F, 1.0F, 0, 0, 1.0F);
		textView.setText(MESSAGE[playID]);
		textView.setPadding(left, top, 0, 0);
		textView.setTextSize(size);
	}
	
	// �w��ԍ��̃{�C�X�ƕ�����\�����郁�\�b�h�i���d��`�j
	// �e�L�X�g�����ʐݒ�
	private void playVoice(int playID, String message ,int left, int top, int size) {
		pool.play(sound[playID], 1.0F, 1.0F, 0, 0, 1.0F);
		textView.setText(message);
		textView.setPadding(left, top, 0, 0);
		textView.setTextSize(size);
	}
	
	// bgNum���󂯎���Ĕw�i��ύX���郁�\�b�h
	private void num2bg(int bgNum) {
		switch (bgNum) {
		case 0:
			layout.setBackgroundColor(Color.WHITE);
			break;
		case 1:
			layout.setBackgroundResource(R.drawable.bg_01);
			break;
		case 2:
			layout.setBackgroundResource(R.drawable.bg_02);
			break;
		case 3:
			layout.setBackgroundResource(R.drawable.bg_03);
			break;
		default:
			break;
		}
	}
}