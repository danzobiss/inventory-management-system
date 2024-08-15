package com.danzobiss.inventory_management_system.util;

import java.lang.reflect.Field;

public class EntityTransformerUtil {

    public static <T> T transform(Object source, T destination) {
        Class<?> sourceClass = source.getClass();
        Class<?> destClass = destination.getClass();

        Field[] sourceFields = sourceClass.getDeclaredFields();
        for (Field sourceField : sourceFields) {
            sourceField.setAccessible(true); // Allow access to private fields
            try {
                Field destField = destClass.getDeclaredField(sourceField.getName());
                destField.setAccessible(true); // Allow access to private fields
                Object value = sourceField.get(source);
                destField.set(destination, value);
            } catch (NoSuchFieldException e) {
                // Field does not exist in the destination class
            } catch (IllegalAccessException e) {
                throw new RuntimeException("An error occurred while saving the product: " + e.getMessage());
            }
        }
        return destination;
    }

}
