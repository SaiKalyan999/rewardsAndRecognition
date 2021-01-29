package com.nineleaps.rewardandrecognition.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.FeatureDescriptor;
import java.util.stream.Stream;

public class DtoUtil {
    public static <T, S> S convertByCopy(T source, Class<S> clazz) {
        try {
            S objNew = clazz.newInstance();
            BeanUtils.copyProperties(source, objNew, getNullPropertyNames(source));
            return objNew;
        } catch (IllegalAccessException
                | InstantiationException e) {
            return null;
        }
    }

    private static String[] getNullPropertyNames(Object source) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
        return Stream.of(wrappedSource.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null)
                .toArray(String[]::new);
    }
}
