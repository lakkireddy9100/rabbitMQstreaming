package dev.rabbitMQ.streaming.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping(path = "/api/v1/feedback")
public class CustomerFeedbackController {


    @Value("${spring.cloud.stream.bindings.output.destination}")
    String bindingValue;


    @Autowired
    private StreamBridge bridge;


    @ApiOperation(value = "Message", notes = "Returns a feedBack")
    @ApiProperty.Boolean(name = "x-42c-no-authentication", value = true)
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = CustomerFeedbackResponse.class),
            @ApiResponse(code = 0, message = "All Errors", response = StandardErrorResponse.class)
    })
    @GetMapping
    public CustomerFeedbackResponse fetchFeedback() {
        return CustomerFeedbackResponse.builder().meeting("Hello").build();
    }
}
