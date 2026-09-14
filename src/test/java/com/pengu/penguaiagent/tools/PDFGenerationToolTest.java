package com.pengu.penguaiagent.tools;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PDFGenerationToolTest {

    @Test
    void generatePDF() {
        PDFGenerationTool tool = new PDFGenerationTool();
        String fileName = "保险规划.pdf";
        String content = "啥地方撒分手的发生的";
        String result = tool.generatePDF(fileName, content);
        assertNotNull(result);
    }
}