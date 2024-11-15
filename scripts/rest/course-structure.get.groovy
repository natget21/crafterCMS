import groovy.util.XmlSlurper


    def component = siteItemService.getSiteItem("/site/components/items/course")
        def xmlContent = new XmlSlurper().parseText(component.getAsXml())
        def fields = []

        xmlContent.fields.field.each { field ->
            fields <<field
        }

    return fields
