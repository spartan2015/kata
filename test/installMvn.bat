set V1=C:\Users\vasilei\Dropbox\java\workspace\test
call mvn -B install:install-file -Dfile=%v1%\j3dcore.jar -DgroupId=j3dcore -DartifactId=j3dcore -Dversion=1.0 -Dpackaging=jar
call mvn -B install:install-file -Dfile=%v1%\j3dutils.jar -DgroupId=j3dutils -DartifactId=j3dutils -Dversion=1.0 -Dpackaging=jar
call mvn -B install:install-file -Dfile=%v1%\sedgewick-algs4.jar -DgroupId=sedgewick-algs4 -DartifactId=sedgewick-algs4 -Dversion=1.0 -Dpackaging=jar
call mvn -B install:install-file -Dfile=%v1%\sedgewick-stdlib.jar -DgroupId=sedgewick-stdlib -DartifactId=sedgewick-stdlib -Dversion=1.0 -Dpackaging=jar
call mvn -B install:install-file -Dfile=%v1%\vecmath.jar -DgroupId=vecmath -DartifactId=vecmath -Dversion=1.0 -Dpackaging=jar
pause