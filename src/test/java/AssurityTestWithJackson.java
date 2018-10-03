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

        HttpGet get = new HttpGet(BASE_ENDPOINT);
        response = client.execute(get);

        String data_Name = TestDataReader.name;
        boolean data_CanRelist = Boolean.parseBoolean(TestDataReader.canRelist);
        String data_Promotion_Name = TestDataReader.promotionName;
        String data_Promotion_Description = TestDataReader.promotionDescription;

        Assurity assurity = ResponseUtils.unmarshallGeneric(response, Assurity.class);

        String name = assurity.getName();
        boolean canRelist = assurity.getCanRelist();
        List<Promotion> promotionList = assurity.getPromotions();
        boolean matchResult = ResponseUtils.matchNameAndDescription(data_Promotion_Name, data_Promotion_Description, promotionList);

        assertEquals(name, data_Name);
        assertEquals(canRelist, data_CanRelist);
        assertEquals(matchResult, true);
    }
}
