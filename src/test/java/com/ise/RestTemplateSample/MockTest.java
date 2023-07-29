package com.ise.RestTemplateSample;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;

public class MockTest {
    @InjectMocks
    private PostSample postSample;

    @BeforeEach
    public void beforeMock() {
        MockitoAnnotations.openMocks(postSample);
        System.out.println("testの開始");
    }

    @AfterEach
    public void afterMock() {
        System.out.println("testの終了");
    }

    @Test
    void test1() {
        postSample.sendExecuteRequest(any());
    }
}
