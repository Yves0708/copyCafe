package net.cloud95.android.lession.cafe;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private List<Cafe> cafes;

	public Order() {
		cafes = new ArrayList<Cafe>();
	}
	
	
	List<Cafe> getCafes() {
		return cafes;
	}

	void setCafes(List<Cafe> cafes) {
		this.cafes = cafes;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String result = "";
		List<Cafe> tempCafes = new ArrayList<Cafe>();
		List<Integer> cafeNumber = new ArrayList<Integer>();
		for(int i=0;i<cafes.size();i++){
			Cafe sourceCafe = cafes.get(i);
			boolean foundSameCafe = false;
			for(int j=0;j<tempCafes.size();j++){
				
				if (sourceCafe.equals(tempCafes.get(j))){
					cafeNumber.set(j,cafeNumber.get(j)+1);//設置改變過後的值
					foundSameCafe = true;
					break;
				}
			}
			if (!foundSameCafe){
				tempCafes.add(sourceCafe);
				cafeNumber.add(1);
				}
		}
		for(int j=0;j<tempCafes.size();j++){
			if(result.length()>0)
				result+="、";
			if(cafeNumber.get(j)>1)
				result+=tempCafes.get(j).toString()+"X"+cafeNumber.get(j);
			else
				result+=tempCafes.get(j).toString();
		}
		
		
		return result;
	}


	//加一杯咖啡
	boolean add(Cafe cafe){
		boolean result = true;
		
		if(cafes ==null){
			result = false;
		}else{
			
			cafes.add(cafe);
		}
		return result;
	}
	
	
	//刪一杯咖啡
	boolean del(Cafe cafe){
		boolean result = false;
		
		if(cafes == null){
			result = false;
		}else{
			
			for(int i=0;i<cafes.size();i++){
				
				if(cafe.equals(cafes.get(i))){
					cafes.remove(i);
					result = true;
					break;
				}
			}
		}
		
		return result;
	}
	
	
	
	//計算小計
	float getSubtotal(){
		float result =0;
		for(Cafe tempCafe:cafes){
			
			result+=tempCafe.getPrice();
		}
		
		return result;
	}
	
	
	
	//取得咖啡杯數
	int getCafesNumber(){
		
		if(cafes!=null){
			return cafes.size();
		}
		return 0;
	}
}
