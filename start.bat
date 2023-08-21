cd generator\generator-service
start gradlew.bat bootRun
cd ..\..\validator\validator-service
start gradlew.bat bootRun
cd ..\..\frontend
start npm install
start npm start
