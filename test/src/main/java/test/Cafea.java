package test;

public enum Cafea {
	MICA(8,"A"),
	MEDIE(10,"B"){
		public String getLid(){ 
			return "special lid"; 
		}
				},
	MARE(16,"C");
	
	private int size;
	private String lid;
	
	public int getSize(){
		return size;
	}
	
	public String getLid(){
		return lid;
	}
	
	Cafea(int size, String lid){
		this.size = size;
		this.lid = lid;
	}
	
	
	
}
