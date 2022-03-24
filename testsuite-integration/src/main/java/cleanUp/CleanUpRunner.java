package cleanUp;

import com.assignment.whiskeyapi.models.Whiskey;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intuit.karate.junit5.Karate;
import com.intuit.karate.junit5.Karate.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CleanUpRunner {

    final String defaultData = "[{\n" +
            "    \"id\": 1,\n" +
            "    \"name\": \"Jameson\",\n" +
            "    \"optionalName\": \"Black Barrel\",\n" +
            "    \"origin\": \"Ireland\",\n" +
            "    \"category\": \"Irish\",\n" +
            "    \"price\": 25.0,\n" +
            "    \"description\": \"Charring is an age-old method for invigorating barrels to intensify the taste. Jameson Black Barrel is our tribute to our coopers, who painstakingly give their bourbon barrels an additional charring to reveal their untold richness and complexity. Because \"\n" +
            "}, {\n" +
            "    \"id\": 2,\n" +
            "    \"name\": \"Tullamore Dew\",\n" +
            "    \"optionalName\": \"12 Year Old Special Reserve\",\n" +
            "    \"origin\": \"Ireland\",\n" +
            "    \"category\": \"Irish\",\n" +
            "    \"price\": 50.0,\n" +
            "    \"description\": \"Tullamore D.E.W. 12 Year Old Special Reserve offers a spice flavour with a robust yet creamy body wrapped in a definite chocolaty note.\"\n" +
            "}, {\n" +
            "    \"id\": 3,\n" +
            "    \"name\": \"Lagavulin\",\n" +
            "    \"optionalName\": \"16 Year Old\",\n" +
            "    \"origin\": \"Scotland\",\n" +
            "    \"category\": \"Scotch\",\n" +
            "    \"price\": 97.5,\n" +
            "    \"description\": \"A legendary malt that is on many people's most wanted list. The 16 year old is a true classic from Islay which combines pungent smoke along with complex flavours of dried fruits, spice, malt, vanilla and oak.\"\n" +
            "}, {\n" +
            "    \"id\": 4,\n" +
            "    \"name\": \"Bulleit\",\n" +
            "    \"optionalName\": \"Rye\",\n" +
            "    \"origin\": \"USA\",\n" +
            "    \"category\": \"Bourbon\",\n" +
            "    \"price\": 50.0,\n" +
            "    \"description\": \"Bulleit Rye is an award-winning, straight rye whiskey with a character of unparalleled spice and complexity. Released in 2011, it continues to enjoy recognition as one of the highest quality ryes available.\"\n" +
            "}]\n";

    @Test
    public Karate runTest() {
        final List<Whiskey> whiskeyList = readData(defaultData);
        // get and delete current data
        // add default data
        return Karate.run("./CleanUp").relativeTo(getClass());
    }

    public void getData() {

    }

    public void deleteData() {

    }

    public void addData() {

    }

    private List<Whiskey> readData(final String uri) {
        List<Whiskey> whiskeyList = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            whiskeyList = mapper.readValue(uri, new TypeReference<List<Whiskey>>(){});
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return whiskeyList;
    }

}
