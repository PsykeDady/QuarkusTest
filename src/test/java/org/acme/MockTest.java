package org.acme;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import co.psyke.repositories.BringRepository;
import co.psyke.services.BringService;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
class MockTest {
    
    @Inject
    BringService bringService;

    @InjectMock
    BringRepository bringRepository;

    @Test
    void mockTestHello () {
        Mockito.when(bringRepository.bringString()).thenReturn("Bang Bang Born");

        assertEquals(bringService.getBringService(), "Bang Bang Born");
    }
}
