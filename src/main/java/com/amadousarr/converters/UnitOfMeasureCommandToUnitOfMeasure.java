package com.amadousarr.converters;

import com.amadousarr.commands.UnitOfMeasureCommand;
import com.amadousarr.domain.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure> {
   @Synchronized
   @Nullable
    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommand source) {
       if (source == null) {
           return null;
       }
        final UnitOfMeasure uom = new UnitOfMeasure();
       uom.setId(source.getId());
       uom.setDescriptor(source.getDescriptor());
       return uom;
    }


}
