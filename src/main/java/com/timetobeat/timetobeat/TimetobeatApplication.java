package com.timetobeat.timetobeat;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

@SpringBootApplication
public class TimetobeatApplication {
	public static void main(String[] args) {
		SpringApplication.run(TimetobeatApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	private static final String BASE_URL = "https://api.igdb.com/v4/";
	@Bean
	public WebClient webClientWithTimeout() {

		HttpClient httpClient = HttpClient.create()
				.responseTimeout(Duration.ofSeconds(2))
				.doOnConnected(conn -> conn
						.addHandlerLast(new ReadTimeoutHandler(10))
						.addHandlerLast(new WriteTimeoutHandler(10)));


		return WebClient.builder()
				.baseUrl(BASE_URL)
				.defaultHeaders(httpHeaders -> {
					httpHeaders.set("Client-ID", "f4ps5a4fbpf1jcxjphi555jn1q4xci");
					httpHeaders.set("Authorization", "Bearer g1dcbty64xivi1jitmnb15kmlxslwv");
				})
				.clientConnector(new ReactorClientHttpConnector(httpClient))
				.build();
	}

}
