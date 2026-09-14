package com.pengu.penguaiagent.rag;

import com.pengu.penguaiagent.rag.InsuranceAppDocumentLoader;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InsuranceAppDocumentLoaderTest {

    @Resource
    private InsuranceAppDocumentLoader insuranceAppDocumentLoader;

    @Test
    void loadMarkdowns() {
        insuranceAppDocumentLoader.loadMarkdowns();
    }
}