/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.galaxy.tapd.validation;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import org.apache.commons.lang.math.NumberRange;
import org.galaxy.tapd.celestialbodys.planetas.PlanetaRocoso.TipoSuelo;

/**
 *
 * @author Fabricio Tuosto
 */
public class BeanValidation {
    
    private final Object bean;
    private final List<PropertyValidation> validations;
    
    private BeanValidation(BeanValidationBuilder builder) {
        this.bean = builder.bean;
        this.validations = builder.validations;
    }

    public static BeanValidationBuilder newBeanValidation(Object bean){
        return new BeanValidationBuilder(bean);
    }

    public boolean isValidBean() {
        boolean isValid = true;
        for(PropertyValidation validation : validations){
            isValid = isValid && validation.validate(bean);
        }
        return isValid;
    }

    public static class BeanValidationBuilder{

        private final Object bean;
        private List<PropertyValidation> validations;

        private BeanValidationBuilder(Object bean) {
            this.bean = bean;
            this.validations = new ArrayList<PropertyValidation>(20);
        }

        public BeanValidation build(){
            return new BeanValidation(this);
        }

        public BeanValidationBuilder validateMenor(String string, Comparable reference) {
           validations.add(new LowerPropertyValidator(string, reference));
           return this;
        }

        public BeanValidationBuilder validateMayor(String string,Comparable reference) {
           validations.add(new GreaterPropertyValidator(string, reference));
           return this;
        }

        public BeanValidationBuilder validateRange(String string, NumberRange range) {
           validations.add(new NumberRangePropertyValidation(string, range));
           return this;
        }

        public BeanValidationBuilder validateEnum(String string, EnumSet<TipoSuelo> set) {
            validations.add(new EnumPropertyValidator(string, set));
            return this;
        }
    }
}
