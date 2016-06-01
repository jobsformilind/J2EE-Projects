package com.test.basic

def countries = ["India", "USA", "China", "Germany"]
for (country in countries) {
	def greeting = "Hello, "
	println "$greeting" + "$country"
}


for (def i =0; i< countries.size; i++) {
	def greeting = "Hello, "
	println "$greeting" + "${countries[i]}"
	println "${i*10}"
	println '${i*10}'
}
