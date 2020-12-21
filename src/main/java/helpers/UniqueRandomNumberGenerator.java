package helpers;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class UniqueRandomNumberGenerator {
    public Integer getRandomNumber(double digitsToGenerate){
            double zerosToAdd = digitsToGenerate-1;
            int lowRange = (int) (1*(Math.pow(10d, zerosToAdd)));
            int maxRange = (int) (9*(Math.pow(10d, zerosToAdd)));
            Random rnd = new Random();
        Integer randomNumber = lowRange + rnd.nextInt(maxRange);
        return randomNumber;
    }
}
