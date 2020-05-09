FROM mongo
EXPOSE 27021
CMD [ "./run.sh" ]

COPY src/main/resources/movies movies
COPY run.sh .

# CMD [ "mongod", "--bind_ip_all", "--port", "27021" ] for some reason running the container with CMD, and not through scipt requires the Candidates app to authenticate, but script does not need it.