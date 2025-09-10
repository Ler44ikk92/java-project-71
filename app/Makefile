.DEFAULT_GOAL := build-run

setup:
	./app/gradlew wrapper --gradle-version 8.7

clean:
	./app/gradlew clean

build:
	./app/gradlew clean build

install:
	./app/gradlew clean install

run-dist:
	./build/install/app/bin/app

run:
	./app/gradlew run

test:
	./app/gradlew test

report:
	./app/gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain

update-deps:
	./app/gradlew refreshVersions
	# ./gradlew dependencyUpdates -Drevision=release


build-run: build run

.PHONY: build
