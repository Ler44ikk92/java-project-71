package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;


import java.util.Map;

public class Parser {



    public static Map<String, Object> parser(String content) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map
                = mapper.readValue(content, new TypeReference<Map<String, Object>>() { });
        return map;
    }

    public static String convertToJson(Map<String, Object> content) throws JsonProcessingException {
        // Создание экземпляра ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        // Преобразование карты в JSON
        JsonNode json = objectMapper.valueToTree(content);
        String str = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
        return str;

    }





}
