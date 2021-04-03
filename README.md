# MovieRecommendationSystem

毕业设计的内容，基于协同过滤算法的电影推荐系统，目前还在学习完善中。

## 1.毕业设计（论文）基本内容和要求

本毕业设计要求了解常用的协同过滤推荐算法，比较不同推荐算法之间的优劣，并在此基础上选择合适的推荐算法，基于真实的数据集进行实验仿真，优化推荐算法达到最优的推荐效果，实现对用户的推荐。并且能够选取合适的指标，对电影推荐的结果进行系统评估。具体地，本毕业设计要求学生：

1. 了解常用的推荐算法，并选取合适的推荐算法进行电影推荐系统的设计
2. 能够熟练的对数据库中的数据进行操作，能够对数据进行一定的处理
3. 能够分析推荐算法的缺陷，改进推荐算法，达到更好的推荐效果
4. 能够选取合适的指标，对推荐结果进行分析，并设计可视化界面，将结果可视化

在这个仓库下体现的是，对推荐结果进行可视化的部分，推荐结果从数据库中读取，并且将结果显示到浏览器页面上。

涉及技术：JDBC数据存储(MySQL数据库)，Ajax通信，Servlet响应处理，HTML、CSS、Javascipt等

## 2.拟采用的研究方案

整个流程分为三个部分：数据收集及处理，模型训练和电影推荐。
在数据集上，数据的来源选择MovieLens的数据，该网站现在有超过45000用户对6600不同的电影发表意见，从数据集的真实性、规模等角度来看，都可以为后续的研究提供保障。
在推荐模型上，我们设计神经协同过滤模型为用户与电影建模，分别用矩阵分解与多层感知机学习用户与电影的特征向量，为了充分挖掘数据中线性与非线性关系，将两种方法学习到的向量结合，实现电影推荐，方案如下：

1. 学习海量数据下的线性关系：基于用户与基于物品的协同过滤在数据较大时推荐性能下降。而矩阵分解被广泛应用于推荐系统，它能够将高维数据分解为低维度的向量，以特征因子内积相乘来预测评分，我们以矩阵分解的方法分解得到用户与电影的隐层因子，充分学习数据中的线性关系。
2. 挖掘数据中的非线性关系：以特征向量内积方式来为用户与电影建模，只能捕捉到行为数据中的线性关系，而多层感知机作为神经网络具有非线性数据的学习能力，使模型挖掘并学习数据中复杂的信息。
3. 向量整合：为了让模型更好地学习数据中蕴含的线性与非线性关系，我们结合由矩阵分解与多层感知机学习到的特征向量来更好地为用户与电影建模。

## 3.本系统相关

### 3.1 整体架构

![系统整体架构](img/系统整体架构.png)

自上至下各部分

- Tomcat Tomcat 服务器是一个免费的开放源代码的Web 应用服务器，属于轻量级应用服务器，在中小型系统和并发访问用户不是很多的场合下被普遍使用，是开发和调试JSP 程序的首选。
- JSP（Java Server Pages）JSP页面由HTML代码和嵌入其中的Java代码所组成。服务器在页面被客户端所请求以后对这些Java代码进行处理，然后将生成的HTML页面返回给客户端的浏览器。JSP可以使用Servlet提供的API，一般和JavaBean结合使用，从而将界面表现和业务逻辑分离。
- Servlet Servlet是一种小型的Java程序，它扩展了Web服务器的功能。作为一种服务器端的应用，当被请求时开始执行。Servlet提供的功能大多与JSP类似，不过实现的方式不同。JSP通常是大多数HTML代码中嵌入少量的Java代码，而servlets全部由Java写成并且生成HTML。
- JDBC 数据库连接(Java Database) JDBC是一组用于执行SQL的Java API ，为访问不同的数据库提供了一种统一的途径，几乎所有的关系型数据库厂商（DBMS）都提供了JDBC的服务或驱动。JDBC对数据库的访问也具有平台无关性
- MySQL MySQL 是最流行的关系型数据库管理系统，在 WEB 应用方面 MySQL 是最好的 RDBMS(Relational Database Management System：关系数据库管理系统)应用软件之一。

