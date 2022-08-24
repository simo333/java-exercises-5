package com.example.javaexercises5.dateapi.Task05;

import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HolidayDays {
    private static final List<HolidayDay> holidayDays = new ArrayList<>();

    static {
        loadHolidayDays();
    }

    private static void loadHolidayDays() {
        String apiPath = "https://date.nager.at/api/v3/PublicHolidays/" + LocalDate.now().getYear() + "/PL";
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(apiPath)).build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
            JSONArray jsonArray = new JSONArray(response.body());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                holidayDays.add(new HolidayDay(jsonObject.getString("localName"),
                        jsonObject.getString("date")));
            }
        } catch (IOException | InterruptedException | JSONException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<HolidayDay> getAllHolidayDays() {
        return holidayDays;
    }

    public Optional<HolidayDay> getHolidayDayByName(String name) {
        return holidayDays.stream()
                .filter(h -> name.equals(h.getLocalName()))
                .findFirst();
    }

    public Optional<HolidayDay> getHolidayDayByDate(LocalDate date) {
        return holidayDays.stream()
                .filter(h -> date.isEqual(date))
                .findFirst();
    }
}
