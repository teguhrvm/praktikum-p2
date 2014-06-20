package Pemrograman2;

import java.io.*;
import java.io.FileReader;

public class CopyFile {
    public static void main(String[] x) throws Exception {
		FileReader asal = 
			new FileReader("src/main/resources/mahasiswa.csv");
		FileWriter tujuan = 
			new FileWriter("target/mahasiswa.csv");

		System.out.println("---------------------");
		int data;
		while((data = asal.read()) != -1){
			System.out.print((char) data);
			tujuan.write(data);
			tujuan.flush();
		}		
		System.out.println("---------------------");
		asal.close();
		tujuan.close();
	}
}
