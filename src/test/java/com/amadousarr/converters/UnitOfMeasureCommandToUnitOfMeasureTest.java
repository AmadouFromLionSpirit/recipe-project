package com.amadousarr.converters;

import com.amadousarr.commands.UnitOfMeasureCommand;
import com.amadousarr.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.gen5.api.Assertions.*;

class UnitOfMeasureCommandToUnitOfMeasureTest {
    public static final String DESCRIPTIOR = "descriptor";
    public static final Long LONG_VALUE = 1L;

    UnitOfMeasureCommandToUnitOfMeasure converter;

  @BeforeEach
    void setUp() {
      converter = new UnitOfMeasureCommandToUnitOfMeasure();
    }

    @Test
    public void testNullParameter() {
      assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
      assertNotNull(converter.convert(new UnitOfMeasureCommand()));
    }

    @Test
    void convert() {
    UnitOfMeasureCommand command = new UnitOfMeasureCommand();
    command.setId(LONG_VALUE);
    command.setDescriptor(DESCRIPTIOR);
    UnitOfMeasure uom = converter.convert(command);
    assertNotNull(uom);
    assertEquals(LONG_VALUE, uom.getId());
    assertEquals(DESCRIPTIOR, uom.getDescriptor());
    }
}