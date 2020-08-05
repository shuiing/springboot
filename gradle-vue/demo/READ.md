
## springboot1.5+vue2

### 1.简介

[参考文档](https://mp.weixin.qq.com/s/qLHWasXfRUPvmN9uS0Nwkw)
[vue文档]()
[gradle文档]()

* demo:将服务端server和客户端web整合在一个项目中
* web中用的vue。在build.gradle中设置了打包后，运行时会启动node的启动命令
* server中的后台代码，在build.gradle中compile project(':web'),会打包web为依赖

**启动**
* 本地启动：分别启动server(tasks.application.bootRun)，和web(tasks.node.npmDev)
* 打包启动：直接打包server。然后将server的build/lib中的jar放到服务器中，java -jar

**项目内容**
* server:设置了/api的头；需要访问host:post/api/接口 例如：http://localhost:3000/api/app/info
* web中vue的build改为script,避免了web在gradle中build后的包名冲突
* web/package.json  修改node打包位置
* /web/config/index.js build中修改了打包位置，dev中设置了访问接口为3000，
并且设置可以跳转到8080(server服务中)
* 其他设置不变，比如spirngboot的配置文件依旧为application

**生成模板**

```
# vue init webpack web
Project name --> web
Project description --> A Vue.js project
Author --> Hello
Vue build --> 回车
Install vue-router ? --> y
Use ESlint to lint your code? --> n
Setup unit tests with Karma + Mocha? --> n
Setup e2e tests with Nightwatch? --> n

此时把web(vue)目录下所有文件拷贝到子项目中
```