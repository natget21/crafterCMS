


    def component = siteItemService.getSiteItem("/site/components/items/course")
        def xmlContent = component.getAsXml()
        def fields = []

        xmlContent.fields.field.each { field ->
            fields <<field
        }

    return component
