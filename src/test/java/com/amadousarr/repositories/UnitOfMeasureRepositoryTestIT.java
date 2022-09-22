package com.amadousarr.repositories;

import com.amadousarr.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Optional;

import static org.junit.gen5.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class UnitOfMeasureRepositoryTestIT {
    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @BeforeEach
    public void setUp() throws Exception {
    }

    @Test
    @DirtiesContext
    public void findByDescriptor() {
        Optional<UnitOfMeasure> uomOptional =
                unitOfMeasureRepository.findByDescriptor("Teaspoon");
        assertEquals("Teaspoon",uomOptional.get().getDescriptor());
    }
}