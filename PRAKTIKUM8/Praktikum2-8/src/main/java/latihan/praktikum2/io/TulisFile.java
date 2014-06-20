package latihan.praktikum2.io;
import java.io.*;

public class TulisFile {
    public static void main (String[] x) throws Exception{
        //1. Writer ke file tujuan
        String namafile = "target/output.txt";
        FileWriter output = new FileWriter (namafile);
        
        //2. Tangkap input dari command line menggunakan BufferedReader
        BufferedReader reader = new BufferedReader (
                new InputStreamReader (System.in));
        
        //3. Beri aba-aba untuk user 
        System.out.println("Silakan mengetik. ketik 'exit' untuk selesai");
        
        String data;
        while((data=reader.readLine()) != null){
            //Jika kita ketik exit, loop selesai
            if("exit".equalsIgnoreCase(data)){
                break;
            }
            output.write(data);
            output.write("\r\n");
            output.flush();
        }
        reader.close();
    }
}
