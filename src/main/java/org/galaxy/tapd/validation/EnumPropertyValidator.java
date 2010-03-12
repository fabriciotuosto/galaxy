/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.galaxy.tapd.validation;

import java.util.EnumSet;

/**
 *
 * @author Fabricio Tuosto
 */
public class EnumPropertyValidator extends PropertyValidation{

    private final EnumSet set;

    public EnumPropertyValidator(String property,EnumSet set){
        super(property);
        this.set = set;
    }

    @Override
    public boolean validate(Object bean) {
        Object value = getValue(bean);
        return set.contains(value);
    }

}