![项目整体架构](img/项目整体架构.png)

### 3.2 Project的结构

- 整体使用Maven约定的目录结构

1. Java文件夹 ------- Source Root 该文件夹及其子文件夹包含应在构建过程中进行编译的源代码。
2. webapp文件夹------- web roots 配置的网站根目录，也就是默认打开浏览器输入localhost:8080/的目录。
3. web.xml  ------- deployment Descriptor web.xml文件是用来初始化配置信息：比如Welcome页面、servlet、servlet-mapping、filter、listener、启动加载级别等。
4. pom.xml  ------- deploymentDescriptor Maven项目管理中使用的文件，用于记录文件信息和添加项目的相关依赖。目前添加的依赖内容：jUnit(测试类使用)、mysql(MySQL驱动文件)，Tomcat(Web容器)	
5. 其他 test编写类的测试文件，编译结果将输出到recommend/target文件夹

### 3.3 用户界面

![用户浏览界面](img/用户浏览界面.png)

首页是用户打开系统时的交互界面。

搜索框---用户可以通过搜索框搜索自己想要的电影，用户通过表单发送GET请求向服务器端。

推荐框一---根据电影数据信息，向用户推荐数据库中评分最高、观看人数最多的电影。这里放它的作用是练习与MySQL数据库的连接接收数据。

推荐框二---根据用户的个人信息，对其进行个性化推荐，功能待完善。

推荐评价---推荐系统通过切分训练集与测试集，训练模型，推荐，评估得出的衡量模型质量指标。

![登录界面](img/登录界面.png)

用户通过登录以获得自身独特的推荐结果。用户登录的姓名需要是数据库中已有的，否则会提示用户不存在信息。

![用户主页界面](img/用户主页.png)

这里将会显示用户对所有已评价的电影内容信息，包括对电影的标签和评分

![用户浏览界面html](img/用户浏览界面html.png)用户浏览界面html

左图是首页的内容。页面使用CSS盒模型，从上至下分为top，top1，main， footer四部分，内部又可以继续分层，对每层的样式分别绘制，可以增加页面的美观程度。

其他页面内容在html文件夹下，样式组合与此类似。

### 3.4 Ajax通信

![Ajax通信](img/Ajax通信.png)

Ajax(Asynchronous JavaScript and XML，异步JavaScript与XML)，是利用JavaScript脚本和XML或JSON数据实现客户端与服务器端之间异步通信的一种技术。

Ajax 是一种在无需重新加载整个网页的情况下，能够更新部分网页的技术。通过在后台与服务器进行少量数据交换，Ajax 可以使网页实现异步更新。这意味着可以在不重新加载整个网页的情况下，对网页的某部分进行更新。传统的网页（不使用 Ajax）如果需要更新内容，必须重载整个网页页面。

使用Ajax请求的五个步骤

1. 创建一个XMLHttpRequest对象。定义创建函数，得到XMLHttpRequest实例对象
2. 设置请求方式和请求地址。调用XMLHttpRequest对象的open()方法打开服务器端URL连接
3. 用send发送请求。调用XMLHttpRequest对象的send()方法发送请求
4. 监听状态变化。注册Onreadystatechange事件处理函数，准备接受响应数据
5. 接受返回的数据。在事件处理函数中判断readyState属性，当返回值为4表示数据接收完毕，可以获得完整的响应数据。

![使用Ajax通信](img/使用Ajax通信.png)
XMLHttpRequest是JavaScript一个外挂组件，用来实现客户端与服务器异步通信，所有Ajax应用都要借助该组件才能够实现。
创建XMLHttpRequest对象之后，就可以使用该对象的open()方法建立一个HTTP请求。

