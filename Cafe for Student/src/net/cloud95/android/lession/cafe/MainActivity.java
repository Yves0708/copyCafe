package net.cloud95.android.lession.cafe;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	private RadioGroup sizerg;
	private RadioGroup icerg;
	private RadioGroup sugarrg;
	private RadioButton[] sizerb = new RadioButton[3];
	private RadioButton[] icerb = new RadioButton[5];
	private RadioButton[] sugarrb = new RadioButton[5];
	private Button[] cafebtns = new Button[8];
	private TextView tv_order;
	private TextView tv_money;

	private int radioButtonCheckedColor = Color.RED;
	private int radioButtonUnCheckedColor = Color.BLACK;
	//目前選擇的大小杯
	private int sizeIndex =2 ;
	//目前選擇的冰
	private int iceIndex = 4;
	//目前選擇的糖
	private int sugarIndex = 4;
	private Order order;
	
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
		cafebtns[0].setTag(0);
		cafebtns[1] =(Button) findViewById(R.id.cafebtn2);
		cafebtns[1].setTag(1);
		cafebtns[2] =(Button) findViewById(R.id.cafebtn3);
		cafebtns[2].setTag(2);
		cafebtns[3] =(Button) findViewById(R.id.cafebtn4);
		cafebtns[3].setTag(3);
		cafebtns[4] =(Button) findViewById(R.id.cafebtn5);
		cafebtns[4].setTag(4);
		cafebtns[5] =(Button) findViewById(R.id.cafebtn6);
		cafebtns[5].setTag(5);
		cafebtns[6] =(Button) findViewById(R.id.cafebtn7);
		cafebtns[6].setTag(6);
		cafebtns[7] =(Button) findViewById(R.id.cafebtn8);
		cafebtns[7].setTag(7);
		tv_order =(TextView) findViewById(R.id.tv_order);
		tv_money =(TextView) findViewById(R.id.tv_money);
	}
	
	private void processControl(){
		order  = new Order();
		//設定 RadioGroup 改選的監聽
		MyOnCheckedChangeListener myOnCheckedChangeListener = new MyOnCheckedChangeListener();
		sizerg.setOnCheckedChangeListener(myOnCheckedChangeListener);
		sugarrg.setOnCheckedChangeListener(myOnCheckedChangeListener);
		icerg.setOnCheckedChangeListener(myOnCheckedChangeListener);
		//刷新 RadioButton 文字顏色
		updateRadioButtons(sizerg);
		updateRadioButtons(sugarrg);
		updateRadioButtons(icerg);
		//刷新 CafeButton 文字內容
		refreshCafeButton();
		//設定CafeButton點選的監聽
		MyOnClickListener myOnClickListener = new MyOnClickListener();
		MyOnLongClickListener myOnLongClickListener = new MyOnLongClickListener();
		for(Button cafebtn:cafebtns){
			cafebtn.setOnClickListener(myOnClickListener);
			cafebtn.setOnLongClickListener(myOnLongClickListener);//設置長按監聽器
		}
	}
	//RadioGroup 改選的受委任者
	class MyOnCheckedChangeListener implements OnCheckedChangeListener{

		@Override
		public void onCheckedChanged(RadioGroup parent, int id) {
			// TODO Auto-generated method stub
			updateRadioButtons(parent);
		}
		
	}
	//CafeButton點選的受委任者
	class MyOnClickListener implements OnClickListener{

		@Override
		public void onClick(View view) {
			// TODO Auto-generated method stub
			String temp_order = "";
			temp_order = tv_order.getText().toString();
			if(temp_order.length()>0){
				temp_order+="、";
			}
		order.add(new Cafe(sizeIndex,iceIndex,sugarIndex,(Integer)view.getTag(),Cafe.cafePrice[(Integer)view.getTag()][sizeIndex]));
			
			tv_order.setText(order.toString());
			tv_money.setText(String.valueOf(order.getSubtotal()));
		}
		
		
	}
	//CafeButton點長按的受委任者
		class MyOnLongClickListener implements OnLongClickListener{

			@Override
			public boolean onLongClick(View view) {
				// TODO Auto-generated method stub
				
			order.del(new Cafe(sizeIndex,iceIndex,sugarIndex,(Integer)view.getTag(),Cafe.cafePrice[(Integer)view.getTag()][sizeIndex]));
				
				tv_order.setText(order.toString());
				tv_money.setText(String.valueOf(order.getSubtotal()));
				return true;//如果傳回false則表示還沒結束會再點擊按鈕一次
			}
			
			
		}
	private void updateRadioButtons(RadioGroup parent){
		//取得 RadioGroup 內 RadioButton 數量
		int radioButtonNumber = parent.getChildCount();
		for(int i=0; i<radioButtonNumber;i++){
			//輪詢 RadioGroup 內 RadioButton
			RadioButton radioButton =(RadioButton) parent.getChildAt(i);
			if(radioButton.isChecked()){
				//若 RadioButton 被選取時文字顏色變更
				radioButton.setTextColor(radioButtonCheckedColor);
				//是否為尺寸的 RadioGroup
				if(sizerg.equals(parent))
					for(int j=0;j<sizerb.length;j++){
						if(sizerb[j].equals(radioButton)){
							sizeIndex=j;
						}
					}
				//是否為糖的 RadioGroup
				if(sugarrg.equals(parent))
					for(int j=0;j<sugarrb.length;j++){
						if(sugarrb[j].equals(radioButton)){
							sugarIndex=j;
						}
					}
				//是否為冰的 RadioGroup
				if(icerg.equals(parent))
					for(int j=0;j<icerb.length;j++){
						if(icerb[j].equals(radioButton)){
							iceIndex=j;
						}
					}
				refreshCafeButton();
			}else{
				//若 RadioButton 沒被選取時文字顏色變更
				radioButton.setTextColor(radioButtonUnCheckedColor);
			}
		}
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
