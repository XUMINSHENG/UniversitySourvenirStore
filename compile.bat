CD %~dp0
CALL setenv.bat
SET CUR_DIR=%CD%
CD ./src/sg/edu/nus/iss/usstore
javac -d %CUR_DIR%/bin util/*.java exception/*.java dao/*.java domain/*.java gui/*.java