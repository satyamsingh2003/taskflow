@echo off
set /p msg="Enter Commit message : "
git add .
git commit -m "%msg%"
git push