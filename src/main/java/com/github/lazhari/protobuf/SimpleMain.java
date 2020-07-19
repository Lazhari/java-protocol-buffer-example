package com.github.lazhari.protobuf;

import example.simple.Simple;
import example.simple.Simple.SimpleMessage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class SimpleMain {
    public static void main(String[] args) {
        System.out.println("Hello Proto buffer");
        SimpleMessage.Builder builder = SimpleMessage.newBuilder();

        builder.setId(42)
        .setIsSimple(true)
        .setName("My Simple Message Name");

        builder.addSampleList(1).addSampleList(2);
        builder.addAllSampleList(Arrays.asList(3, 4,5));

        System.out.println(builder.toString());

        SimpleMessage message =builder.build();

        try{
            FileOutputStream outputStream = new FileOutputStream("simple_message.bin");
            message.writeTo(outputStream);
            outputStream.close();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // send as byte array
        byte[] bytes = message.toByteArray();

        try {
            System.out.println("Reading from a file");
            FileInputStream fileInputStream = new FileInputStream("simple_message.bin");

            SimpleMessage messageFromFile = SimpleMessage.parseFrom(fileInputStream);

            System.out.println(messageFromFile.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
