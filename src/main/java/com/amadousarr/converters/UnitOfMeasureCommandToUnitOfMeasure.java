package com.amadousarr.converters;

import com.amadousarr.commands.UnitOfMeasureCommand;
import com.amadousarr.domain.UnitOfMeasure;
import org.springframework.core.convert.converter.Converter;

public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure> {
    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommand source) {
        return null;
    }

    @Override
    public <U> Converter<UnitOfMeasureCommand, U> andThen(Converter<? super UnitOfMeasure, ? extends U> after) {
        return Converter.super.andThen(after);
    }
}
