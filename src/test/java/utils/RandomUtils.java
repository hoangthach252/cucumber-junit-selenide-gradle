package utils;

import com.github.javafaker.Faker;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RandomUtils {


    /**
     * You can use com.github.javafaker.Faker
     * to generate many Random Data types such as fullName, firstName, lastName, Address...
     */

    public static String getRandomName() {
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMMhhmmss");
        String strDate = formatter.format(new Date());
        return strDate.concat(getRandomNumber());
    }

    /**
     * Generate Random numer with 4 digits length.
     */
    public static String getRandomNumber() {
        SecureRandom random = new SecureRandom();
        return new BigInteger(16, random).toString(1).toLowerCase();
    }

    public static String getRandomFullName() {
        Faker faker = new Faker();
        return faker.name().fullName();
    }

    public static String getRandomEmail() {
        return "ZenAuto" + RandomUtils.getRandomName() + "@yopmail.com";
    }
}
