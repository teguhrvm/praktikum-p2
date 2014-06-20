package Pemrograman2;

import java.io.*;
import java.io.FileWriter;

public class TulisFile {
    public static void main(String[] x) throws Exception {
		//1. writer ke file tujuan
		String namafile = "target/output.txt";
		FileWriter output = new FileWriter(namafile);

		//2. Tangkap input dari command line menggunakan BufferedReader
		BufferedReader reader =
			new BufferedReader(
				new InputStreamReader(System.in));

		//3. Beri aba-aba untuk user
		System.out.println("Silakan mengetik exit untuk keluar");	
		
		String data;
		while((data = reader.readLine()) != null){
			//Jika ketik exit, selesai loop
			if ("exit".equalsIgnoreCase(data)) {
				break;
			}
			output.write(data);
			output.write("\r\n");
                        output.flush();
		}

		reader.close();
	}
}
