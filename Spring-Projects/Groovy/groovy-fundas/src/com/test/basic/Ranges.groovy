package com.test.basic
import java.time.format.DateTimeFormatterBuilder.WeekBasedFieldPrinterParser;

def numbers = 1..10

for (number in numbers) {
	println "$number"
}

def letters = 'a'..'g'

for (letter in letters) {
	println "$letter"
}

def enum DAYS {
	SUN,MON,TUES, WED,THU, FRI, SAT
}

def weekdays = DAYS.MON..DAYS.FRI
for (day in weekdays) {
	println "$day"
}
println "Extents : from " + weekdays.from +" to "  + weekdays.to

