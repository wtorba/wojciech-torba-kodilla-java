package com.kodilla.testing.checkutf;

public class CheckUtf {

    public static void main(String[] args) {
        Byte[] bajty = {(byte)99};
        System.out.println("Type " + bajty.getClass());
        System.out.println("Bajty " + bajty);
    }
}


//byte[] bytesU8=null;

//bytesU8 = record.getContentAs(bytesU8.getClass());
//String contents = new String(bytesU8, StandardCharsets.UTF8);