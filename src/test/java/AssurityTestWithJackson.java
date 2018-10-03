import entities.Assurity;
import entities.Promotion;
import org.apache.http.client.methods.HttpGet;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class AssurityTestWithJackson extends BaseClass {

    @Test
    public void matchThreeCriteria() throws IOException {

        // Get response
        HttpGet get = new HttpGet(BASE_ENDPOINT);
        response = client.execute(get);

        // Get test data from TestData file
        String data_Name = TestDataReader.name;
        boolean data_CanRelist = Boolean.parseBoolean(TestDataReader.canRelist);
        String data_Promotion_Name = TestDataReader.promotionName;
        String data_Promotion_Description = TestDataReader.promotionDescription;

        // Format response data to structure
        Assurity assurity = ResponseUtils.unmarshallGeneric(response, Assurity.class);

        // Get related data from structure
        String name = assurity.getName();
        boolean canRelist = assurity.getCanRelist();
        List<Promotion> promotionList = assurity.getPromotions();
        boolean matchResult = matchNameAndDescription(data_Promotion_Name, data_Promotion_Description, promotionList);

        // Assert data result
        assertEquals(name, data_Name);
        assertEquals(canRelist, data_CanRelist);
        assertEquals(matchResult, true);
    }

    // Method to find whether specific name and description are in the same promotion object at the same time
    public static boolean matchNameAndDescription(String name, String description, List<Promotion> promotions) {

        for (int i = 0; i < promotions.size(); i++) {
            if ((promotions.get(i).getName().equals(name)) && (promotions.get(i).getDescription().contains(description))) {
                return true;
            }
        }

        return false;
    }
}
