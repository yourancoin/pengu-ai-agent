package com.pengu.penguaiagent.tools;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;

/**
 * 网页抓取工具
 */
public class WebScrapingTool {

    @Tool(description = "Scrape the content of a web page")
    public String scrapeWebPage(@ToolParam(description = "URL of the web page to scrape") String url) {
        try {
            Document document = Jsoup.connect(url).get();
            Document doc = Jsoup.parse(document.html());
            Element content = doc.getElementById("mcont");
            if (content != null) {
                // 保留段落换行
                String result = content.html()
                        .replaceAll("<p>", "\n")
                        .replaceAll("</p>", "")
                        .replaceAll("<br\\s*/?>", "\n")
                        .replaceAll("<[^>]+>", "")
                        .replaceAll("\n{3,}", "\n\n")
                        .trim();
                // 解码 HTML 实体
                result = org.jsoup.parser.Parser.unescapeEntities(result, true);
                return result;
            }
        } catch (Exception e) {
            return "Error scraping web page: " + e.getMessage();
        }
        return url;
    }
}
