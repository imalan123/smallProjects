#pragma once
#include <string>
#include <iostream>
#include <vector>
#include "Copy.h"
#include "Student.h"
#include "Teacher.h"
using namespace std;

class Book
{
private:
	int ISBN, index, category, favor, numCopy;
	//startDate and expireDate are ints for now, but could be changed for a different implimentation
	//The reason for putting category in int is so that each number can represent a topic
	//We can decide on which number is which topic in the implementation
	string title, author;
	vector<Copy> copies;
	vector<string> reserver;
public:
	Book();
	Book(int ISBN, int index, int category, int favor, int numCopy, string title, string author);
	friend istream& operator >>(istream& input, Book& book);
	friend ostream& operator <<(ostream& output, Book& book);
	int getISBN();
	int getCategory();
	int getIndex();
	int getNumCopy();
	int getFavor();
	Copy getCopy(int i);
	string getReserver(int i);
	int getNumReserve();
	string getTitle();
	string getAuthor();
	void setISBN(int ISBN);
	void setCategory(int Category);
	void setTitle(string title);
	void setAuthor(string author);
	void setIndex(int index);
	void setNumCopy(int numCopy);
	void setFavor(int favor);

};
/*A possible idea for the date is that we simply make a counter which counts up from a date that we set ex.January 1st 2000
  This works with the idea that startDate = 30 would simply be equal to the date January 31st 2000
  Where we have a calculator function that can convert between the int values and the string dates*/