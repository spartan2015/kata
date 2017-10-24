#!/bin/bash
gitsyncho(){
	cd $1
	git config user.name "DocMsEco"
	git config user.email doc.mseco@gmail.com
	git add .
	git commit -m 'next' && git push origin master	
}

for D in `find /c/dev/my-git -type d`
do
	echo "$D synch begun"
    gitsyncho $D
done
