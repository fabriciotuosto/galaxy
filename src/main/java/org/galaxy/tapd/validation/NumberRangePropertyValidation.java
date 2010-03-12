/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.galaxy.tapd.validation;

import org.apache.commons.lang.math.NumberRange;

/**
 *
 * @author Fabricio Tuosto
 */
public class NumberRangePropertyValidation extends PropertyValidation{
    
    private final NumberRange range;

    public NumberRangePropertyValidation(String property,NumberRange range) {
        super(property);
        this.range = range;
    }

    @Override
    public boolean validate(Object bean) {
        Number value = getValue(bean);
        return range.containsNumber(value);
    }


}
