package helpers;

import org.apache.commons.lang3.RandomStringUtils;

public class UniqueRandomStringGenerator {

    public String getRandomCapitalised() {
        int length=6;
        boolean useLetters=true;
        boolean useNumbers = false;
        String randomStringCapitalised = RandomStringUtils.random(length, useLetters, useNumbers);
        return randomStringCapitalised;
    }
}
