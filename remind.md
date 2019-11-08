# 启动    mysql

docker run --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 -d mysql:5.7 

# 启动 redis

docker run -p 6379:6379 -d redis:latest redis-server

# 启动  rocketmq

[启动rocketmq](https://www.jb51.net/article/163191.htm)

启动NameServer：

docker run -d -p 9876:9876 --name rmqserver foxiswho/rocketmq:server-4.5.1

启动broker：

docker run -d -p 10911:10911 -p 10909:10909\
--name rmqbroker --link rmqserver:namesrv\
-e "NAMESRV_ADDR=namesrv:9876" -e "JAVA_OPTS=-Duser.home=/opt"\
-e "JAVA_OPT_EXT=-server -Xms128m -Xmx128m"\
foxiswho/rocketmq:broker-4.5.1

Broker容器中默认的配置文件的路径为：
/etc/rocketmq/broker.conf
也可以通过-v参数指定本机的配置文件：

docker run -d -p 10911:10911 -p 10909:10909\
--name rmqbroker --link rmqserver:namesrv\
-e "NAMESRV_ADDR=namesrv:9876" -e "JAVA_OPTS=-Duser.home=/opt"\
-e "JAVA_OPT_EXT=-server -Xms128m -Xmx128m"\
-v /conf/broker.conf:/etc/rocketmq/broker.conf \
foxiswho/rocketmq:broker-4.5.1


如果一切正常，NameServer和Broker一会儿就会安装好，为了管理上的方便，rocketmq console也是必不可少的工具了，通过上面查询的方式找到需要启动的版本，启动方式如下：

docker run -d --name rmqconsole -p 8180:8080 --link rmqserver:namesrv\
-e "JAVA_OPTS=-Drocketmq.namesrv.addr=namesrv:9876\
-Dcom.rocketmq.sendMessageWithVIPChannel=false"\
-t styletang/rocketmq-console-ng

然后通过如下命令检查一下启动情况：

docker ps|grep rocketmq

再通过浏览器访问localhost:8180，console的页面显示如下：