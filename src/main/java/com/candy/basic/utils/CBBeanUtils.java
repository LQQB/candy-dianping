package com.candy.basic.utils;

import com.google.common.collect.Sets;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Classname CBBeanUtils
 * @Description bean 工具類
 * @Author liqb
 * @Date 2021/1/3 22:44
 */
public class CBBeanUtils {


    public static <T, F> T beanToForm(F bean, Class<T> formClass) {
        Object form = null;

        try {
            form = formClass.newInstance();
            BeanUtils.copyProperties(bean, form);
            return (T) form;
        } catch (Exception var4) {
            var4.printStackTrace();
            return (T) form;
        }
    }

    /**
     * 将给定的beans(集合)转为form集合,若beans为空或者长度为0则返回null
     * @param beans	bean集合
     * @param formClass form的Class类型，用于实例化
     * @return form的集合
     */
    public static <T,F> List<T> parseBeansToForms(List<F> beans, Class<T> formClass){
        List<T> forms= new ArrayList<>();
        if(!CollectionUtils.isEmpty(beans)){
            try {
                for (F bean : beans) {
                    T form = formClass.newInstance();
                    BeanUtils.copyProperties(bean, form);
                    forms.add(form);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return forms;
    }

    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = Sets.newHashSet();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

}