open()方法用法如下：oXMLHttpRequest.open(bstrMethod, bstrUrl, varAsync, bstrUser, bstrPassword);
参数分别为：HTTP方法字符串、请求的URL地址字符串、指定请求是否为异步方式、验证信息中的用户名、验证信息中的密码，只有前两个是必选项。

send()方法是要传递的值。如果是GET方法可以直接在URL中附带，传递信息可以为null，如果是POST方法，该值是一个或多个“名/值”对，多个“名/值”对之间用&分割。
XMLHttpRequest对象通过readyState属性实时跟踪异步交互状态。一旦该属性发生变化，就触发readystatechange时间，调用该事件绑定的回调函数。readyState属性值一共有5个(0-4)，4表示数据接收完毕。

### 3.5 客户端响应

![Servlet容器的作用](img/Servlet容器的作用.png)
Web服务器和Web客户端之间通过HTTP进行通信，web服务器的工作有两个，处理客户端请求与创建并返回响应。处理请求需要在TCP层进行socket编程，实现客户端-服务器的协议，进而从请求报文中提取信息。服务器根据请求，发出相应的。

Web服务器将处理应用程序逻辑的部分分离出来作为Servlet程序，并对其进行拓展性支持。用于管理Servlet的专门模块被称为Servlet容器，Servlet容器提供Java运行环境与Servlet接口。Servlet容器会接受来自浏览器的HTTP请求和返回发向浏览器的HTTP响应，并管理Servlet的生命周期，Servlet程序对请求和响应做出处理。Tomcat服务器是一个运行在JVM之上的Servlet容器，它可以作为一个服务器，解析请求并返回响应。

![Servlet接口](img/Servlet接口.png)
Servlet是一个定义处理网络请求规范的接口，它要求必须实现五个方法，init()、service()、destroy()方法分别定义网络请求初始化、接收到请求、销毁时的动作。我们自己定义的Servlet不会去直接实现javax.servlet.servlet接口，而是去继承HttpServlet类或者GenericServlet类，我们有选择地覆盖相应的方法来完成要完成的工作。

![HttpServlet类](img/HttpServlet类.png)
上图是HttpServlet类，我们通过继承该类并重写doGet()和doPost()方法，可以处理Get请求和Post请求。

浏览器和服务器是使用HTTP协议通过URL来进行通信，所以Servlet类的处理对象也是针对特定的URL，通过对Web.xml下的Servlet-mapping，可以设置匹配请求。

按照Servlet规范，Java Web应用将相关的html、jsp、Servlet类等资源文件按特定方式组织在一起，程序被组织后放置在容器中，容器按部署的结构识别Web程序的各个部分。

<pre>
└── websample
    └── WEB-INF
        ├── classer
        ├── lib
        └── web.xml
</pre>

比如websample是一个应用，在Tomcat中，tomcat安装路径/webapps是所有应用的根目录，而该应用的根目录是install_dir/webapps/websample，一个应用的目录下除了HTMP，JSP等文件，还直接包含一个web-INF的目录，这个目录的名字固定且不能通过服务器外部访问，WEB-INF文件夹由三部分组成，classer文件夹存放已编译的Servlet类和其他Java类，供Web容器调用，lib文件夹存放需要的、已经打包好的JAP包，如第三方库和数据库厂商提供的驱动程序，web.xml成为“Web应用的部署描述符(Web Application Deployment Descript)”它用来描述Web容器对该应用程序的部署。

部署描述符是一个xml文件，它定义了Web容器应该了解的有关Web应用的所有设置。

- ServletContext初始化参数
- Session配置
- Servlet声明
- Servlet映射
- 应用生存期监听器
- 过滤器定义和应黑色(啥玩意儿？————————————————————————————————————————————————————————————————————————————————)
- MIME了形映射

![1.4.3 Web应用部署描述符](img/1.4.3Web应用部署描述符.png)

图中的Servlet声明和Servlet映射，将SimpleAjaxServlet类与根目录下/SimpleAjax的URL绑定，当存在这样的请求时，通过Web容器解析就可以将请求传递给SimpleAjaxServlet类，从而进行处理并创建响应。

