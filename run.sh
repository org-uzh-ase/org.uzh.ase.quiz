#!/bin/bash
mongod --bind_ip_all --port 27021 &

# CODE in case of debugging need.
mongorestore --port 27021 -d movies movies 2> /dev/null

while true; do sleep 100; done
# kill %1
# sleep 20 # need to wait for the process to die
# mongod --bind_ip_all --port 27021
# 
# EXPOSE 27020
# CMD [ "mongod", "--bind_ip_all", "--port", "27020" ]