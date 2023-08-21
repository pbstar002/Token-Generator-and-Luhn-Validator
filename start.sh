#!/bin/bash

# Move to generator-service and run it
cd generator/generator-service
./gradlew bootRun &
cd ../../

# Move to validator-service and run it
cd validator/validator-service
./gradlew bootRun &
cd ../../

# Move to frontend, install dependencies, and start it
cd frontend
npm install
npm start &
cd ../../
