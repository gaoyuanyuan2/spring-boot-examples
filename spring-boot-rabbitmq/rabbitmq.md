安装docker

# curl -sSL http://acs-public-mirror.oss-cn-hangzhou.aliyuncs.com/docker-engine/internet | sh -
# docker -v

# sudo service docker start

https://hub.docker.com/r/library/rabbitmq/tags/

加速下载

# docker pull registry.docker-cn.com/library/rabbitmq:3-management-alpine

查看文件，检查

# docker images

启动rabbitmq

# docker run -d -p 5672:5672 -p 15672:15672 --name myrabbitmq d39f7aefe7a2

查看运行情况

# docker ps

网页访问地址 guest guest

http://192.168.10.8:15672/
