#!/usr/bin/perl
#!/usr/local/bin/perl
#Данный скрипт призван заменить известную игру fortune-mod.Зачем?  Потому что у меня эта игра не запускается.
use Getopt::Std;getopt("c");getopt ("n");
if ($opt_c eq 'true') {system ('clear');};#clear the screen
if ($opt_n) {$counter=0;while ($counter++<$opt_n) {&print;print "-------\n";};};&print;
sub print {
opendir (DIR, "./data");#opening the current dir
$index=0;srand;
foreach $file (readdir (DIR)){if ($file gt "..") {$fortunes[$index++]=$file;};};
$file=rand (@fortunes);$file=$fortunes[$file];closedir (DIR);
open (FORTUNES,"./data/$file")||die "Can't open dictionary - program will now close";
$num=1;while (<FORTUNES>){if ($_ eq "%\n") {$num++;};};#the number of fortunes
srand;$fortune=rand($num) % $num;#random fortune number
$num=1;
close (FORTUNES); open (FORTUNES,"./data/$file");
while (<FORTUNES>){
	if ($_ eq "%\n") {$num++;};
	if (($_ ne "%\n") && ($num == $fortune)) {print "$_";};
};
close (FORTUNES);}
