# RANDY

Solution to a programming problem posed by PROTEUS Technologies.

## Problem

Write a simple random number generator service in Java. The service should provide at least,
but not limited to, two different random number generator implementations - one that uses 
Java's built-in random number generator and another that uses a generator employing an 
algorithm of the author's choosing.  PROTEUS evaluators should be able to use the code and 
compiled classes developed by the candidate to plug in their own random number generator 
implementation without recompiling the candidates code.

The main program should be a Java program that fetches five random numbers from the random number 
generator service and displays them on the screen. The program should not have dependencies on 
libraries other than those bundled with the Java Runtime Environment. This program will probably 
require: A main calling class, two random number generator implementation classes, and supporting 
classes for a clean design.

Deliverables include all source code, an executable .jar, and appropriate documentation (including javadoc).

Skills demonstrated: Design by contract, simple inversion of control, basic Java skills.

Note: This assignment does not require a lot of code to successfully complete. The assignment will
be evaluated based on design approach, organization, creativity, and coding style.

## How to build and run

To build:

	ant build

To run:

API doc:

	ant javadoc
	open apidoc
