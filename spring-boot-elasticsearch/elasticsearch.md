
# docker pull registry.docker-cn.com/library/elasticsearch
# docker images

运行，默认加载2G内存，所以要设置内存大小9200 端口 9300分布式端口

# docker run -e ES_JAVA_OPTS="-Xms256m -Xmx256m" -d -p 9200:9200 -p 9300:9300 --name ES01 a62bcf85821b

http://192.168.10.8:9200/

官方文档：https://www.elastic.co/guide/cn/elasticsearch/guide/current/index.html

# docker ps

删除

# docker rm 497a31a0e4ea

springboot 和elastic版本不匹配，安装另外版本

# docker pull registry.docker-cn.com/library/elasticsearch:5.5

# docker run -e ES_JAVA_OPTS="-Xms256m -Xmx256m" -d -p 9201:9200 -p 9301:9300 --name ES02 20f2af19bab6


https://hub.docker.com/r/library/elasticsearch/tags/

