// Define the path to the content type descriptor
def contentTypePath = "/site/components/categories.content-type.xml" // Adjust path

// Fetch the content type descriptor
def contentTypeDescriptor = siteItemService.getSiteItem(SiteContext.current.site, contentTypePath)

// Parse the content type XML to extract structure
def xmlParser = new XmlParser()
def contentTypeXml = xmlParser.parseText(contentTypeDescriptor.text)

// Extract fields
def fields = contentTypeXml.fields.field.collect { field ->
    [
        name: field.@name,
        type: field.@type,
        label: field.label.text(),
        required: field.required?.text() == "true"
    ]
}

// Return structure
return [
    status: 200,
    contentTypeName: contentTypeXml.@name,
    fields: fields
]
