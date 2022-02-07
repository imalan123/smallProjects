#pragma once
#include <iostream>
using namespace std;

class Copy
{
private:
	int ID, avail, startDate, expireDate, reserveDate;
	string title, reader, reserver;
public:
	Copy();
	Copy(int ID, int avail, int startDate, int expireDate, int reserveDate, string title, string reader, string reserver);
	int getID();
	int getAvail();
	int getStartDate();
	int getExpireDate();
	int getReserveDate();

	string getTitle();
	string getReader();
	string getReserver();
	void setID(int ID);
	void setAvail(int avail);
	void setStartDate(int startDate);
	void setExpireDate(int expireDate);
	void setReserveDate(int reserveDate);
	void setReader(string reader);
	void setReserver(string reserver);
};
