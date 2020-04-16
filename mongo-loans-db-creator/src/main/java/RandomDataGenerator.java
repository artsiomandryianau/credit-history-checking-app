import java.io.IOException;
import java.util.Random;

public class RandomDataGenerator {

    static Random random;
    static String currentDate;
    static int currentMonth;

    public RandomDataGenerator(Random random) throws IOException {
        this.random = random;
    }

    public String getRandomDateOfLoan(){
        String dateOfBirth = null;
        int mounth = getRandom().nextInt(12) + 1;
        String mounthStr = null;
        String dayStr = null;
        int day = 1;
        int year = getRandom().nextInt(10) + 2010;
        if(mounth == 1 || mounth == 3 || mounth == 5 || mounth == 7 || mounth == 8 || mounth == 10 || mounth == 12) {
            day = getRandom().nextInt(31) + 1;
        } else {
            if(mounth != 2) {
                day = getRandom().nextInt(30) + 1;
            } else {
                if(year % 4 == 0){ day = getRandom().nextInt(29) + 1; } else { day = getRandom().nextInt(28) + 1;}
            }
        }
        if(mounth < 10) { mounthStr = "0" + mounth; } else { mounthStr = mounth + ""; }
        if(day < 10) { dayStr = "0" + day; } else { dayStr = day + ""; }
        dateOfBirth = year + "-" + mounthStr + "-" + dayStr;
        currentDate = dateOfBirth;
        return dateOfBirth;
    }


    public int getRandomMonth(){
        int[] mount = {3, 6, 12, 18, 24, 36, 48, 60, 120, 240};
        currentMonth = mount[getRandom().nextInt(10)];
        return currentMonth;
    }

    public boolean getCoinFlip(){
        return getRandom().nextBoolean();
    }

    public int getRandomAmount(){
        if(currentMonth<=12) {
            return getRandom().nextInt(3000) + 5000;
        } else {
            if(currentMonth > 60){
                return getRandom().nextInt(200000) + 200000;
            } else {
                return getRandom().nextInt(192000) + 8000;
            }
        }
    }

    public String getRandomPhoneNumber(){
        String phoneNumber = "";
        int number = getRandom().nextInt(4)  + 5;
        phoneNumber += number;
        number = getRandom().nextInt(90) + 10;
        phoneNumber += number + "-";
        number = getRandom().nextInt(900) + 100;
        phoneNumber += number + "-";
        number = getRandom().nextInt(900) + 100;
        phoneNumber += number;


        return phoneNumber;
    }

    public static Random getRandom() {
        return random;
    }
}
