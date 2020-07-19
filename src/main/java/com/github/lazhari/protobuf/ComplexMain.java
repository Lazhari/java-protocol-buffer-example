package com.github.lazhari.protobuf;

import example.complex.Complex.*;

public class ComplexMain {
    public static void main(String[] args) {
        System.out.println("Complex messages");

        DummyMessage oneDummy = newDummyMessage(55, "one dummy message");

        ComplexMessage.Builder builder = ComplexMessage.newBuilder();

        builder.setOneDummy(oneDummy);

        // repeated field
        builder.addMultipleDummy(newDummyMessage(44, "second Dummy"))
                .addMultipleDummy(newDummyMessage(45, "third Dummy"));

        ComplexMessage message = builder.build();
        System.out.println(message);
    }

    public static DummyMessage newDummyMessage(Integer id, String name) {
        DummyMessage.Builder dummyMessageBuilder = DummyMessage.newBuilder();

        DummyMessage message = dummyMessageBuilder.setName("Mama").setId((55)).build();

        return message;
    }
}
