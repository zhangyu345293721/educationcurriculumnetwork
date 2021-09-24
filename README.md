# education-curriculum-network (教育课程网)<hr>  

<li>项目简介</li>
&#12288;&#12288;  课程网是一个综合性的B2B2C 平台，类似京东商城、天猫商城。培训机构入驻的模式，培训机构提交申请，有平台进行资质审核，审核通过后，商家拥有独立的管理后台录入课程信息，课程经过平台审核后即可发布。课程网主要分为网站前台、运营商后台、商家管理后台三个子系统。<br>

1.网站前台<br>
&#12288;&#12288;主要包括网站首页、入驻商家首页、课程详细页、搜索页面、会员中心、订单与支付相关页面、秒杀频道等。 <br>
2.运营商后台 <br>
&#12288;&#12288;运营商后台是运营商的运营人员的管理后台。主要包括入驻结构审核、品牌管理、规格管理、模板管理、课程分类管理、课程审核、广告类型管理、广告管理、订单查询、入驻商家结算等。<br>
3.商家管理后台<br>
&#12288;&#12288;入驻的商家进行管理的后台，主要功能是对课程的管理以及订单查询统计、资金结算等功能。<br>
<li>框架组合</li>
&#12288;&#12288;教育课程网采用当前流行的前后端编程架构。后端框架采用 Spring +SpringMVC+Mybatis +Dubbo+Zookeepper；<br> &#12288;&#12288;前端采用 angularJS + Bootstrap。
<li>教育课程网架构图</li>

![image](https://github.com/zhangyu345293721/education-curriculum-network/blob/master/picture/1.png)
<li>开发环境</li>
&#12288;&#12288;JDK1.8、MySql5.7、SSM Framework、 Dubbo 、Redis、Solr、AngularJS、ActiveMQ、SpringSecurity、SpringBoot
<li>主要功能</li>
1.用户注册（阿里大于短信微服务），用户登录（单点登录系统CAS）模块<br>
2.课程管理功能（课程审核导入索引，课程删除移除索引，课程审核执行静态网页，课程删除详细页）<br>
3.课程规格模板管理（前端MVC改造，项目集成改造，代码生成器，规格管理，模板管理）<br> 
4.课程搜索功能（关键字搜索，分类列表，品牌规则过滤查询，分页查询，排序，更新索引库）<br> 
5.安全框架和机构入驻审核（机构入驻申请，商家审核，商家登录，运营商后台登录）<br>
6.广告内容管理（广告首页展示，更换样式，更换内容）<br>
7.购物车功能（课程购入，删除，过时清除）<br>
8.跨域解决方法（课程详细页对接购物车，结算地址选择，结算方式选择，提交订单）<br>
9.课程支付功能（微信扫描支付，支付宝扫描支付）<br>
10.课程秒杀功能（倒计时读秒，秒杀下单，秒杀支付，超时处理）<br>

