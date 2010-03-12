/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.galaxy.tapd.validation;

import java.beans.PropertyDescriptor;

/**
 *
 * @author Fabricio Tuosto
 */
public abstract class PropertyValidation {

    private final String attribute;

    public PropertyValidation(String attribute){
        this.attribute = attribute;
    }

    public abstract boolean validate(Object bean);

    protected <T> T getValue(Object bean){
        try {
            return (T) retrieveValue(bean);
        } catch (Exception ex) {
            throw new Error(ex);
        }
    }

    private Object retrieveValue(Object bean) throws Exception{
        Object retValue = null;
        final Object[] empty_array = new Object[0];
        PropertyDescriptor descriptor = new PropertyDescriptor(attribute,bean.getClass());
        retValue = descriptor.getReadMethod().invoke(bean, empty_array);
        return retValue;
    }

}
