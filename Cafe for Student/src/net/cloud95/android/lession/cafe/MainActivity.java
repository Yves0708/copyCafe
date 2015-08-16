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
	//目前選擇的大小杯
	//目前選擇的冰
	//目前選擇的糖
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	private void processView(){
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
