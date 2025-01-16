package app.controller;

import app.integration.DeliveryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ClientController {

    private final DeliveryService deliveryService;

    @GetMapping("/client/answer")
    public String getAnswer() {
        return deliveryService.getAnswer();
    }

}
