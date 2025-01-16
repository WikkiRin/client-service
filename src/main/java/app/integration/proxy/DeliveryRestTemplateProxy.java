package app.integration.proxy;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Прокси класс для обращений к микросервису доставки delivery-service, тут АБСТРАКТНЫЕ запросы-шаблоны
 */
@Component
@RequiredArgsConstructor
public class DeliveryRestTemplateProxy {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${service.delivery-service.host}")
    private String host;

    /**
     * Все GET запросы будут проходить через этот метод
     *
     * @param url здесь передаем путь самого запроса
     * @param responseType это ТИП возвращаемого объекта, можно вернуть строчку, тогда передаем String.class,
     *                     можно ничего не возвращать, тогда передаем Void.class
     * @param <T> Это собственно то что вернется в результате запроса, либо строка, число, объект, либо ничего,
     *           зависит от того что передали в responseType
     */
    public <T> ResponseEntity<T> makeGetRequest(String url, Class<T> responseType) {
        return restTemplate.getForEntity(host + url, responseType);
    }

}
