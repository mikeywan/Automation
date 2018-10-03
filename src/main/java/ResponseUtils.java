import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Promotion;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

public class ResponseUtils {

    public static <T> T unmarshallGeneric(CloseableHttpResponse response, Class<T> clazz) throws IOException {

        String jsonBody = EntityUtils.toString(response.getEntity());

        return new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .readValue(jsonBody, clazz);
    }

    public static boolean matchNameAndDescription(String name, String description, List<Promotion> promotions) {

        for (int i = 0; i < promotions.size(); i++) {
            if ((promotions.get(i).getName().equals(name)) && (promotions.get(i).getDescription().contains(description))) {
                return true;
            }
        }

        return false;
    }
}
