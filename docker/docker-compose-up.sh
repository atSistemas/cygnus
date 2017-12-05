# profile
export SPRING_PROFILES_ACTIVE=docker

# config-server
export CONFIG_SERVER_PORT=8888
export CONFIG_REPO=https://github.com/atSistemas/cygnus-config
export LOCAL_CONFIG_REPO_PATH=$HOME/git/cygnus-config
export CONFIG_SERVER_ENDPOINT=http://config-server:$CONFIG_SERVER_PORT

# config retry
export CONFIG_RETRY_MULTIPLIER=1.5
export CONFIG_RETRY_MAX_INTERVAL=20000
export CONFIG_RETRY_MAX_ATTEMPTS=10

# eureka-server
export EUREKA_SERVER_PORT=1111
export EUREKA_ENDPOINT=http://eureka-server:$EUREKA_SERVER_PORT/eureka/

# zuul-proxy
export ZUUL_PORT=8080

# admin-server
export ADMIN_SERVER_PORT=9999

# hystrix-dashboard
export HYSTRIX_DASHBOARD_PORT=9000

# turbine
export TURBINE_PORT=8989

docker-compose up

#docker-compose -f docker-compose-config.yml up
