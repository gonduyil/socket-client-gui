package org.gonduyil.socketclientgui.infrastructure;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.hc.core5.net.URIBuilder;

import java.net.URISyntaxException;

public class UriUtil {

    public static String javaObjectToUriString(Object params) throws URISyntaxException {
        JSONObject connectJson = (JSONObject) JSON.toJSON(params);

        URIBuilder uriBuilder = new URIBuilder();

        connectJson.entrySet().stream().forEach(entry -> uriBuilder.addParameter(entry.getKey(), String.valueOf(entry.getValue())));
        String uri = uriBuilder.build().getQuery();
        return uri;
    }
}
