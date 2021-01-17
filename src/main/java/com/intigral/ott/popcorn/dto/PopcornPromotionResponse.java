package com.intigral.ott.popcorn.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Creating POJO for validating Popcorn API Response Body.
 */
@Builder@Data@NoArgsConstructor@AllArgsConstructor@JsonIgnoreProperties(ignoreUnknown = true)
public class PopcornPromotionResponse {

   private List<Promotion> promotions;

    @Builder@Data@NoArgsConstructor@AllArgsConstructor@JsonIgnoreProperties(ignoreUnknown = true)
   public static class Promotion{
       String promotionId;
       Integer orderId;
       List<String>promoArea;
       String promoType;
       boolean showPrice;
       boolean showText;
       LocalizedText localizedTexts;
       List<Properties> properties;
       List<Image> images;


   }
    @Builder@Data@NoArgsConstructor@AllArgsConstructor@JsonIgnoreProperties(ignoreUnknown = true)
   public static class LocalizedText{
        List<String> ar;
        List<String>en;
   }
    @Builder@Data@NoArgsConstructor@AllArgsConstructor@JsonIgnoreProperties(ignoreUnknown = true)
   public static class Properties{
        String year;
        String programType;
        String currency;
        String programAvailabilityId;
        Rating rating;
        List<String> categories;
        List<String> genre;
        ProgramDescription programDescription;
        String duration;
   }
    @Builder@Data@NoArgsConstructor@AllArgsConstructor@JsonIgnoreProperties(ignoreUnknown = true)
   public static class Rating{
        String scheme;
        String rating;
   }
    @Builder@Data@NoArgsConstructor@AllArgsConstructor@JsonIgnoreProperties(ignoreUnknown = true)
   public static class ProgramDescription{
        String ar;
        String en;
   }
    @Builder@Data@NoArgsConstructor@AllArgsConstructor@JsonIgnoreProperties(ignoreUnknown = true)
   public static class Image{
        String id;
        String url;
        Integer width;
        Integer height;
   }
}
