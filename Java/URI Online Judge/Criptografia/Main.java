package Criptografia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    public ArrayList<String> encryptedMessages; 
    public static void main(String[] args) throws IOException {
        new Main();
    }

    public Main() {
        encryptedMessages = new ArrayList<String>();
        Scanner ler = new Scanner(System.in);
        int n = setN(ler.nextInt());
        ler.nextLine();
        for (int i = 0; i < n; i++) {
            String line = ler.nextLine();
            if(lineLengthAtLimit(line.length())) {
                String encryptedMessage = thirdEncryption(secondEncryption(firstEncryption(line)));
                encryptedMessages.add(encryptedMessage);
            }
        }
        for (String encryptedMessage : encryptedMessages) {
            System.out.println(encryptedMessage);
        }
        ler.close();
    }

    public int setN(int n) {
        if(n >= 1 && n <= 1 * Math.pow(10, 4)) {
            return n;
        }
        return 0;
    }

    public boolean lineLengthAtLimit(int m) {
        return m >= 1 && m <= 1 * Math.pow(10, 3);
    }

    public String firstEncryption(String message) {
        String encryptedMessage = "";
        Integer[] messageChars = new Integer[message.length()];
        for (int i = 0; i < message.length(); i++) {
            if(message.charAt(i) >= 65 && message.charAt(i) <= 90 || message.charAt(i) >= 97 && message.charAt(i) <= 122) {
                messageChars[i] = message.charAt(i) + 3;
            } else {
                messageChars[i] = (int)message.charAt(i);
            }
            encryptedMessage += Character.toString(messageChars[i]) ;
        }
        return encryptedMessage;
    }

    public String secondEncryption(String message) {
        String encryptedMessage = "";
        for (int i = message.length() - 1; i >= 0; i--) {
            encryptedMessage += Character.toString(message.charAt(i));
        }
        return encryptedMessage;
    }

    public String thirdEncryption(String message) {
        String encryptedMessage = "";
        for (int i = 0; i < message.length(); i++) {
            if(!(i >= message.length() / 2)) {
                encryptedMessage += Character.toString(message.charAt(i));
            } else {
                encryptedMessage += Character.toString(message.charAt(i) - 1);
            }
        }
        return encryptedMessage;
    }
}