package net.cloud95.android.lession.cafe;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends Activity {
	private RadioGroup sizerg;
	private RadioGroup icerg;
	private RadioGroup sugarrg;
	private RadioButton[] sizerb = new RadioButton[3];
	private RadioButton[] icerb = new RadioButton[5];
	private RadioButton[] sugarrb = new RadioButton[5];
	private Button[] cafebtns = new Button[8];
	//咖啡名稱
	private String[] cafeName={
			"美式咖啡",
			"招牌咖啡",
			"海岩咖啡",
			"拿鐵咖啡",
			"義式咖啡",
			"卡布奇諾",
			"焦糖瑪奇朵",
			"北海道醇濃奶茶"
	};
	//咖啡價目表
	private int[][] cafePrice={
			{35,50,60},
			{45,60,70},
			{45,60,70},
			{55,70,80},
			{55,70,80},
			{55,70,80},
			{65,80,90},
			{65,80,90}
	};
	private int radioButtonCheckedColor = Color.RED;
	private int radioButtonUnCheckedColor = Color.BLACK;
	//目前選擇的大小杯
	private int sizeIndex =2 ;
	//目前選擇的冰
	private int iceIndex = 4;
	//目前選擇的糖
	private int sugarIndex = 4;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		processView();//處理視覺
		processControl();//流程控制
	}
	private void processView(){
		sizerg =(RadioGroup) findViewById(R.id.sizerg);
		sugarrg =(RadioGroup) findViewById(R.id.sugarrg);
		icerg =(RadioGroup) findViewById(R.id.icerg);
		sizerb[0] = (RadioButton)findViewById(R.id.sizerb1);
		sizerb[1] = (RadioButton)findViewById(R.id.sizerb2);
		sizerb[2] = (RadioButton)findViewById(R.id.sizerb3);
		sugarrb[0] =(RadioButton)findViewById(R.id.sugarrb1);
		sugarrb[1] =(RadioButton)findViewById(R.id.sugarrb2);
		sugarrb[2] =(RadioButton)findViewById(R.id.sugarrb3);
		sugarrb[3] =(RadioButton)findViewById(R.id.sugarrb4);
		sugarrb[4] =(RadioButton)findViewById(R.id.sugarrb5);
		icerb[0] = (RadioButton)findViewById(R.id.icerb1);
		icerb[1] = (RadioButton)findViewById(R.id.icerb2);
		icerb[2] = (RadioButton)findViewById(R.id.icerb3);
		icerb[3] = (RadioButton)findViewById(R.id.icerb4);
		icerb[4] = (RadioButton)findViewById(R.id.icerb5);
		cafebtns[0] =(Button) findViewById(R.id.cafebtn1);
		cafebtns[1] =(Button) findViewById(R.id.cafebtn2);
		cafebtns[2] =(Button) findViewById(R.id.cafebtn3);
		cafebtns[3] =(Button) findViewById(R.id.cafebtn4);
		cafebtns[4] =(Button) findViewById(R.id.cafebtn5);
		cafebtns[5] =(Button) findViewById(R.id.cafebtn6);
		cafebtns[6] =(Button) findViewById(R.id.cafebtn7);
		cafebtns[7] =(Button) findViewById(R.id.cafebtn8);
	}
	
	private void processControl(){
		//設定 RadioGroup 改選的監聽
		//刷新 RadioButton 文字顏色
		//刷新 CafeButton 文字內容
	}
	//RadioGroup 改選的受委任者
	class MyOnCheckedChangeListener implements OnCheckedChangeListener{

		@Override
		public void onCheckedChanged(RadioGroup parent, int id) {
			// TODO Auto-generated method stub
		}
		
	}
	
	private void updateRadioButtons(RadioGroup parent){
		//取得 RadioGroup 內 RadioButton 數量
			//輪詢 RadioGroup 內 RadioButton 
				//若 RadioButton 被選取時文字顏色變更
				//是否為尺寸的 RadioGroup
				//是否為糖的 RadioGroup
				//是否為冰的 RadioGroup
				//若 RadioButton 沒被選取時文字顏色變更
	}
	//刷新 CafeButton 文字內容
	private void refreshCafeButton(){
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
