package pemrograman2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] xx) throws Exception {
        //1. Input konfigurasi
        BufferedReader input = 
                new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Masukkan Nama : ");
        String nama = input.readLine();
        System.out.println("Hallo " + nama);

        System.out.println("Masukkan alamat IP tujuan : ");
        String ipTujuan = input.readLine();

        System.out.println("masukkan port tujuan : ");
        Integer portTujuan = Integer.parseInt(input.readLine());

        //2. Buka Koneksi
        Socket s = new Socket(ipTujuan, portTujuan);
        System.out.println("Berhasil connect ke " + ipTujuan + ":" + portTujuan);

        new ChatSendThread(s, nama).start();
        new ChatThread(s).start();
    }

    private static class ChatSendThread extends Thread {

        private final Socket koneksi;
        private final String nama;

        ChatSendThread(Socket k, String nama) {
            this.koneksi = k;
            this.nama = nama;

        }

        public void run() {
            try {
                System.out.print("Terima koneksi dari alamat IP ");
                System.out.println(((InetSocketAddress) koneksi.getRemoteSocketAddress()).getAddress());

                // 4. Tampilkan data selama belum bye
                BufferedReader chat = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter output = new 
        PrintWriter(koneksi.getOutputStream(), true);

                String msg = chat.readLine();
                while (msg != null && !"bye".equalsIgnoreCase(msg)) {
                    output.println(nama + "> " + msg);
                    msg = chat.readLine();
                }
                chat.close();
                koneksi.close();
            } catch (Exception err) {
                err.printStackTrace();
            }
        }
    }

    private static class ChatThread extends Thread {

        private Socket koneksi;

        ChatThread(Socket k) {
            this.koneksi = k;
        }

        public void run() {
            try {
                System.out.print("Terima koneksi dari alamat IP ");
                System.out.println(((InetSocketAddress) koneksi.getRemoteSocketAddress()).getAddress());

                // 4. Tampilkan data selama belum bye
                BufferedReader chatIncoming
                        = new BufferedReader(new InputStreamReader(koneksi.getInputStream()));

                String msg = chatIncoming.readLine();
                while (msg != null && !"bye".equalsIgnoreCase(msg)) {
                    System.out.println(msg);
                    msg = chatIncoming.readLine();
                }
                chatIncoming.close();
                koneksi.close();
            } 
            catch (Exception err) {
                err.printStackTrace();
            }
        }
    } 
}
