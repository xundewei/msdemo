# msdemo
msdemo
由于在外地，环境和时间的限制，没有做数据层面的相关业务，只是实现了部分业务框架功能
实现以下功能：
1.HttpClient 前台模拟测试
2.对资源的过滤，TOKEN验证机制， 生命周期的配置 并做加密处理
3.用户注册，查询的接口不要TOKEN
4.对书的业务的查询，新增，修改，删除的接口并用GET,PSOT,PUT,DELETE 等方式实现，前后台对象的传输，需要TOKEN验证
5.异常管理

使用的部分技术：JAVA，JERSEY,HTTPCLIENT,Json
使用的工具：ECLIPSE,GIT,MAVEN,TOMCATE
部署：
  TOMCATE 运行
测试：
  找到SimpleClient 测试类运行，需要修改
  		String result = httpPost("http://localhost:8888/msdemo/services/login?username=admin&password=123");
		String result1 = httpGet("http://localhost:8888/msdemo/services/user/queryuser?username=admin");
		String result2 = httpPost("http://localhost:8888/msdemo/services/user/regist?username=admin&password=123");
		String result3 = httpGet("http://localhost:8888/msdemo/services/user/queryuser?username=admin");
		String result4 = httpPostWithToken("http://localhost:8888/msdemo/services/book/querybook?bookId=0001");
		String result5 = httpPostWithJSON("http://localhost:8888/msdemo/services/book/add_book");
		String result6 = httpPutWithJSON("http://localhost:8888/msdemo/services/book/update_book");
		String result7 = httpDelete("http://localhost:8888/msdemo/services/book/delete_book?bookId=0001");
    里面的地址和端口
    
    运行结果：
{"authToken":"eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJKZXJzZXktU2VjdXJpdHktQmFzaWMiLCJzdWIiOiJhZG1pbiIsImF1ZCI6InVzZXIiLCJleHAiOjE0OTIxNzE5OTMsImlhdCI6MTQ5MjA4NTU5NCwianRpIjoiMSJ9.iQuRo2TbvkArwsFKec6eJfk8ofmBIY5105tMj_0Z_UI","expires":1492171993889}
正确登入！
admin_____注册成功
正确登入！
{"bookID":"0001","bookName":"星球大战_新增","author":null,"coverUrl":null,"iSBN":null,"publisher":null}
{"bookID":"0002","bookName":"星球大战_添加","author":null,"coverUrl":null,"iSBN":null,"publisher":null}
{"bookID":"0002","bookName":"星球大战_更新","author":null,"coverUrl":null,"iSBN":null,"publisher":null}
0001————————删除成功

