
package com.example.helloSpring.model;

import java.util.LinkedHashMap;
import java.util.Map;
// import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "date",
   // "explanation",
        "explanation",
    "hdurl",
    "media_type",
    "service_version",
    "title",
    "url"
})
// @Generated("jsonschema2pojo")





@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Apod {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;




    @JsonProperty("date")
    private String date;

    @JsonProperty("explanation")
    @Column(columnDefinition = "Text")
    private String explanation;

    @JsonProperty("hdurl")
    private String hdurl;
    @JsonProperty("media_type")
    private String mediaType;
    @JsonProperty("service_version")
    private String serviceVersion;
    @JsonProperty("title")
    private String title;
    @JsonProperty("url")
    private String url;

 /*  @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();*/


    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("explanation")
    public String getExplanation() {
        return explanation;
    }

    @JsonProperty("explanation")
    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    @JsonProperty("hdurl")
    public String getHdurl() {
        return hdurl;
    }

    @JsonProperty("hdurl")
    public void setHdurl(String hdurl) {
        this.hdurl = hdurl;
    }

    @JsonProperty("media_type")
    public String getMediaType() {
        return mediaType;
    }

    @JsonProperty("media_type")
    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    @JsonProperty("service_version")
    public String getServiceVersion() {
        return serviceVersion;
    }

    @JsonProperty("service_version")
    public void setServiceVersion(String serviceVersion) {
        this.serviceVersion = serviceVersion;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    /*@JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
*/
}
