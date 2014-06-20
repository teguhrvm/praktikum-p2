package pemrograman2;

public class DoubleThread { 
    public static void main(String[] x) throws Exception{
		System.out.println("Baris pertama");
		System.out.println("Baris kedua");
		new Thread(new Runnable(){
			public void run(){
				System.out.println("Baris ketiga");
				System.out.println("Baris keempat");
			}
		}).start();
		System.out.println("Baris kelima");
		System.out.println("Baris keenam");
	}
}
