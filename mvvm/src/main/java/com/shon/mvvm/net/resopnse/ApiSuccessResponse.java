package com.shon.mvvm.net.resopnse;

import androidx.annotation.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Auth : xiao_yun_fei
 * Date : 2020/7/26 18:24
 * Package name : com.shon.mvvm.net
 * Des :
 */
public class ApiSuccessResponse<T> extends ApiResponse<T> {
    private Pattern LINK_PATTERN = Pattern.compile("<([^>]*)>[\\s]*;[\\s]*rel=\"([a-zA-Z0-9]+)\"");
    private Pattern PAGE_PATTERN = Pattern.compile("\\bpage=(\\d+)");
    private final String NEXT_LINK = "next";

    private T body;
    private Map<String, String> links;

    public ApiSuccessResponse(T body, @Nullable String linkHeader) {
        super();
        this.body = body;
        if (linkHeader == null || "".equals(linkHeader)) {
            this.links = new HashMap<>();
        } else {
            this.links = extractLinks(linkHeader);
        }
    }

    public T getBody() {
        return body;
    }

    @Nullable
    public Integer getNextPage() {
        String next = links.get(NEXT_LINK);
        if (next != null) {
            Matcher matcher = PAGE_PATTERN.matcher(next);
            if (!matcher.find() || matcher.groupCount() != 1) {
                return null;
            } else {
                try {
                    return Integer.parseInt(matcher.group(1));
                } catch (NumberFormatException ex) {
//                    Log.w("","cannot parse next page from %s", next);
                    return null;
                }
            }
        } else {
            return  null;
        }
    }

    private Map<String, String> extractLinks(String url) {
        Map<String, String> links = new HashMap <>();
        Matcher matcher = LINK_PATTERN.matcher(url);

        while (matcher.find()) {
            int count = matcher.groupCount();
            if (count == 2) {
                links.put(matcher.group(2), matcher.group(1));
            }
        }
        return links;
    }
}
