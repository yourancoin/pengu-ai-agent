package com.pengu.penguaiagent.agent;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PenguManusTest {

    @Resource
    private PenguManus penguManus;

    @Test
    public void run() {
        String userPrompt = """
                我是AI保险规划专家，
                请结合一些网络图片，制定一份详细的规划，
                并以 PDF 格式输出""";
        String answer = penguManus.run(userPrompt);
        Assertions.assertNotNull(answer);
    }
}