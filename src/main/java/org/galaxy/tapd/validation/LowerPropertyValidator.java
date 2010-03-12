/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.galaxy.tapd.validation;

/**
 *
 * @author Fabricio Tuosto
 */
public class LowerPropertyValidator extends PropertyValidation{
    private final Comparable reference;

    public LowerPropertyValidator(String property,Comparable reference) {
        super(property);
        this.reference = reference;
    }

    @Override
    public boolean validate(Object bean) {
        Object value = getValue(bean);
        return reference.compareTo(value) > 1;
    }

}
