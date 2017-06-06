#!/usr/bin/bash
# schedule as basic task with C:\Users\vairimia\AppData\Local\Programs\Git\bin\bash.exe
# arguments: C:\dev\my-git\kata\dev-util\affirmations.sh
# start in: C:\dev\my-git\kata\dev-util\
V=`shuf affirmations.txt | tail -n 1`
/c/Users/vairimia/Downloads/notifu-1.6/notifu.exe -p "Fortune" -M "$V"