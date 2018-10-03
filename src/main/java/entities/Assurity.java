package entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Name",
        "CanRelist",
        "Promotions"
})
public class Assurity {

    @JsonProperty("Name")
    private String name;
    @JsonProperty("CanRelist")
    private Boolean canRelist;
    @JsonProperty("Promotions")
    private List<Promotion> promotions = new ArrayList<Promotion>();

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("CanRelist")
    public Boolean getCanRelist() {
        return canRelist;
    }

    @JsonProperty("Promotions")
    public List<Promotion> getPromotions() {
        return promotions;
    }
}
