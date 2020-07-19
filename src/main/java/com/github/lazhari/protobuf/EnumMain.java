package com.github.lazhari.protobuf;

import example.enumerations.EnumExample;
import example.enumerations.EnumExample.EnumMessage;

public class EnumMain {
    public static void main(String[] args) {
        System.out.println("Example for enums");

        EnumExample.EnumMessage.Builder builder = EnumMessage.newBuilder();

        builder.setId(345);

        builder.setDayOfTheWeek(EnumExample.DayOfTheWeek.SATURDAY);

        EnumMessage message = builder.build();
        System.out.println(message);
    }
}
