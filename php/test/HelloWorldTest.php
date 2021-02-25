<?php

namespace Test;
use PHPUnit\Framework\TestCase;
use HelloWorld\HelloWorld;

class Test01Test extends TestCase
{
   
    public function test01()
    {
        $expected = 'Hello-World Geek!';
        $value = (new HelloWorld())->apply("Geek");
        $this->assertEquals($value, $expected );
    }

}