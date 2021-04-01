package com.example.demo_productpage.aop;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.example.demo_productpage.dto.ProductpageDTO;
import com.example.demo_productpage.kafka.Producer;
import com.example.demo_productpage.util.CommUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import io.opentracing.Span;
import io.opentracing.Tracer;

@Aspect
@Component
public class ProductpageSpanAspect {

    private final static String[] headers_to_propagate = {
        // All applications should propagate x-request-id. 
        "x-request-id",

        // Lightstep tracing header. Propagate this if you use lightstep tracing in Istio 
        "x-ot-span-context",

        // Datadog tracing header. Propagate these headers if you use Datadog tracing.
        "x-datadog-trace-id", "x-datadog-parent-id", "x-datadog-sampling-priority",

        // W3C Trace Context. Compatible with OpenCensusAgent and Stackdriver Istio configurations.
        "traceparent", "tracestate",

        // Cloud trace context. Compatible with OpenCensusAgent and Stackdriver Istio configurations.
        "x-cloud-trace-context",

        // Grpc binary trace context.
        "grpc-trace-bin",

        // b3 trace headers. Compatible with Zipkin, OpenCensusAgent, and Stackdriver Istio configurations. 
        "x-b3-traceid", "x-b3-spanid", "x-b3-parentspanid", "x-b3-sampled", "x-b3-flags",

        // Application-specific headers to forward.
        "end-user", "user-agent"};
    
    @Autowired
    private Tracer tracer;

    Logger logger = LoggerFactory.getLogger(ProductpageSpanAspect.class);

    private String kafkaUUID = null;

    @Autowired
    private Environment env;

    // @Autowired
    // public SpanAspect(Tracer tracer){
    //     this.tracer = tracer;
    // }

    /**
     * @methodName  spanLogging
     * @return      Object
     * @description DemoOpentracingApplication Class에서 Bean으로 등록한 tracer를 사용하여 Span을 생성하고 종료합니다.
     *              com.example.demo_productpage.controller.EmployeeController.*(..) 패턴으로 Around AOP를 적용합니다.
     */    
    @Around("execution(* com.example.demo_productpage.controller.ProductpageController.*(..))")
    public Object spanLogging(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("[                             spanLogging Start                                ]");

        /*
        // Opentracing Span Test
        Span span = tracer.buildSpan(pjp.getSignature().getName()).start();
        Object result = pjp.proceed();
        span.finish();
        Span span = tracer.buildSpan(pjp.getSignature().getName()).start();
        span.finish();
        */
        /*
        Span parentSpan = tracer.scopeManager().activeSpan();
        Span spanPhase1 = tracer.buildSpan("spanPhase_1").asChildOf(parentSpan).start();
        Object result = pjp.proceed();
        spanPhase1.log("                                                SpanPhase1 log");
        spanPhase1.finish();
        */
        
        Span parentSpan = tracer.scopeManager().activeSpan();
        Span AOPSpan = tracer.buildSpan(pjp.getSignature().getName()).asChildOf(parentSpan).start();
        Object result = pjp.proceed();
        AOPSpan.finish();
        
        logger.info("[                             AOPSpan End                                ]");
        return result;
    }

    /**
     * @methodName  makeHttpHeaders
     * @return      org.springframework.http.HttpHeaders
     * @description headers_to_propagate Array에 명시된 Headers 정보를 가지고 Jaeger Trace Propagation을 위해서 HttpHeaders를 Exchange합니다.
     */
    public HttpHeaders makeHttpHeaders(HttpHeaders httpHeaders) {
        final HttpHeaders headers = new HttpHeaders();
        for (String header : headers_to_propagate) {
            if (httpHeaders.containsKey(header)) {
                logger.info("==========================  [ AOP:makeHttpHeaders ] KEY : " + header + ", VALUE : "
                        + httpHeaders.get(header).get(0));
                headers.add(header, httpHeaders.get(header).get(0));
            }
        }

        return headers;
    }

    /**
     * @methodName  headerExchangeGet
     * @return      Object
     * @description ProceedingJoinPoint에서 Args로 넘어온 HttpHeaders를 가져와서 makeHttpHeaders Method를 사용하여 Http Header 정보를 Exchange한다.
     *              com.example.demo_productpage.controller.ProductpageController.get*(..) 패턴으로 Around AOP를 적용합니다.
     */    
    @Around("execution(* com.example.demo_productpage.controller.ProductpageController.get*(..))")
    public Object headerExchangeGet(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("[                             headerExchangeGet Start                                ]");
        HttpHeaders headers = null;
        Object result = null;
        String prodCode = null;

        // getMehtod의 Type : all / single
        for(Object obj : pjp.getArgs()) {
            if(obj instanceof HttpHeaders) {
                logger.info("==========================  [ headerExchangeGet : PJP HttpHeaders ] ");
                headers = makeHttpHeaders((HttpHeaders) obj);
            }

            if(obj instanceof String) prodCode = (String) obj;
        }
        // Span span = tracer.buildSpan(pjp.getSignature().getName()).start();
        if("getDetailsInfo".equals(pjp.getSignature().getName())) {
            logger.info("==========================  [ headerExchangeGet : PJP Method Name ] getDetailsInfo");
            Object[]  args = {headers, prodCode};
            result = pjp.proceed(args);
        } else if("getProductpageInfo".equals(pjp.getSignature().getName())) {
            logger.info("==========================  [ headerExchangeGet : PJP Method Name ] getPrpductpageInfo");
            Object[]  args = {headers};
            result = pjp.proceed(args);
        }
        // Object[] args = {headers};
        // result = pjp.proceed(args);
        // span.finish();
        
        ResponseEntity<Object> entity = (ResponseEntity<Object>) result;
        headers = makeHttpHeaders(entity.getHeaders());
        logger.info("[                             headerExchangeGet End                               ]");
        return ResponseEntity.ok().headers(headers).body(entity.getBody());
    }


