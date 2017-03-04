# profile
export SPRING_PROFILES_ACTIVE=docker

# config-server
export CONFIG_SERVER_PORT=8888
export CONFIG_SERVER_REPO=$HOME/git/cygnus-config
export CONFIG_SERVER_ENDPOINT=http://config-server:$CONFIG_SERVER_PORT
export CONFIG_RETRY_INITIAL_INTERVAL=10000

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
