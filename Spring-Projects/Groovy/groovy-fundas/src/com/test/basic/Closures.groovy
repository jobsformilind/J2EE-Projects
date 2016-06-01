package com.test.basic;

def countries = ["India", "USA", "China", "Germany"]

def myClosure  = {
	println "My Closure Object.."
	println "Current time : " + new Date()
}

println "------ 1 -------"
for (i in 1..3) {
	myClosure()
	//sleep(1000)
}

println "------ 2 -------"
(1..3).each ({myClosure()})

println "------ 3 -------"
(1..3).each ({ println "My Closure Object: $it" })

println "------ 4 -------"
(1..3).each ({ i -> println "My Closure Object: $i" })

println "------ 5 -------"
countries.each ({ country -> println "My Closure Object: $country" })

println "------ 6 -------"
(1..10).findAll({it%2==0}).each ({println "Number: $it" })


