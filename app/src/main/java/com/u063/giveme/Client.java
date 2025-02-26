package com.u063.giveme;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private Socket socket;

    public Client(String ip, int port){
        socket = new Socket();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    socket.connect(new InetSocketAddress(ip,port));
                    read();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        // socket.connect(new InetSocketAddress(ip,port));
    }
    public void read(){
        Boolean thatsAll = false;
        while (!thatsAll){
            try {
                BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String s = "";

                while(true){
                //while(b){
                    int b = bf.read();
                    if(b==-1){
                        thatsAll=true;
                        break;
                    }
                    Log.e("","recived: "+ b);

                }
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
