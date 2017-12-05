#!/bin/sh
printf "
                                                                                                    
                                              .77777.                                               
                         .ZZZZZZ.           .777777777.    .?????????????????????                   
                      .ZZZZZZZZZZZZI      .I777777777777.  .?????????????????????                   
                     ZZZZZZZZZZZZZZZZ.   ?7777777777777777 .?????????????????????                   
                   .ZZZZZZZZZZZZZZZZZZ?.777777777.I77777777.?????????????????????                   
                   ZZZZZZZ.    .ZZZZZZZ77777777.   .77777777?????          ??????                   
                  :ZZZZZZ        .ZZZZ7777777.       .777777?????          ??????                   
                  ZZZZZZ.         ZZZ7777777.         .77777?????          ??????                   
                  ZZZZZZ          ZZZ7777777.         .77777?????          ??????                   
                  ZZZZZZ.         ZZZZ7777777         777777?????          ??????                   
                  .ZZZZZZ:       ZZZZZZ7777777I     I7777777?????          ??????                   
                   .ZZZZZZZZI=ZZZZZZZZZ 77777777=.~77777777.?????????????????????                   
                    .ZZZZZZZZZZZZZZZZZ   ~777777777777777= .?????????????????????                   
                     .ZZZZZZZZZZZZZZ.     .7777777777777.  .?????????????????????                   
                       ..ZZZZZZZZ?.         .777777777.    .?????????????????????                   
                                              .77777.                                               
                                                                                                    "

if [ "$DEBUG" = true ]; then
  printf "Running the application in debug mode.\n"
  JAVA_OPTS="$JAVA_OPTS -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n"
fi

# Improve startup time by using less complex random seed
JAVA_OPTS="$JAVA_OPTS -Djava.security.egd=file:/dev/./urandom"

JAVA_COMMAND="java $JAVA_OPTS -jar /app/spring-boot.jar $SPRINGBOOT_OPTS"

printf "JAVA_OPTS: $JAVA_OPTS\n"
printf "SPRINGBOOT_OPTS: $SPRINGBOOT_OPTS\n"
printf "JAVA_COMMAND: $JAVA_COMMAND\n"
printf "ENVIRONMENT:\n"
printenv
printf "*********************************************\n"

exec $JAVA_COMMAND
