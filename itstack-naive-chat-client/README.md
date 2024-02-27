# :heartbeat:《Netty+JavaFx实战：仿桌面版微信聊天》| 客户端

[![stars](https://badgen.net/github/stars/itstack-naive-chat/itstack-naive-chat-client?icon=github&color=4ab8a1)](https://github.com/itstack-naive-chat/itstack-naive-chat-client) [![forks](https://badgen.net/github/forks/itstack-naive-chat/itstack-naive-chat-client?icon=github&color=4ab8a1)](https://github.com/itstack-naive-chat/itstack-naive-chat-client) [<img src="https://itstack.org/_media/onlinebook.svg">](http://chat.itstack.org) [<img src="https://itstack.org/_media/wxbugstack.svg">](https://itstack.org/_media/qrcode.png?x-oss-process=style/may)

> 本项目是作者小傅哥使用技术栈```JavaFx```、```Netty4.x```、```SpringBoot```、```Mysql```等，搭建的仿桌面版微信聊天工程实现通信核心功能。如果本项目能为您提供帮助，请给予支持(关注、点赞、分享)！

> **作者：** 小傅哥，Java Developer，[:trophy: CSDN 博客专家](https://bugstack.blog.csdn.net)，[:bug: 虫洞 · 科技栈](https://bugstack.cn)

**学习链接：**

- [《Netty+JavaFx实战：仿桌面版微信聊天》](https://chat.itstack.org)
 
**赏个鸡腿🍗**

![](https://bugstack.cn/assets/images/tip.jpg)

----

## 一、简述

客户端是我们的通信核心工程，主要使用Netty4.x作为我们的socket框架来完成通信交互。并且在此工程中负责引入UI的Jar包，完成UI定义的事件(登录验证、搜索添加好友、对话通知、发送信息等等)，以及需要使用我们在服务端工程定义的通信协议来完成信息的交互操作。


## 二、Maven配置

```xml
<!-- UI包 -->
<dependency>
  <groupId>org.itstack</groupId>
  <artifactId>itstack-naive-chat-ui</artifactId>
  <version>1.0.0-SNAPSHOT</version>
</dependency>

<!-- 协议定义 -->
<dependency>
  <groupId>org.itstack</groupId>
  <artifactId>itstack-naive-chat-server-agreement</artifactId>
  <version>1.0.0-SNAPSHOT</version>
</dependency>
```

## 三、系统架构

![](https://chat.itstack.org/assets/img/2020/chat/wechat-2.3-00.png)

- **UI层**：在UI层我们使用工程```itstack-naive-chat-ui```对外部提供的Jar包，并使用内部的接口、事件来操作UI的展现和行为发起。如果还不是特别理解也没关系，因为在后续我们的代码开发中会有落地的展现内容。这也是我们反复强调的要让UI与业务逻辑代码分开。

- **业务层**：对于通信客户端的核心业务功能来说，主要负责窗体中用户信息的维护(好友、群组)以及用户和群组之间进行对话信息发送和接收操作。最终也就是在这一层来处理UI的接口与事件。

- **协议包**：在“通信协议包定义”中，我们已经明确将了数据帧的作用，以及需要在中间穿插一位```标识帧```，用来区分发送的是不同的对象。其实这里不同的对象就是我们的不同业务，例如；登录、对话框获取、消息发送、添加好友等等，这些与我们的UI窗体中的流程息息相关。

- **通信层**：在Netty的框架下，可以非常方便的让我们使用Socket通信服务，只要更加注重业务开发即可。当然如果是工作中需要，并且还是初步了解Netty，那么一定还是需要在这方面的知识上有所深入学习的。

- **运行环境**：最下面是我们的运行环境，Jdk1.8，Windows桌面即可运行。也可以运行在其他安装jdk1.8的系统上。


----

如果本项目能为您提供帮助，请给予支持(关注、点赞、分享)！


