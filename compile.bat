CD %~dp0
CALL setenv.bat
SET CUR_DIR=%CD%
CD ./src/sg/edu/nus/iss/usstore
if not exist %CUR_DIR%/bin mkdir %CUR_DIR%/bin
javac -d %CUR_DIR%/bin -cp %CUR_DIR%/lib/jdatepicker-1.3.4.jar util/*.java exception/*.java dao/*.java domain/*.java gui/*.java