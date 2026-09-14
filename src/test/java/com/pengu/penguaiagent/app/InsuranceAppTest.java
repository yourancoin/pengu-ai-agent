package com.pengu.penguaiagent.app;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class InsuranceAppTest {

    @Resource
    private InsuranceApp insuranceApp;

    @Test
    void testChat() {
        String chatId = UUID.randomUUID().toString();
        // 第一轮
        String message = "你好，我是youran";
        String answer = insuranceApp.doChat(message, chatId);
        // 第二轮
        message = "帮我总结下市面上热门保险";
        answer = insuranceApp.doChat(message, chatId);
        Assertions.assertNotNull(answer);
        // 第三轮
        message = "我叫什么刚跟你说过，帮我回忆一下";
        answer = insuranceApp.doChat(message, chatId);
        Assertions.assertNotNull(answer);
    }

    @Test
    void doChatWithReport() {
        String chatId = UUID.randomUUID().toString();
        String message = "你好，我是youran，帮我看下市面上热门重疾险，但我不知道该怎么做";
        InsuranceApp.LoveReport loveReport = insuranceApp.doChatWithReport(message, chatId);
        Assertions.assertNotNull(loveReport);
    }

    @Test
    void doChatWithRag() {
        String chatId = UUID.randomUUID().toString();
        String message = "我还未结婚，不太想买保险，怎么办？";
        String answer = insuranceApp.doChatWithRag(message, chatId);
        Assertions.assertNotNull(answer);
    }

    @Test
    void doChatWithTools() {
        // 测试联网搜索问题的答案
        testMessage("人到人中年上有老下有小需要配置那些保险");

        // 测试网页抓取：案例分析
        testMessage("家庭新组建育儿期间保险案例分析，规划");

        // 测试资源下载：图片下载
        testMessage("直接下载一张适合做手机壁纸图片为文件");

        // 测试终端操作：执行代码
        testMessage("执行 Python3 脚本来生成数据分析报告");

        // 测试文件操作：保存用户档案
        testMessage("保存我的保险档案为文件");

        // 测试 PDF 生成
        testMessage("生成一份‘我的保险规划’PDF，包含寿险、重疾险、意外险、车险、医疗险");
    }

    private void testMessage(String message) {
        String chatId = UUID.randomUUID().toString();
        String answer = insuranceApp.doChatWithTools(message, chatId);
        Assertions.assertNotNull(answer);
    }

    @Test
    void doChatWithMcp() {
        String chatId = UUID.randomUUID().toString();
        // 测试地图 MCP
//        String message = "我在西湖区，请帮我找找附近保险公司地点";
//        String answer =  loveApp.doChatWithMcp(message, chatId);
//        Assertions.assertNotNull(answer);
        // 测试图片搜索 MCP
        String message = "帮我搜索一些开心的图片";
        String answer =  insuranceApp.doChatWithMcp(message, chatId);
        Assertions.assertNotNull(answer);
    }
}
