package com.store.cake.service.category;

import java.util.Base64;

public class Base64Converter {

    public static String encodeToBase64(byte[] imageBytes) {
        if (imageBytes == null) {
            return null;
        }
        return Base64.getEncoder().encodeToString(imageBytes);
    }

    public static byte[] decodeFromBase64(String base64String) {
        if (base64String == null) {
            return null;
        }
        return Base64.getDecoder().decode(base64String);
    }
}