    /**
     * @methodName  headerExchangePost
     * @return      Object
     * @description ProceedingJoinPoint에서 Args로 넘어온 HttpHeaders를 가져와서 makeHttpHeaders Method를 사용하여 Http Header 정보를 Exchange한다.
     *              com.example.demo_productpage.controller.ProductpageController.post*(..) 패턴으로 Around AOP를 적용합니다.
     */    
    @Around("execution(* com.example.demo_productpage.controller.ProductpageController.post*(..))")
    public Object headerExchangePost(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("[                             headerExchangePost Start                                ]");
        HttpHeaders headers = null;
        ProductpageDTO.Request request = null;

        for(Object obj : pjp.getArgs()) {
            logger.info("==========================  [ headerExchangePost : PJP Args ] " + obj.toString());
            if(obj instanceof HttpHeaders) {
                logger.info("==========================  [ headerExchangePost : PJP HttpHeaders ] ");
                headers = makeHttpHeaders((HttpHeaders) obj);
            }

            if(obj instanceof ProductpageDTO.Request) {
                request = (ProductpageDTO.Request) obj;
            }
        }
 
        // Span span = tracer.buildSpan(pjp.getSignature().getName()).start();
        Object[] args = {headers, request};
        Object result = pjp.proceed(args);
        // span.finish();

        ResponseEntity<Object> entity = (ResponseEntity<Object>) result;
        headers = makeHttpHeaders(entity.getHeaders());
        logger.info("[                             headerExchangePost End                               ]");
        return ResponseEntity.ok().headers(headers).body(entity.getBody());
    }


    /**
     * @methodName  messageBeforeQueueLogging
     * @return      void
     * @description http request header, body 값으로 kafka msg produce
     *              com.example.demo_productpage.controller.ProductpageController.*(..) 패턴으로 Before AOP를 적용합니다.
     */
    @Before("execution(* com.example.demo_productpage.controller.ProductpageController.*(..))")
    public void messageBeforeQueueLogging(JoinPoint pjp) throws Throwable {
        logger.info("[                             Kafka Before Logging Start                                ]");
        logger.info("============================  [ AOP:messageBeforeQueueLogging ]");
        logger.info(kafkaUUID);

        kafkaUUID = CommUtil.genUUID();

        String Msg = "";
        String headersString = "";
        String bodyString = "";
        String kafkaData = "";
        LocalDateTime currentDateTime = LocalDateTime.now();
        ObjectMapper mapper = new ObjectMapper();

        kafkaData = "[ " + currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + " ]|"
                  + "[ " + env.getProperty("kafka.service.code") + " ]|"
                  + "[ " + pjp.getSignature().getName() + " ]|"
                  + "[ " + kafkaUUID + " ]|";


        for(Object obj : pjp.getArgs()) {
            if(obj instanceof HttpHeaders) {
                headersString = kafkaData + obj.toString();
            }

            if(obj instanceof ProductpageDTO.Request) {
                bodyString = mapper.writeValueAsString(obj);
            }
        }

        Msg = headersString +" "+ bodyString;
        logger.info(Msg);
        Producer.produce(env.getProperty("kafka.brokers"), env.getProperty("kafka.topic"), Msg);

        logger.info("[                             Kafka Before Logging END                                ]");

    }


    /**
     * @methodName  messageAfterQueueLogging
     * @return      null
     * @description http request header, body 값으로 kafka msg produce
     *              com.example.demo_productpage.controller.ProductpageController.*(..) 패턴으로 Before AOP를 적용합니다.
     */
    @After("execution(* com.example.demo_productpage.controller.ProductpageController.*(..))")
    public void messageAfterQueueLogging(JoinPoint pjp) throws Throwable {
        logger.info("[                             Kafka After Logging Start                                ]");
        logger.info("============================  [ AOP:messageAfterQueueLogging ]");
        logger.info(kafkaUUID);

        String Msg = "";
        String headersString = "";
        String bodyString = "";
        String kafkaData = "";
        LocalDateTime currentDateTime = LocalDateTime.now();
        ObjectMapper mapper = new ObjectMapper();

        kafkaData = "[ " + currentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + " ]|"
                  + "[ " + env.getProperty("kafka.service.code") + " ]|"
                  + "[ " + pjp.getSignature().getName() + " ]|"
                  + "[ " + kafkaUUID + " ]|";


        for(Object obj : pjp.getArgs()) {
            if(obj instanceof HttpHeaders) {
                headersString = kafkaData + obj.toString();
            }

            if(obj instanceof ProductpageDTO.Request) {
                bodyString = mapper.writeValueAsString(obj);
            }
        }

        Msg = headersString +" "+ bodyString;
        logger.info(Msg);
        Producer.produce(env.getProperty("kafka.brokers"), env.getProperty("kafka.topic"), Msg);

        logger.info("[                             Kafka After Logging END                                ]");

    }

}