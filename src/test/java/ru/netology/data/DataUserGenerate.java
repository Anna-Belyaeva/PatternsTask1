package ru.netology.data;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataUserGenerate {
    private DataUserGenerate() {
    }

    public static String generateDate(int addDays) {
        return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity() {
        String[] cities = new String[]{
                "Майкоп", "Горно-Алтайск", "Уфа", "Улан-Удэ", "Махачкала", "Магас"
        };
        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateName(String local) {
        var faker = new Faker(new Locale(local));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhone(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }

    public  static UserInfo generateUser(String locale) {
        return new UserInfo(generateCity(), generateName(locale), generatePhone(locale));
    }

}
