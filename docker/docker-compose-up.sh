export GROUP_ID=com.atsistemas.cygnus
export DEFAULT_PORT=8080

# profile
export SPRING_PROFILES_ACTIVE=docker
export CONFIG_SERVER_SPRING_PROFILES_ACTIVE=local-repo

# config-server
export CONFIG_REPO=https://github.com/atSistemas/cygnus-config
export LOCAL_CONFIG_REPO=$HOME/git/cygnus-config
export CONFIG_SERVER_ENDPOINT=http://config-server:$DEFAULT_PORT

# retry config
export CONFIG_RETRY_MULTIPLIER=1.5
export CONFIG_RETRY_MAX_INTERVAL=20000
export CONFIG_RETRY_MAX_ATTEMPTS=10

# eureka-server
export EUREKA_ENDPOINT=http://eureka:$DEFAULT_PORT/eureka/

#docker-compose up
docker-compose -f docker-compose-test.yml up
