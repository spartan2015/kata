#!/bin/bash
gitsyncho(){
	cd $1
	git config user.name "DocMsEco"
	git config user.email doc.mseco@gmail.com
	git add .
	git commit -m 'next' && git push origin master	
}

for D in /C/Users/vairimia/Desktop/my-git/*
do
	echo "$D synch begun"
    gitsyncho $D
done