### 3.6 Tomcat总体架构

![Tomcat总体架构](img/1.5.1Tomcat总体架构.png)

- Server：代表整个tomcat服务器，一个tomcat只有一个Server；
- Service：Server中的一个逻辑功能层， 一个Server可以包含多个Service；
- Connector：称作连接器，是Service的核心组件之一，一个Service可以有多个Connector，主要是连接客户端请求；
- Container：Service的另一个核心组件，按照层级有Engine，Host，Context，Wrapper四种，一个Service只有一个Engine，其主要作用是执行业务逻辑；
- Jasper：JSP引擎；
- Naming：命名服务；
- Session：会话管理；
- Logging：使用Tomcat时内部的日志记录；

![Tomcat核心组件——Connector](img/1.5.2Tomcat核心组件——Connector.png)

Connector使用ProtocolHandler来处理请求的，不同的ProtocolHandler代表不同的连接类型。
Endpoint用来处理底层Socket的网络连。，Processor用于将Endpoint接收到的Socket封装成Request
Adapter充当适配器，用于将Request转换为ServletRequest交给Container进行具体的处理。 
Endpoint由于是处理底层的Socket网络连接，因此Endpoint是用来实现TCP/IP协议的，而Processor用来实现HTTP协议的，Adapter将请求适配到Servlet容器进行具体的处理。

![Tomcat核心组件——Container](img/1.5.3Tomcat核心组件——Container.png)

Container容器的设计是典型的责任链的设计模式，它由四个子容器组件构成，分别是Engine、Host、Context和Wrapper。

- Mapper: Servlet在容器中的包装类，负责管理一个Servlet的装在、初始化、执行以及资源回收。
- Context: 管理Servlet的容器每个Context代表一个应用。简单的Tomcat可以只有Wrapper和Context。
- Host: 每个代表一个虚拟主机，作用是运行多个应用，对web.xml的解析需要Host。
- Engine: 代表一个完整的Servlet引擎，它定义了一些基本的关联关系。

### 3.7 MySQL/JDBC

操作MySQL数据库的方法有通过MySQL客户端、MySQL命令行还有通过java来访问

- JDBC 规范定义接口，具体的实现由各大数据库厂商来实现。 
- JDBC 是 Java 访问数据库的标准规范，真正怎么操作数据库还需要具体的实现类，也就是数据库驱动。每个数据库厂商根据自家数据库的通信格式编写好自己数据库的驱动。所以我们只需要调用 JDBC 接口中的方法即可。

![JDBC连接](img/1.6.1JDBC连接.png)

通过在pom.xml中填写坐标，maven可以自动帮我们下载相关驱动，通过查看以来详情可以看到，下载的最新版是8.0.23版本

|接口或类|作用|
|:-|:-|
|Driver Manager 类|1) 管理和注册数据库驱动 <br />2) 得到数据库连接对象|
|Connection 接口|一个连接对象，可用于创建 Statement 和 PreparedStatement 对象|
|Statement 接口|一个 SQL 语句对象，用于将 SQL 语句发送给数据库服务器。|

这里是JDBC的核心API。通过这些类或接口，我们可以实现对数据库的连接与操作。

![JDBC连接类](img/1.6.1JDBC连接类.png)

如图所示是连接数据库的方法，在它的测试类里通过查询返回前五十条数据，之后在Servlet或其他类需要对数据库进行操作的时候，都可以通过这样的方法连接与操作数据库。

![JDBC连接测试类](img/1.6.1JDBC连接测试类.png)

左图连接数据库的类，在它的测试类里通过查询返回前五十条数据.

![MySQL数据库信息](img/1.6.2MySQL数据库信息.png)

- Movies、ratings、tags 这些是根据Movie_lens数据导入的数据库内容，存储了电影基本信息。
- Register：在用户登录时保存的登陆状态
- Recommend_result：保存推荐结果
