package com.example.springboard.util.converter;

import java.util.Map;

public class ParamMapConverter {

    public static String paramMapToString(Map<String, String[]> paramMap) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<String, String[]> entry : paramMap.entrySet()) {
            stringBuilder.append(entry.getKey()).append(": [");
            String[] values = entry.getValue();
            if (values != null && values.length > 0) {
                stringBuilder.append(String.join(", ", values));
            }
            stringBuilder.append("]\n");
        }

        return stringBuilder.toString();
    }
}
