# education-curriculum-network (教育课程网)<hr>  <h4>说明:这是我在公司参与的项目，由于保密，只上传后台代码</h4>
教育课程网 <br>
<li>简介</li>
&#12288;&#12288;教育课程网是一个基于 B2B2C 模式的O2O课程商城，分为网站前台、管理后台、培训机构管理后台三个子系统.网站采用补习机构入驻的模式，其机构向平台提交入驻申请，网站平台对补习机构进行资质审核；审核通过后，补习机构拥有独立的管理后台有添加修改课程的权限。<br>
&#12288;&#12288;教育课程网主要分为网站前台、运营商后台、入驻商家管理后台三个子系统,这个三个不同的模块，有三个不同的界面。<br>

1.网站前台<br>
&#12288;&#12288;主要包括网站首页、入驻商家首页、课程详细页、搜索页面、会员中心、订单与支付相关页面、秒杀频道等。 <br>
2.运营商后台 <br>
&#12288;&#12288;运营商后台是运营商的运营人员的管理后台。主要包括入驻结构审核、品牌管理、规格管理、模板管理、课程分类管理、课程审核、广告类型管理、广告管理、订单查询、入驻商家结算等。<br>
3.商家管理后台<br>
&#12288;&#12288;入驻的商家进行管理的后台，主要功能是对课程的管理以及订单查询统计、资金结算等功能。<br>
<li>系统架构</li>
&#12288;&#12288;SOA 是 Service-Oriented Architecture 的首字母简称，它是一种支持面向服务的架构样式。<br>
<li>框架组合</li>
&#12288;&#12288;教育课程网采用当前流行的前后端编程架构。后端框架采用 Spring +SpringMVC+mybatis +Dubbo+Zookeepper；前端采用 angularJS + Bootstrap。
<li>教育课程网架构图</li>
![image](https://github.com/zhangyu345293721/education-curriculum-network/blob/master/picture/1.png)
<li>开发环境</li>
&#12288;&#12288;JDK1.8、MySql5.7、Eclipse、SSM Framework、 Dubbo 、Redis、Solr、AngularJS、ActiveMQ、SpringSecurity、SpringBoot
<li>主要负责模块</li>
1.用户注册（阿里大于短信微服务），用户登录（单点登录系统CAS）模块<br>
2.课程管理功能（课程审核导入索引，课程删除移除索引，课程审核执行静态网页，课程删除详细页）<br>
3.网络课程搜索功能（关键字搜索，分类列表，品牌规则过滤查询，分页查询，排序，更新索引库）<br> 
4.网络课程秒杀功能（倒计时读秒，秒杀下单，秒杀支付，超时处理）<br>
<li>部署项目</li> 
1.搭载Zookeeper集群 <br>
1.1 搭载要求<br>
&#12288;&#12288;真实的集群是需要部署在不同的服务器上的，但是在我们测试时同时启动十几个虚拟机内存会吃不消，所以我们通常会搭建伪集群，也就是把所有的服务都搭在一台虚拟机上，用端口进行区分重新部署一台虚拟机作为我们搭建集群的测试服务器。<br>
1.2准备工作<br>
（1）安装 JDK <br>
（2）Zookeeper 压缩包上传到服务器 <br>
（3）将 Zookeeper 解压 ，创建 data 目录 ，将 conf 下 zoo_sample.cfg 文件改名为 zoo.cfg  <br>
（4）建立/usr/local/zookeeper-cluster 目录，将解压后的 Zookeeper 复制到以下三个目录 <br>
  &#12288;   /usr/local/zookeeper-cluster/zookeeper-1 <br>
  &#12288;   /usr/local/zookeeper-cluster/zookeeper-2 <br>
  &#12288;   /usr/local/zookeeper-cluster/zookeeper-3。<br>




