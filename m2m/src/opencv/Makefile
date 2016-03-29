CPP=g++
CFLAGS=-Wall
INCLUDES=`pkg-config opencv --cflags`
LIBS=-I /usr/include/opencv/

all : clean test

test : test.o
	$(CPP) $(LIBS) $(CFLAGS) `pkg-config opencv --libs` -o $@ $^

%.o: %.cpp
	$(CPP) $(LIBS) $(CFLAGS) $(INCLUDES) -c $<

clean :
	rm -f test *.o *~

