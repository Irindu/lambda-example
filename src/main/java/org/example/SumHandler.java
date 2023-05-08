package org.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import util.Logger;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumHandler {

    public Map<String, Object> handleRequest(Map<String, Object> input, Context context) throws IOException {

        Logger logger = new Logger(context.getLogger());
        ObjectMapper mapper = new ObjectMapper();

        if(input.get("numbers") == null){
            input = mapper.readValue((String) input.get("body"), new TypeReference<HashMap<String,Object>>() {});
        }

        logger.log("received input: " + input);

        // Parse the input JSON
        int[] numbers = mapper.readValue(mapper.writeValueAsString(input.get("numbers")), int[].class);

        logger.log("received numbers: " + Arrays.toString(numbers));

        // Compute the sum of the numbers
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        // Create the output JSON
        Map<String, Object> output = Map.of("sum", sum);

        logger.log("generated output: " + output);

        return output;
    }

}