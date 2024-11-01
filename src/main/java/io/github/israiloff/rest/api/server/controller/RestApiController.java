package io.github.israiloff.rest.api.server.controller;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.israiloff.rest.api.server.model.ClientModel;
import io.github.israiloff.rest.api.server.model.ServerModel;
import io.github.israiloff.rest.api.server.model.Time;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * Rest API controller.
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/echo")
    public Mono<ClientModel> hello(@RequestParam("data") String data) {
        var startedAt = LocalDateTime.now();
        log.info("Received message: {}", data);
        return Mono.just(new ClientModel(data, new Time(startedAt, LocalDateTime.now())));
    }

    @GetMapping("/delayed")
    public Mono<ClientModel> delayed(@RequestParam("data") String data) {
        log.info("Received message: {}", data);
        return Mono.just(LocalDateTime.now())
                .delayElement(Duration.ofSeconds(5))
                .map(now -> new Time(now, LocalDateTime.now()))
                .map(time -> new ClientModel(data, time));
    }

    @PostMapping("/echo")
    public Mono<ServerModel> echo(@RequestBody ClientModel clientModel) {
        log.info("Received message: {}", clientModel.data());
        return Mono.just(new ServerModel(clientModel.data()));
    }

    @PostMapping("/delayed")
    public Mono<ServerModel> delayed(@RequestBody ClientModel clientModel) {
        log.info("Received message: {}", clientModel.data());
        return Mono.just(LocalDateTime.now())
                .delayElement(Duration.ofSeconds(5))
                .map(now -> new ServerModel(clientModel.data()));
    }

}
