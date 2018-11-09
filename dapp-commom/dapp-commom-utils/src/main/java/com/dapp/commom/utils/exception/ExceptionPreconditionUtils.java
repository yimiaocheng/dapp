package com.dapp.commom.utils.exception;

import com.dapp.commom.exception.BaseException;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;

public class ExceptionPreconditionUtils {
    /**
     * 用于判断参数是否符合条件
     *
     * @param flag 判断的条件
     * @param e 如果对象不符合条件，平台需要返回的业务错误
     */
    public static void checkBool(boolean flag, BaseException e) {
        if (!flag) {
            throw e;
        }
    }

    /**
     * 判断字符串不为空或空串
     *
     * @param checkString  需要判断的字符串
     * @param e 返回的业务错误
     */
    public static void checkStringNotBlank(String checkString, BaseException e) {
        if (!StringUtils.isNotBlank(checkString)) {
            throw e;
        }
    }

    /**
     * 判断一个集合是否为空（包含null和size为0的情况）
     *
     * @param collection
     * @param e
     */
    public static void checkCollectionNotEmpty(Collection collection, BaseException e) {
        if (collection == null || collection.size() == 0) {
            throw e;
        }
    }

    /**
     * 判断一个对象不可以为空
     *
     * @param obj 需要判断的对象
     * @param e 如果对象为空，平台需要返回的业务错误代码
     */
    public static void checkNotNull(Object obj, BaseException e) {
        if (obj == null) {
            throw e;
        }
    }

}
