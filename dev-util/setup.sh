alias ls="ls -al"
alias ls3333='netstat -anob | grep 3333'
alias ls8181='netstat -anob | grep 8181'
alias lsport='netstat -anob | grep $1'

alias killport='netstat -anob | grep 8181 | awk '\''{ print $5 }'\'' | head -n 1'


unlink /usr/bin/lson3333
ln -s /d/my-git/kata/dev-util/listeningOn3333.sh /usr/bin/lson3333
unlink /usr/bin/lson
ln -s /d/my-git/kata/dev-util/listeningOn.sh /usr/bin/lson