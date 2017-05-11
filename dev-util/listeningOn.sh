echo "Finding listening on $1"
netstat -anob | grep $1
