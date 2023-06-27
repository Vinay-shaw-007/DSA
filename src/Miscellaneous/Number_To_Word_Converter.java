package Miscellaneous;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class Number_To_Word_Converter {

    // Array of word representations for single-digit numbers
    private static final String[] UNITS = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
            "Seventeen", "Eighteen", "Nineteen"
    };

    // Array of word representations for tens places (10, 20, 30, etc.)
    private static final String[] TENS = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    // Array of word representations for a thousand, a million, and a billion places
    private static final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public static void main(String[] args) {
        // Entry point of the program, calls the getValueFromUrl method
        getValueFromUrl();
    }

    public static void getValueFromUrl() {
        try {
            // URL to retrieve JSON data from
            String url = "https://api.coindesk.com/v1/bpi/currentprice.json";

            // Creating an HTTP GET request to the specified URL
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(url))
                    .build();

            // Creating an HttpClient to execute the request
            HttpClient client = HttpClient.newBuilder().build();

            // Sending the request and receiving the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Extracting the response body as a string
            String jsonString = response.body();

            // Creating a Gson object to parse the JSON string
            Gson gson = new Gson();

            // Parsing the JSON string into a JsonObject
            JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);

            // Accessing the "bpi" object from the JSON object
            JsonObject bpi = jsonObject.getAsJsonObject("bpi");

            // Iterating over the currencies in the "bpi" object
            for (Map.Entry<String, JsonElement> entry : bpi.entrySet()) {
                String currencyCode = entry.getKey();
                JsonObject currencyInfo = entry.getValue().getAsJsonObject();

                // Extracting the rate value as a string and converting into integer.
                String rate = currencyInfo.get("rate").getAsString();
                int rateInWords = Integer.parseInt(rate.split("\\.")[0].replace(",",""));
                // Printing the currency code, rate, and the rate converted to words
                System.out.println("Currency Code: " + currencyCode);
                System.out.println("Rate: " + rate);
                System.out.println("In Words: "+addAnd(convertToWord(rateInWords)));
                System.out.println();
            }

        } catch (IOException | InterruptedException e) {
            // Handling exceptions that may occur during the HTTP request
            System.out.println(e.getMessage());
        }
    }

    // Converts a given number to its word representation
    private static String convertToWord(int number) {
        if (number == 0) {
            return "Zero";
        }

        String word = "";

        int index = 0;
        while (number > 0) {
            if (number % 1000 != 0) {
                // Converting the current three-digit segment to words and adding the appropriate place value
                word = convertHundreds(number % 1000) + THOUSANDS[index] + " " + word;
            }
            number /= 1000;
            index++;
        }

        return word.trim();
    }

    // Converts a three-digit number to its word representation
    private static String convertHundreds(int number) {
        String word;

        if (number % 100 < 20) {
            // Handling numbers less than 20
            word = UNITS[number % 100] + " ";
            number /= 100;
        } else {
            // Handling numbers greater than or equal to 20
            word = UNITS[number % 10] + " ";
            number /= 10;

            word = TENS[number % 10]  + " " + word;
            number /= 10;
        }

        if (number != 0) {
            // Handling the hundreds place
            word = UNITS[number] + " Hundred " + word;
        }

        return word;
    }
    private static String addAnd(String word) {
        int lastSpaceIndex = word.lastIndexOf(' ');
        if (lastSpaceIndex != -1) {
            word = word.substring(0, lastSpaceIndex) + " and " + word.substring(lastSpaceIndex + 1);
        }
        return word;
    }
}

