//Run this script in the command line with the Mongo Shell: mongo < DB_setup.js
use quizdb
db.dropDatabase()
db.createCollection("quiz")
db.quiz.createIndex( { imdbId: -1 } )