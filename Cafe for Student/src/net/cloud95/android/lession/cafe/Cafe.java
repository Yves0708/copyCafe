package net.cloud95.android.lession.cafe;

public class Cafe {
	private int sizeIndex;
	private int iceIndex;
	private int sugarIndex;
	private int cafeType;
	private float price;
	
	//咖啡名稱
		private static String[] cafeName={
				"美式咖啡",
				"招牌咖啡",
				"海岩咖啡",
				"拿鐵咖啡",
				"義式咖啡",
				"卡布奇諾",
				"焦糖瑪奇朵",
				"北海道醇濃奶茶"
		};
		//尺寸名稱
		private static String[] sizeName = {
					"小杯",
					"中杯",
					"大杯"
		};
		//冰名稱
			private static String[] iceName = {
						"熱飲",
						"溫飲",
						"去冰",
						"半冰",
						"冰正常"
			};
			//糖名稱
			private static String[] sugarName = {
								"無糖",
								"三分糖",
								"半糖",
								"七分糖",
								"正常糖"
					};
		//咖啡價目表
		static final int[][] cafePrice={
				{35,50,60},
				{45,60,70},
				{45,60,70},
				{55,70,80},
				{55,70,80},
				{55,70,80},
				{65,80,90},
				{65,80,90}
		};
		public Cafe(int sizeIndex, int iceIndex, int sugarIndex, int cafeType,
				float price) {
			super();
			this.sizeIndex = sizeIndex;
			this.iceIndex = iceIndex;
			this.sugarIndex = sugarIndex;
			this.cafeType = cafeType;
			this.price = price;
		}
		public int getSizeIndex() {
			return sizeIndex;
		}
		public void setSizeIndex(int sizeIndex) {
			this.sizeIndex = sizeIndex;
		}
		public int getIceIndex() {
			return iceIndex;
		}
		public void setIceIndex(int iceIndex) {
			this.iceIndex = iceIndex;
		}
		public int getSugarIndex() {
			return sugarIndex;
		}
		public void setSugarIndex(int sugarIndex) {
			this.sugarIndex = sugarIndex;
		}
		public int getCafeType() {
			return cafeType;
		}
		public void setCafeType(int cafeType) {
			this.cafeType = cafeType;
		}
		public float getPrice() {
			return price;
		}
		public void setPrice(float price) {
			this.price = price;
		}
		
		public boolean equals(Cafe cafe) {
			// TODO Auto-generated method stub
			boolean result= true;
			if(sizeIndex!=cafe.getSizeIndex())
				result = false;
			if(cafeType!=cafe.getCafeType())
				result = false;
			if(iceIndex!=cafe.getIceIndex())
				result = false;
			if(sugarIndex!=cafe.getSugarIndex())
				result = false;
			
			return result;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return cafeName[cafeType]+"("+iceName[iceIndex]+"、"+sugarName[sugarIndex]+"、"+sizeName[sizeIndex]+")";
			
		}
		
		
		
}
