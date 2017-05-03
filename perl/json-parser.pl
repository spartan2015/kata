#!/usr/bin/perl
use strict;
use JSON;

my $json_string = <STDIN>;
print "Received: $json_string\n";
my $json_data = decode_json $json_string;


print "Json is:\n";

sub jsPrint{
  my ($ref) = @_;
  if (ref($ref) eq 'ARRAY'){
	print "[@$ref]\n";
  }elsif(ref($ref) eq 'HASH' ){
	print "{\n";
	my @keys = keys %$ref;
	for my $key (@keys) {
		print $key."=>";
		my $val = %$ref{$key};
		jsPrint($val);
	}
	print "}\n";
  }else{
	print "\"$ref\"\n";
  }
}

jsPrint($json_data);
