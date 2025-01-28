.PHONY: all clean compile run

all: clean compile run

clean:
	rm -rf bin/*

compile:
	mkdir -p bin
	javac -d bin src/java/*.java src/java/**/*.java

run:
	java -cp bin wc.src.java.Application ${args}
