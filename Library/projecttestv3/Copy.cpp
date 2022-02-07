#include "Copy.h"
#include <iostream>
using namespace std;

Copy::Copy()
{
	ID = 0;
	avail = 0;
	startDate = 0;
	expireDate = 0;
	reserveDate = 0;
	title = "";
	reader = "";
	reserver = "";
}
Copy::Copy(int ID, int avail, int startDate, int expireDate, int reserveDate, string title, string reader, string reserver)
{
	this->ID = ID;
	this->avail = avail;
	this->startDate = startDate;
	this->expireDate = expireDate;
	this->reserveDate = reserveDate;
	this->title = title;
	this->reader = reader;
	this->reserver = reserver;
}
int Copy::getID()
{
	return ID;
}
int Copy::getAvail()
{
	return avail;
}
int Copy::getStartDate()
{
	return startDate;
}
int Copy::getExpireDate()
{
	return expireDate;
}
int Copy::getReserveDate()
{
	return reserveDate;
}
string Copy::getTitle()
{
	return title;
}
string Copy::getReader()
{
	return reader;
}
string Copy::getReserver()
{
	return reserver;
}
void Copy::setID(int ID)
{
	this->ID = ID;
}
void Copy::setAvail(int avail)
{
	this->avail = avail;
}
void Copy::setStartDate(int startDate)
{
	this->startDate = startDate;
}
void Copy::setExpireDate(int expireDate)
{
	this->expireDate = expireDate;
}
void Copy::setReserveDate(int reserveDate)
{
	this->reserveDate = reserveDate;
}
void Copy::setReader(string reader)
{
	this->reader = reader;
}
void Copy::setReserver(string reserver)
{
	this->reserver = reserver;
}