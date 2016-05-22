#Makefile
target:
	javac -d ./bin -classpath ./src ./src/pack/Main.java
run:
	java -classpath ./bin pack.Main
clean:
	rm -rf ./bin/pack/*.class
	rm -rf ./bin/algorithms/*.class
	rm -rf ./bin/problems/*.class
	rm ./*.jar

jar:
	cd ./bin; jar cvfm ../Main.jar ../MANIFEST.MF .
	chmod +x ./Main.jar
