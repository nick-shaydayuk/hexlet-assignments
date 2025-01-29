package exercise;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import kong.unirest.Unirest;
import io.javalin.Javalin;

class SessionTest {

    private Javalin app;
    private String baseUrl;

    @BeforeEach
    public void beforeAll() {
        app = App.getApp();
        app.start(0);
        int port = app.port();
        baseUrl = "http://localhost:" + port;
    }

    @AfterEach
    public void afterAll() {
        app.stop();
    }


}
