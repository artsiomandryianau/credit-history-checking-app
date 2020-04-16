import com.mongodb.*;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        RandomDataGenerator randomDataGenerator = new RandomDataGenerator(new Random());
        try {

            MongoClient mongo = new MongoClient("localhost", 27017);
            DB db = mongo.getDB("admin");
            DBCollection table = db.getCollection("loans");
            for(int i = 1; i <= 2000; i++) {
                BasicDBObject document = new BasicDBObject();
                document.put("loan_id", i);
                document.put("client_id", randomDataGenerator.getRandomForeignKey(1,500));
                document.put("loan_is_payed", randomDataGenerator.getCoinFlip());
                document.put("date_loan_was_taken", randomDataGenerator.getRandomDateOfLoan());
                document.put("loan_number_month_back", randomDataGenerator.getRandomMonth());
                document.put("loan_amount", randomDataGenerator.getRandomAmount());
                table.insert(document);
            }


            /**** Find and display ****/
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("loan_id", 450);

            DBCursor cursor = table.find(searchQuery);

            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }


            /**** Done ****/
            System.out.println("Done");


        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (MongoException e) {
            e.printStackTrace();
        }

    }
}





