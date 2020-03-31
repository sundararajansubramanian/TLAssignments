package week1.day1;

public class Mobile {

	boolean issmartphone = true;
	int price = 60000;
	String model = "iPhone";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("I'm ready");
		
	Mobile mobile1 = new Mobile();
	
	boolean issmartphone1 = mobile1.issmartphone;
	System.out.println(issmartphone1);
	
	int price1 = mobile1.price;
	System.out.println(price1);
	
	String model1 = mobile1.model;
	System.out.println(model1);

	}

}
