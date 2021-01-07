package com.example.demo_productpage.controller;

import com.example.demo_productpage.dto.ProductpageDTO;
import com.example.demo_productpage.service.ProductpageService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// import io.opentracing.Tracer;

/**
 * @className ProductpageController
 * @description 아래 예제는 Productpage Service 콘트롤러입니다. GET Method와 POST Method를 가지고
 *              있습니다.
 */
@CrossOrigin(origins="*")
@RestController
public class ProductpageController {
    
    Logger logger = LoggerFactory.getLogger(ProductpageController.class);

    @Autowired
    private ProductpageService service;

    // @Autowired
    // private Tracer tracer;

    /**
     * @methodName getProductpageInfo
     * @throws     Exception
     * @description GET Request를 받아서 전체 Productpage 정보를 조회하는 메소드
     */
    @RequestMapping(value="/productpageInfo", method=RequestMethod.GET)
    public ResponseEntity<ProductpageDTO.MainResponse> getProductpageInfo() throws Exception{
        ProductpageDTO.MainResponse responseBody = null;
        try {
            responseBody = service.getProductpageInfo();
        }catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
        return ResponseEntity.ok().body(responseBody);
    }

    /**
     * @methodName getDetailsInfo
     * @throws     Exception
     * @description GET Request를 받아서 전체 해당 prodCode에 대한 Details 정보를 조회하는 메소드
     */
    @RequestMapping(value="/detailsInfo", method=RequestMethod.GET)
    public ResponseEntity<ProductpageDTO.DetailsResponse> getDetailsInfo(@RequestHeader HttpHeaders requestHeader, @RequestParam String prodCode) throws Exception{
        ProductpageDTO.DetailsResponse responseBody = null;
        try {
            responseBody = service.getDetailsInfo(requestHeader, prodCode);
        }catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
        return ResponseEntity.ok().body(responseBody);
    }

    /**
     * @methodName postReviewsInfo
     * @throws     Exception
     * @description GET Request를 받아서 전체 해당 prodCode에 대한 Details 정보를 조회하는 메소드
     */
    @RequestMapping(value="/reviewsInfo", method=RequestMethod.POST)
    public ResponseEntity<ProductpageDTO.reviewsResponse> postReviewsInfo(@RequestHeader HttpHeaders requestHeader, @RequestBody ProductpageDTO.Request request) throws Exception{
        ProductpageDTO.reviewsResponse responseBody = null;
        try {
            responseBody = service.postReviewsInfo(requestHeader, request);
        }catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
        return ResponseEntity.ok().body(responseBody);
    }
}
