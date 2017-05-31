#!/usr/bin/perl
#!/usr/local/bin/perl
use Getopt::Std;
getopt("f");getopt ("b");getopt ("v");getopt("n");getopt("c");getopt("w");
#getopt("m");#okay,the pattern search will be in version 1.2
#OPTIONS (ARGUMENTS)
if ($opt_b) {system ('clear');};#clear the screen
#I decided to give some compatibility with the original fortune-mod.So as far as I inserted a new feature,I have to choose a letter from available ones.
if ($opt_n) {$counter=0;while ($counter++<$opt_n){&cookie;print "-------\n";};};
if ($opt_v) {die "The Fortune-Mod:Perl Edition 1.1\n(c) Oreolek 2007\n";};
if ($opt_f) {exec "ls ./data";exit;};
#if ($opt_m) {&search;exit;};
&cookie;
$lines=0;

sub cookie {
opendir (DIR, "./data");#opening the current dir
$index=0;srand;
foreach $file (readdir (DIR)){if ($file gt "..") {$fortunes[$index++]=$file;};};
$file=rand (@fortunes);$file=$fortunes[$file];closedir (DIR);
open (FORTUNES,"./data/$file")||die "Can't find any cookie - closing...";
$num=1;while (<FORTUNES>){if ($_ eq "%\n") {$num++;};};#the number of fortunes
srand;$fortune=rand($num) % $num;#random fortune number
$num=1;
close (FORTUNES); open (FORTUNES,"./data/$file");
if ($opt_c) {print "The cookie came from $file\n";};
while (<FORTUNES>){
	if ($_ eq "%\n") {$num++;};
	if (($_ ne "%\n") && ($num == $fortune)) {print "$_";$lines++;};
};
close (FORTUNES);
if ($opt_w){sleep ($lines*1.5);};#usual practice - not working with ascii-art
}

#sub search{
#opendir (DIR, "./data");
#$lines=0;
#foreach $file (readdir (DIR)){
#	
#};
#}
