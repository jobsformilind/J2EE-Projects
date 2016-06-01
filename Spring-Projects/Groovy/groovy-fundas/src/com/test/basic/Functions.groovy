package com.test.basic

def numbers = 1..10

for (number in numbers) {
	if (isEven(number))
		println "$number"
}

def isEven(number) {
	number%2==0
}
