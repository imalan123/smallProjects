#include "Book.h"
#include <string>
#include <iostream>
using namespace std;
//Just implementations so far
Book::Book()
{
	ISBN = 0;
	index = 0;
	category = 0;
	favor = 0;
	numCopy = 0;
	title = "";
	author = "";
}
Book::Book(int ISBN, int index, int category, int favor, int numCopy, string title, string author)
{
	this->ISBN = ISBN;
	this->category = category;
	this->title = title;
	this->author = author;
	this->index = index;
	this->numCopy = numCopy;
	this->favor = favor;
}
istream& operator >> (istream& input, Book& book) //Overloaded operator for inputting in a book
{
	int ISBN, index, category, numCopy, favor;
	string title, author;
	input >> ISBN >> index >> category >> numCopy >> favor >> title >> author;
	book.setISBN(ISBN);
	book.setIndex(index);
	book.setCategory(category);
	book.setNumCopy(numCopy);
	book.setFavor(favor);
	book.setTitle(title);
	book.setAuthor(author);

	return input;
}
int Book::getISBN() //Gets and Sets functions
{
	return ISBN;
}
int Book::getIndex() {
	return index;
}
int Book::getCategory()
{
	return category;
}
int Book::getFavor() {
	return favor;
}
int Book::getNumCopy() {
	return numCopy;
}
Copy Book::getCopy(int i)
{
	return copies.at(i);
}
string Book::getTitle()
{
	return title;
}
string Book::getAuthor()
{
	return author;
}
string Book::getReserver(int i)
{
	return reserver.at(i);
}
int Book::getNumReserve()
{
	return size(reserver);
}
void Book::setISBN(int ISBN)
{
	this->ISBN = ISBN;
}
void Book::setCategory(int category)
{
	this->category = category;
}
void Book::setTitle(string title)
{
	this->title = title;
}
void Book::setAuthor(string author)
{
	this->author = author;
}
void Book::setFavor(int favor) {
	this->favor = favor;
}
void Book::setNumCopy(int numCopy) {
	this->numCopy = numCopy;
}
void Book::setIndex(int index) {
	this->index = index;
}