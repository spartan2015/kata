#!/bin/bash
name=$0

git config --add user.name 'Doc MsEco'
git config --add user.email doc.mseco@gmail.com
git add .
git commit -m "next"
git remote add origin https://github.com/spartan2015/$(name).git
git push origin master -u