import helpers.UniqueRandomNumberGenerator;
import helpers.UniqueRandomStringGenerator;

import java.util.*;

public class DataGenerator {

    public List<String> generateMockedData(double amountUnits) {
        List personalData = new ArrayList<String>();
        UniqueRandomNumberGenerator urng = new UniqueRandomNumberGenerator();
        UniqueRandomStringGenerator ursg = new UniqueRandomStringGenerator();

        double digitsToGenerateId = 9;
        for (int i = 1; i <= amountUnits; i++) {
            String firstname = ursg.getRandomCapitalised();
            String lastname = ursg.getRandomCapitalised();
            String email = "";
            String city = Cities.getRandom().city;
            Countries country = Cities.valueOfCountry(city);
            Integer personalID = urng.getRandomNumber(digitsToGenerateId);
            email = (firstname + "_" + lastname + i + "@company.com").toLowerCase();
            String person = email + ", " + firstname + ", " + lastname + ", " + city + "," + country + ", " + personalID;
//            System.out.println(person);
            personalData.add(person);
        }


        return personalData;
    }

    public void runGenerating() {

    }
}
