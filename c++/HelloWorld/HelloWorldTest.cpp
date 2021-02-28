#include "pch.h"
#include "CppUnitTest.h"
#include "HelloWorld.h"

using namespace Microsoft::VisualStudio::CppUnitTestFramework;

namespace HelloWorldTest
{
	TEST_CLASS(HelloWorldTest)
	{
	public:
		
		TEST_METHOD(TestMethod1)
		{
			auto expected = "Hello-World Geek!";

			auto helloWorld = new HelloWorld();
			auto res = helloWorld->apply("Geek");

			Assert::AreEqual(expected, res);
		}
	};
}

Nombre de la prueba : TestMethod1
Nombre completo de la prueba : HelloWorld::HelloWorldTest::HelloWorldTest::TestMethod1
Origen de la prueba : V:\HelloWorld\HelloWorld\HelloWorldTest.cpp : línea 13
Salida de la prueba : Correcta
Duración de la prueba : 0 : 00 : 00

Nombre de la prueba : TestMethod1
Salida de la prueba : Correcta

