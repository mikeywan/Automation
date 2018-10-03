package entities;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Id",
        "Name",
        "Description",
        "Price",
        "MinimumPhotoCount",
        "OriginalPrice",
        "Recommended"
})
public class Promotion {

    @JsonProperty("Id")
    private Integer id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("Price")
    private Double price;
    @JsonProperty("MinimumPhotoCount")
    private Integer minimumPhotoCount;
    @JsonProperty("OriginalPrice")
    private Double originalPrice;
    @JsonProperty("Recommended")
    private Boolean recommended;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("Price")
    public Double getPrice() {
        return price;
    }

    @JsonProperty("MinimumPhotoCount")
    public Integer getMinimumPhotoCount() {
        return minimumPhotoCount;
    }

    @JsonProperty("OriginalPrice")
    public Double getOriginalPrice() {
        return originalPrice;
    }

    @JsonProperty("Recommended")
    public Boolean getRecommended() {
        return recommended;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }
}
