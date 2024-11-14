import groovy.xml.XmlSlurper

// Ensure siteItemService is available for content fetching
def siteItemService = binding.getVariable("siteItemService") ?: applicationContext?.getBean("siteItemService")

return siteItemService;