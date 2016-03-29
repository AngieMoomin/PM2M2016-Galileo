CC=g++

# compile flags
CFLAGS=-g -Wall

# OpenCV Related
OCVFLAGS=`pkg-config --cflags opencv`
OCVLIBS=`pkg-config --libs opencv`

OBJECTS=FastMatchTemplate.o main.o Camera.o

PROGRAM=Camera

program: $(OBJECTS)
	$(CC) $(OBJECTS) -o $(PROGRAM) $(OCVLIBS)
  
FastMatchTemplate.o: FastMatchTemplate.cc FastMatchTemplate.h
	$(CC) -c $(CFLAGS) $(OCVFLAGS) FastMatchTemplate.cc
Camera.o: Camera.cc Camera.h
	$(CC) -c $(CFLAGS) $(OCVFLAGS) Camera.cc

main.o: main.cc
	$(CC) -c $(CFLAGS) $(OCVFLAGS) main.cc

clean:
	rm -f *o
	rm -f $(PROGRAM)
	rm -f *~
