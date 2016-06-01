package com.test.gps

import groovy.xml.StreamingMarkupBuilder

def file = new File('fells_loop.gpx')
def slurper = new XmlSlurper()
def gpx = slurper.parse(file)

def builder = new StreamingMarkupBuilder();
def xml = builder.bind{ mkp.comment(gpx.name)
	route{
		(gpx.rte.rtept).each { point ->
			routepoint(name:point.name.toString()){
				latitude(point.@lat)
				latitude(point.@lon)
			}
		}
	}
}
xml = groovy.xml.XmlUtil.serialize(xml)

File outFile = new File('fells_loop_modified.xml')
outFile.write(xml.toString())
