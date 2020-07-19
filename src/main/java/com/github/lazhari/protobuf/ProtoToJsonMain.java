package com.github.lazhari.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import example.simple.Simple;

import java.util.Arrays;

public class ProtoToJsonMain {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        System.out.println("proto message to JSON");
        Simple.SimpleMessage.Builder builder = Simple.SimpleMessage.newBuilder();

        builder.setId(42)
                .setIsSimple(true)
                .setName("My Simple Message Name");

        builder.addSampleList(1).addSampleList(2);
        builder.addAllSampleList(Arrays.asList(3, 4, 5));

        // Print this as a JSON
        String jsonString = JsonFormat.printer()
    //                .includingDefaultValueFields()
                .print(builder);

        System.out.println(jsonString);

        // Json to protocol buffer
        Simple.SimpleMessage.Builder builder2 = Simple.SimpleMessage.newBuilder();

        JsonFormat.parser().ignoringUnknownFields().merge(jsonString, builder2);

        System.out.println(builder2);
    }
}
