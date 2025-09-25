itsource-ymcc
├── cjc-basic           //所有项目通用，其他项目也可以用的二方库；表示所有项目通用（如果还存在其他项目）；
│       └── project-basic-common  // 项目通用，其他项目也可以用的公共代码
│                                  //如公共util,BaseQuery,BaseDomain,PageList,JSONResul，PageResult，异常处理等
│       └── project-gen-code      //项目通用，其他项目也可以用的代码生成器
├── ymcc-support            // 微服务基础公共服务
│       └── ymcc-service-gateway     //Gateway网关
├── ymcc-basic              //基础代码；该项目抽离出来的公共服务
│       └── ymcc-basic-common  //云课堂项目的公共代码,:当前项目的工具类 ，实体类
│       └── ymcc-basic-dependency //云课堂微服务项目的公共jar包
├── ymcc-service            //微服务
│       └── ymcc-service-system    //管理服务:controller,service,mapper,mapper.xml
│       └── ymcc-service-uaa      //认证授服务
│       └── ymcc-service-user     //用户服务
├── ymcc-pojo               //对象模型
│       └── ymcc-pojo-system       //管理服务对象模型:Domain,Dto,Vo,To,SystemQuery
│       └── ymcc-pojo-uaa          //认证服务的对象模型
│       └── ymcc-pojo-user         //用户服务的对象模型
├── ymcc-api                // 服务的API，使用Feign通信
│       └──ymcc-api-system         //管理服务的API:调用system服务的Feign接口
│       └──ymcc-api-uaa           //认证服务API
├── ymcc-ui                  // 前端站点
│       └── ymcc-ui-system         //管理系统
│       └── ymcc-ui-course        //门户-课程
│       └── ymcc-ui-user          //门户-用户
├──pom.xml                   // 管理公共依赖以及SpringBoot,SpringCloud
注意：
【`特别注意`】项目搭建完成之后做如下检查
顶级父工程是SpringBoot父工程，里面做了依赖管理！
- 项目采用pom父子模块进行构建，在一级pom中管理springboot和springcloud依赖以及公共依赖
    - 父工程做POM聚合

- 二级不做pom管理，不导入任何依赖
    - 二级主要是用来划分功能模块

- 三级导入项目本身需要的依赖

- 一级和二级的pom的packaging应该是pom,三级的packaging应该是jar

- 检查项目JDK、项目Maven在IDEA中的配置

