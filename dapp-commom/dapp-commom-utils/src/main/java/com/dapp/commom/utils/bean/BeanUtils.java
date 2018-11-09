package com.dapp.commom.utils.bean;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class BeanUtils {

    public static final Set<Class<?>> baseTypeSet = new HashSet<Class<?>>(0);
    static {
        baseTypeSet.add(byte.class);
        baseTypeSet.add(short.class);
        baseTypeSet.add(int.class);
        baseTypeSet.add(long.class);
        baseTypeSet.add(float.class);
        baseTypeSet.add(double.class);
        baseTypeSet.add(char.class);
        baseTypeSet.add(boolean.class);
        baseTypeSet.add(void.class);
        baseTypeSet.add(byte[].class);
        baseTypeSet.add(short[].class);
        baseTypeSet.add(int[].class);
        baseTypeSet.add(long[].class);
        baseTypeSet.add(float[].class);
        baseTypeSet.add(double[].class);
        baseTypeSet.add(char[].class);
        baseTypeSet.add(boolean[].class);
        baseTypeSet.add(Byte.class);
        baseTypeSet.add(Short.class);
        baseTypeSet.add(Integer.class);
        baseTypeSet.add(Long.class);
        baseTypeSet.add(Float.class);
        baseTypeSet.add(Double.class);
        baseTypeSet.add(Character.class);
        baseTypeSet.add(Boolean.class);
        baseTypeSet.add(Void.class);
        baseTypeSet.add(Enum.class);
        baseTypeSet.add(String.class);
        baseTypeSet.add(Date.class);
        baseTypeSet.add(BigInteger.class);
        baseTypeSet.add(BigDecimal.class);
        baseTypeSet.add(Byte[].class);
        baseTypeSet.add(Short[].class);
        baseTypeSet.add(Integer[].class);
        baseTypeSet.add(Long[].class);
        baseTypeSet.add(Float[].class);
        baseTypeSet.add(Double[].class);
        baseTypeSet.add(Character[].class);
        baseTypeSet.add(Boolean[].class);
        baseTypeSet.add(Void[].class);
        baseTypeSet.add(Enum[].class);
        baseTypeSet.add(String[].class);
        baseTypeSet.add(Date[].class);
        baseTypeSet.add(BigInteger[].class);
        baseTypeSet.add(BigDecimal[].class);
    }

    public static void copySamePropertyValue(Object src, Object des, boolean isNotCopyNull, boolean isOverrideDesNotNullValue) {
        Field[] srcFiledArr = BeanUtils.getAllFields(src.getClass());
        for (int i = 0; i < srcFiledArr.length; i++) {
            Field srcField = srcFiledArr[i];
            String fieldName = srcField.getName();
            Field desField = BeanUtils.getField(des.getClass(), fieldName);
            if (null != desField) {
                try {
                    srcField.setAccessible(true);
                    Object srcValue = srcField.get(src);
                    if (isNotCopyNull) {
                        if (srcValue == null) {
                            continue;
                        }
                    }
                    desField.setAccessible(true);
                    Object desValue = desField.get(des);
                    if (isOverrideDesNotNullValue) {
                        desField.set(des, srcValue);
                    } else {
                        if (null == desValue) {
                            desField.set(des, srcValue);
                        }
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    public static Object getFiledValue(Object target, String fieldName) {
        Object obj = null;
        try {
            Field field = BeanUtils.getField(target.getClass(), fieldName);
            field.setAccessible(true);
            obj = field.get(target);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static void copyProperties(Object src, Object des, String[] ignoreProperties) {
        org.springframework.beans.BeanUtils.copyProperties(src, des, ignoreProperties);
    }

    public static void copySamePropertyValue(Object src, Object des) {
        BeanUtils.copySamePropertyValue(src, des, false);
    }

    public static void copySamePropertyValue(Object src, Object des, boolean isUseNoCopyValue) {
        Field[] srcFiledArr = BeanUtils.getAllFields(src.getClass(), true);
        for (int i = 0; i < srcFiledArr.length; i++) {
            Field srcField = srcFiledArr[i];
            String fieldName = srcField.getName();
            Field desField = BeanUtils.getField(des.getClass(), fieldName);
            if (isUseNoCopyValue && null != desField) {
                BeanUtilsNoCopyValue annotation = desField.getAnnotation(BeanUtilsNoCopyValue.class);
                if (null != annotation) {
                    continue;
                }
            }
            if (null != desField) {
                try {
                    srcField.setAccessible(true);
                    Object srcValue = srcField.get(src);
                    desField.setAccessible(true);
                    if (!Modifier.isStatic(desField.getModifiers())) {
                        desField.set(des, srcValue);
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    public static Object getFieldValue(Object target, Class<?> clazz, String fieldName) {
        Object obj = null;
        try {
            Field field = BeanUtils.getField((null == target ? clazz : target.getClass()), fieldName);
            field.setAccessible(true);
            obj = field.get((null == target ? null : target));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static Object getFieldValue(Class<?> clazz, String fieldName) {
        return getFieldValue(null, clazz, fieldName);
    }

    public static Object getFieldValue(Object target, String fieldName) {
        return getFieldValue(target, null, fieldName);
    }

    public static Object getFieldValue(Object target, Field field) {
        Object obj = null;
        try {
            if (null != field) {
                field.setAccessible(true);
                obj = field.get(target);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static void setFieldValue(Object target, Class<?> clazz, String fieldName, Object fieldValue) {
        try {
            Field field = getField((null == target ? clazz : target.getClass()), fieldName);
            field.setAccessible(true);
            field.set((null == target ? null : target), fieldValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setFieldValue(Object target, String fieldName, Object fieldValue) {
        setFieldValue(target, null, fieldName, fieldValue);
    }

    public static void setFieldValue(Class<?> clazz, String fieldName, Object fieldValue) {
        setFieldValue(null, clazz, fieldName, fieldValue);
    }

    public static void setFieldValue(Object target, Field field, Object fieldValue) {
        try {
            if (null != field) {
                field.setAccessible(true);
                field.set(target, fieldValue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setFieldValues(Object target, Class<?> clazz, String[] fieldNames, Object[] fieldValues) {
        if (ArrayUtils.isNotEmpty(fieldNames) && ArrayUtils.isNotEmpty(fieldValues)) {
            for (int i = 0, len = fieldNames.length; i < len; i++) {
                setFieldValue(target, clazz, fieldNames[i], fieldValues[i]);
            }
        }
    }

    public static void setFieldValues(Object target, String[] fieldNames, Object[] fieldValues) {
        setFieldValues(target, null, fieldNames, fieldValues);
    }

    public static void setFieldValues(Class<?> clazz, String[] fieldNames, Object[] fieldValues) {
        setFieldValues(null, clazz, fieldNames, fieldValues);
    }

    public static void setFieldValues(Object target, Map<String, Object> nameValueMap) {
        setFieldValues(target, null, nameValueMap.keySet().toArray(new String[0]), nameValueMap.values().toArray());
    }

    public static void setFieldValues(Class<?> clazz, Map<String, Object> nameValueMap) {
        setFieldValues(null, clazz, nameValueMap.keySet().toArray(new String[0]), nameValueMap.values().toArray());
    }

    public static void setFieldValues(Object target, Field fields[], Object fieldValues[]) {
        if (ArrayUtils.isNotEmpty(fields) && ArrayUtils.isNotEmpty(fieldValues)) {
            for (int i = 0, len = fields.length; i < len; i++) {
                setFieldValue(target, fields[i], fieldValues[i]);
            }
        }
    }

    public static Object invokeMethod(Object target, Method method, Object[] argArr) {
        Object obj = null;
        if (null != method) {
            try {
                method.setAccessible(true);
                obj = method.invoke(target, argArr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return obj;
    }

    public static Map<Method, Object> invokeMethods(Object[] targets, Method[] methods, Object[][] argArrs) {
        Map<Method, Object> returnValMap = new HashMap<Method, Object>();
        if (ArrayUtils.isNotEmpty(targets) && ArrayUtils.isNotEmpty(methods) && ArrayUtils.isNotEmpty(argArrs)) {
            for (int i = 0, len = methods.length; i < len; i++) {
                returnValMap.put(methods[i], invokeMethod(targets[i], methods[i], argArrs[i]));
            }
        }
        return returnValMap;
    }

    public static Object invokeMethod(Object target, String methodName, Object[] argArr, Class<?>[] parameterTypes) {
        Object obj = null;
        try {
            Class<?>[] argTypeArr = parameterTypes;
            if (null == parameterTypes) {
                if (null != argArr && 0 < argArr.length) {
                    argTypeArr = new Class<?>[argArr.length];
                    for (int i = 0; i < argArr.length; i++) {
                        if (null != argArr[i]) {
                            argTypeArr[i] = argArr[i].getClass();
                        } else {
                            argTypeArr[i] = null;
                        }
                    }
                }
            }
            Method method = BeanUtils.getMethod(target.getClass(), methodName, argTypeArr);
            obj = invokeMethod(target, method, argArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static Field getField(Class<?> clazz, String fieldName) {
        Field field = null;
        try {
            field = clazz.getDeclaredField(fieldName);
        } catch (Exception e) {
        }
        if (null == field) {
            Class<?> superClazz = clazz.getSuperclass();
            if (null != superClazz) {
                field = BeanUtils.getField(superClazz, fieldName);
            }
        }
        return field;
    }

    public static Field[] getAnnotationFields(Class<?> clazz, Class<? extends Annotation> annotationClass) {
        List<Field> fieldList = new ArrayList<Field>();
        Field[] fieldArr = getAllFields(clazz);
        for (int i = 0; i < fieldArr.length; i++) {
            Annotation annotation = fieldArr[i].getAnnotation(annotationClass);
            if (null != annotation) {
                fieldList.add(fieldArr[i]);
            }
        }
        return fieldList.toArray(new Field[0]);
    }

    public static Method getMethod(Class<?> clazz, String methodName, Class<?>[] parameterTypes) {
        Method method = null;
        try {
            method = clazz.getDeclaredMethod(methodName, parameterTypes);
        } catch (Exception e) {
        }
        if (null == method) {
            Class<?> superClazz = clazz.getSuperclass();
            if (null != superClazz) {
                method = BeanUtils.getMethod(superClazz, methodName, parameterTypes);
            }
        }
        return method;
    }

    public static Method[] getAnnotationMethods(Class<?> clazz, Class<? extends Annotation> annotationClass) {
        List<Method> methodList = new ArrayList<Method>();
        Method[] methodArr = getAllMethods(clazz);
        for (int i = 0; i < methodArr.length; i++) {
            Annotation annotation = methodArr[i].getAnnotation(annotationClass);
            if (null != annotation) {
                methodList.add(methodArr[i]);
            }
        }
        return methodList.toArray(new Method[0]);
    }

    public static Field[] getAllFields(Class<?> clazz) {
        return getAllFields(clazz, false);
    }

    public static Field[] getAllFields(Class<?> clazz, boolean isSubOverrideParent) {
        if (isSubOverrideParent) {
            Map<String, Field> fieldMap = new HashMap<String, Field>();
            Field[] thisClazzFiledArr = clazz.getDeclaredFields();
            for (int i = 0, len = thisClazzFiledArr.length; i < len; i++) {
                Field field = thisClazzFiledArr[i];
                if (null != field) {
                    String fieldName = field.getName();
                    if (null == fieldMap.get(fieldName)) {
                        fieldMap.put(fieldName, field);
                    }
                }
            }
            Class<?> superClazz = clazz.getSuperclass();
            if (null != superClazz) {
                Field[] thatClazzFiledArr = BeanUtils.getAllFields(superClazz);
                for (int i = 0, len = thatClazzFiledArr.length; i < len; i++) {
                    Field field = thatClazzFiledArr[i];
                    if (null != field) {
                        String fieldName = field.getName();
                        if (null == fieldMap.get(fieldName)) {
                            fieldMap.put(fieldName, field);
                        }
                    }
                }
            }
            return fieldMap.values().toArray(new Field[0]);
        } else {
            List<Field> fieldList = new LinkedList<Field>();
            fieldList.addAll(Arrays.asList(clazz.getDeclaredFields()));
            Class<?> superClazz = clazz.getSuperclass();
            if (null != superClazz) {
                fieldList.addAll(Arrays.asList(BeanUtils.getAllFields(superClazz)));
            }
            return fieldList.toArray(new Field[0]);
        }
    }

    public static Map<String, Object> getAllFieldsValue(Object target, Class<?> clazz, boolean isSubOverrideParent) {
        Map<String, Object> objMap = new HashMap<String, Object>();
        try {
            Field[] fieldArr = BeanUtils.getAllFields((null == target ? clazz : target.getClass()), isSubOverrideParent);
            for (int i = 0, len = fieldArr.length; i < len; i++) {
                Field field = fieldArr[i];
                field.setAccessible(true);
                objMap.put(field.getName(), field.get((null == target ? null : target)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objMap;
    }

    public static Map<String, Object> getAllFieldsValue(Object target, boolean isSubOverrideParent) {
        return getAllFieldsValue(target, null, isSubOverrideParent);
    }

    public static Map<String, Object> getAllFieldsValue(Class<?> clazz, boolean isSubOverrideParent) {
        return getAllFieldsValue(null, clazz, isSubOverrideParent);
    }

    public static Map<String, Object> getAllFieldsValue(Object target) {
        return getAllFieldsValue(target, false);
    }

    public static Map<String, Object> getAllFieldsValue(Class<?> clazz) {
        return getAllFieldsValue(clazz, false);
    }

    public static Object[] getFieldValues(Object target, Field fields[]) {
        Object[] objArr = null;
        if (ArrayUtils.isNotEmpty(fields)) {
            objArr = new Object[fields.length];
            for (int i = 0, len = fields.length; i < len; i++) {
                objArr[i] = getFieldValue(target, fields[i]);
            }
        }
        return objArr;
    }

    public static Method[] getAllMethods(Class<?> clazz) {
        List<Method> methodList = new LinkedList<Method>();
        methodList.addAll(Arrays.asList(clazz.getDeclaredMethods()));
        Class<?> superClazz = clazz.getSuperclass();
        if (null != superClazz) {
            methodList.addAll(Arrays.asList(BeanUtils.getAllMethods(superClazz)));
        }
        return methodList.toArray(new Method[0]);
    }

    public static Boolean hasField(Class<?> clazz, String fieldName) {
        return (null != BeanUtils.getField(clazz, fieldName));
    }

    public static Boolean hasMethod(Class<?> clazz, String methodName, Class<?>[] parameterTypes) {
        return (null != BeanUtils.getMethod(clazz, methodName, parameterTypes));
    }

    public static void setEmptyToNull(Object target) {
        Map<String, Object> allFieldsValue = getAllFieldsValue(target);
        Iterator<String> keyIt = allFieldsValue.keySet().iterator();
        while (keyIt.hasNext()) {
            String key = keyIt.next();
            Object object = allFieldsValue.get(key);
            if (object instanceof String && StringUtils.isEmpty((String) object)) {
                setFieldValue(target, key, null);
            }
        }
    }

    public static void setBlankToNull(Object target) {
        Map<String, Object> allFieldsValue = getAllFieldsValue(target);
        Iterator<String> keyIt = allFieldsValue.keySet().iterator();
        while (keyIt.hasNext()) {
            String key = keyIt.next();
            Object object = allFieldsValue.get(key);
            if (object instanceof String && StringUtils.isBlank((String) object)) {
                setFieldValue(target, key, null);
            }
        }
    }

    public static Object getWrapperObject(Object baseType) {
        Object resultObj = baseType;
        if (baseType.getClass().isArray()) {
            try {
                Object[] baseTypeArr = (Object[]) baseType;
                return baseTypeArr;
            } catch (Exception e) {
                Class<?> baseClassType = baseType.getClass();
                if (byte[].class.equals(baseClassType)) {
                    byte[] newBaseArr = (byte[]) baseType;
                    Byte[] newWrapperArr = new Byte[newBaseArr.length];
                    for (int i = 0; i < newBaseArr.length; i++) {
                        newWrapperArr[i] = newBaseArr[i];
                    }
                    resultObj = newWrapperArr;
                } else if (short[].class.equals(baseClassType)) {
                    short[] newBaseArr = (short[]) baseType;
                    Short[] newWrapperArr = new Short[newBaseArr.length];
                    for (int i = 0; i < newBaseArr.length; i++) {
                        newWrapperArr[i] = newBaseArr[i];
                    }
                    resultObj = newWrapperArr;
                } else if (int[].class.equals(baseClassType)) {
                    int[] newBaseArr = (int[]) baseType;
                    Integer[] newWrapperArr = new Integer[newBaseArr.length];
                    for (int i = 0; i < newBaseArr.length; i++) {
                        newWrapperArr[i] = newBaseArr[i];
                    }
                    resultObj = newWrapperArr;
                } else if (long[].class.equals(baseClassType)) {
                    long[] newBaseArr = (long[]) baseType;
                    Long[] newWrapperArr = new Long[newBaseArr.length];
                    for (int i = 0; i < newBaseArr.length; i++) {
                        newWrapperArr[i] = newBaseArr[i];
                    }
                    resultObj = newWrapperArr;
                } else if (float[].class.equals(baseClassType)) {
                    float[] newBaseArr = (float[]) baseType;
                    Float[] newWrapperArr = new Float[newBaseArr.length];
                    for (int i = 0; i < newBaseArr.length; i++) {
                        newWrapperArr[i] = newBaseArr[i];
                    }
                    resultObj = newWrapperArr;
                } else if (double[].class.equals(baseClassType)) {
                    double[] newBaseArr = (double[]) baseType;
                    Double[] newWrapperArr = new Double[newBaseArr.length];
                    for (int i = 0; i < newBaseArr.length; i++) {
                        newWrapperArr[i] = newBaseArr[i];
                    }
                    resultObj = newWrapperArr;
                } else if (char[].class.equals(baseClassType)) {
                    char[] newBaseArr = (char[]) baseType;
                    Character[] newWrapperArr = new Character[newBaseArr.length];
                    for (int i = 0; i < newBaseArr.length; i++) {
                        newWrapperArr[i] = newBaseArr[i];
                    }
                    resultObj = newWrapperArr;
                } else if (boolean[].class.equals(baseClassType)) {
                    boolean[] newBaseArr = (boolean[]) baseType;
                    Boolean[] newWrapperArr = new Boolean[newBaseArr.length];
                    for (int i = 0; i < newBaseArr.length; i++) {
                        newWrapperArr[i] = newBaseArr[i];
                    }
                    resultObj = newWrapperArr;
                }
            }
        } else {
            if (baseType.getClass().isPrimitive()) {
                Class<?> baseClassType = baseType.getClass();
                if (byte.class.equals(baseClassType)) {
                    resultObj = (Byte) baseType;
                } else if (short.class.equals(baseClassType)) {
                    resultObj = (Short) baseType;
                } else if (int.class.equals(baseClassType)) {
                    resultObj = (Integer) baseType;
                } else if (long.class.equals(baseClassType)) {
                    resultObj = (Long) baseType;
                } else if (float.class.equals(baseClassType)) {
                    resultObj = (Float) baseType;
                } else if (double.class.equals(baseClassType)) {
                    resultObj = (Double) baseType;
                } else if (char.class.equals(baseClassType)) {
                    resultObj = (Character) baseType;
                } else if (boolean.class.equals(baseClassType)) {
                    resultObj = (Boolean) baseType;
                } else if (void.class.equals(baseClassType)) {
                    resultObj = (Void) baseType;
                }
            }
        }
        return resultObj;
    }

    public static String[] getComplexFieldNames(Class<?> classType) {
        return BeanUtils.getComplexFieldNames(classType, null, false);
    }
    public static String[] getComplexFieldNames(Class<?> classType, List<String> excludesList, boolean isCheckBaseClass) {
        Set<String> resultSet = new HashSet<String>();
        if (null != excludesList && 0 < excludesList.size()) {
            resultSet.addAll(excludesList);
        }
        Field[] fields = null;
        if (isCheckBaseClass) {
            fields = BeanUtils.getAllFields(classType);
        } else {
            fields = classType.getDeclaredFields();
        }
        if (null != fields) {
            for (int i = 0; i < fields.length; i++) {
                Class<?> fieldType = fields[i].getType();
                if (!BeanUtils.baseTypeSet.contains(fieldType)) {
                    resultSet.add(fields[i].getName());
                }
            }
        }
        return resultSet.toArray(new String[0]);
    }

    public static <T> T map2Dto(Map<String, String> map, Class<T> class1) {
        T bean = null;
        try {
            bean = class1.newInstance();
            org.apache.commons.beanutils.BeanUtils.populate(bean, map);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }
}
