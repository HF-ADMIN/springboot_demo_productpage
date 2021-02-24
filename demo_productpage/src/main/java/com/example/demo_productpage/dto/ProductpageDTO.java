package com.example.demo_productpage.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class ProductpageDTO{
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request implements TInfoDTO {
        private String cudFlag;
        private String prodCode;
        private String reviewsId;
        private String contents;
        private Integer rating;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Review implements TInfoDTO {
        private String reviewsId;
        private String contents;
        private Integer rating;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Product implements TInfoDTO {
        private String prodCode;
        private String prodName;
        private String prodIntro;
        private String prodImg;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MainResponse implements TInfoDTO {
        private Integer resultCode;
        private List<ProductpageDTO.Product> productList;
    }

    @Getter
    @Setter
    @AllArgsConstructor 
    @NoArgsConstructor
    public static class DetailsResponse implements TInfoDTO {
        private String prodCode;
        private String prodName; 
        private String detailImg;
        private Integer resultCode;
        private List<ProductpageDTO.Review> reviewList;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class reviewsResponse implements TInfoDTO {
        private Integer resultCode;
    }
}
