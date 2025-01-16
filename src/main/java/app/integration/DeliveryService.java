package app.integration;

import app.integration.proxy.DeliveryRestTemplateProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Класс для общения между сервисами, здесь прописываются КОНКРЕТНЫЕ запросы к сервису delivery
 */
@Service
@RequiredArgsConstructor
public class DeliveryService {

    private final DeliveryRestTemplateProxy deliveryRestTemplateProxy;

    public String getAnswer(){
        ResponseEntity<String> response = deliveryRestTemplateProxy.makeGetRequest("/delivery/answer", String.class);
        return response.getBody();
    }
}
