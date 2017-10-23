#!/bin/bash
gitsyncho(){
	cd $1
	git config user.name="Doc MsEco"
	git config user.email=doc.mseco@gmail.com
	git add .
	git commit -m 'next' && git push origin master	
}

gitsyncho /c/dev/my-git/kata
gitsyncho /c/dev/my-git/nodejs
gitsyncho /c/dev/my-git/kube