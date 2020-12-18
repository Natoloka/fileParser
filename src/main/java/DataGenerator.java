import helpers.UniqueRandomNumberGenerator;
import helpers.UniqueRandomStringGenerator;

import java.util.*;

public class DataGenerator {

    public List<String> generateMockedData(double amountUnits){

        UniqueRandomNumberGenerator urng = new UniqueRandomNumberGenerator();
        UniqueRandomStringGenerator ursg = new UniqueRandomStringGenerator();

        double digitsToGenerateId = 9;

        String firstname = ursg.getRandomCapitalised();
        String lastname = ursg.getRandomCapitalised();
        String email = "";
        String city = Cities.getRandom().getTitle();
        String country = Countries.getRandom().getTitle();
        List<Integer> personalID = urng.getRandomNumber(digitsToGenerateId, amountUnits);

        List personalData = new ArrayList<String>();

        for (int i=1; i<=amountUnits; i++){
            email = (firstname +"_"+ lastname + i + "@company.com").toLowerCase();

            String person = email+", "+firstname+", "+lastname+", "+city+","+country+", "+personalID.get(i);
            System.out.println(person);
            personalData.add(person);
        }


        return personalData;
    }

    public void runGenerating(){

    }
}
