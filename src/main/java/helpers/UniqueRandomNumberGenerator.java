package helpers;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class UniqueRandomNumberGenerator {
    public List getRandomNumber(double digitsToGenerate, double amountOfUnits){
        int randomNumber;
        List list = new ArrayList();
        for (double i=0; i<=amountOfUnits; i++){
            double zerosToAdd = digitsToGenerate-1;
            int lowRange = (int) (1*(Math.pow(10d, zerosToAdd)));
            int maxRange = (int) (9*(Math.pow(10d, zerosToAdd)));
            Random rnd = new Random();
            randomNumber = lowRange + rnd.nextInt(maxRange);
            list.add(randomNumber);
        }
        return list;
    }
}
