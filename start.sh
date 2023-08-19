#!/bin/bash

cd generator/generator-service
./gradlew bootRun &
cd ../../

cd validator/validator-service
./gradlew bootRun &
cd ../../

cd frontend/token-ui
npm start &
cd ../../
