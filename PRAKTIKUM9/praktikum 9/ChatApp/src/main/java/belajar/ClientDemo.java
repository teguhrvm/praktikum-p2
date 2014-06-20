package belajar;
import java.net.*;

public class ClientDemo {
   public static void main(String[] x) throws Exception{
		//1. IP Adress dan port Server
		String ipServer = "127.0.0.1";
		Integer portServer = 10000;

		//2. Connect menggunakan socket
		Socket s = new Socket(ipServer,portServer);  

		//3. Tampilkan informasi server
		InetSocketAddress server = (InetSocketAddress) s.getRemoteSocketAddress();
		System.out.println("IP Server : "+server.getAddress());
		System.out.println("Port Server : "+server.getPort());
		System.out.println("Hostname Server : "+server.getHostName());

		//4. Tutup Koneksi
		s.close();
	} 
}
