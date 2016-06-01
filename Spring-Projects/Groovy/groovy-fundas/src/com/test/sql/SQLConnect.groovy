package com.test.sql

def db = [url:'jdbc:mysql://localhost:3306/idp45?autoreconnect=true', user:'root', password:'root', driver:'com.mysql.jdbc.Driver']
def sql = groovy.sql.Sql.newInstance(db.url, db.user, db.password, db.driver)
println sql.properties
sql.eachRow("select * from csfirm") { row->
	def id = "$row.id"
	def name = "${row.name.padRight(10)}"
	
	println "($id): ${name}"
}


