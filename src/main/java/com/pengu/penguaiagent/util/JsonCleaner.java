package com.pengu.penguaiagent.util;

import cn.hutool.json.*;

public class JsonCleaner {
    /**
     * 统一清洗各种不合法 JSON 字符串
     */
    public static String clean(String raw) {
        if (raw == null || raw.isBlank()) {
            return "[]";
        }

        String s = raw.trim();

        // 1. 去掉 JSONP 包裹：callback( ... )
        s = s.replaceAll("^\\s*\\w+\\s*\\(", "")
                .replaceAll("\\)\\s*;?\\s*$", "");

        // 2. 单引号 → 双引号（简单场景）
        s = s.replaceAll("(?<!\\\\)'", "\"");

        // 3. 去掉 // 单行注释
        s = s.replaceAll("//.*", "");

        // 4. 去掉 /* */ 多行注释
        s = s.replaceAll("/\\*[\\s\\S]*?\\*/", "");

        // 5. 去掉末尾多余逗号：", }"  ", ]"
        s = s.replaceAll(",\\s*}", "}");
        s = s.replaceAll(",\\s*\\]", "]");

        // 6. 如果看起来是多个对象拼在一起，包上 [ ]
        if (!s.startsWith("[") && !s.startsWith("{")) {
            s = "[" + s + "]";
        } else if (s.startsWith("{") && s.contains("}\n{")) {
            // {}\n{} 形式
            s = "[" + s.replaceAll("\\}\\s*\\{", "},{") + "]";
        }

        return s.trim();
    }

    /**
     * 安全解析 + 格式化输出
     */
    public static String formatSafe(String raw) {
        try {
            String cleaned = clean(raw);
            return JSONUtil.formatJsonStr(cleaned);
        } catch (Exception e) {
            // 最后兜底：返回原始内容，避免程序崩
            return raw;
        }
    }

    /**
     * 安全解析为 JSONArray（如果不是数组就包成数组）
     */
    public static JSONArray parseArraySafe(String raw) {
        try {
            String cleaned = clean(raw);
            if (!cleaned.startsWith("[")) {
                cleaned = "[" + cleaned + "]";
            }
            return JSONUtil.parseArray(cleaned);
        } catch (Exception e) {
            return new JSONArray();
        }
    }
}
