#!/usr/bin/perl 

use strict;
use warnings;
use JSON;
use Scalar::Util 'reftype';

my ($filename) = @ARGV;
if (not defined $filename) {
  die "Need file\n";
}

open(my $fh, '<:encoding(UTF-8)', $filename)
  or die "Could not open file '$filename' $!";

my %rec_hash;
my @fields;
my $row ;
while ($row = <$fh>) {
  $row =~ s/[\r\n]+$//;
  @fields = split /=/, $row;
  if (exists $rec_hash{$fields[0]}) 
  {
	my $ref = $rec_hash{$fields[0]};
	
	if(!(ref($ref) eq 'ARRAY' )) {
		$rec_hash{$fields[0]}=[];        
		my $arr = $rec_hash{$fields[0]};
		push @$arr, $ref;
    }
	my $narr = $rec_hash{$fields[0]};
    push @$narr, $fields[1];
  }
  else{
	$rec_hash{$fields[0]}=$fields[1];
  }
  
}

my $json = encode_json \%rec_hash;

print "$json\n";