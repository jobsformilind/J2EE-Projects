package com.test.gps


def file = new File('fells_loop.gpx')
println file.getAbsolutePath()

def slurper = new XmlSlurper()
def gpx = slurper.parse(file)
println ''
println 'Name : '
println gpx.name
println ''
println 'Description : '
println gpx.desc
println ''
println 'GPX Version : '
println gpx.@version
println ''
println 'GPX Creator : '
println gpx.@creator

println ''
println 'Route Points: '
(gpx.rte.rtept).each  { 
	println '---> '+ it.name
	println it.@lat
	println it.@lon
	println it.time
}






