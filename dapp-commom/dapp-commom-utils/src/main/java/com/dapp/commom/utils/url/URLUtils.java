package com.dapp.commom.utils.url;

import com.google.common.base.Joiner;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class URLUtils {

    /**
     * <p>description map转url地址参数</p>
     *
     * @param map
     * @param isURLEncoder 是否需要Encoder
     * @return java.lang.String
     */
    public static String mapToUrlParams(Map<String, Object> map, boolean isURLEncoder) throws UnsupportedEncodingException {
        String formData = "";
        if(map != null && map.size() > 0){
            formData = Joiner.on("&").withKeyValueSeparator("=").join(map);
            if(isURLEncoder){
                formData = URLEncoder.encode(formData, "UTF-8");
            }
        }
        return formData;
    }

    /**
     * <p>description url地址参数转map</p>
     *
     * @param queryString
     * @param isUrlDecoder 是否需要Decoder
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public static Map<String, Object> urlParamsToMap(String queryString, boolean isUrlDecoder) throws UnsupportedEncodingException {
        Map<String, Object> map = new HashMap();
        if(StringUtils.isNotBlank(queryString)){
            if(isUrlDecoder)
                queryString = URLDecoder.decode(queryString, "UTF-8");
            String[] splits = queryString.split("&");
            for(String split : splits){
                String[] tmp = split.split("=");
                if(tmp.length == 2)
                    map.put(tmp[0],tmp[1]);
            }
        }
        return map;
    }
}
