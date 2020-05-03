#!/bin/bash
mongod --bind_ip_all --port 27021

# CODE in case of debugging need.
# mongorestore --port 27021 -d movies movies
# kill %1
# sleep 20 # need to wait for the process to die
# mongod --bind_ip_all --port 27021
# 
# EXPOSE 27020
# CMD [ "mongod", "--bind_ip_all", "--port", "27020" ]