package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class Compare {

    public static Map<String, Object> compare(Map<String, Object> content1, Map<String, Object> content2)
            throws JsonProcessingException {
        // Используем TreeMap для автоматической сортировки по ключам
        Map<String, Object> resultMap = new LinkedHashMap<>();

        // Сравнение первого JSON
        for (Map.Entry<String, Object> entry1 : content1.entrySet()) {
            String key1 = entry1.getKey();
            Object value1 = entry1.getValue();

            if (content2.containsKey(key1)) {
                Object value2 = content2.get(key1);
                if (value1 == null && value2 == null) {
                    resultMap.put(" " + key1, null);
                } else if (value1 == null) {
                    resultMap.put("- " + key1, null);
                    resultMap.put("+ " + key1, value2);
                } else if (value2 == null) {
                    resultMap.put("- " + key1, value1);
                    resultMap.put("+ " + key1, null);
                } else if  (value1.equals(value2)) {
                    resultMap.put("  " + key1, value1);
                } else {
                    resultMap.put("- " + key1, value1); // Изменённый ключ
                    resultMap.put("+ " + key1, value2); // Новое значение
                }
            } else {
                resultMap.put("- " + key1, value1);

            }
        }

        // Сравнение второго JSON
        for (Map.Entry<String, Object> entry2 : content2.entrySet()) {
            String key2 = entry2.getKey();
            if (!content1.containsKey(key2)) {
                if (entry2.getValue() == null) {
                    resultMap.put("+ " + key2, null);
                } else {
                    resultMap.put("+ " + key2, entry2.getValue().toString()); // Добавленный ключ
                }
            }
        }
        return sortMap(resultMap); // Возвращаем отсортированную карту
    }

    public static Map<String, Object> sortMap(Map<String, Object> map) {
        // создает список пар ключ-значение из исходного map
        List<Map.Entry<String, Object>> entryList = new ArrayList<>(map.entrySet());

        // Сортировка списка с использованием компаратора
        entryList.sort((entry1, entry2) -> {
            String key1 = entry1.getKey().substring(2);
            String key2 = entry2.getKey().substring(2);
            return key1.compareTo(key2);
        });

        // Создание нового LinkedHashMap для сохранения порядка
        Map<String, Object> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Object> entry : entryList) {
            if (entry.getValue() == null) {
                sortedMap.put(entry.getKey(), null);
            } else {
                sortedMap.put(entry.getKey(), entry.getValue());
            }
        }

        return sortedMap;
    }


}
