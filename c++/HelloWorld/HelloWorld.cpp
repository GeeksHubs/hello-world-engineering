#include "HelloWorld.h"
#include <iostream>


const char* HelloWorld::apply(char* input)
{
	std::string res("Hello-World ");
	res.append(input).append("!");
	return res.c_str();
}