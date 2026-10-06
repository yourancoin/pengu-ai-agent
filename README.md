# AI 超级智能体项目

## 项目介绍

**AI保险规划专家 、 拥有自主规划能力的AI超级智能体**

![Uploading image.png…]()

`AI 保险规划应用` 可以依赖 AI 大模型解决用户的家庭资产规划问题，支持多轮对话、基于自定义知识库进行问答、对话记忆持久化、RAG 知识库检索、自主调用工具和 MCP 服务完成任务。

![](https://picture.coinyouran.cn/20261006000620444.png)

此外，右边 AI超级智能体用 ReAct 模式的 `自主规划智能体 PenguManus` ，可以根据用户的需求，自主推理和行动，直到完成目标。通过AI MCP 服务可以从特定网站搜索图片，可以利用一系列工具包括联网搜索、文件操作、网页抓取、资源下载、终端操作、PDF 生成工具，帮用户制定并生成文档。

## 技术栈&特性

项目以 Spring AI 框架为核心，多种主流 AI 客户端和工具库。

- Java 21 + Spring Boot 3 框架
- Spring AI + LangChain4j
- RAG 知识库
- PGvector 向量数据库
- Tool Calling 工具调用
- MCP 模型上下文协议
- ReAct Agent 智能体构建
- Serverless 计算服务
- AI 大模型开发平台百炼
- Cursor AI 代码生成
- SSE 异步推送
- 第三方接口：如 SearchAPI / Pexels API
- Ollama 大模型部署
- 工具库如：Kryo 高性能序列化 + Jsoup 网页抓取 + iText PDF 生成 + Knife4j 接口文档

---
1)大模型接入与调用：

- 使用spring-ai-alibaba-starter 和 spring-ai-ollama-spring-boot-starter简化大模型的配置和集成。

- 通过Spring Al的ChatModel和更高级的ChatClient API与Al大模型交互，实现对话功能。

2)Advisors：

- 利用MessageChatMemoryAdvisor 实现了多轮对话中的上下文记忆功能。

- 为了增强应用的可观测性，我还自定义了Advisor，例如用于记录Al请求和响应日志的MyLoggerAdvisor，以及用于尝试提高模型推理能力的ReReadingAdvisor。

3)对话记忆：

- 项目初期使用了基于内存的InMemoryChatMemory。

- 为了实现对话记忆的持久化，我自定义了FileBasedChatMemory，并使用Kryo序列化库解决了Message对象层级复杂难以直接序列化的问题。

4)结构化输出：通过Spring Al的结构化输出转换器，我把AI模型的文本输出直接转换为Java对象，方便后端处理和使用。

5)Prompt模板：利用PromptTemplate 管理和动态生成提示词，比如使用占位符替换变量、从外部文件加载复杂的提示词模板，提高了提示词的可维护性和灵活性。

6)RAG(检索增强生成)：

- 文档ETL：使用了Spring Al的ETL Pipeline 组件，如MarkdownDocumentReader 加载本地Markdown知识库文档、TokenTextSplitter 进行文本分割、 KeywordMetadataEnricher自动为文档添加关键词元数据。

- 向量存储：集成SimpleVectorStore 和PgVectorStore 用于存储和检索文档向量。在集成PgVectorStore时，我还解决了多个EmbeddingModel Bean 冲突的问题。

- 检索与增强：使用QuestionAnswerAdvisor 和更灵活的RetrievalAugmentationAdvisor 实现 RAG 流程，后者还结合了VectorStoreDocumentRetriever和 ContextualQueryAugmenter等组件进行查询优化和空上下文处理。还实践了查询重写(RewriteQueryTransformer)等预检索优化技术。

![](https://picture.coinyouran.cn/Image_mhac29mhac29mhac.jpeg)

7)工具调用(Tool Calling)：

- 通过@Tool和@ToolParam注解定义了多种外部工具，如文件操作、联网搜索、PDF生成等，并使用ChatClient的tools()方法将这些工具注册给AI模型，让Al能够调用这些工具完成特定任务。

- 在构建PenguManus智能体时，手动控制了工具的执行流程(ReAct模式)，通过DashScopeChatOptions 禁用Spring Al内部的自动工具执行，更方便、更精细地管理思考-行动循环。

8)MCP(模型上下文协议)集成：

- MCP客户端：使用spring-ai-mcp-client-spring-boot-starter，配置 stdio 和 SSE 连接方式来调用外部MCP服务。通过 ToolCallbackProvider将MCP服务提供的工具无缝集成到ChatClient的工具调用机制中。

- MCP服务端：基于spring-ai-mcp-server-webmvc-spring-boot-starter 开发了自定义的图片搜索MCP服务，使用@Tool 注解暴露工具，然后通过 ToolCallbackProvider Bean 进行注册。

## 项目架构设计图：


![](https://picture.coinyouran.cn/20261005234709227.png)

