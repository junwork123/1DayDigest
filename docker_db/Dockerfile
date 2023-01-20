# Database
FROM postgres:14

ENV APPNAME Database
ENV WORKDIR /home/$APPNAME
WORKDIR $WORKDIR

# 타임존 설정
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime \
  && echo $TZ > /etc/timezone